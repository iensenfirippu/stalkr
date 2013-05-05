package easj.jrpg.mappers;

import easj.jrpg.Match;
import easj.jrpg.stalkrlib.Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class UserMapper
{
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String SERVER = "localhost:3306";
	private static final String DATABASE = "stalkr";
	private static final String USERNAME = "stalkr";
	private static final String PASSWORD = "DatabasePassword1";
	//private static final String USERNAME = "root";	// For local testing
	//private static final String PASSWORD = "";		// For local testing
	
	private static final boolean DEBUG = false;			// For extended error messages
	
	// Error codes
	private static final String ERRNULL = "E00";		// null or empty resultset
	private static final String ERRFALS = "E01";		// boolean false
	private static final String ERRTRUE = "E10";		// boolean true
	private static final String ERRPERM = "E25";		// insufficient permissions
	private static final String ERRINVA = "E42";		// invalid userstring
	private static final String ERRSQL  = "E90";		// SQL error
	private static final String ERRUNKN = "E99";		// unidentified runtime error
	
	private static Connection _con;
	private static Statement _sta;
	
	/**
	 * Connects to the database
	 */
	private static void connect()
	{
		try
		{
			Class.forName(DRIVER);
			_con = DriverManager.getConnection("jdbc:mysql://" + SERVER + "/" + DATABASE + "?user=" + USERNAME + "&password=" + PASSWORD);
			_sta = _con.createStatement();
		}
		catch (Exception e)
		{
			//e.printStackTrace();
		}
	}
	
	/**
	 * Closes the connection with the database
	 */
	private static void disconnect()
	{
		try
		{
			_sta.close();
			_sta = null;
			_con.close();
			_con = null;
		}
		catch (Exception e)
		{
			//e.printStackTrace();
		}
	}

	/**
	 * Verifies a users login
	 * @param username The username of the user
	 * @param password The Password of the user
	 * @return Error code string (E01 on success).
	 */
	public static String userLogin(String username, String password)
	{
		String result = ERRFALS;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(u_id) AS number FROM user WHERE ");
		sb.append("username = '").append(username).append("' AND ");
		sb.append("password = '").append(password).append("'");
		
		try
		{
			connect();
			ResultSet rs = _sta.executeQuery(sb.toString());
			rs.first();
			
			if(rs.getInt("number") == 1)
			{
				result = ERRTRUE;
			}
		}
		catch (SQLException ex)
		{
			result = ERRSQL;
		}
		catch (Exception ex)
		{
			result = ERRUNKN;
		}
		finally
		{
			disconnect();
		}
		
		return result;
	}

	/**
	 * Verifies an administrators login
	 * @param username The username of the administrator
	 * @param password The Password of the administrator
	 * @return permission string
	 */
	public static String adminLogin(String username, String password)
	{
		String result = "000000";
		
		if (!username.equals("") && !password.equals(""))
		{
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT permission FROM admin WHERE ");
			sb.append("username = '").append(username).append("' AND ");
			sb.append("password = '").append(password).append("'");

			try
			{
				connect();
				ResultSet rs = _sta.executeQuery(sb.toString());

				while (rs.next())
				{
					result = rs.getString("permission");
				}
			}
			//catch (SQLException ex) { result = ERRSQL; }
			catch (Exception ex) { /*result = ERRUNKN;*/ }
			finally
			{
				disconnect();
			}
		}
		
		return result;
	}
	
	/**
	 * Fetches a single User from the database
	 * @param username The username of the user
	 * @param password The Password of the user
	 * @param uuid ID of the user to fetch
	 * @return User as string
	 */
	public static String userGetUser(String username, String password, String uuid)
	{
		String result = ERRNULL;
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		// SELECT all but password in user
		sb1.append("SELECT user.u_id, user.email, user.username, ");
		sb1.append("user.firstname, user.lastname, user.birthday, ");
		sb1.append("user.loc_lat, user.loc_lon, user.loc_tim, ");
		// SELECT all but id in description
		sb1.append("dscr.timestamp, dscr.title, dscr.age, dscr.age_max, dscr.gender, ");
		sb1.append("dscr.sexuality, dscr.region, dscr.smoking, dscr.drinking ");
		// FROM user table
		sb1.append("FROM user ");
		sb1.append("INNER JOIN description AS dscr ON user.u_id = dscr.d_id ");
		sb1.append("WHERE user.u_id = '").append(uuid).append("' ");
		
		// SELECT all fields from all preferences
		sb2.append("SELECT ud.u_id, pref.* FROM description AS pref ");
		sb2.append("INNER JOIN userdescription AS ud ON pref.d_id = ud.d_id ");
		sb2.append("WHERE ud.u_id = '").append(uuid).append("' ");
		
		try
		{
			connect();
			ResultSet rs = _sta.executeQuery(sb1.toString());
			StringBuilder user = new StringBuilder();
			rs.first();
			
			// USER
			user.append(rs.getString("u_id"))					.append("|");
			user.append(rs.getString("email"))					.append("|");
			user.append(rs.getString("username"))				.append("|");
			/*user.append(rs.getString("password"))	*/user		.append("|");
			user.append(rs.getString("firstname"))				.append("|");
			user.append(rs.getString("lastname"))				.append("|");
			user.append(Long.toString(rs.getLong("birthday")))	.append("|");
			
			// LOCATION
			user.append(Float.toString(rs.getFloat("loc_lat")))	.append("|");
			user.append(Float.toString(rs.getFloat("loc_lon")))	.append("|");
			user.append(Long.toString(rs.getLong("loc_tim")))	.append("|");
			
			// DESCRIPTION
			user.append(rs.getLong("timestamp"))				.append("|");
			user.append(rs.getString("title"))					.append("|");
			user.append(rs.getInt("age"))						.append("|");
			user.append(rs.getInt("age_max"))					.append("|");
			user.append(rs.getString("gender"))					.append("|");
			user.append(rs.getString("sexuality"))				.append("|");
			user.append(rs.getString("region"))					.append("|");
			user.append(rs.getString("smoking"))				.append("|");
			user.append(rs.getString("drinking"))				;
			
			rs = _sta.executeQuery(sb2.toString());
			while (rs.next())
			{
				// PREFERENCE
				user.append("{");
				user.append(rs.getString("d_id"))				.append("|");
				user.append(rs.getLong("timestamp"))			.append("|");
				user.append(rs.getString("title"))				.append("|");
				user.append(rs.getInt("age"))					.append("|");
				user.append(rs.getInt("age_max"))				.append("|");
				user.append(rs.getString("gender"))				.append("|");
				user.append(rs.getString("sexuality"))			.append("|");
				user.append(rs.getString("region"))				.append("|");
				user.append(rs.getString("smoking"))			.append("|");
				user.append(rs.getString("drinking"))			;
			}
			
			result = user.toString();
		}
		catch (SQLException ex)	{ result = ERRSQL; }
		catch (Exception ex)	{ result = ERRUNKN; }
		finally
		{
			disconnect();
			if (Tools.ValidateUserString(result) == 0f) { result = ERRINVA; }
		}
		
		return result;
	}
	
	/**
	 * Fetches a list of users from the database
	 * @param username The username of the user
	 * @param password The Password of the user
	 * @param uuid ID of user to exclude
	 * @return Users as strings in array
	 */
	public static String[] adminGetUsers(String username, String password, String uuid)
	{
		String admin = adminLogin(username, password);
		String[] result = new String[1];
		
		if (admin.charAt(3) == '1' || admin.charAt(4) == '1' || admin.charAt(5) == '1')
		{
			ArrayList<StringBuilder> users = new ArrayList<StringBuilder>();

			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();

			// SELECT all but password in user
			sb1.append("SELECT user.u_id, user.email, user.username, ");
			sb1.append("user.firstname, user.lastname, user.birthday, ");
			sb1.append("user.loc_lat, user.loc_lon, user.loc_tim, ");
			// SELECT all but id in description
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
				ResultSet rs = _sta.executeQuery(sb1.toString());

				while(rs.next())
				{
					StringBuilder user = new StringBuilder();

					// USER
					user.append(rs.getString("u_id"))						.append("|");
					user.append(rs.getString("email"))						.append("|");
					user.append(rs.getString("username"))					.append("|");
					/*result.append(rs.getString("password"))*/user			.append("|");
					user.append(rs.getString("firstname"))					.append("|");
					user.append(rs.getString("lastname"))					.append("|");
					user.append(Long.toString(rs.getLong("birthday")))		.append("|");

					// LOCATION
					user.append(Float.toString(rs.getFloat("loc_lat")))		.append("|");
					user.append(Float.toString(rs.getFloat("loc_lon")))		.append("|");
					user.append(Long.toString(rs.getLong("loc_tim")))		.append("|");

					// DESCRIPTION
					user.append(rs.getLong("timestamp"))					.append("|");
					user.append(rs.getString("title"))						.append("|");
					user.append(rs.getInt("age"))							.append("|");
					user.append(rs.getInt("age_max"))						.append("|");
					user.append(rs.getString("gender"))						.append("|");
					user.append(rs.getString("sexuality"))					.append("|");
					user.append(rs.getString("region"))						.append("|");
					user.append(rs.getString("smoking"))					.append("|");
					user.append(rs.getString("drinking"))					;

					users.add(user);
				}

				for (StringBuilder u : users)
				{
					String statement = sb2.toString() + "'" + u.substring(0, 36) + "'";
					rs = _sta.executeQuery(statement);

					while (rs.next())
					{
						// PREFERENCE
						u.append("{");
						u.append(rs.getString("d_id"))						.append("|");
						u.append(rs.getLong("timestamp"))					.append("|");
						u.append(rs.getString("title"))						.append("|");
						u.append(rs.getInt("age"))							.append("|");
						u.append(rs.getInt("age_max"))						.append("|");
						u.append(rs.getString("gender"))					.append("|");
						u.append(rs.getString("sexuality"))					.append("|");
						u.append(rs.getString("region"))					.append("|");
						u.append(rs.getString("smoking"))					.append("|");
						u.append(rs.getString("drinking"))					;
					}
				}

				result = new String[users.size()];
				for (int i = 0; i < result.length; i++)
				{
					result[i] = users.get(i).toString();
					if (Tools.ValidateUserString(result[i]) == 0f) { result[i] = ERRINVA; }
				}
			}
			catch (SQLException ex) { result[0] = ERRSQL; }
			catch (Exception ex) { result[0] = ERRUNKN; }
			finally
			{
				disconnect();
			}
		}
		else
		{
			result[0] = ERRPERM;
		}
		
		return result;
	}
	
	/**
	 * Saves a user to the database
	 * @param username The username of the user
	 * @param password The Password of the user
	 * @param userasstring The user as a string
	 * @return true on success
	 */
	public static String adminSaveUser(String username, String password, String userasstring)
	{
		String admin = adminLogin(username, password);
		String result = ERRINVA;
		
		if (admin.charAt(4) == '1')
		{
			if (Tools.ValidateUserString(userasstring) >= 0.2f)
			{
				result = ERRFALS;

				//boolean allowed = false;
				boolean userexists = false;
				boolean descriptionexists = false;
				ArrayList<String> preferenceids = new ArrayList<String>();

				String uid = userasstring.substring(0, 36);

				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				StringBuilder sb3 = new StringBuilder();

				sb1.append("SELECT count(u_id) AS users FROM user ");
				sb1.append("WHERE u_id = '").append(uid).append("';");

				sb2.append("SELECT count(d_id) AS descriptions FROM description ");
				sb2.append("WHERE d_id = '").append(uid).append("';");

				sb3.append("SELECT d_id AS p_id FROM userdescription ");
				sb3.append("WHERE u_id = '").append(uid).append("';");

				try
				{
					connect();
					ResultSet rs;

					rs = _sta.executeQuery(sb1.toString());
					rs.first();
					if (rs.getInt("users") == 1) { userexists = true; }

					rs = _sta.executeQuery(sb2.toString());
					rs.first();
					if (rs.getInt("descriptions") == 1) { descriptionexists = true; }

					rs = _sta.executeQuery(sb3.toString());
					while (rs.next())
					{
						preferenceids.add(rs.getString("p_id"));
					}
				}
				catch (Exception ex) { /* do nothing */ }
				finally { disconnect(); }

				result = saveUser(result, uid, userexists, descriptionexists, preferenceids, userasstring);
			}
		}
		else
		{
			result = ERRPERM;
		}
		
		return result;
	}
	public static String userSaveUser(String username, String password, String userasstring)
	{
		String result = ERRINVA;
		
		if (Tools.ValidateUserString(userasstring) >= 0.2f)
		{
			result = ERRFALS;

			boolean userexists = false;
			boolean descriptionexists = false;
			ArrayList<String> preferenceids = new ArrayList<String>();

			String[] parts = userasstring.split("\\{");
			String uid = parts[0].substring(0, 36);

			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();

			sb1.append("SELECT count(u_id) AS users FROM user ");
			sb1.append("WHERE u_id = '").append(uid).append("' ");
			sb1.append("AND username = '").append(username).append("' ");
			sb1.append("AND password = '").append(password).append("';");

			sb2.append("SELECT count(d_id) AS descriptions FROM description ");
			sb2.append("WHERE d_id = '").append(uid).append("';");

			sb3.append("SELECT d_id AS p_id FROM userdescription ");
			sb3.append("WHERE u_id = '").append(uid).append("';");

			try
			{
				connect();
				ResultSet rs;

				rs = _sta.executeQuery(sb1.toString());
				rs.first();
				if (rs.getInt("users") == 1) { userexists = true; }

				rs = _sta.executeQuery(sb2.toString());
				rs.first();
				if (rs.getInt("descriptions") == 1) { descriptionexists = true; }

				rs = _sta.executeQuery(sb3.toString());
				while (rs.next())
				{
					preferenceids.add(rs.getString("p_id"));
				}
			}
			catch (Exception ex) { /* do nothing */ }
			finally
			{
				disconnect();
			}

			if (userexists)
			{
				result = saveUser(result, uid, userexists, descriptionexists, preferenceids, userasstring);
			}
			else
			{
				result = ERRPERM;
			}
		}
		
		return result;
	}
	private static String saveUser(String result, String uid, boolean userexists, boolean descriptionexists, ArrayList<String> preferenceids, String userasstring)
	{
		String[] parts = userasstring.split("\\{");
		int expectedrows = 0;
		ArrayList<String> sqlstatements = new ArrayList<String>();

		// user UPDATE
		if (userexists)
		{
			String statement = makeStatement_UpdateUser(parts[0]);
			if (!statement.equals("")) // If no fields were changed, ignore
			{
				expectedrows++;
				sqlstatements.add(statement);
			}
		}
		// user INSERT
		else
		{
			expectedrows++;
			sqlstatements.add(makeStatement_InsertUser(parts[0]));
		}

		// Description UPDATE
		if (descriptionexists)
		{
			String statement = makeStatement_UpdateDescription(parts[0]);
			if (!statement.equals("")) // If no fields were changed, ignore
			{
				expectedrows++;
				sqlstatements.add(statement);
			}
		}
		// Description INSERT
		else
		{
			expectedrows++;
			sqlstatements.add(makeStatement_InsertDescription(parts[0]));
		}

		for (int i = 1; i < parts.length; i++)
		{
			String pid = parts[i].substring(0, 36);

			// Preference UPDATE
			if (preferenceids.contains(pid))
			{
				String statement = makeStatement_UpdatePreference(parts[i]);
				if (!statement.equals(""))
				{
					expectedrows++;
					sqlstatements.add(statement);
				}
				preferenceids.remove(pid);
			}
			// Preference INSERT
			else
			{
				expectedrows += 2;
				sqlstatements.add(makeStatement_InsertPreference(parts[i]));
				sqlstatements.add(makeStatement_InsertUserDescription(uid, pid));
			}
		}
		// Preference DELETE
		for (String id : preferenceids)
		{
			expectedrows += 2;
			sqlstatements.add(makeStatement_DeleteDescription(id));
			sqlstatements.add(makeStatement_DeleteUserDescription(id));
		}

		try
		{
			connect();
			int rowsaffected = 0;

			for (String statement : sqlstatements)
			{
				if (DEBUG) { result = statement; }
				rowsaffected += _sta.executeUpdate(statement);
			}

			if (rowsaffected == expectedrows)
			{
				result = ERRTRUE;
			}
		}
		catch (SQLException ex)
		{
				if (DEBUG)	{ result = ERRSQL + ": " + result; }
				else		{ result = ERRSQL; }
		}
		catch (Exception ex)
		{
				if (DEBUG)	{ result = ERRUNKN + ": " + ex.getMessage(); }
				else		{ result = ERRUNKN; }
		}
		finally
		{
			disconnect();
		}

		return result;
	}
	private static String makeStatement_InsertUser(String user) {
		String[] values = user.split("\\|", -1);
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO user (u_id, email, username, "
				+ "password, firstname, lastname, birthday, "
				+ "loc_lat, loc_lon, loc_tim"
				+ ") VALUES (");
		sb.append("'")	.append(values[0])	.append("', ");
		sb.append("'")	.append(values[1])	.append("', ");
		sb.append("'")	.append(values[2])	.append("', ");
		sb.append("'")	.append(values[3])	.append("', ");
		sb.append("'")	.append(values[4])	.append("', ");
		sb.append("'")	.append(values[5])	.append("', ");
		sb				.append(values[6])	.append( ", ");
		sb				.append(values[7])	.append( ", ");
		sb				.append(values[8])	.append( ", ");
		sb				.append(values[9])	.append(");");
		
		return sb.toString();
	}
	private static String makeStatement_UpdateUser(String user) {
		String[] values = user.split("\\|", -1);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		sb.append("UPDATE user SET ");
		if (!values[1].equals("")) { i++;							sb.append("email='")		.append(values[1]).append("'"); }
		if (!values[2].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("username='")		.append(values[2]).append("'"); }
		if (!values[3].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("password='")		.append(values[3]).append("'"); }
		if (!values[4].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("firstname='")	.append(values[4]).append("'"); }
		if (!values[5].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("lastname='")		.append(values[5]).append("'"); }
		if (!values[6].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("birthday=")		.append(values[6]); }
		if (!values[7].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("loc_lat=")		.append(values[7]); }
		if (!values[8].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("loc_lon=")		.append(values[8]); }
		if (!values[9].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("loc_tim=")		.append(values[9]); }
		sb.append(" WHERE u_id = '")	.append(values[0])	.append("';");
		
		return sb.toString();
	}
	private static String makeStatement_InsertDescription(String user) {
		String[] values = user.split("\\|", -1);
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO description (d_id, timestamp, title, age, age_max, "
				+ "gender, sexuality, region, smoking, drinking) VALUES (");
		sb.append("'")	.append(values[0])	.append("', ");
		sb				.append(values[10])	.append( ", ");
		sb.append("'")	.append(values[11])	.append("', ");
		sb				.append(values[12])	.append( ", ");
		sb				.append(values[13])	.append( ", ");
		sb.append("'")	.append(values[14])	.append("', ");
		sb.append("'")	.append(values[15])	.append("', ");
		sb.append("'")	.append(values[16])	.append("', ");
		sb.append("'")	.append(values[17])	.append("', ");
		sb.append("'")	.append(values[18])	.append("');");
		
		return sb.toString();
	}
	private static String makeStatement_UpdateDescription(String desc) {
		String[] values = desc.split("\\|", -1);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		sb.append("UPDATE description SET ");
		if(!values[10].equals("")) { i++;							sb.append("timestamp=")		.append(values[10]); }
		if(!values[11].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("title='")		.append(values[11]).append("'"); }
		if(!values[12].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("age=")			.append(values[12]); }
		if(!values[13].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("age_max=")		.append(values[13]); }
		if(!values[14].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("gender='")		.append(values[14]).append("'"); }
		if(!values[15].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("sexuality='")	.append(values[15]).append("'"); }
		if(!values[16].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("region='")		.append(values[16]).append("'"); }
		if(!values[17].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("smoking='")		.append(values[17]).append("'"); }
		if(!values[18].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("drinking='")		.append(values[18]).append("'"); }
		sb.append(" WHERE d_id = '")	.append(values[0]).append("';");
		
		if (i == 0) { sb = new StringBuilder(); }
		
		return sb.toString();
	}
	private static String makeStatement_DeleteDescription(String d_id) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("DELETE FROM description WHERE ");
		sb.append("d_id = '").append(d_id).append("';");
		
		return sb.toString();
	}
	private static String makeStatement_InsertPreference(String desc) {
		String[] values = desc.split("\\|", -1);
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO description (d_id, timestamp, title, age, age_max, "
				+ "gender, sexuality, region, smoking, drinking) VALUES (");
		sb.append("'")	.append(values[0])	.append("', ");
		sb				.append(values[1])	.append( ", ");
		sb.append("'")	.append(values[2])	.append("', ");
		sb				.append(values[3])	.append( ", ");
		sb				.append(values[4])	.append( ", ");
		sb.append("'")	.append(values[5])	.append("', ");
		sb.append("'")	.append(values[6])	.append("', ");
		sb.append("'")	.append(values[7])	.append("', ");
		sb.append("'")	.append(values[8])	.append("', ");
		sb.append("'")	.append(values[9])	.append("');");
		
		return sb.toString();
	}
	private static String makeStatement_UpdatePreference(String desc) {
		String[] values = desc.split("\\|", -1);
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		sb.append("UPDATE description SET ");
		if(!values[1].equals("")) { i++;							sb.append("timestamp=")		.append(values[1]); }
		if(!values[2].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("title='")		.append(values[2]).append("'"); }
		if(!values[3].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("age=")			.append(values[3]); }
		if(!values[4].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("age_max=")		.append(values[4]); }
		if(!values[5].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("gender='")		.append(values[5]).append("'"); }
		if(!values[6].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("sexuality='")	.append(values[6]).append("'"); }
		if(!values[7].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("region='")		.append(values[7]).append("'"); }
		if(!values[8].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("smoking='")		.append(values[8]).append("'"); }
		if(!values[9].equals("")) { if(i>0){sb.append(", ");}i++;	sb.append("drinking='")		.append(values[9]).append("'"); }
		sb.append(" WHERE d_id = '")	.append(values[0]).append("';");
		
		if (i == 0) { sb = new StringBuilder(); }
		
		return sb.toString();
	}
	private static String makeStatement_InsertUserDescription(String u_id, String d_id) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO userdescription (u_id, d_id) VALUES (");
		sb.append("'").append(u_id.toString()).append("', ");
		sb.append("'").append(d_id.toString()).append("');");
		
		return sb.toString();
	}
	private static String makeStatement_DeleteUserDescription(String d_id) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("DELETE FROM userdescription WHERE ");
		sb.append("d_id = '").append(d_id).append("';");
		
		return sb.toString();
	}
	
	/**
	 * Deletes a user from the database
	 * @param username The username of the admin
	 * @param password The Password of the admin
	 * @param uuid The ID of the user to delete
	 * @return Error code string ("E01" on success)
	 */
	public static String adminDeleteUser(String username, String password, String uuid)
	{
		String admin = adminLogin(username, password);
		String result = ERRFALS;
		
		if (admin.charAt(5) == '1')
		{
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			StringBuilder sb4 = new StringBuilder();

			sb1.append("DELETE pref.* FROM description AS pref ");
			sb1.append("INNER JOIN userdescription AS ud ON pref.d_id = ud.d_id ");
			sb1.append("WHERE ud.u_id = '").append(uuid).append("'");

			sb2.append("DELETE FROM description ");
			sb2.append("WHERE d_id = '").append(uuid).append("' ");

			sb3.append("DELETE FROM userdescription WHERE ");
			sb3.append("u_id = '").append(uuid).append("'");

			sb4.append("DELETE FROM user ");
			sb4.append("WHERE u_id = '").append(uuid).append("'");

			try
			{
				connect();

				int rowsaffected = 0;
				rowsaffected += _sta.executeUpdate(sb1.toString());
				rowsaffected += _sta.executeUpdate(sb2.toString());
				rowsaffected += _sta.executeUpdate(sb3.toString());
				rowsaffected += _sta.executeUpdate(sb4.toString());

				if (rowsaffected >= 2)
				{
					result = ERRTRUE;
				}
			}
			catch (SQLException ex) { result = ERRSQL; }
			catch (Exception ex) { result = ERRUNKN; }
			finally
			{
				disconnect();
			}
		}
		else
		{
			result = ERRPERM;
		}
		
		return result;
	}
	
	/**
	 * Deletes a user from the database
	 * @param username The username of the user
	 * @param password The Password of the user
	 * @param uuid The ID of the user to delete
	 * @return Error code string ("E01" on success)
	 */
	public static String userDeleteUser(String username, String password)
	{
		String result = ERRFALS;
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		
		sb1.append("SELECT u_id FROM user ");
		sb1.append("WHERE username = '").append(username).append("' ");
		sb1.append("AND password = '").append(password).append("' ");

		sb2.append("DELETE pref.* FROM description AS pref ");
		sb2.append("INNER JOIN userdescription AS ud ON pref.d_id = ud.d_id ");
		sb2.append("WHERE ud.u_id = '");//.append(uuid).append("'");

		sb3.append("DELETE FROM description ");
		sb3.append("WHERE d_id = '");//.append(uuid).append("' ");

		sb4.append("DELETE FROM userdescription ");
		sb4.append("WHERE u_id = '");//.append(uuid).append("'");

		sb5.append("DELETE FROM user ");
		sb5.append("WHERE u_id = '");//.append(uuid).append("';");

		try
		{
			connect();
			
			ResultSet rs = _sta.executeQuery(sb1.toString());
			rs.first();
			String uuid = rs.getString("u_id");
			
			if (!uuid.equals(""))
			{	
				sb2.append(uuid).append("';");
				sb3.append(uuid).append("';");
				sb4.append(uuid).append("';");
				sb5.append(uuid).append("';");
				
				int rowsaffected = 0;
				rowsaffected += _sta.executeUpdate(sb2.toString());
				rowsaffected += _sta.executeUpdate(sb3.toString());
				rowsaffected += _sta.executeUpdate(sb4.toString());
				rowsaffected += _sta.executeUpdate(sb5.toString());

				if (rowsaffected >= 2)
				{
					result = ERRTRUE;
				}
			}
			else
			{
				result = ERRPERM;
			}
		}
		catch (SQLException ex) { result = ERRSQL; }
		catch (Exception ex) { result = ERRUNKN; }
		finally
		{
			disconnect();
		}
		
		return result;
	}
	
	/**
	 * Returns the IDs and match-percentages of the other potential matches (within proximity, later)
	 * @param username The username of the user
	 * @param password The Password of the user
	 * @param userasstring A string-formatted user object
	 * @return String containing the id, username and match-percentage separated by | (pipe)
	 */
	public static String[] userGetMatches(String userasstring)
	{
		String[] result = new String[1];
		ArrayList<Match> matches = new ArrayList<Match>();
		ArrayList<String> statements = new ArrayList<String>();
		String[] parts = userasstring.split("\\{");
		String[] values = parts[0].split("\\|", -1);
		
		float vicinity = 100f;
		long timefrom = Tools.DTtoTS(new Date()) - (((365 * 24) * 60) * 60);
		
		int count;
		
		for (int i = 1; i< parts.length; i++)
		{
			StringBuilder sb = new StringBuilder();
			
			// SELECT ID, username and location from user
			sb.append("SELECT user.u_id, user.username, ");
				//sb.append("user.loc_lat, user.loc_lon, user.loc_tim, ");
			// SELECT all but d_id, timestamp, title and age_max from description
				//sb.append("dscr.age, dscr.gender, dscr.sexuality, ");
				//sb.append("dscr.region, dscr.smoking, dscr.drinking, ");
			// SELECT all but d_id, timestamp, title from each preference (description)
			sb.append("pref.age AS p_age, pref.age_max AS p_age_max, ");
			sb.append("pref.gender AS p_gender, pref.sexuality AS p_sexuality, ");
			sb.append("pref.region AS p_region, pref.smoking AS p_smoking, pref.drinking AS p_drinking ");
			// FROM user table
			sb.append("FROM user ");
			sb.append("INNER JOIN description AS dscr ON user.u_id = dscr.d_id ");
			sb.append("INNER JOIN userdescription AS ud ON user.u_id = ud.u_id ");
			sb.append("INNER JOIN description AS pref ON ud.d_id = pref.d_id ");

			// Exclude self
			sb	.append("WHERE user.u_id <> '").append(values[0]).append("'");

			// Search LOCATION
			sb	.append(" AND user.loc_lat BETWEEN ").append(Float.toString(Float.parseFloat(values[8]) - vicinity))
				.append(" AND ").append(Float.toString(Float.parseFloat(values[8]) + vicinity))
				.append(" AND user.loc_lat BETWEEN ").append(Float.toString(Float.parseFloat(values[9]) - vicinity))
				.append(" AND ").append(Float.toString(Float.parseFloat(values[9]) + vicinity))
				.append(" AND user.loc_tim >= ").append(timefrom);

			// Search AGE
			sb	.append(" AND dscr.age BETWEEN ").append(values[12])
				.append(" AND ").append(values[13]);

			// Search GENDER
			count = 0;
			for (char c : values[14].toCharArray()) { if (c == '1') { count++; } }
			if (count > 0)
			{
				if (count == 1)	{ sb.append(" AND dscr.gender = '").append(values[14]).append("'"); }
				else			{ sb.append(" AND dscr.gender LIKE '").append(values[14].replaceAll("1", "%")).append("'"); }
			}

			// Search SEXUALITY
			count = 0;
			for (char c : values[15].toCharArray()) { if (c == '1') { count++; } }
			if (count > 0)
			{
				if (count == 1)	{ sb.append(" AND dscr.sexuality = '").append(values[15]).append("'"); }
				else			{ sb.append(" AND dscr.sexuality LIKE '").append(values[15].replaceAll("1", "%")).append("'"); }
			}

			// Search AREA
			count = 0;
			for (char c : values[16].toCharArray()) { if (c == '1') { count++; } }
			if (count > 0)
			{
				if (count == 1)	{ sb.append(" AND dscr.region = '").append(values[16]).append("'"); }
				else			{ sb.append(" AND dscr.region LIKE '").append(values[16].replaceAll("1", "%")).append("'"); }
			}

			// Search SMOKING
			count = 0;
			for (char c : values[17].toCharArray()) { if (c == '1') { count++; } }
			if (count > 0)
			{
				if (count == 1)	{ sb.append(" AND dscr.smoking = '").append(values[17]).append("'"); }
				else			{ sb.append(" AND dscr.smoking LIKE '").append(values[17].replaceAll("1", "%")).append("'"); }
			}

			// Search DRINKING
			count = 0;
			for (char c : values[18].toCharArray()) { if (c == '1') { count++; } }
			if (count > 0)
			{
				if (count == 1)	{ sb.append(" AND dscr.drinking = '").append(values[18]).append("'"); }
				else			{ sb.append(" AND dscr.drinking LIKE '").append(values[18].replaceAll("1", "%")).append("'"); }
			}
			
			sb.append(" ORDER BY u_id ASC;");
			statements.add(sb.toString());
		}
		
		try
		{
			connect();
			Match match = null;
			for (String s : statements)
			{
				ResultSet rs = _sta.executeQuery(s);
				
				while (rs.next())
				{	
					int matched = 0;
					int outof = 0;
					
					int age =		Integer.parseInt(values[12]);	outof++;
					int gender =	values[14].indexOf("1");		outof++;
					int sexuality =	values[15].indexOf("1");		outof++;
					int area =		values[16].indexOf("1");		outof++;
					int smoking =	values[17].indexOf("1");		outof++;
					int drinking =	values[18].indexOf("1");		outof++;
					
					if (age >= rs.getInt("p_age") && age <= rs.getInt("p_age_max"))		{ matched++; }
					if (rs.getString("p_gender").charAt(gender) == '1')					{ matched++; }
					if (rs.getString("p_sexuality").charAt(sexuality) == '1')			{ matched++; }
					if (rs.getString("p_region").charAt(area) == '1')					{ matched++; }
					if (rs.getString("p_smoking").charAt(smoking) == '1')				{ matched++; }
					if (rs.getString("p_drinking").charAt(drinking) == '1')				{ matched++; }
					
					int percentage = ((50 / outof) * matched) + 50;
					
					// Check if the name of the current match is the same as the previous match
					// if not, add the previous match to the list and clear the match field.
					if (match != null && !match.getId().equals(rs.getString("u_id")))
					{
						matches.add(match);
						match = null;
					}
					// If the match was just cleared, or the current match has the same name as
					// the previous match, set the match field to the current match.
					if (match == null || match.getId().equals(rs.getString("u_id")))
					{
						if (match == null || percentage > match.getPercentage())
						{
							match = new Match(rs.getString("u_id"), rs.getString("username"), percentage);
						}
					}
				}
				
				// Add the last match
				if (match != null) { matches.add(match); }
			}
			
			result = new String[matches.size()];
			for (int i = 0; i < result.length; i++)
			{
				result[i] = matches.get(i).toString();
			}
			/*String[] result = new String[statements.size()];
			for (int i = 0; i < result.length; i++)
			{
				result[i] = statements.get(i).toString();
			}*/
		}
		catch (SQLException ex) { result[0] = ERRSQL; }
		catch (Exception ex) { result[0] = ERRUNKN; }
		finally
		{
			disconnect();
		}
		
		return result;
	}
}
