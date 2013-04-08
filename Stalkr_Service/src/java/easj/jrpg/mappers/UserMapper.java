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
import stalkrlib.EnumMapper;

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
        
        sb1.append("INSERT INTO user (u_id, username, displayname, firstname, "
                + "lastname, password, birthday, "
                + "loc_lat, loc_lon, loc_tim, "
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
        
        sb2.append("INSERT INTO description (d_id, timestamp, country, region, "
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
        sb2.append("'").append(EnumMapper.enumListToString(Gender.OTHER, user.getDescription().getGender())).append("', ");
        sb2.append("'").append(EnumMapper.enumListToString(Smoking.NO, user.getDescription().getSmoking())).append("', ");
        sb2.append("'").append(EnumMapper.enumListToString(Drinking.NO, user.getDescription().getDrinking())).append("', ");
        sb2.append("'").append(EnumMapper.enumListToString(Sexuality.ASEXUAL, user.getDescription().getSexuality())).append("' ");
        sb2.append(");");
        
        sb3.append("INSERT INTO description (d_id, timestamp, country, region, "
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
        sb3.append("'").append(EnumMapper.enumListToString(Gender.OTHER, user.getDescription().getGender())).append("', ");
        sb3.append("'").append(EnumMapper.enumListToString(Smoking.NO, user.getDescription().getSmoking())).append("', ");
        sb3.append("'").append(EnumMapper.enumListToString(Drinking.NO, user.getDescription().getDrinking())).append("', ");
        sb3.append("'").append(EnumMapper.enumListToString(Sexuality.ASEXUAL, user.getDescription().getSexuality())).append("' ");
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
    
    public void deleteUser(String uuid){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();

        sb1.append("DELETE FROM description WHERE ");
        sb1.append("d_id = '").append(uuid).append("'");
        sb2.append("DELETE pref.* FROM description AS pref");
        sb2.append("INNER JOIN userdescription AS ud ON pref.d_id = ud.d_id ");
        sb2.append("WHERE ud.u_id = '").append(uuid).append("'");
        sb3.append("DELETE FROM userdescription WHERE ");
        sb3.append("u_id = '").append(uuid).append("'");
        sb4.append("DELETE FROM user WHERE ");
        sb4.append("u_id = '").append(uuid).append("'");

        try{
            connect();
            sta.executeUpdate(sb1.toString());
            sta.executeUpdate(sb2.toString());
            sta.executeUpdate(sb3.toString());
            sta.executeUpdate(sb4.toString());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            disconnect();
        }
    }
    
    public ArrayList<User> getOtherUsers(String uuid){
        ArrayList<User> users = new ArrayList();
        
        StringBuilder sb = new StringBuilder();
        // SELECT all fields in user
        sb.append("SELECT user.*, ");
        // SELECT all but d_id from description
        sb.append("dscr.timestamp, dscr.title, dscr.age, dscr.age_max, dscr.gender, ");
        sb.append("dscr.sexuality, dscr.region, dscr.smoking, dscr.drinking, ");
        // SELECT all (with alias) from "preference"
        sb.append("pref.d_id AS p_id, pref.timestamp AS p_timestamp, pref.title AS p_title, ");
        sb.append("pref.age AS p_age, pref.age_max AS p_agemax, ");
        sb.append("pref.gender AS p_gender, pref.sexuality AS p_sexuality, ");
        sb.append("pref.region AS p_region, ");
        sb.append("pref.smoking AS p_smoking, pref.drinking AS p_drinking ");
        // FROM user table
        sb.append("FROM user ");
        sb.append("INNER JOIN description AS dscr ON user.u_id = dscr.d_id ");
        sb.append("INNER JOIN userdescription AS ud ON user.u_id = ud.u_id ");
        sb.append("INNER JOIN description AS pref ON ud.d_id = pref.d_id ");
        sb.append("WHERE u_id = '").append(uuid).append("' ");
        
        try{
            connect();
            ResultSet rs = sta.executeQuery(sb.toString());
            while(rs.next()){
                Description desc = new Description(rs.getString("u_id"),
                        EnumMapper.stringToEnumList(Gender.OTHER, rs.getString("gender")),
                        new Range(rs.getInt("age"), rs.getInt("age_max")),
                        EnumMapper.stringToEnumList(Area.NOTSPECIFIED, rs.getString("region")),
                        EnumMapper.stringToEnumList(Smoking.NO, rs.getString("smoking")),
                        EnumMapper.stringToEnumList(Drinking.NO, rs.getString("drinking")),
                        EnumMapper.stringToEnumList(Sexuality.ASEXUAL, rs.getString("sexuality")));
                
                Description pref = new Description(rs.getString("p_id"),
                        EnumMapper.stringToEnumList(Gender.OTHER, rs.getString("p_gender")),
                        new Range(rs.getInt("p_age"), rs.getInt("p_age_max")),
                        EnumMapper.stringToEnumList(Area.NOTSPECIFIED, rs.getString("p_region")),
                        EnumMapper.stringToEnumList(Smoking.NO, rs.getString("p_smoking")),
                        EnumMapper.stringToEnumList(Drinking.NO, rs.getString("p_drinking")),
                        EnumMapper.stringToEnumList(Sexuality.ASEXUAL, rs.getString("p_sexuality")));
                
                Location loc = new Location(rs.getFloat("loc_lat"), 
                        rs.getFloat("loc_lon"), 
                        new Date(rs.getLong("loc_tim")));
                
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
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        
        sb1.append("UPDATE user SET ");
        sb1.append("email='").append(user.getEmail()).append("',");
        sb1.append("username='").append(user.getUsername()).append("',");
        sb1.append("password='").append(user.getPassword()).append("',");
        sb1.append("firstname='").append(user.getName()).append("',");
        sb1.append("lastname='").append(user.getName()).append("',");
        sb1.append("birthday='").append(user.getBirthdate().getTime() / 1000).append("',");
        sb1.append("loc_lat='").append(user.getLastLocation().getLatitude()).append("',");
        sb1.append("loc_lon='").append(user.getLastLocation().getLongitude()).append("',");
        sb1.append("loc_tim='") .append(user.getLastLocation().getTime()).append("' ");
        sb1.append("WHERE u_id = '").append(user.getId()).append("'");

        sb2.append("UPDATE description SET ");
        sb2.append("age='").append(user.getDescription().getAge().getMin()).append("',");
        sb2.append("agemax='").append(user.getDescription().getAge().getMax()).append("',");
        sb2.append("gender='").append(user.getDescription().getGender().toString()).append("',");
        sb2.append("sexuality='").append(user.getDescription().getSexuality().toString()).append("',");
        sb2.append("region='").append(user.getDescription().getArea().toString()).append("',");
        sb2.append("smoking='").append(user.getDescription().getSmoking().toString()).append("',");
        sb2.append("drinking='").append(user.getDescription().getDrinking().toString()).append("',");
        sb2.append("WHERE d_id = '").append(user.getDescription().getId()).append("'");

        sb3.append("UPDATE description SET ");
        sb3.append("age='").append(user.getPreference().getAge().getMin()).append("',");
        sb3.append("agemax='").append(user.getPreference().getAge().getMax()).append("',");
        sb3.append("gender='").append(user.getPreference().getGender().toString()).append("',");
        sb3.append("sexuality='").append(user.getPreference().getSexuality().toString()).append("',");
        sb3.append("region='").append(user.getPreference().getArea().toString()).append("',");
        sb3.append("smoking='").append(user.getPreference().getSmoking().toString()).append("',");
        sb3.append("drinking='").append(user.getPreference().getDrinking().toString()).append("',");
        sb3.append("WHERE d_id = '").append(user.getPreference().getId()).append("'");
    }
}
