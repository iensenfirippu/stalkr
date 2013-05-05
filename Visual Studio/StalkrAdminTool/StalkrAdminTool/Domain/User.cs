using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	/// <summary>
	/// Class describing User objects
	/// </summary>
	public class User
	{
		// Class global variables
		private Guid _uniqueid;
		private String _email;
		private String _username;
		private String _password;
		private String _firstname;
		private String _lastname;
		private DateTime _birthday;
		private GeoLocation _location;
		private Description _description;
		private List<Description> _preferences;

		private Dictionary<String, bool> _alteredfields;

		// Constructors
		public User() : this(Guid.NewGuid())
		{
			SetAlteredFields(true);
		}
		public User(Guid guid)
		{
			_uniqueid = guid;
			_birthday = DateTime.Now;
			_location = new GeoLocation();
			_description = new Description();
			_preferences = new List<Description>();

			_alteredfields = new Dictionary<string, bool>();
			SetAlteredFields(false);
		}

		// Methods
		private void SetAlteredFields(bool value)
		{
			_alteredfields.Clear();
			_alteredfields.Add("uniqueid", value);
			_alteredfields.Add("email", value);
			_alteredfields.Add("username", value);
			_alteredfields.Add("password", value);
			_alteredfields.Add("firstname", value);
			_alteredfields.Add("lastname", value);
			_alteredfields.Add("birthday", value);
			_alteredfields.Add("location", value);
			_alteredfields.Add("description", value);
			_alteredfields.Add("preference", value);
		}

		public void ResetAlteredFields()
		{
			SetAlteredFields(false);
		}

		// Properties
		public Guid UniqueID
		{
			get { return _uniqueid; }
			//set { _alteredfields["uniqueid"] = true; _uniqueid = value; }
		}
		public String Email
		{
			get { return _email; }
			set { _alteredfields["email"] = true; _email = value; }
		}
		public String Username
		{
			get { return _username; }
			set { _alteredfields["username"] = true; _username = value; }
		}
		public String Password
		{
			get { return _password; }
			set { _alteredfields["password"] = true; _password = value; }
		}
		public String FirstName
		{
			get { return _firstname; }
			set { _alteredfields["firstname"] = true; _firstname = value; }
		}
		public String LastName
		{
			get { return _lastname; }
			set { _alteredfields["lastname"] = true; _lastname = value; }
		}
		public String FullName
		{
			get { return _lastname + ", " + _firstname; }
		}
		public DateTime Birthday
		{
			get { return _birthday; }
			set { _alteredfields["birthday"] = true; _birthday = value; }
		}
		public GeoLocation Location
		{
			get { return _location; }
			set { _alteredfields["location"] = true; _location = value; }
		}
		public Description Description
		{
			get { return _description; }
			set { _alteredfields["description"] = true; _description = value; }
		}
		public List<Description> Preferences
		{
			get { return _preferences; }
			set { _alteredfields["preference"] = true; _preferences = value; }
		}

		public bool IsChanged(string field)
		{
			bool result = false;
			if (_alteredfields.TryGetValue(field, out result))
			{
				return result;
			}
			else
			{
				throw new KeyNotFoundException("Key not found in Dictionary");
			}
		}
	}
}