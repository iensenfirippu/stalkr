package dk.iensenfirippu.jrpg.ws;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import dk.iensenfirippu.jrpg.ws.bo.SimpleReturnStringBO;
import dk.iensenfirippu.jrpg.ws.bo.SimpleReturnStringBO;
import dk.iensenfirippu.jrpg.wsclient.AbstractProgressableAsyncTask;

import android.util.Log;

public class LoginTask extends AbstractProgressableAsyncTask<SoapObject, SimpleReturnStringBO>
{
    public static final String TAG = "LoginTask";
	
    private static final String WSDL_URL = "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS?WSDL";
    private static final String WS_NAMESPACE = "http://jrpg.iensenfirippu.dk/";
    private static final String WS_METHOD_NAME = "login";

    public LoginTask()
    {

    }

    public static SoapObject createRequest(String username, String password)
    {
        SoapObject request = new SoapObject(WS_NAMESPACE, WS_METHOD_NAME);

        PropertyInfo property = new PropertyInfo();
        //property.setNamespace(WS_NAMESPACE);
        property.setName("username");
        property.setValue(username);
        request.addProperty(property);

        PropertyInfo property2 = new PropertyInfo();
        property2.setName("password");
        property2.setValue(password);
        request.addProperty(property2);
    
        return request;
    }

    @Override
    protected SimpleReturnStringBO performTaskInBackground(SoapObject parameter) throws Exception
    {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setAddAdornments(false);
        envelope.setOutputSoapObject(parameter);

        HttpTransportSE httpTransport = new HttpTransportSE(WSDL_URL);
        httpTransport.debug = true; // allows capture of raw request/respose in Logcat
        httpTransport.call(WS_NAMESPACE + WS_METHOD_NAME, envelope);
        Log.d(TAG, "HTTP REQUEST:\n" + httpTransport.requestDump);
        Log.d(TAG, "HTTP RESPONSE:\n" + httpTransport.responseDump);
        Log.d(TAG, "bodyIn:\n" + envelope.bodyIn);

        SimpleReturnStringBO result = null;
        if (envelope.bodyIn instanceof SoapObject) // SoapObject = SUCCESS
        {
            SoapObject soapObject = (SoapObject) envelope.bodyIn;
            result = parseSOAPResponse(soapObject);
        }
        else if (envelope.bodyIn instanceof SoapFault) // SoapFault = FAILURE
        {
            SoapFault soapFault = (SoapFault) envelope.bodyIn;
            throw new Exception(soapFault.getMessage());
        }

        return result;
    }

    private SimpleReturnStringBO parseSOAPResponse(SoapObject response)
    {
    	SimpleReturnStringBO result = null;
        String noderesponse = response.getPrimitivePropertyAsString("return");
        
        if (noderesponse != "")
        {
            result = new SimpleReturnStringBO(noderesponse);
        }

        return result;
    }

}
