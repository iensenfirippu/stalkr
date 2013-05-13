package dk.iensenfirippu.jrpg.stalkr;

import android.location.LocationListener;
import android.location.Location; 
import android.os.Bundle;


public class StalkrLocationListener implements LocationListener
{ 
	double longitude;
	double latitude;
	
	@Override
	public void onLocationChanged(Location loc) 
	{
		longitude = loc.getLongitude();
		latitude = loc.getLatitude();
	}

	@Override
	public void onProviderDisabled(String arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) 
	{
		// TODO Auto-generated method stub
		
	} 
	
	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

}