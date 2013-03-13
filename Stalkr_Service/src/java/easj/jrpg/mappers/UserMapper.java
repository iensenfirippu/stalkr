/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.mappers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import stalkrlib.User;

/**
 *
 * @author Sommer
 */
public class UserMapper {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String IP_ADDRESS = "localhost";
    private final int IP_PORT = 8123;
    private Connection con;
    private Statement sta;
    
    private void connect(){
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection("jdbc:mysql://" + IP_ADDRESS + ":" + IP_PORT);
            sta = con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void disconnect(){
        try{
            sta.close();
            sta = null;
            con.close();
            con = null;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Alternatively use getUser and check if null.
    public boolean userExists(String username){
        boolean a = true;
        
        try{
            connect();
            ResultSet rs = sta.executeQuery("SELECT * FROM user WHERE username='" + username + "'");
            if(rs.first() == false){
                a = false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            disconnect();
        }
        
        return a;
    }
    
    public void updateUser(int userID, String name){
        //NYI
    }
    
    public User getUserByUsername(String username){
        try{
            connect();
            ResultSet rs = sta.executeQuery("SELECT * FROM user WHERE username='" + username + "'");
            
            if(rs.first() == true){
                //User exists, extract data from ResultSet and create User Object
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            disconnect();
            return null;
        }
    }
    
    public User getUserByID(int ID){
        try{
            connect();
            ResultSet rs = sta.executeQuery("SELECT * FROM user WHERE id=" + ID);
            
            if(rs.first() == true){
                //User exists, extract data from ResultSet and create User Object
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            disconnect();
            return null;
        }
    }
    
    public User[] getMatches(String username){
        //NYI
        double threshold = 0;
        
        User user1 = new User("Sommer", "Hjort11", "Rasmus Sommer", new Date(), "sommerawesome@gmail.com");
        User user2 = new User("Jonaz", "Hjort11", "Jonaz van der Zee", new Date(), "phandazee@gmail.com");
        User user3 = new User("Glenn", "Hjort11", "Glenn Brodersen", new Date(), "derpderp@gmail.com");
        User[] users = {user2, user3};
        User[] matches = {};
        int i = 0;
        
        for(User u : users){
            if(user1.getPreference().comparePreference(u.getDescription()) >= threshold){
                matches[i] = u;
                i++;
            }
        }
        
        return matches;
    }
}
