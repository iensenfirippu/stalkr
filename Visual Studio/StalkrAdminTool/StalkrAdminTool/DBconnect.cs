using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace StalkrAdminTool
{
	class StalkrToolBelt
	{
		/// <summary>
		/// Converts a DateTime object into a Unix Timstamp
		/// </summary>
		public static double DTtoTS (DateTime dateTime)
		{
			DateTime epoch = new DateTime(1970, 1, 1, 0, 0, 0, 0).ToLocalTime();
			TimeSpan span = (dateTime.ToLocalTime() - epoch);
			return span.TotalSeconds;
		}

		/// <summary>
		/// Converts a Unix Timstamp into a DateTime object
		/// </summary>
		public static DateTime TStoDT (double unixTimeStamp)
		{
			// Unix timestamp is seconds past epoch
			System.DateTime dtDateTime = new DateTime(1970,1,1,0,0,0,0);
			dtDateTime = dtDateTime.AddSeconds( unixTimeStamp ).ToLocalTime();
			return dtDateTime;
		}
	}

	class DBConnect
	{
		private MySqlConnection connection;
		private string server;
		private string database;
		private string uid;
		private string password;

		//Constructor
		public DBConnect()
		{
			Initialize();
		}

		//Initialize values
		private void Initialize()
		{
			server = "localhost";
			database = "stalkr";
			uid = "root";
			password = "";
			string connectionString;
			connectionString = "SERVER=" + server + ";" + "DATABASE=" +
			database + ";" + "UID=" + uid + ";" + "PASSWORD=" + password + ";";

			connection = new MySqlConnection(connectionString);
		}

		//open connection to database
		private bool OpenConnection()
		{
			try
			{
				connection.Open();
				return true;
			}
			catch (MySqlException ex)
			{
				//When handling errors, you can your application's response based 
				//on the error number.
				//The two most common error numbers when connecting are as follows:
				//0: Cannot connect to server.
				//1045: Invalid user name and/or password.
				switch (ex.Number)
				{
					case 1045:
						System.Windows.Forms.MessageBox.Show("Invalid username/password, please try again");
						break;
					default:
						System.Windows.Forms.MessageBox.Show("Cannot connect to server.  Contact administrator");
						break;
				}
				return false;
			}
		}

		//Close connection
		private bool CloseConnection()
		{
			try
			{
				connection.Close();
				return true;
			}
			catch (MySqlException ex)
			{
				System.Windows.Forms.MessageBox.Show(ex.Message);
				return false;
			}
		}

		//Insert statement
		public void InsertUser(User user)
		{
			StringBuilder sb = new StringBuilder();
			sb.Append("INSERT INTO user (username, password, firstname, birthday, location_latitude, location_longitude, location_timestamp) VALUES ('");
			sb.Append(user.Name.UserName); sb.Append("''");
			sb.Append(user.Password); sb.Append("''");
			sb.Append(user.Name.FirstName); sb.Append("''");
			sb.Append(StalkrToolBelt.DTtoTS(user.Birthdate)); sb.Append("''");
			sb.Append(user.LastLocation.Latitude); sb.Append("''");
			sb.Append(user.LastLocation.Longitude); sb.Append("''");
			sb.Append(StalkrToolBelt.DTtoTS(user.LastLocation.TimeStamp)); sb.Append("');");
			sb.Append("INSERT INTO description (region, age, gender) VALUES ('");
			sb.Append(user.Description.Area); sb.Append("''");
			sb.Append(user.Description.Age); sb.Append("''");
			sb.Append(user.Description.Gender); sb.Append("');");
			sb.Append("INSERT INTO description (region, age, gender) VALUES ('");
			sb.Append(user.Preferences.Area); sb.Append("''");
			sb.Append(user.Preferences.Age); sb.Append("''");
			sb.Append(user.Preferences.Gender); sb.Append("');");

			//open connection
			if (this.OpenConnection() == true)
			{
				//create command and assign the query and connection from the constructor
				MySqlCommand cmd = new MySqlCommand(sb.ToString(), connection);
				//Execute command
				cmd.ExecuteNonQuery();
				//close connection
				this.CloseConnection();
			}
		}

		//Update statement
		public void UpdateUser(User user)
		{
			StringBuilder sb = new StringBuilder();
			sb.Append("UPDATE user SET password='"); sb.Append(user.Password);
			sb.Append("' firstname='"); sb.Append(user.Name.FirstName);
			sb.Append("' birthday='"); sb.Append(StalkrToolBelt.DTtoTS(user.Birthdate));
			sb.Append("' location_latitude='"); sb.Append(user.LastLocation.Latitude);
			sb.Append("' location_longitude='"); sb.Append(user.LastLocation.Longitude);
			sb.Append("' location_timestamp='"); sb.Append(StalkrToolBelt.DTtoTS(user.LastLocation.TimeStamp));
			sb.Append("' WHERE username='"); sb.Append(user.Name.UserName); sb.Append("';");
			sb.Append("UPDATE description SET region='"); sb.Append(user.Description.Area);
			sb.Append("' age='"); sb.Append(user.Description.Age);
			sb.Append("' gender='"); sb.Append(user.Description.Gender);
			sb.Append("' WHERE id='"); sb.Append(user.Description.Index); sb.Append("';");
			sb.Append("UPDATE description SET region='"); sb.Append(user.Preferences.Area);
			sb.Append("' age='"); sb.Append(user.Preferences.Age);
			sb.Append("' gender='"); sb.Append(user.Preferences.Gender);
			sb.Append("' WHERE id='"); sb.Append(user.Preferences.Index); sb.Append("';");

			//Open connection
			if (this.OpenConnection() == true)
			{
				//create mysql command
				MySqlCommand cmd = new MySqlCommand();
				//Assign the query using CommandText
				cmd.CommandText = sb.ToString();
				//Assign the connection using Connection
				cmd.Connection = connection;

				//Execute query
				cmd.ExecuteNonQuery();

				//close connection
				this.CloseConnection();
			}
		}

		//Delete statement
		public void Delete()
		{
			string query = "DELETE FROM tableinfo WHERE name='John Smith'";

			if (this.OpenConnection() == true)
			{
				MySqlCommand cmd = new MySqlCommand(query, connection);
				cmd.ExecuteNonQuery();
				this.CloseConnection();
			}
		}

		//Select statement
		public List<User> SelectAllUsers()
		{
			string query = "SELECT * FROM user";

			//Create a list to store the result
			List<User> list = new List<User>();

			//Open connection
			if (this.OpenConnection() == true)
			{
				//Create Command
				MySqlCommand cmd = new MySqlCommand(query, connection);
				//Create a data reader and Execute the command
				MySqlDataReader dataReader = cmd.ExecuteReader();

				//Read the data and store them in the list
				while (dataReader.Read())
				{
					User u = new User(
						new Names(
							dataReader["username"].ToString(),
							dataReader["displayname"].ToString(),
							dataReader["firstname"].ToString(),
							dataReader["lastname"].ToString()
						),
						dataReader["password"].ToString(),
						StalkrToolBelt.TStoDT(Convert.ToDouble(dataReader["birthday"])),
						dataReader["email"].ToString(),
						new GeoLocation(
							Convert.ToSingle(dataReader["location_latitude"]),
							Convert.ToSingle(dataReader["location_longitude"]),
							StalkrToolBelt.TStoDT(Convert.ToDouble(dataReader["location_timestamp"]))
						)
					);
					list.Add(u);
				}

				//close Data Reader
				dataReader.Close();

				//close Connection
				this.CloseConnection();

				//return list to be displayed
				return list;
			}
			else
			{
				return list;
			}
		}

		//Count statement
		public int Count()
		{
			string query = "SELECT Count(*) FROM tableinfo";
			int Count = -1;

			//Open Connection
			if (this.OpenConnection() == true)
			{
				//Create Mysql Command
				MySqlCommand cmd = new MySqlCommand(query, connection);

				//ExecuteScalar will return one value
				Count = int.Parse(cmd.ExecuteScalar() + "");

				//close Connection
				this.CloseConnection();

				return Count;
			}
			else
			{
				return Count;
			}
		}
	}
}
