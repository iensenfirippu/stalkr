/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.mappers;

import com.mysql.jdbc.Connection;
import java.util.Date;
import stalkrlib.Description;
import stalkrlib.Description.Area;
import stalkrlib.Description.Drinking;
import stalkrlib.Description.Gender;
import stalkrlib.Description.Sexuality;
import stalkrlib.Description.Smoking;
import stalkrlib.Location;
import stalkrlib.Range;
import stalkrlib.User;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Sommer
 */
public class UserMapper {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String IP_ADDRESS = "localhost";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private final int IP_PORT = 8123;
    private Connection con;
    private Statement sta;
    
    private void connect(){
        try{
            Class.forName(DRIVER);
            con = (Connection) DriverManager.getConnection("jdbc:mysql://" + IP_ADDRESS + ":" + IP_PORT + "/stalkr_db", USERNAME, PASSWORD);
            sta = (Statement) con.createStatement();
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
            ResultSet rs = sta.executeQuery("SELECT * FROM user WHERE username = '" + username + "' INNER JOIN info_description ON user.info_description=description.guid INNER JOIN info_preference ON user.info_preference=description.guid");
            
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
    
    public User[] getOtherUsers(String username){ // UUID param?
        User[] ua = {};
        int i = 0;
        try{
            connect();
            ResultSet rs = sta.executeQuery("SELECT * FROM user WHERE username <> '" + username + "' INNER JOIN info_description ON user.info_description=description.guid INNER JOIN info_preference ON user.info_preference=description.guid");
            while(rs.next()){
                //IMPLEMENT DATE OBJECT FROM DB(?)
                Description description = new Description(Gender.values()[Integer.parseInt(rs.getString("info_description.gender"))], new Range(rs.getInt("info_description.age"), -1), Area.values()[Integer.parseInt(rs.getString("info_description.region"))], Smoking.values()[Integer.parseInt(rs.getString("info_description.smoking"))], Drinking.values()[Integer.parseInt(rs.getString("info_description.drinking"))], Sexuality.values()[Integer.parseInt(rs.getString("info_description.orientation"))]);
                Description preference = new Description(Gender.values()[Integer.parseInt(rs.getString("info_preference.gender"))], new Range(rs.getInt("info_preference.age"), rs.getInt("info_preference.age_max")), Area.values()[Integer.parseInt(rs.getString("info_preference.region"))], Smoking.values()[Integer.parseInt(rs.getString("info_preference.smoking"))], Drinking.values()[Integer.parseInt(rs.getString("info_preference.drinking"))], Sexuality.values()[Integer.parseInt(rs.getString("info_preference.orientation"))]);
                User user = new User(rs.getString("user.guid"),rs.getString("user.username"), rs.getString("user.password"), rs.getString("user.firstname") + " " + rs.getString("user.lastname"), new Date(), rs.getString("user.email"), description, preference, new Location(rs.getFloat("user.location_latitude"), rs.getFloat("user.location_longitude"), new Date()));
                ua[i] = user;
                i++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            disconnect();
            return ua;
        }
    }
}
