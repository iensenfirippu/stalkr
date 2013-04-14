using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	public class WSconnect
	{
		// Class local variables
		private dk.iensenfirippu.jrpg.WS _ws;

		// Constructor
		public WSconnect()
		{
			_ws = new dk.iensenfirippu.jrpg.WS();
		}

		// Methods
		public User GetUser(Guid userid)
		{
			return Tools.UserFromString(_ws.getUser(userid.ToString()));
		}

		public List<User> GetUsers(Guid exclude)
		{
			List<User> list = new List<User>();

			string[] strings = _ws.getUsers(exclude.ToString());
			foreach (string s in strings)
			{
				list.Add(Tools.UserFromString(s));
			}

			return list;
		}

		public bool SaveUser(User user)
		{
			return _ws.saveUser(Tools.UserToString(user));
		}

		public bool DeleteUser(Guid userid)
		{
			return _ws.deleteUser("Jonazzy", "9876", userid.ToString());
		}

		public bool Login(string username, string password)
		{
			return _ws.verifyLogin(username, password);
		}
	}
}
