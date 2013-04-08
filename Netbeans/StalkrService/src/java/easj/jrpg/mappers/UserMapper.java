/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.mappers;

import easj.jrpg.stalkrlib.*;
import easj.jrpg.stalkrlib.enums.*;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Sommer
 */
public class UserMapper
{
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String SERVER = "localhost";
    private final String DATABASE = "stalkr";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Connection con;
    private Statement sta;
    
    private void connect()
	{
        try
		{
            Class.forName(DRIVER);
            con = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE + "?user=" + USERNAME + "&password=" + PASSWORD);
            sta = con.createStatement();
        }
        catch(Exception e)
		{
            e.printStackTrace();
        }
    }
    
    private void disconnect()
	{
        try
		{
            sta.close();
            sta = null;
            con.close();
            con = null;
        }
        catch(Exception e)
		{
            e.printStackTrace();
        }
    }
    
    public String test()
	{
        String result = "couldn't connect";
        User u = new User();
		
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
            return u.getUsername() + ": " + u.getUniqueID();
        }
     }
    
    public boolean verifyLogin(String username, String password)
	{
        boolean passwordMatch = false;
        
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(guid) FROM user WHERE ");
        sb.append("username ='").append(username).append("' AND ");
        sb.append("password ='").append(password).append("'");
        
        try
		{
            connect();
            ResultSet rs = sta.executeQuery(sb.toString());
			rs.first();
			
            if(rs.getInt(1) == 1)
			{
                passwordMatch = true;
            }
        }
        catch(Exception ex)
		{
            ex.printStackTrace();
        }
        finally
		{
            disconnect();
            return passwordMatch;
        }
     }
    
    public boolean saveUser(User user)
	{
		boolean exists = false;
		boolean result = false;
		
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT count(u_id) FROM user ");
		sb.append("WHERE id = '").append(user.getUniqueID()).append("'");
		
		try
		{
			ResultSet rs = sta.executeQuery(sb.toString());
			rs.first();
			
			if (rs.getInt(1) == 1)
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
    
    private boolean createUser(User user)
	{
		boolean result = false;
		
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        
        sb1.append("INSERT INTO user (u_id, email, username, "
                + "password, firstname, lastname, birthday, "
                + "location_latitude, location_longitude, location_timestamp, "
                + ") VALUES (");
        sb1.append("'")	.append(user.getUniqueID())									.append("', ");
        sb1.append("'")	.append(user.getEmail())									.append("', ");
        sb1.append("'")	.append(user.getUsername())									.append("', ");
        sb1.append("'")	.append(user.getPassword())									.append("', ");
        sb1.append("'")	.append(user.getFirstName())								.append("', ");
        sb1.append("'")	.append(user.getLastName())									.append("', ");
        sb1				.append(Toolbelt.DateToUTS(user.getBirthday()))				.append(", ");
        sb1				.append(user.getLocation().getLatitude())					.append(", ");
        sb1				.append(user.getLocation().getLongitude())					.append(", ");
        sb1				.append(Toolbelt.DateToUTS(user.getLocation().getTimeStamp())).append(");");
        
        sb2.append("INSERT INTO description (d_id, timestamp, age, age_max, "
                + "gender, sexuality, region, smoking, drinking) VALUES (");
        sb2.append("'")	.append(user.getDescription().getUniqueID())				.append("', ");
        sb2				.append(user.getDescription().getAge().getMin())			.append(", ");
        sb2				.append(user.getDescription().getAge().getMax())			.append(", ");
        sb2.append("'")	.append(user.getDescription().getGender().toString())		.append("', ");
        sb2.append("'")	.append(user.getDescription().getSexuality().toString())	.append("', ");
        sb2.append("'")	.append(user.getDescription().getArea().toString())			.append("', ");
        sb2.append("'")	.append(user.getDescription().getSmoking().toString())		.append("', ");
        sb2.append("'")	.append(user.getDescription().getDrinking().toString())		.append("');");
		
        sb3.append("INSERT INTO description (d_id, timestamp, age, age_max, "
                + "gender, sexuality, region, smoking, drinking) VALUES (");
        sb3.append("'")	.append(user.getPreference(0).getUniqueID())				.append("', ");
        sb3				.append(user.getPreference(0).getAge().getMin())			.append(", ");
        sb3				.append(user.getPreference(0).getAge().getMax())			.append(", ");
        sb3.append("'")	.append(user.getPreference(0).getGender().toString())		.append("', ");
        sb3.append("'")	.append(user.getPreference(0).getSexuality().toString())	.append("', ");
        sb3.append("'")	.append(user.getPreference(0).getArea().toString())			.append("', ");
        sb3.append("'")	.append(user.getPreference(0).getSmoking().toString())		.append("', ");
        sb3.append("'")	.append(user.getPreference(0).getDrinking().toString())		.append("');");
		
        sb4.append("INSERT INTO userdescription (u_id, d_id) VALUES (");
        sb4.append("'")	.append(user.getUniqueID())									.append("', ");
        sb4.append("'")	.append(user.getPreference(0).getUniqueID())				.append("');");
		
        try
		{
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
    
    private boolean updateUser(User user)
	{
		boolean result = false;
		
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        
        sb1.append("UPDATE user SET ");
        sb1.append("email='")		.append(user.getEmail())										.append("',");
        sb1.append("username='")	.append(user.getUsername())										.append("',");
        sb1.append("password='")	.append(user.getPassword())										.append("',");
        sb1.append("firstname='")	.append(user.getFirstName())									.append("',");
        sb1.append("lastname='")	.append(user.getLastName())										.append("',");
        sb1.append("birthday='")	.append(Toolbelt.DateToUTS(user.getBirthday()))					.append("',");
        sb1.append("loc_lat='")		.append(user.getLocation().getLatitude())						.append("',");
        sb1.append("loc_lon='")		.append(user.getLocation().getLongitude())						.append("',");
        sb1.append("loc_tim='")		.append(Toolbelt.DateToUTS(user.getLocation().getTimeStamp()))	.append("' ");
        sb1.append("WHERE u_id = '").append(user.getUniqueID())										.append("'");
		
        sb2.append("UPDATE description SET ");
        sb2.append("timestamp='")	.append(user.getDescription().getTimeStamp())					.append("',");
        sb2.append("age='")			.append(user.getDescription().getAge().getMin())				.append("',");
        sb2.append("agemax='")		.append(user.getDescription().getAge().getMax())				.append("',");
        sb2.append("gender='")		.append(user.getDescription().getGender().toString())			.append("',");
        sb2.append("sexuality='")	.append(user.getDescription().getSexuality().toString())		.append("',");
        sb2.append("region='")		.append(user.getDescription().getArea().toString())				.append("',");
        sb2.append("smoking='")		.append(user.getDescription().getSmoking().toString())			.append("',");
        sb2.append("drinking='")	.append(user.getDescription().getDrinking().toString())			.append("',");
        sb2.append("WHERE d_id = '").append(user.getDescription().getUniqueID())					.append("'");
		
        sb3.append("UPDATE description SET ");
        sb3.append("timestamp='")	.append(user.getPreference(0).getTimeStamp())					.append("',");
        sb3.append("age='")			.append(user.getPreference(0).getAge().getMin())				.append("',");
        sb3.append("agemax='")		.append(user.getPreference(0).getAge().getMax())				.append("',");
        sb3.append("gender='")		.append(user.getPreference(0).getGender().toString())			.append("',");
        sb3.append("sexuality='")	.append(user.getPreference(0).getSexuality().toString())		.append("',");
        sb3.append("region='")		.append(user.getPreference(0).getArea().toString())				.append("',");
        sb3.append("smoking='")		.append(user.getPreference(0).getSmoking().toString())			.append("',");
        sb3.append("drinking='")	.append(user.getPreference(0).getDrinking().toString())			.append("',");
        sb3.append("WHERE d_id = '").append(user.getPreference(0).getUniqueID())					.append("'");
		
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
    
    public boolean deleteUser(String uuid)
	{
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

		try
		{
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
	
    public User getUser(String uuid)
	{
		try 
		{
			User user = null;
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

			try
			{
				connect();
				ResultSet rs = sta.executeQuery(sb.toString());
				rs.first();
				
				user = new User(UUID.fromString(rs.getString("u_id")));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setBirthday(Toolbelt.UTStoDate(rs.getInt("birthdate")));
				user.setLocation(new GeoLocation(rs.getFloat("loc_lat"), 
						rs.getFloat("loc_lon"),
						new Date(rs.getLong("loc_tim"))));

				Description desc = new Description(UUID.fromString(rs.getString("u_id")));
				desc.setAge(new Range(rs.getInt("age"), rs.getInt("agemax")));
				desc.setGender(GenderList.FromString(rs.getString("gender")));
				desc.setSexuality(SexualityList.FromString(rs.getString("sexuality")));
				desc.setArea(AreaList.FromString(rs.getString("region")));
				desc.setSmoking(SmokingList.FromString(rs.getString("smoking")));
				desc.setDrinking(DrinkingList.FromString(rs.getString("drinking")));
				user.setDescription(desc);

				Description pref = new Description(UUID.fromString(rs.getString("p_id")));
				pref.setAge(new Range(rs.getInt("p_age"), rs.getInt("p_agemax")));
				pref.setGender(GenderList.FromString(rs.getString("p_gender")));
				pref.setSexuality(SexualityList.FromString(rs.getString("p_sexuality")));
				pref.setArea(AreaList.FromString(rs.getString("p_region")));
				pref.setSmoking(SmokingList.FromString(rs.getString("p_smoking")));
				pref.setDrinking(DrinkingList.FromString(rs.getString("p_drinking")));
				user.getPreferences().add(pref);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				disconnect();
				return user;
			}
		}
        catch(Exception ex)
		{
            ex.printStackTrace();
        }
        finally
		{
            disconnect();
            return null;
        }
    }
	
    public ArrayList<User> getUsers(String username)
	{
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
        if (!username.isEmpty()) { sb.append("WHERE username <> '").append(username).append("' "); }
        
        try
		{
            connect();
            ResultSet rs = sta.executeQuery(sb.toString());
            while(rs.next())
			{
				User user = new User(UUID.fromString(rs.getString("u_id")));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setBirthday(Toolbelt.UTStoDate(rs.getInt("birthdate")));
				user.setLocation(new GeoLocation(rs.getFloat("loc_lat"), 
						rs.getFloat("loc_lon"),
						new Date(rs.getLong("loc_tim"))));

				Description desc = new Description(UUID.fromString(rs.getString("u_id")));
				desc.setAge(new Range(rs.getInt("age"), rs.getInt("agemax")));
				desc.setGender(GenderList.FromString(rs.getString("gender")));
				desc.setSexuality(SexualityList.FromString(rs.getString("sexuality")));
				desc.setArea(AreaList.FromString(rs.getString("region")));
				desc.setSmoking(SmokingList.FromString(rs.getString("smoking")));
				desc.setDrinking(DrinkingList.FromString(rs.getString("drinking")));
				user.setDescription(desc);

				Description pref = new Description(UUID.fromString(rs.getString("p_id")));
				pref.setAge(new Range(rs.getInt("p_age"), rs.getInt("p_agemax")));
				pref.setGender(GenderList.FromString(rs.getString("p_gender")));
				pref.setSexuality(SexualityList.FromString(rs.getString("p_sexuality")));
				pref.setArea(AreaList.FromString(rs.getString("p_region")));
				pref.setSmoking(SmokingList.FromString(rs.getString("p_smoking")));
				pref.setDrinking(DrinkingList.FromString(rs.getString("p_drinking")));
				user.getPreferences().add(pref);

				users.add(user);
            }
        }
        catch(Exception ex)
		{
            ex.printStackTrace();
        }
        finally
		{
            disconnect();
            return users;
        }
    }
}
