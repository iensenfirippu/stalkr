﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	public class Names
	{
		private String _username;
		private String _displayname;
		private String _firstname;
		private String _lastname;

		public Names() : this("", "", "", "") { }
		public Names(String username) : this(username, "", "", "") { }
		public Names(String username, String firstname, String lastname) : this(username, firstname, firstname, lastname) { }
		public Names(String username, String displayname, String firstname, String lastname)
		{
			_username = username;
			_displayname = displayname;
			_firstname = firstname;
			_lastname = lastname;
		}

		public String UserName
		{
			get { return _username; }
			set { _username = value; }
		}
		public String DisplayName
		{
			get { return _displayname; }
			set { _displayname = value; }
		}
		public String FirstName
		{
			get { return _firstname; }
			set { _firstname = value; }
		}
		public String LastName
		{
			get { return _lastname; }
			set { _lastname = value; }
		}
		public String FullName
		{
			get { return _lastname + ", " + _firstname; }
		}
	}

	public class User
	{
		private Names _name;
		private String _password;
		private DateTime _birthdate;
		private String _email;
		private Description _description;
		private Description _preference;

		private GeoLocation _lastLocation;
		
		public User(Names name, String password, DateTime birthdate, String email, GeoLocation location)
			: this(name, password, birthdate, email, location, null, null) { }
		public User(Names name, String password, DateTime birthdate, String email, GeoLocation lastLocation, Description description, Description preference)
		{
			_name = name;
			_password = password;
			_birthdate = birthdate;
			_email = email;
			_description = description;
			_preference = preference;
			_lastLocation = lastLocation;
		}

		public Names Name
		{
			get { return _name; }
			set { _name = value; }
		}
		public String Password
		{
			get { return _password; }
			set { _password = value; }
		}
		public DateTime Birthdate
		{
			get { return _birthdate; }
			set { _birthdate = value; }
		}
		public String Email
		{
			get { return _email; }
			set { _email = value; }
		}
		public Description Description
		{
			get { return _description; }
			set { _description = value; }
		}
		public Description Preferences
		{
			get { return _preference; }
			set { _preference = value; }
		}
		public GeoLocation LastLocation
		{
			get { return _lastLocation; }
			set { _lastLocation = value; }
		}
	}
}