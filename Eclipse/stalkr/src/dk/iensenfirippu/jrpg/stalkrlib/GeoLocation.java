package dk.iensenfirippu.jrpg.stalkrlib;

import java.util.Date;

/**
 * Class describing a physical GPS point
 */
public class GeoLocation
{
	// Class global variables
	private float _latitude;
	private float _longitude;
	private Date _timestamp;

	// Constructors
	public GeoLocation()
	{
		_latitude = 0;
		_longitude = 0;
		_timestamp = new Date();
	}
	public GeoLocation(float lat, float lon)
	{
		_latitude = lat;
		_longitude = lon;
		_timestamp = new Date();
	}
	public GeoLocation(float lat, float lon, Date date)
	{
		_latitude = lat;
		_longitude = lon;
		_timestamp = date;
	}

	// Properties
	public float getLatitude() { return _latitude; }
	public float getLongitude() { return _longitude; }
	public Date getTimeStamp() { return _timestamp; }
}