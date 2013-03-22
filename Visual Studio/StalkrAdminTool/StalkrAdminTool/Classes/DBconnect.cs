using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace StalkrAdminTool
{
	/// <summary>
	/// Class with commonly used static functions (Put in their's own class so they are easy to move if needed)
	/// </summary>
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

	/// <summary>
	/// Class for connecting to the database (should be replaced with the java web service at some point) 
	/// </summary>
	class DBConnect
	{
		// Class global variables
		private MySqlConnection connection;
		private string server;
		private string database;
		private string uid;
		private string password;

		// Constructor
		public DBConnect()
		{
			Initialize();
		}

		// Initialize values
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

		// open connection to database
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

		// Close connection
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

		// Select all users from the database
		public List<User> SelectAllUsers()
		{
			string query = "SELECT * FROM user AS usr INNER JOIN description AS dscr ON usr.info_description = dscr.guid INNER JOIN description AS pref ON usr.pref_description = pref.guid";

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
					User u = new User(new Guid(dataReader["guid"].ToString()));
					u.Name = new Names(dataReader["username"].ToString(), dataReader["displayname"].ToString(), dataReader["firstname"].ToString(), dataReader["lastname"].ToString());
					u.Password = dataReader["password"].ToString();
					u.Birthdate = StalkrToolBelt.TStoDT(Convert.ToDouble(dataReader["birthday"]));
					u.Email = dataReader["email"].ToString();
					u.Location = new GeoLocation(Convert.ToSingle(dataReader["location_latitude"]), Convert.ToSingle(dataReader["location_longitude"]), StalkrToolBelt.TStoDT(Convert.ToDouble(dataReader["location_timestamp"])));

					u.Description = new Description(new Guid(dataReader[13].ToString()));
					u.Description.TimeStamp = StalkrToolBelt.TStoDT(Convert.ToDouble(dataReader[14]));
					u.Description.Gender = (GenderType) Convert.ToInt32(dataReader[20].ToString());
					u.Description.Sexuality = (SexualityType) Convert.ToInt32(dataReader[23].ToString());
					u.Description.Age = new AgeRange(Convert.ToInt32(dataReader[18].ToString()), Convert.ToInt32(dataReader[19].ToString()));
					u.Description.Area = (AreaType) Convert.ToInt32(dataReader[16].ToString());
					u.Description.Smoking = (SmokingType) Convert.ToInt32(dataReader[21].ToString());
					u.Description.Drinking = (DrinkingType) Convert.ToInt32(dataReader[22].ToString());

					u.Preferences = new Description(new Guid(dataReader[24].ToString()));
					u.Description.TimeStamp = StalkrToolBelt.TStoDT(Convert.ToDouble(dataReader[25]));
					u.Description.Gender = (GenderType) Convert.ToInt32(dataReader[31].ToString());
					u.Description.Sexuality = (SexualityType) Convert.ToInt32(dataReader[34].ToString());
					u.Description.Age = new AgeRange(Convert.ToInt32(dataReader[29].ToString()), Convert.ToInt32(dataReader[30].ToString()));
					u.Description.Area = (AreaType) Convert.ToInt32(dataReader[27].ToString());
					u.Description.Smoking = (SmokingType) Convert.ToInt32(dataReader[32].ToString());
					u.Description.Drinking = (DrinkingType) Convert.ToInt32(dataReader[33].ToString());

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
	}
}
