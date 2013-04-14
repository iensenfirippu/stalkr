package easj.jrpg.mappers;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import easj.jrpg.stalkrlib.*;
import easj.jrpg.stalkrlib.EnumList.*;

/**
 *
 * @author Philip
 */
public class UserMapper
{
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String SERVER = "localhost:3306";
	private final String DATABASE = "stalkr";
	//private final String USERNAME = "stalkr";
	//private final String PASSWORD = "DatabasePassword1";
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private Connection con;
	private Statement sta;
	
	/**
	 * Connects to the database
	 */
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
	
	/**
	 * Closes the connection with the database
	 */
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
	
	/**
	 * Saves a user to the database
	 * @param userasstring The user as a string
	 * @return true on success
	 */
	public boolean saveUser(String userasstring)
	{
		boolean result = false;
		
		boolean userexists = false;
		boolean descriptionexists = false;
		ArrayList<String> preferenceids = new ArrayList<String>();
		User user = Tools.UserFromString(userasstring);
		
		if (user != null)
		{
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			
			sb1.append("SELECT count(u_id) AS users FROM user ");
			sb1.append("WHERE u_id = '").append(user.getUniqueID().toString()).append("';");
			
			sb2.append("SELECT count(d_id) AS descriptions FROM description ");
			sb2.append("WHERE d_id = '").append(user.getUniqueID().toString()).append("';");
			
			sb3.append("SELECT d_id AS p_id FROM userdescription ");
			sb3.append("WHERE u_id = '").append(user.getUniqueID().toString()).append("';");

			try
			{
				connect();
				ResultSet rs = sta.executeQuery(sb1.toString());
				rs.first();
				if (rs.getInt("users") == 1) { userexists = true; }
				rs = sta.executeQuery(sb2.toString());
				rs.first();
				if (rs.getInt("descriptions") == 1) { descriptionexists = true; }
				rs = sta.executeQuery(sb3.toString());
				while (rs.next())
				{
					preferenceids.add(rs.getString("p_id"));
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

			ArrayList<String> sqlstatements = new ArrayList<String>();
			
			// user UPDATE
			if (userexists)			{ sqlstatements.add(makeStatement_UpdateUser(user)); }
			// user INSERT
			else					{ sqlstatements.add(makeStatement_InsertUser(user)); }
			
			// Description UPDATE
			if (descriptionexists)	{ sqlstatements.add(makeStatement_UpdateDescription(user.getDescription())); }
			// Description INSERT
			else					{ sqlstatements.add(makeStatement_InsertDescription(user.getDescription())); }
			
			for (Description p : user.getPreferences())
			{
				// Preference UPDATE
				if (preferenceids.contains(p.getUniqueID().toString()))
				{
					sqlstatements.add(makeStatement_UpdateDescription(p));
					preferenceids.remove(p.getUniqueID().toString());
				}
				// Preference INSERT
				else
				{
					sqlstatements.add(makeStatement_InsertDescription(p));
					sqlstatements.add(makeStatement_InsertUserDescription(user.getUniqueID().toString(), p.getUniqueID().toString()));
				}
			}
			// Preference DELETE
			for (String id : preferenceids)
			{
				sqlstatements.add(makeStatement_DeleteDescription(id));
				sqlstatements.add(makeStatement_DeleteUserDescription(id));
			}

			try
			{
				connect();
				int rowsaffected = 0;
				for (String statement : sqlstatements)
				{
					//System.out.println(statement);
					rowsaffected += sta.executeUpdate(statement);
				}
				if (rowsaffected == (user.getPreferences().size() * 2) + (preferenceids.size() * 2) + 2)
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
		
		return result;
	}
	
	private String makeStatement_InsertUser(User user)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO user (u_id, email, username, "
				+ "password, firstname, lastname, birthday, "
				+ "loc_lat, loc_lon, loc_tim"
				+ ") VALUES (");
		sb.append("'")	.append(user.getUniqueID())										.append("', ");
		sb.append("'")	.append(user.getEmail())										.append("', ");
		sb.append("'")	.append(user.getUsername())										.append("', ");
		sb.append("'")	.append(user.getPassword())										.append("', ");
		sb.append("'")	.append(user.getFirstName())									.append("', ");
		sb.append("'")	.append(user.getLastName())										.append("', ");
		sb				.append(Tools.DTtoTS(user.getBirthday()))					.append(", ");
		sb				.append(user.getLocation().getLatitude())						.append(", ");
		sb				.append(user.getLocation().getLongitude())						.append(", ");
		sb				.append(Tools.DTtoTS(user.getLocation().getTimeStamp()))		.append(");");
		
		return sb.toString();
	}
	
	private String makeStatement_UpdateUser(User user)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("UPDATE user SET ");
		sb.append("email='")		.append(user.getEmail())										.append("',");
		sb.append("username='")		.append(user.getUsername())										.append("',");
		sb.append("password='")		.append(user.getPassword())										.append("',");
		sb.append("firstname='")	.append(user.getFirstName())									.append("',");
		sb.append("lastname='")		.append(user.getLastName())										.append("',");
		sb.append("birthday=")		.append(Tools.DTtoTS(user.getBirthday()))					.append(",");
		sb.append("loc_lat=")		.append(user.getLocation().getLatitude())						.append(",");
		sb.append("loc_lon=")		.append(user.getLocation().getLongitude())						.append(",");
		sb.append("loc_tim=")		.append(Tools.DTtoTS(user.getLocation().getTimeStamp()))		.append(" ");
		sb.append("WHERE u_id = '")	.append(user.getUniqueID())										.append("';");
		
		return sb.toString();
	}
	
	private String makeStatement_InsertDescription(Description desc)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO description (d_id, timestamp, title, age, age_max, "
				+ "gender, sexuality, region, smoking, drinking) VALUES (");
		sb.append("'")	.append(desc.getUniqueID())							.append("', ");
		sb				.append(Tools.DTtoTS(desc.getTimeStamp()))		.append(", ");
		sb.append("'")	.append(desc.getTitle())							.append("', ");
		sb				.append(desc.getAge().getMin())						.append(", ");
		sb				.append(desc.getAge().getMax())						.append(", ");
		sb.append("'")	.append(desc.getGender().toString())				.append("', ");
		sb.append("'")	.append(desc.getSexuality().toString())				.append("', ");
		sb.append("'")	.append(desc.getArea().toString())					.append("', ");
		sb.append("'")	.append(desc.getSmoking().toString())				.append("', ");
		sb.append("'")	.append(desc.getDrinking().toString())				.append("');");
		
		return sb.toString();
	}
	
	private String makeStatement_UpdateDescription(Description desc)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("UPDATE description SET ");
		sb.append("title='").append(desc.getTitle()).append("',");
		sb.append("timestamp=").append(Tools.DTtoTS(desc.getTimeStamp())).append(",");
		sb.append("age=").append(desc.getAge().getMin()).append(",");
		sb.append("age_max=").append(desc.getAge().getMax()).append(",");
		sb.append("gender='").append(desc.getGender().toString()).append("',");
		sb.append("sexuality='").append(desc.getSexuality().toString()).append("',");
		sb.append("region='").append(desc.getArea().toString()).append("',");
		sb.append("smoking='").append(desc.getSmoking().toString()).append("',");
		sb.append("drinking='").append(desc.getDrinking().toString()).append("' ");
		sb.append("WHERE d_id = '").append(desc.getUniqueID()).append("';");
		
		return sb.toString();
	}
	
