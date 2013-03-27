using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace StalkrAdminTool
{
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
			string query = "SELECT * FROM user AS usr " +
				"INNER JOIN description AS dscr ON usr.u_id = dscr.d_id " +
				"INNER JOIN userdescription AS ud ON usr.u_id = ud.u_id " +
				"INNER JOIN description AS pref ON ud.d_id = pref.d_id";

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
					User u = new User(new Guid(dataReader["u_id"].ToString()));
					u.Username = dataReader["username"].ToString();
					u.FirstName = dataReader["firstname"].ToString();
					u.LastName = dataReader["lastname"].ToString();
					u.Password = dataReader["password"].ToString();
					u.Birthday = StalkrToolbelt.TStoDT(Convert.ToDouble(dataReader["birthday"]));
					u.Email = dataReader["email"].ToString();
					u.Location = new GeoLocation(Convert.ToSingle(dataReader["loc_lat"]), Convert.ToSingle(dataReader["loc_lon"]), StalkrToolbelt.TStoDT(Convert.ToDouble(dataReader["loc_tim"])));

					u.Description = new Description(new Guid(dataReader[10].ToString()));
					u.Description.TimeStamp = StalkrToolbelt.TStoDT(Convert.ToDouble(dataReader[11]));
					u.Description.Title = dataReader[12].ToString();
					u.Description.Age = new Range(Convert.ToInt32(dataReader[13].ToString()), Convert.ToInt32(dataReader[14].ToString()));
					u.Description.Gender = EnumList<GenderType>.FromString(dataReader[15].ToString());
					u.Description.Sexuality = EnumList<SexualityType>.FromString(dataReader[16].ToString());
					//country = 17
					u.Description.Area = EnumList<AreaType>.FromString(dataReader[18].ToString());
					//city = 19
					u.Description.Smoking = EnumList<SmokingType>.FromString(dataReader[20].ToString());
					u.Description.Drinking = EnumList<DrinkingType>.FromString(dataReader[21].ToString());

					u.Preferences.Add(new Description(new Guid(dataReader[24].ToString())));
					u.Preferences[0].TimeStamp = StalkrToolbelt.TStoDT(Convert.ToDouble(dataReader[25]));
					u.Preferences[0].Title = dataReader[26].ToString();
					u.Preferences[0].Age = new Range(Convert.ToInt32(dataReader[27].ToString()), Convert.ToInt32(dataReader[28].ToString()));
					u.Preferences[0].Gender = EnumList<GenderType>.FromString(dataReader[29].ToString());
					u.Preferences[0].Sexuality = EnumList<SexualityType>.FromString(dataReader[30].ToString());
					//country = 31
					u.Preferences[0].Area = EnumList<AreaType>.FromString(dataReader[32].ToString());
					//city = 33
					u.Preferences[0].Smoking = EnumList<SmokingType>.FromString(dataReader[34].ToString());
					u.Preferences[0].Drinking = EnumList<DrinkingType>.FromString(dataReader[35].ToString());

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
