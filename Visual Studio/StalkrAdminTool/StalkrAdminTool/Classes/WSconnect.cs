using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	public class WSconnect
	{
		// Singleton implementation
		private static WSconnect _instance;
		public static WSconnect Instance
		{
			get
			{
				if (_instance == null)
				{
					_instance = new WSconnect();
				}
				return _instance;
			}
		}

		// Class local variables
		private dk.iensenfirippu.jrpg.WS _ws;
		private string _username;
		private string _password;
		private string _permission;

		// Constructor
		private WSconnect()
		{
			_username = "";
			_password = "";
			_permission = "";
			_ws = new dk.iensenfirippu.jrpg.WS();
		}

		// Methods
		public User GetUser(Guid userid)
		{
			return Tools.UserFromString(_ws.getUser(_username, _password, userid.ToString()));
		}

		public List<User> GetUsers(Guid exclude)
		{
			List<User> list = new List<User>();

			string[] strings = _ws.getUsers(_username, _password, exclude.ToString());
			foreach (string s in strings)
			{
				list.Add(Tools.UserFromString(s));
			}

			return list;
		}

		public string SaveUser(User user)
		{
			string result = "";
			if (_permission[3] == '1' && _permission[4] == '1')
			{
				result = _ws.saveUser(_username, _password, Tools.UserToString(user, false));
			}
			return result;
		}

		public string DeleteUser(Guid userid)
		{
			string result = "";
			if (_permission[5] == '1')
			{
				result = _ws.deleteUser(_username, _password, userid.ToString());
			}
			return result;
		}

		public void Login(string username, string password)
		{
			_username = username;
			_password = password;
			_permission = _ws.loginAdmin(_username, _password);
		}

		// Properties
		public string Username
		{
			get { return _username; }
		}
		public string Password
		{
			get { return _password; }
		}
		public string Permission
		{
			get { return _permission; }
		}
	}
}
