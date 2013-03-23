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
	public class StalkrToolbelt
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
		public static DateTime TStoDT(double unixTimeStamp)
		{
			// Unix timestamp is seconds past epoch
			System.DateTime dtDateTime = new DateTime(1970, 1, 1, 0, 0, 0, 0);
			dtDateTime = dtDateTime.AddSeconds(unixTimeStamp).ToLocalTime();
			return dtDateTime;
		}

		/// <summary>
		/// Converts an enum type to a list of strings
		/// </summary>
		public static List<string> EnumToStrings<T>()
		{
			List<string> value = null;

			if (typeof(T).IsEnum)
			{
				value = new List<string>();
				foreach (T t in Enum.GetValues(typeof(T)))
				{
					value.Add(t.ToString());
				}
			}

			return value;
		}
	}
}
