import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

class ConnectionHolder implements HttpSessionBindingListener {
  private Connection con = null;

  public ConnectionHolder(Connection con) {
    // Save the Connection
    this.con = con;
    try {
      con.setAutoCommit(false);  // transactions can extend between web pages!
    }
    catch(SQLException e) {
      // Perform error handling
    }
  }

  public Connection getConnection() {
    return con;  // return the cargo
  }

  public void valueBound(HttpSessionBindingEvent event) {
    // Do nothing when added to a Session
  }

  public void valueUnbound(HttpSessionBindingEvent event) {
    // Roll back changes when removed from a Session
    // (or when the Session expires)
    try {
      if (con != null) {
        con.rollback();  // abandon any uncomitted data
        con.close();
      }
    }
    catch (SQLException e) {
      // Report it
    }
  }
}

/* Actual Servlet */

public class Stalkr_Create_User {

  public void init() throws ServletException {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    }
    catch (ClassNotFoundException e) {
      System.out.println("Couldn't load OracleDriver");
      throw new UnavailableException("Couldn't load OracleDriver");
    }
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/plain");
    PrintWriter out = res.getWriter();

    HttpSession session = req.getSession(true);
    Connection con;

    synchronized (session) {
       ConnectionHolder holder =
        (ConnectionHolder) session.getAttribute("servletapp.connection");

       if (holder == null) {
        try {
          holder = new ConnectionHolder(DriverManager.getConnection(
            "jdbc:oracle:oci7:ordersdb", "user", "passwd"));
          session.setAttribute("servletapp.connection", holder);
        }
        catch (SQLException e) {
          log("Couldn't get db connection", e);
        }
      }

       con = holder.getConnection();
    }

     try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate("UPDATE INVENTORY SET STOCK = (STOCK - 10) ");
      stmt.executeUpdate("UPDATE SHIPPING SET SHIPPED = (SHIPPED + 10) ");
      res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/servlet/CardHandler"));
    }
    catch (Exception e) {
      try {
        con.rollback();
        session.removeAttribute("servletapp.connection");
      }
      catch (Exception ignored) { }
      out.println("Order failed. Please contact technical support.");
    }
  }
}