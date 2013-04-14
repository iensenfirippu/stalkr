using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	/// <summary>
	/// Class with commonly used static functions (Put in their's own class so they are easy to move if needed)
	/// </summary>
	public class Tools
	{
		/// <summary>
		/// Converts a DateTime object into a Unix Timstamp
		/// </summary>
		public static double DTtoTS(DateTime dateTime)
		{
			DateTime epoch = new DateTime(1970, 1, 1, 0, 0, 0, 0).ToLocalTime();
			TimeSpan span = (dateTime.ToLocalTime() - epoch);
			return span.TotalSeconds;
		}

		/// <summary>
		/// Converts a Unix Timstamp into a DateTime object
		/// </summary>
		public static DateTime DTfromTS(double unixTimeStamp)
		{
			// Unix timestamp is seconds past epoch
			System.DateTime dtDateTime = new DateTime(1970, 1, 1, 0, 0, 0, 0);
			dtDateTime = dtDateTime.AddSeconds(unixTimeStamp).ToLocalTime();
			return dtDateTime;
		}

		/// <summary>
		/// Converts a User object into a string
		/// </summary>
		/// <param name="u">User object to convert</param>
		/// <returns></returns>
		public static String UserToString(User u)
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
				sb.Append(d.Drinking.ToString())							;
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
					sb.Append(p.Drinking.ToString())						;
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
					// Make sure the list is empty
					//u.Preferences.clear;

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
	}
}
