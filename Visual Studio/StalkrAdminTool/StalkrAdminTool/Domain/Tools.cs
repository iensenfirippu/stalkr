using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace StalkrAdminTool
{
	/// <summary>
	/// Class with commonly used static functions (Put in their's own class so they are easy to move if needed)
	/// </summary>
	public class Tools
	{
		// First version of the validation string
		private static string UVS01 = "^[A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12}\\|[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\|[A-Za-z0-9]*\\|[A-Za-z0-9\\ ]*\\|[A-Za-z0-9\\ ]*\\|[A-Za-z0-9\\ ]*\\|[0-9]+\\|[0-9.]+\\|[0-9.]+\\|[0-9]+\\|[0-9]+\\|[A-Za-z0-9\\ ]*\\|[0-9]+\\|[0-9]+\\|[0-1]{5}\\|[0-1]{4}\\|[0-1]{5}\\|[0-1]{3}\\|[0-1]{2}(\\{[A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12}\\|[0-9]+\\|[A-Za-z0-9\\ ]*\\|[0-9]+\\|[0-9]+\\|[0-1]{5}\\|[0-1]{4}\\|[0-1]{5}\\|[0-1]{3}\\|[0-1]{2})*$";
		// Second version, added support for saving fields selectively
		private static string UVS02 = "^([A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12}){1}\\|([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+(?:\\.[A-Za-z]{2,4}){1,2}){0,1}\\|([A-Za-z0-9]+){0,1}\\|([A-Za-z0-9\\ ]+){0,1}\\|([A-Za-z0-9\\ ]+){0,1}\\|([A-Za-z0-9\\ ]+){0,1}\\|((?:-){0,1}[0-9]+){0,1}\\|((?:-){0,1}[0-9]+\\.[0-9]+){0,1}\\|((?:-){0,1}[0-9]+\\.[0-9]+){0,1}\\|([0-9]+){0,1}\\|([0-9]+){0,1}\\|([A-Za-z0-9\\ ]+){0,1}\\|([0-9]+){0,1}\\|([0-9]+){0,1}\\|([0-1]{5}){0,1}\\|([0-1]{4}){0,1}\\|([0-1]{5}){0,1}\\|([0-1]{3}){0,1}\\|([0-1]{2}){0,1}(?:\\{([A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12}){1}\\|([0-9]+){0,1}\\|([A-Za-z0-9\\ ]+){0,1}\\|([0-9]+){0,1}\\|([0-9]+){0,1}\\|([0-1]{5}){0,1}\\|([0-1]{4}){0,1}\\|([0-1]{5}){0,1}\\|([0-1]{3}){0,1}\\|([0-1]{2}){0,1}|)*$";

		private static string LOCFORM = "0.0#######";

		/// <summary>
		/// Converts a DateTime object into a Unix Timstamp
		/// </summary>
		public static long DTtoTS(DateTime dateTime)
		{
			DateTime epoch = new DateTime(1970, 1, 1, 0, 0, 0, 0);
			TimeSpan span = (dateTime - epoch);
			return Convert.ToInt32(span.TotalSeconds);
		}

		/// <summary>
		/// Converts a Unix Timstamp into a DateTime object
		/// </summary>
		public static DateTime DTfromTS(double unixTimeStamp)
		{
			// Unix timestamp is seconds past epoch
			System.DateTime dtDateTime = new DateTime(1970, 1, 1, 0, 0, 0, 0);
			dtDateTime = dtDateTime.AddSeconds(unixTimeStamp);
			return dtDateTime;
		}

		/// <summary>
		/// Tries to validates a given string as a userstring
		/// </summary>
		/// <param name="userasstring">A user object formatted as a string</param>
		/// <returns>returns 0 if invalid, otherwise the version number of the validation which the string conforms to</returns>
		public static float ValidateUserString(String userasstring)
		{
			float result = 0f;

			// Regular expression matching
			Match match = Regex.Match(userasstring, UVS02);

			// Try to validate the userstring against the newest version
			if (match.Success) { result = 0.2f; }

			// ...or try to validate the userstring against older versions
			else
			{
				match = Regex.Match(userasstring, UVS01);
				if (match.Success) { result = 0.1f; }
			}

			return result;
		}

		/// <summary>
		/// Converts a User object into a string
		/// </summary>
		/// <param name="u">User object to convert</param>
		/// <returns></returns>
		public static String UserToString(User u, bool full)
		{
			String result = UserToStringV02(u, full);
			System.Console.Out.WriteLine(result);
			return result;
		}

		public static String UserToStringV01(User u, bool full)
		{
			StringBuilder sb = new StringBuilder();

			try
			{
				GeoLocation l = u.Location;
				Description d = u.Description;

				sb.Append(u.UniqueID)										.Append("|");
				sb.Append(u.Email)											.Append("|");
				sb.Append(u.Username)										.Append("|");
				sb.Append(u.Password)										.Append("|");
				sb.Append(u.FirstName)										.Append("|");
				sb.Append(u.LastName)										.Append("|");
				sb.Append(Convert.ToInt32(Tools.DTtoTS(u.Birthday)))		.Append("|");
				sb.Append(Convert.ToSingle(l.Latitude))						.Append("|");
				sb.Append(Convert.ToSingle(l.Longitude))					.Append("|");
				sb.Append(Convert.ToInt32(Tools.DTtoTS(l.TimeStamp)))		.Append("|");
				sb.Append(Convert.ToInt32(Tools.DTtoTS(d.TimeStamp)))		.Append("|");
				sb.Append(d.Title)											.Append("|");
				sb.Append(Convert.ToInt16(d.Age.Min))						.Append("|");
				sb.Append(Convert.ToInt16(d.Age.Max))						.Append("|");
				sb.Append(d.Gender.ToString())								.Append("|");
				sb.Append(d.Sexuality.ToString())							.Append("|");
				sb.Append(d.Area.ToString())								.Append("|");
				sb.Append(d.Smoking.ToString())								.Append("|");
				sb.Append(d.Drinking.ToString());
				foreach (Description p in u.Preferences)
				{
					sb.Append("{");
					sb.Append(p.UniqueID.ToString())						.Append("|");
					sb.Append(Convert.ToInt32(Tools.DTtoTS(p.TimeStamp)))	.Append("|");
					sb.Append(p.Title)										.Append("|");
					sb.Append(Convert.ToInt16(p.Age.Min))					.Append("|");
					sb.Append(Convert.ToInt16(p.Age.Max))					.Append("|");
					sb.Append(p.Gender.ToString())							.Append("|");
					sb.Append(p.Sexuality.ToString())						.Append("|");
					sb.Append(p.Area.ToString())							.Append("|");
					sb.Append(p.Smoking.ToString())							.Append("|");
					sb.Append(p.Drinking.ToString());
				}
			}
			catch (Exception e)
			{
				sb = new StringBuilder();
			}

			return sb.ToString();
		}
		private static String UserToStringV02(User u, bool full)
		{
			StringBuilder sb = new StringBuilder();
		
			try
			{
				GeoLocation l = u.Location;
				Description d = u.Description;

				// User
				sb.Append(u.UniqueID);																sb.Append("|");
				if (full || u.IsChanged("email"))		{ sb.Append(u.Email); }						sb.Append("|");
				if (full || u.IsChanged("username"))	{ sb.Append(u.Username); }					sb.Append("|");
				if (full || u.IsChanged("password"))	{ sb.Append(u.Password); }					sb.Append("|");
				if (full || u.IsChanged("firstname"))	{ sb.Append(u.FirstName); }					sb.Append("|");
				if (full || u.IsChanged("lastname"))	{ sb.Append(u.LastName); }					sb.Append("|");
				if (full || u.IsChanged("birthday"))
					{ sb.Append(Tools.DTtoTS(u.Birthday)).ToString(); }								sb.Append("|");
				if (full || u.IsChanged("location")) {
					sb.Append(l.Latitude.ToString(LOCFORM))											  .Append("|");
					sb.Append(l.Longitude.ToString(LOCFORM))										  .Append("|");
					sb.Append(Tools.DTtoTS(l.TimeStamp).ToString())									  .Append("|");
				} else { sb.Append("|||"); }

				// Description
				if (full || d.IsChanged("timestamp"))
					{ sb.Append(Tools.DTtoTS(d.TimeStamp).ToString()); }							sb.Append("|");
				if (full || d.IsChanged("title"))		{ sb.Append(d.Title); }						sb.Append("|");
				if (full || d.IsChanged("age")) {
					sb.Append(d.Age.Min.ToString())													  .Append("|");
					sb.Append(d.Age.Max.ToString())													  .Append("|");
				} else { sb.Append("||"); }
				if (full || d.IsChanged("gender"))		{ sb.Append(d.Gender.ToString()); }			sb.Append("|");
				if (full || d.IsChanged("sexuality"))	{ sb.Append(d.Sexuality.ToString()); }		sb.Append("|");
				if (full || d.IsChanged("area"))		{ sb.Append(d.Area.ToString()); }			sb.Append("|");
				if (full || d.IsChanged("smoking"))		{ sb.Append(d.Smoking.ToString()); }		sb.Append("|");
				if (full || d.IsChanged("drinking"))	{ sb.Append(d.Drinking.ToString()); }
			
				// Preferences
				foreach (Description p in u.Preferences)
				{
					sb.Append("{");
					sb.Append(p.UniqueID.ToString())												  .Append("|");
					if (full || p.IsChanged("timestamp"))
					{ sb.Append(Tools.DTtoTS(p.TimeStamp).ToString()); }							sb.Append("|");
					if (full || p.IsChanged("title"))		{ sb.Append(p.Title); }					sb.Append("|");
					if (full || p.IsChanged("age"))
					{
						sb.Append(p.Age.Min.ToString())												  .Append("|");
						sb.Append(p.Age.Max.ToString())												  .Append("|");
					}
					else { sb.Append("||"); }
					if (full || p.IsChanged("gender"))		{ sb.Append(p.Gender.ToString()); }		sb.Append("|");
					if (full || p.IsChanged("sexuality"))	{ sb.Append(p.Sexuality.ToString()); }	sb.Append("|");
					if (full || p.IsChanged("area"))		{ sb.Append(p.Area.ToString()); }		sb.Append("|");
					if (full || p.IsChanged("smoking"))		{ sb.Append(p.Smoking.ToString()); }	sb.Append("|");
					if (full || p.IsChanged("drinking"))	{ sb.Append(p.Drinking.ToString()); }
				}
			}
			catch (Exception e)
			{
				sb = new StringBuilder();
			}

			return sb.ToString();
		}

		/// <summary>
		/// Converts a string-formatted User into a user object
		/// </summary>
		/// <param name="s">The string to convert</param>
		/// <returns>The created object</returns>
		public static User UserFromString(String s)
		{
			User result = null;
			float validation = ValidateUserString(s);
			if (validation >= 0.2f) { result = UserFromStringV02(s); }
			else if (validation >= 0.1f) { result = UserFromStringV01(s); }
			return result;
		}

		private static User UserFromStringV01(String s)
		{
			User u = null;
			try
			{
				String[] parts = s.Split("\\{".ToCharArray());
				String[] ss = parts[0].Split("\\|".ToCharArray());

				u = new User(new Guid(ss[0]));
				u.Email = ss[1];
				u.Username = ss[2];
				u.Password = ss[3];
				u.FirstName = ss[4];
				u.LastName = ss[5];
				u.Birthday = Tools.DTfromTS(Convert.ToInt32(ss[6]));
				u.Location = new GeoLocation(
					Convert.ToSingle(ss[7]),
					Convert.ToSingle(ss[8]),
					Tools.DTfromTS(Convert.ToInt32(ss[9]))
				);
				Description d = new Description(new Guid(ss[0]));
				d.TimeStamp = Tools.DTfromTS(Convert.ToSingle(ss[10]));
				d.Title = ss[11];
				d.Age.Set(Convert.ToInt16(ss[12]), (Convert.ToInt16(ss[13])));
				d.Gender = EnumList<GenderType>.FromString(ss[14]);
				d.Sexuality = EnumList<SexualityType>.FromString(ss[15]);
				d.Area = EnumList<AreaType>.FromString(ss[16]);
				d.Smoking = EnumList<SmokingType>.FromString(ss[17]);
				d.Drinking = EnumList<DrinkingType>.FromString(ss[18]);
				u.Description = d;

				// Add preference descriptions if available
				if (parts.Length > 1)
				{
					for (int i = 1; i < parts.Length; i++)
					{
						ss = parts[i].Split("\\|".ToCharArray());

						Description p = new Description(new Guid(ss[0]));
						p.TimeStamp = Tools.DTfromTS(Convert.ToSingle(ss[1]));
						p.Title = ss[2];
						p.Age.Set(Convert.ToInt16(ss[3]), (Convert.ToInt16(ss[4])));
						p.Gender = EnumList<GenderType>.FromString(ss[5]);
						p.Sexuality = EnumList<SexualityType>.FromString(ss[6]);
						p.Area = EnumList<AreaType>.FromString(ss[7]);
						p.Smoking = EnumList<SmokingType>.FromString(ss[8]);
						p.Drinking = EnumList<DrinkingType>.FromString(ss[9]);
						u.Preferences.Add(p);
					}
				}
			}
			catch (Exception e)
			{
				u = null;
			}

			return u;
		}
		private static User UserFromStringV02(String s)
		{
			// No difference from v01
			return UserFromStringV01(s);
		}
	}
}
