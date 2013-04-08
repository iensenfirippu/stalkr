/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.mappers;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import stalkrlib.*;
import stalkrlib.Description.*;

/**
 *
 * @author Sommer
 */
public class UserMapper {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String IP_ADDRESS = "localhost";
    private final String DATABASE = "stalkr";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Connection con;
    private Statement sta;
    
    private void connect(){
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection("jdbc:mysql://" + IP_ADDRESS + "/" + DATABASE + "?user=" + USERNAME + "&password=" + PASSWORD);
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
    
    public String test(){
        String result = "couldn't connect";
        User u = new User(UUID.randomUUID().toString());
		
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT username FROM user LIMIT 0,1");
        
        try
		{
            connect();
            ResultSet rs = sta.executeQuery(sb.toString());

			while (rs.next())
			{
				u.setUsername(rs.getString("username"));
			}
        }
        catch(SQLException ex)
		{
			result = "SQL error: " + ex.getErrorCode();
			//ex.printStackTrace();
        }
        catch(Exception ex)
		{
			result = ex.toString();
			//ex.printStackTrace();
        }
        finally
		{
            disconnect();
            return u.getUsername() + ": " + u.getId();
        }
     }
    
    public boolean saveUser(String userasstring){
		boolean exists = false;
		boolean result = false;
		User user = User.fromString(userasstring);
		
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT count(u_id) AS number FROM user ");
		sb.append("WHERE u_id = '").append(user.getId()).append("'");
		
		try
		{
			connect();
			ResultSet rs = sta.executeQuery(sb.toString());
			rs.first();
			
			if (rs.getInt("number") == 1)
			{
				exists = true;
			}
		}
        catch(Exception ex)
		{
            ex.printStackTrace();
        }
        finally
		{
            disconnect();
        }
		
		if (exists)
		{
			result = updateUser(user);
		}
		else
		{
			result = createUser(user);
		}
		
		return result;
	}
    
    private boolean createUser(User user){
		boolean result = false;
		
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        
        sb1.append("INSERT INTO user (u_id, email, username, "
                + "password, firstname, lastname, birthday, "
                + "loc_lat, loc_lon, loc_tim"
                + ") VALUES (");
        sb1.append("'")	.append(user.getId())										.append("', ");
        sb1.append("'")	.append(user.getEmail())									.append("', ");
        sb1.append("'")	.append(user.getUsername())									.append("', ");
        sb1.append("'")	.append(user.getPassword())									.append("', ");
        sb1.append("'")	.append(user.getFirstName())								.append("', ");
        sb1.append("'")	.append(user.getLastName())									.append("', ");
        sb1				.append(user.getBirthdate().getTime() / 1000)				.append(", ");
        sb1				.append(user.getLastLocation().getLatitude())				.append(", ");
        sb1				.append(user.getLastLocation().getLongitude())				.append(", ");
        sb1				.append(user.getLastLocation().getTime().getTime() / 1000)	;
        sb1.append(");");
        
        sb2.append("INSERT INTO description (d_id, timestamp, title, age, age_max, "
                + "gender, sexuality, region, smoking, drinking) VALUES (");
        sb2.append("'")	.append(user.getDescription().getId())															.append("', ");
        sb2				.append(user.getPreference(0).getTimestamp().getTime() / 1000)									.append(", ");
        sb2.append("'")	.append(user.getPreference(0).getTitle())														.append("', ");
        sb2				.append(user.getDescription().getAge().getMin())												.append(", ");
        sb2				.append(user.getDescription().getAge().getMax())												.append(", ");
        sb2.append("'")	.append(EnumMapper.enumListToString(Gender.OTHER, user.getDescription().getGender()))			.append("', ");
        sb2.append("'")	.append(EnumMapper.enumListToString(Sexuality.ASEXUAL, user.getDescription().getSexuality()))	.append("', ");
        sb2.append("'")	.append(EnumMapper.enumListToString(Area.NOTSPECIFIED, user.getDescription().getArea()))		.append("', ");
        sb2.append("'")	.append(EnumMapper.enumListToString(Smoking.NO, user.getDescription().getSmoking()))			.append("', ");
        sb2.append("'")	.append(EnumMapper.enumListToString(Drinking.NO, user.getDescription().getDrinking()))			.append("'");
		sb2.append(");");
		
        sb3.append("INSERT INTO description (d_id, timestamp, title, age, age_max, "
                + "gender, sexuality, region, smoking, drinking) VALUES (");
        sb3.append("'")	.append(user.getPreference(0).getId())															.append("', ");
        sb3				.append(user.getPreference(0).getTimestamp().getTime() / 1000)									.append(", ");
        sb3.append("'")	.append(user.getPreference(0).getTitle())														.append("', ");
        sb3				.append(user.getPreference(0).getAge().getMin())												.append(", ");
        sb3				.append(user.getPreference(0).getAge().getMax())												.append(", ");
        sb3.append("'")	.append(EnumMapper.enumListToString(Gender.OTHER, user.getPreference(0).getGender()))			.append("', ");
        sb3.append("'")	.append(EnumMapper.enumListToString(Sexuality.ASEXUAL, user.getPreference(0).getSexuality()))	.append("', ");
        sb3.append("'")	.append(EnumMapper.enumListToString(Area.NOTSPECIFIED, user.getPreference(0).getArea()))		.append("', ");
        sb3.append("'")	.append(EnumMapper.enumListToString(Smoking.NO, user.getPreference(0).getSmoking()))			.append("', ");
        sb3.append("'")	.append(EnumMapper.enumListToString(Drinking.NO, user.getPreference(0).getDrinking()))			.append("'");
		sb3.append(");");
		
        sb4.append("INSERT INTO userdescription (u_id, d_id) VALUES (");
        sb4.append("'")	.append(user.getId())										.append("', ");
        sb4.append("'")	.append(user.getPreference(0).getId())						.append("');");
        
        try{
            connect();
			int rowsaffected = 0;
            System.out.println(sb1.toString());
            System.out.println(sb2.toString());
            System.out.println(sb3.toString());
            System.out.println(sb4.toString());
            rowsaffected += sta.executeUpdate(sb1.toString());
            rowsaffected += sta.executeUpdate(sb2.toString());
            rowsaffected += sta.executeUpdate(sb3.toString());
            rowsaffected += sta.executeUpdate(sb4.toString());
			if (rowsaffected == 4)
			{
				result = true;
			}
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            disconnect();
			return result;
        }
    }
    
    private boolean updateUser(User user){
		boolean result = false;
		
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        
        sb1.append("UPDATE user SET ");
        sb1.append("email='")		.append(user.getEmail())									.append("',");
        sb1.append("username='")	.append(user.getUsername())									.append("',");
        sb1.append("password='")	.append(user.getPassword())									.append("',");
        sb1.append("firstname='")	.append(user.getFirstName())								.append("',");
        sb1.append("lastname='")	.append(user.getLastName())									.append("',");
        sb1.append("birthday=")		.append(user.getBirthdate().getTime() / 1000)				.append(",");
        sb1.append("loc_lat=")		.append(user.getLastLocation().getLatitude())				.append(",");
        sb1.append("loc_lon=")		.append(user.getLastLocation().getLongitude())				.append(",");
        sb1.append("loc_tim=")		.append(user.getLastLocation().getTime().getTime() / 1000)	.append(" ");
        sb1.append("WHERE u_id = '").append(user.getId())										.append("';");

        sb2.append("UPDATE description SET ");
        sb2.append("title='")		.append(user.getDescription().getTitle())														.append("',");
        sb2.append("timestamp=")	.append(user.getDescription().getTimestamp().getTime() / 1000)									.append(",");
        sb2.append("age=")			.append(user.getDescription().getAge().getMin())												.append(",");
        sb2.append("age_max=")		.append(user.getDescription().getAge().getMax())												.append(",");
        sb2.append("gender='")		.append(EnumMapper.enumListToString(Gender.OTHER, user.getDescription().getGender()))			.append("',");
        sb2.append("sexuality='")	.append(EnumMapper.enumListToString(Sexuality.ASEXUAL, user.getDescription().getSexuality()))	.append("',");
        sb2.append("region='")		.append(EnumMapper.enumListToString(Area.NOTSPECIFIED, user.getDescription().getArea()))		.append("',");
        sb2.append("smoking='")		.append(EnumMapper.enumListToString(Smoking.NO, user.getDescription().getSmoking()))			.append("',");
        sb2.append("drinking='")	.append(EnumMapper.enumListToString(Drinking.NO, user.getDescription().getDrinking()))			.append("' ");
        sb2.append("WHERE d_id = '").append(user.getDescription().getId())															.append("';");

        sb3.append("UPDATE description SET ");
        sb3.append("title='")		.append(user.getPreference(0).getTitle())														.append("',");
        sb3.append("timestamp=")	.append(user.getPreference(0).getTimestamp().getTime() / 1000)									.append(",");
        sb3.append("age='")			.append(user.getPreference(0).getAge().getMin())												.append("',");
        sb3.append("age_max='")		.append(user.getPreference(0).getAge().getMax())												.append("',");
        sb3.append("gender='")		.append(EnumMapper.enumListToString(Gender.OTHER, user.getPreference(0).getGender()))			.append("',");
        sb3.append("sexuality='")	.append(EnumMapper.enumListToString(Sexuality.ASEXUAL, user.getPreference(0).getSexuality()))	.append("',");
        sb3.append("region='")		.append(EnumMapper.enumListToString(Area.NOTSPECIFIED, user.getPreference(0).getArea()))		.append("',");
        sb3.append("smoking='")		.append(EnumMapper.enumListToString(Smoking.NO, user.getPreference(0).getSmoking()))			.append("',");
        sb3.append("drinking='")	.append(EnumMapper.enumListToString(Drinking.NO, user.getPreference(0).getDrinking()))			.append("' ");
        sb3.append("WHERE d_id = '").append(user.getPreference(0).getId())															.append("';");
		
        try
		{
            connect();
			int rowsaffected = 0;
            System.out.println(sb1.toString());
            System.out.println(sb2.toString());
            System.out.println(sb3.toString());
            rowsaffected += sta.executeUpdate(sb1.toString());
            rowsaffected += sta.executeUpdate(sb2.toString());
            rowsaffected += sta.executeUpdate(sb3.toString());
			if (rowsaffected == 3)
			{
				result = true;
			}
        }
        catch(Exception ex)
		{
            ex.printStackTrace();
        }
        finally
		{
            disconnect();
			return result;
        }
    }
    
    public boolean deleteUser(String uuid){
		boolean result = false;
		
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
			int rowsaffected = 0;
			rowsaffected += sta.executeUpdate(sb1.toString());
			rowsaffected += sta.executeUpdate(sb2.toString());
			rowsaffected += sta.executeUpdate(sb3.toString());
			rowsaffected += sta.executeUpdate(sb4.toString());
			if (rowsaffected == 4)
			{
				result = true;
			}
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            disconnect();
			return result;
        }
    }
    
