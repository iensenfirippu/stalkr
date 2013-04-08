/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.mappers;

import java.sql.Connection;
import java.util.Date;
import stalkrlib.Description;
import stalkrlib.Location;
import stalkrlib.Range;
import stalkrlib.User;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import stalkrlib.Description.Area;
import stalkrlib.Description.Drinking;
import stalkrlib.Description.Gender;
import stalkrlib.Description.Sexuality;
import stalkrlib.Description.Smoking;

/**
 *
 * @author Sommer
 */
public class UserMapper {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String IP_ADDRESS = "localhost";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Connection con;
    private Statement sta;
    
    private void connect(){
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection("jdbc:mysql://" + IP_ADDRESS + "/stalkr?user=" + USERNAME + "&password=" + PASSWORD);
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
    
    public void createUser(User user){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        
        sb1.append("INSERT INTO user (guid, username, displayname, firstname, "
                + "lastname, password, birthday, "
                + "location_latitude, location_longitude, location_timestamp, "
                + "email, info_description, pref_description) VALUES ");
        sb1.append("(");
        sb1.append("'").append(user.getId()).append("', ");
        sb1.append("'").append(user.getUsername()).append("', ");
        sb1.append("'").append(user.getDisplay()).append("', ");
        sb1.append("'").append(user.getName()).append("', ");
        sb1.append("'").append(user.getName()).append("', ");
        sb1.append("'").append(user.getPassword()).append("', ");
        sb1.append("").append(user.getBirthdate().getTime() / 1000).append(", ");
        sb1.append("").append(user.getLastLocation().getLatitude()).append(", ");
        sb1.append("").append(user.getLastLocation().getLongitude()).append(", ");
        sb1.append("").append(user.getLastLocation().getTime().getTime() / 1000).append(", ");
        sb1.append("'").append(user.getEmail()).append("', ");
        sb1.append("'").append(user.getDescription().getId()).append("', ");
        sb1.append("'").append(user.getPreference().getId()).append("' ");
        sb1.append(");");
        
        sb2.append("INSERT INTO description (guid, timestamp, country, region, "
                + "city, age, age_max, gender, "
                + "smoking, drinking, orientation) VALUES ");
        sb2.append("(");
        sb2.append("'").append(user.getDescription().getId()).append("', ");
        sb2.append("").append(0).append(", ");
        sb2.append("'").append(0).append("', ");
        sb2.append("'").append(user.getDescription().getArea()).append("', ");
        sb2.append("'").append(0).append("', ");
        sb2.append("'").append(user.getDescription().getAge().getMin()).append("', ");
        sb2.append("'").append(user.getDescription().getAge().getMax()).append("', ");
        sb2.append("'").append(user.getDescription().getGender()).append("', ");
        sb2.append("'").append(user.getDescription().getSmoking()).append("', ");
        sb2.append("'").append(user.getDescription().getDrinking()).append("', ");
        sb2.append("'").append(user.getDescription().getSexuality()).append("' ");
        sb2.append(");");
        
        sb3.append("INSERT INTO description (guid, timestamp, country, region, "
                + "city, age, age_max, gender, "
                + "smoking, drinking, orientation) VALUES ");
        sb3.append("(");
        sb3.append("'").append(user.getPreference().getId()).append("', ");
        sb3.append("").append(0).append(", ");
        sb3.append("'").append(0).append("', ");
        sb3.append("'").append(user.getPreference().getArea()).append("', ");
        sb3.append("'").append(0).append("', ");
        sb3.append("'").append(user.getPreference().getAge().getMin()).append("', ");
        sb3.append("'").append(user.getPreference().getAge().getMax()).append("', ");
        sb3.append("'").append(user.getPreference().getGender()).append("', ");
        sb3.append("'").append(user.getPreference().getSmoking()).append("', ");
        sb3.append("'").append(user.getPreference().getDrinking()).append("', ");
        sb3.append("'").append(user.getPreference().getSexuality()).append("' ");
        sb3.append(");"); 
        try{
            connect();
            System.out.println(sb1.toString());
            System.out.println(sb2.toString());
            System.out.println(sb3.toString());
            sta.executeUpdate(sb1.toString());
            sta.executeUpdate(sb2.toString());
            sta.executeUpdate(sb3.toString());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            disconnect();
        }
    }
    
    public void deleteUser(User user){
        if(verifyLogin(user.getUsername(), user.getPassword())){
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            
            sb1.append("DELETE FROM description WHERE ");
            sb1.append("guid = '").append(user.getDescription().getId()).append("'");
            sb2.append("DELETE FROM description WHERE ");
            sb2.append("guid = '").append(user.getPreference().getId()).append("'");
            sb3.append("DELETE FROM user WHERE ");
            sb3.append("guid = '").append(user.getId()).append("'");
            
            try{
                connect();
                sta.executeUpdate(sb1.toString());
                sta.executeUpdate(sb2.toString());
                sta.executeUpdate(sb3.toString());
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            finally{
                disconnect();
            }
        }
    }
    
    public ArrayList<User> getOtherUsers(String username){
        ArrayList<User> users = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM user ");
        sb.append("INNER JOIN description AS descr ON user.info_description = descr.guid ");
        sb.append("INNER JOIN description AS pref ON user.pref_description = pref.guid ");
        sb.append("WHERE username <> '").append(username).append("' ");
        
        try{
            connect();
            ResultSet rs = sta.executeQuery(sb.toString());
            while(rs.next()){
                Description desc = new Description(rs.getString(13), 
                        Gender.values()[rs.getInt(20)], 
                        new Range(rs.getInt(18), rs.getInt(19)), 
                        Area.values()[rs.getInt(16)], 
                        Smoking.values()[rs.getInt(21)], 
                        Drinking.values()[rs.getInt(22)], 
                        Sexuality.values()[rs.getInt(23)]);
                
                Description pref = new Description(rs.getString(24), 
                        Gender.values()[rs.getInt(31)], 
                        new Range(rs.getInt(29), rs.getInt(30)), 
                        Area.values()[rs.getInt(27)], 
                        Smoking.values()[rs.getInt(32)], 
                        Drinking.values()[rs.getInt(33)], 
                        Sexuality.values()[rs.getInt(34)]);
                
                Location loc = new Location(rs.getFloat("location_latitude"), 
                        rs.getFloat("location_longitude"), 
                        new Date(rs.getLong("location_timestamp")));
                
                users.add(new User(rs.getString("username"), 
                        rs.getString("displayname"), 
                        rs.getString("password"), 
                        rs.getString("firstname"), 
                        new Date(rs.getInt("birthdate") * 1000), 
                        rs.getString("email"), 
                        desc, pref, loc));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            disconnect();
            return users;
        }
    }
    
    public boolean verifyLogin(String username, String password){
        boolean passwordMatch = false;
        
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT (guid) FROM user WHERE ");
        sb.append("username ='").append(username).append("' AND ");
        sb.append("password ='").append(password).append("'");
        
        try{
            connect();
            ResultSet rs = sta.executeQuery(sb.toString());
            if(rs.getInt(1) == 1){
                passwordMatch = true;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            disconnect();
            return passwordMatch;
        }
     }
    
    public void updateUser(User user){
        //EXAMPLE 1: int i = Gender.FEMALE.ordinal(); ENUM -> INT
        //EXAMPLE 2: Gender.values()[i] INT -> ENUM
    }
}
