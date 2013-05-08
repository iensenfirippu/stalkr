package dk.iensenfirippu.jrpg.stalkr;

import stalkrlib.*;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebServiceAccess 
{
	private static final String NAMESPACE = "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS";
	private static String URL = "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS?WSDL"; 
	private static final String METHOD_NAME1 = "saveUser";
	private static final String SOAP_ACTION1 =  "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS/saveUser";
	private static final String METHOD_NAME2 = "getUser";
	private static final String SOAP_ACTION2 = "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS/getUser";
	private static final String METHOD_NAME3 = "getMatches";	
	private static final String SOAP_ACTION3 = "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS/getMatches";



	public static void saveProfile(User user)
	{		
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
		request.addProperty("saveProfile",user.getUniqueID().toString());
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = true;
        try 
        {
        	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        	androidHttpTransport.call(SOAP_ACTION1, envelope);
            SoapObject result = (SoapObject)envelope.bodyIn;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
	
	//needs to return user object somehow
	public static void getProfile(User user)
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
		request.addProperty("getProfile",user.getUniqueID().toString());
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = true;
        try 
        {
        	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        	androidHttpTransport.call(SOAP_ACTION2, envelope);
            SoapObject result = (SoapObject)envelope.bodyIn;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }		
	}
	
	// needs to return ???
	public static void getMatches(User user)
	{
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME3);
		request.addProperty("Matches",user.getPreferences().toString());
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.dotNet = true;
        try 
        {
        	HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        	androidHttpTransport.call(SOAP_ACTION3, envelope);
            SoapObject result = (SoapObject)envelope.bodyIn;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}