    public String getUser(String uuid){
        User user = new User(uuid);
        
        StringBuilder sb = new StringBuilder();
        // SELECT all fields in user
        sb.append("SELECT user.*, ");
        // SELECT all but d_id from description
        sb.append("dscr.timestamp, dscr.title, dscr.age, dscr.age_max, dscr.gender, ");
        sb.append("dscr.sexuality, dscr.region, dscr.smoking, dscr.drinking, ");
        // SELECT all (with alias) from "preference"
        sb.append("pref.d_id AS p_id, pref.timestamp AS p_timestamp, pref.title AS p_title, ");
        sb.append("pref.age AS p_age, pref.age_max AS p_age_max, ");
        sb.append("pref.gender AS p_gender, pref.sexuality AS p_sexuality, ");
        sb.append("pref.region AS p_region, ");
        sb.append("pref.smoking AS p_smoking, pref.drinking AS p_drinking ");
        // FROM user table
        sb.append("FROM user ");
        sb.append("INNER JOIN description AS dscr ON user.u_id = dscr.d_id ");
        sb.append("INNER JOIN userdescription AS ud ON user.u_id = ud.u_id ");
        sb.append("INNER JOIN description AS pref ON ud.d_id = pref.d_id ");
        sb.append("WHERE user.u_id = '").append(uuid).append("' ");
        
        try{
            connect();
            ResultSet rs = sta.executeQuery(sb.toString());
            
			while (rs.next())
			{
				Description desc = new Description(rs.getString("u_id"),
						rs.getString("title"), 
						new Date(rs.getLong("timestamp")), 
						EnumMapper.stringToEnumList(Gender.OTHER, rs.getString("gender")),
						new Range(rs.getInt("age"), rs.getInt("age_max")),
						EnumMapper.stringToEnumList(Area.NOTSPECIFIED, rs.getString("region")),
						EnumMapper.stringToEnumList(Smoking.NO, rs.getString("smoking")),
						EnumMapper.stringToEnumList(Drinking.NO, rs.getString("drinking")),
						EnumMapper.stringToEnumList(Sexuality.ASEXUAL, rs.getString("sexuality")));

				Description pref = new Description(rs.getString("p_id"),
						rs.getString("p_title"), 
						new Date(rs.getLong("p_timestamp")),
						EnumMapper.stringToEnumList(Gender.OTHER, rs.getString("p_gender")),
						new Range(rs.getInt("p_age"), rs.getInt("p_age_max")),
						EnumMapper.stringToEnumList(Area.NOTSPECIFIED, rs.getString("p_region")),
						EnumMapper.stringToEnumList(Smoking.NO, rs.getString("p_smoking")),
						EnumMapper.stringToEnumList(Drinking.NO, rs.getString("p_drinking")),
						EnumMapper.stringToEnumList(Sexuality.ASEXUAL, rs.getString("p_sexuality")));

				Location loc = new Location(rs.getFloat("loc_lat"), 
						rs.getFloat("loc_lon"), 
						new Date(rs.getLong("loc_tim")));

				user.setUsername(rs.getString("username")); 
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setBirthdate(new Date(rs.getInt("birthday") * 1000)); 
				user.setEmail(rs.getString("email"));
				user.setDescription(desc);
				user.getPreferences().add(pref);
				user.setLastLocation(loc);
			}
        }
        catch(Exception ex){
			return "Exception: " + ex.getMessage();
            //ex.printStackTrace();
        }
        finally{
            disconnect();
            return user.toString();
        }
    }
    
