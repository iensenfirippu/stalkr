using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StalkrAdminTool
{
	public class GeoLocation
	{
		private float _latitude;
		private float _longitude;
		private DateTime _timestamp;

		public GeoLocation() : this(0, 0, DateTime.Now) {}
		public GeoLocation(float lat, float lon) : this(lat, lon, DateTime.Now) {}
		public GeoLocation(float lat, float lon, DateTime time)
		{
			_latitude = lat;
			_longitude = lon;
			_timestamp = time;
		}

		//public static GeoLocation Empty
		//{
		//	get { return new GeoLocation(); }
		//}

		public float Latitude
		{
			get { return _latitude; }
		}
		public float Longitude
		{
			get { return _longitude; }
		}
		public DateTime TimeStamp
		{
			get { return _timestamp; }
		}
	}
}