	private String makeStatement_DeleteDescription(String d_id)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("DELETE FROM description WHERE ");
		sb.append("d_id = '").append(d_id).append("';");
		
		return sb.toString();
	}
	
	private String makeStatement_InsertUserDescription(String u_id, String d_id)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO userdescription (u_id, d_id) VALUES (");
		sb.append("'").append(u_id.toString()).append("', ");
		sb.append("'").append(d_id.toString()).append("');");
		
		return sb.toString();
	}
	
	private String makeStatement_DeleteUserDescription(String d_id)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("DELETE FROM userdescription WHERE ");
		sb.append("d_id = '").append(d_id).append("';");
		
		return sb.toString();
	}
	
	/**
	 * Deletes a user from the database
	 * @param uuid The ID of the user to delete
	 * @return true on success
	 */
	public boolean deleteUser(String uuid)
	{
		boolean result = false;
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();

		sb1.append("DELETE FROM description WHERE ");
		sb1.append("d_id = '").append(uuid).append("'");
		sb2.append("DELETE pref.* FROM description AS pref ");
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
			if (rowsaffected >= 2)
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
	
	/**
	 * Fetches a single User from the database
	 * @param uuid ID of the user to fetch
	 * @return User as string
	 */
	public String getUser(String uuid)
	{
		User user = new User(UUID.fromString(uuid));
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		// SELECT all fields in user
		sb1.append("SELECT user.*, ");
		// SELECT all but d_id from description
		sb1.append("dscr.timestamp, dscr.title, dscr.age, dscr.age_max, dscr.gender, ");
		sb1.append("dscr.sexuality, dscr.region, dscr.smoking, dscr.drinking ");
		// FROM user table
		sb1.append("FROM user ");
		sb1.append("INNER JOIN description AS dscr ON user.u_id = dscr.d_id ");
		sb1.append("WHERE user.u_id = '").append(uuid).append("' ");
		
		// SELECT all fields in user
		sb2.append("SELECT ud.u_id, pref.* FROM description AS pref ");
		sb2.append("INNER JOIN userdescription AS ud ON pref.d_id = ud.d_id ");
		sb2.append("WHERE ud.u_id = '").append(uuid).append("' ");
		
		try
		{
			connect();
			ResultSet rs = sta.executeQuery(sb1.toString());
			rs.first();
			
			Description desc = new Description(UUID.fromString(rs.getString("u_id")));
			desc.setTitle(rs.getString("title"));
			desc.setTimeStamp(Tools.DTfromTS(rs.getLong("timestamp")));
			desc.getAge().set(rs.getInt("age"), rs.getInt("age_max"));
			desc.getGender().loadString(rs.getString("gender"));
			desc.getSexuality().loadString(rs.getString("sexuality"));
			desc.getArea().loadString(rs.getString("region"));
			desc.getSmoking().loadString(rs.getString("smoking"));
			desc.getDrinking().loadString(rs.getString("drinking"));

			GeoLocation loc = new GeoLocation(
				rs.getFloat("loc_lat"), 
				rs.getFloat("loc_lon"), 
				Tools.DTfromTS(rs.getLong("loc_tim"))
			);

			user.setUsername(rs.getString("username")); 
			user.setPassword(rs.getString("password"));
			user.setFirstName(rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
			user.setBirthday(Tools.DTfromTS(rs.getInt("birthday"))); 
			user.setEmail(rs.getString("email"));
			user.setDescription(desc);
			user.setLocation(loc);
			
			rs = sta.executeQuery(sb2.toString());
			while (rs.next())
			{
				Description pref = new Description(UUID.fromString(rs.getString("d_id")));
				pref.setTitle(rs.getString("title"));
				pref.setTimeStamp(Tools.DTfromTS(rs.getLong("timestamp")));
				pref.getAge().set(rs.getInt("age"), rs.getInt("age_max"));
				pref.getGender().loadString(rs.getString("gender"));
				pref.getSexuality().loadString(rs.getString("sexuality"));
				pref.getArea().loadString(rs.getString("region"));
				pref.getSmoking().loadString(rs.getString("smoking"));
				pref.getDrinking().loadString(rs.getString("drinking"));
				user.getPreferences().add(pref);
			}
		}
		catch(Exception ex)
		{
			return "Exception: " + ex.getMessage();
			//ex.printStackTrace();
		}
		finally
		{
			disconnect();
			return Tools.UserToString(user, true);
		}
	}
	
	/**
	 * Fetches a list of users from the database
	 * @param uuid ID of user to exclude
	 * @return Users as strings in array
	 */
	public String[] getUsers(String uuid)
	{
		ArrayList<User> users = new ArrayList();
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		// SELECT all fields in user
		sb1.append("SELECT user.*, ");
		// SELECT all but d_id from description
		sb1.append("dscr.timestamp, dscr.title, dscr.age, dscr.age_max, dscr.gender, ");
		sb1.append("dscr.sexuality, dscr.region, dscr.smoking, dscr.drinking ");
		// FROM user table
		sb1.append("FROM user ");
		sb1.append("INNER JOIN description AS dscr ON user.u_id = dscr.d_id ");
		if (uuid != "") { sb1.append("WHERE user.u_id <> '").append(uuid).append("' "); }

		// SELECT each users preferences
		sb2.append("SELECT ud.u_id, pref.* FROM description as pref ");
		sb2.append("INNER JOIN userdescription AS ud ON pref.d_id = ud.d_id ");
		sb2.append("WHERE ud.u_id = ");
		
		try
		{
			connect();
			//System.out.println(sb1.toString());
			ResultSet rs = sta.executeQuery(sb1.toString());
			while(rs.next())
			{
				Description desc = new Description(UUID.fromString(rs.getString("u_id")));
				desc.setTitle(rs.getString("title"));
				desc.setTimeStamp(Tools.DTfromTS(rs.getLong("timestamp")));
				desc.getAge().set(rs.getInt("age"), rs.getInt("age_max"));
				desc.getGender().loadString(rs.getString("gender"));
				desc.getSexuality().loadString(rs.getString("sexuality"));
				desc.getArea().loadString(rs.getString("region"));
				desc.getSmoking().loadString(rs.getString("smoking"));
				desc.getDrinking().loadString(rs.getString("drinking"));

				GeoLocation loc = new GeoLocation(
					rs.getFloat("loc_lat"), 
					rs.getFloat("loc_lon"), 
					Tools.DTfromTS(rs.getLong("loc_tim"))
				);

				User user = new User(UUID.fromString(rs.getString("u_id")));
				user.setUsername(rs.getString("username")); 
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setBirthday(Tools.DTfromTS(rs.getInt("birthday"))); 
				user.setEmail(rs.getString("email"));
				user.setDescription(desc);
				user.setLocation(loc);
				
				users.add(user);
			}
			
			for (User u : users)
			{
				String statement = sb2.toString() + "'" + u.getUniqueID().toString() + "'";
				//System.out.println(statement);
				rs = sta.executeQuery(statement);
				while(rs.next())
				{
					Description pref = new Description(UUID.fromString(rs.getString("d_id")));
					pref.setTitle(rs.getString("title"));
					pref.setTimeStamp(Tools.DTfromTS(rs.getLong("timestamp")));
					pref.getAge().set(rs.getInt("age"), rs.getInt("age_max"));
					pref.getGender().loadString(rs.getString("gender"));
					pref.getSexuality().loadString(rs.getString("sexuality"));
					pref.getArea().loadString(rs.getString("region"));
					pref.getSmoking().loadString(rs.getString("smoking"));
					pref.getDrinking().loadString(rs.getString("drinking"));
					u.getPreferences().add(pref);
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disconnect();
			String[] result = new String[users.size()];
			for (int i = 0; i < result.length; i++)
			{
				result[i] = Tools.UserToString(users.get(i), true);
			}
			return result;
		}
	}
	
	/**
	 * Verifies a users login
	 * @param username The username of the user
	 * @param password The Password of the user
	 * @return true on success
	 */
	public boolean verifyLogin(String username, String password)
	{
		boolean passwordMatch = false;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(u_id) AS number FROM user WHERE ");
		sb.append("username = '").append(username).append("' AND ");
		sb.append("password = '").append(password).append("'");
		
		try
		{
			connect();
			ResultSet rs = sta.executeQuery(sb.toString());
			rs.first();
			
			if(rs.getInt("number") == 1)
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
}