    public String[] getOtherUsers(String uuid){
        ArrayList<User> users = new ArrayList();
        
        StringBuilder sb = new StringBuilder();
        // SELECT all fields in user
        sb.append("SELECT user.*, ");
        // SELECT all but d_id from description
        sb.append("dscr.timestamp, dscr.title, dscr.age, dscr.age_max, dscr.gender, ");
        sb.append("dscr.sexuality, dscr.region, dscr.smoking, dscr.drinking, ");
        // SELECT all (with alias) from "preference"
        sb.append("pref.d_id AS p_id, pref.timestamp AS p_timestamp, pref.title AS p_title, ");
        sb.append("pref.age AS p_age, pref.age_max AS p_age_max, ");
        sb.append("pref.gender AS p_gender, pref.sexuality AS p_sexuality, ");
        sb.append("pref.region AS p_region, ");
        sb.append("pref.smoking AS p_smoking, pref.drinking AS p_drinking ");
        // FROM user table
        sb.append("FROM user ");
        sb.append("INNER JOIN description AS dscr ON user.u_id = dscr.d_id ");
        sb.append("INNER JOIN userdescription AS ud ON user.u_id = ud.u_id ");
        sb.append("INNER JOIN description AS pref ON ud.d_id = pref.d_id ");
        if (uuid != "") { sb.append("WHERE user.u_id <> '").append(uuid).append("' "); }
        
        try{
            connect();
            ResultSet rs = sta.executeQuery(sb.toString());
            while(rs.next()){
                Description desc = new Description(rs.getString("u_id"),
                        rs.getString("title"), 
                        new Date(rs.getLong("timestamp")), 
                        EnumMapper.stringToEnumList(Gender.OTHER, rs.getString("gender")),
                        new Range(rs.getInt("age"), rs.getInt("age_max")),
                        EnumMapper.stringToEnumList(Area.NOTSPECIFIED, rs.getString("region")),
                        EnumMapper.stringToEnumList(Smoking.NO, rs.getString("smoking")),
                        EnumMapper.stringToEnumList(Drinking.NO, rs.getString("drinking")),
                        EnumMapper.stringToEnumList(Sexuality.ASEXUAL, rs.getString("sexuality")));
                
                Description pref = new Description(rs.getString("p_id"),
                        rs.getString("p_title"), 
                        new Date(rs.getLong("p_timestamp")),
                        EnumMapper.stringToEnumList(Gender.OTHER, rs.getString("p_gender")),
                        new Range(rs.getInt("p_age"), rs.getInt("p_age_max")),
                        EnumMapper.stringToEnumList(Area.NOTSPECIFIED, rs.getString("p_region")),
                        EnumMapper.stringToEnumList(Smoking.NO, rs.getString("p_smoking")),
                        EnumMapper.stringToEnumList(Drinking.NO, rs.getString("p_drinking")),
                        EnumMapper.stringToEnumList(Sexuality.ASEXUAL, rs.getString("p_sexuality")));
                
                Location loc = new Location(rs.getFloat("loc_lat"), 
                        rs.getFloat("loc_lon"), 
                        new Date(rs.getLong("loc_tim")));
                
	            User user = new User(rs.getString("u_id"));
				user.setUsername(rs.getString("username")); 
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setBirthdate(new Date(rs.getInt("birthday") * 1000));
				user.setEmail(rs.getString("email"));
				user.setDescription(desc);
				user.getPreferences().add(pref);
				user.setLastLocation(loc);

				users.add(user);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            disconnect();
			String[] result = new String[users.size()];
			for (int i = 0; i < result.length; i++)
			{
				result[i] = users.get(i).toString();
			}
            return result;
        }
    }
    
    public String verifyLogin(String username, String password){
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
            //return passwordMatch;
			return sb.toString();
        }
     }
}
