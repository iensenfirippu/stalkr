package dk.iensenfirippu.jrpg.stalkr;

import stalkrlib.*;
import stalkrlib.enums.*;
import java.util.Calendar;
import java.util.Date;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.location.Location; 
import android.location.LocationListener; 
import android.location.LocationManager;

public class ProfileActivity extends Activity
{
	private static final String BIRTHDATE_FORMAT = "yyyy MM/dd";
	
	private User _user;
	private Date _birthday;
	private Button _birthdaybtn;
	private EditText _agedisplay;
	private static final String NAMESPACE = "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS";
	private static String URL = "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS?WSDL"; 
	private static final String METHOD_NAME1 = "saveUser";
	private static final String SOAP_ACTION1 =  "http://jrpg.iensenfirippu.dk:8080/Stalkr/WS/saveUser";  
	StalkrLocationListener locListener = new StalkrLocationListener();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		//_user = WebServiceAccess.getProfile(_user);

		// Fake the user object
		_user = Toolbelt.getTestUsers().get(0);
		_birthdaybtn = ((Button)this.findViewById(R.id.profile_btn_birthday));
		_agedisplay = ((EditText)this.findViewById(R.id.profile_txt_age));
		
		// Fills the spinners with the enum values
		FillSpinners();
		
		// Location manager
		LocationManager locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
		
		// Fill in the values from the user object
		FillValues();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	private void FillSpinners()
	{
		// Fill out Gender options
		Spinner spinner_gender = (Spinner)this.findViewById(R.id.profile_spn_gender);
		ArrayAdapter<CharSequence> adapter_gender = ArrayAdapter.createFromResource(this, R.array.enum_gender, android.R.layout.simple_spinner_item);
		adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_gender.setAdapter(adapter_gender);
		
		// Fill out Sexuality options
		Spinner spinner_sexuality = (Spinner)this.findViewById(R.id.profile_spn_sexuality);
		ArrayAdapter<CharSequence> adapter_sexuality = ArrayAdapter.createFromResource(this, R.array.enum_sexuality, android.R.layout.simple_spinner_item);
		adapter_sexuality.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_sexuality.setAdapter(adapter_sexuality);
		
		// Fill out area options
		Spinner spinner_area = (Spinner)this.findViewById(R.id.profile_spn_area);
		ArrayAdapter<CharSequence> adapter_area = ArrayAdapter.createFromResource(this, R.array.enum_area, android.R.layout.simple_spinner_item);
		adapter_area.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_area.setAdapter(adapter_area);
		
		// Fill out smoking options
		Spinner spinner_smoking = (Spinner)this.findViewById(R.id.profile_spn_smoking);
		ArrayAdapter<CharSequence> adapter_smoking = ArrayAdapter.createFromResource(this, R.array.enum_smoking, android.R.layout.simple_spinner_item);
		adapter_smoking.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_smoking.setAdapter(adapter_smoking);
		
		// Fill out drinking options
		Spinner spinner_drinking = (Spinner)this.findViewById(R.id.profile_spn_drinking);
		ArrayAdapter<CharSequence> adapter_drinking = ArrayAdapter.createFromResource(this, R.array.enum_drinking, android.R.layout.simple_spinner_item);
		adapter_drinking.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_drinking.setAdapter(adapter_drinking);
	}
	
	private void FillValues()
	{
		_birthday = _user.getBirthday();
		double longitude = locListener.getLongitude();
		double latitude = locListener.getLatitude();
		String finalLongitude = new Double(longitude).toString();
		String finalLatitude = new Double(latitude).toString();
		
		try
		{
			((EditText)	this.findViewById(R.id.profile_txt_username))	.setText(_user.getUsername());
			((EditText)	this.findViewById(R.id.profile_txt_email))		.setText(_user.getEmail());
			((EditText)	this.findViewById(R.id.profile_txt_firstname))	.setText(_user.getFirstName());
			((EditText)	this.findViewById(R.id.profile_txt_lastname))	.setText(_user.getLastName());
			((Button)	this.findViewById(R.id.profile_btn_birthday))	.setText(DateFormat.format(BIRTHDATE_FORMAT, _birthday));
			((EditText)	this.findViewById(R.id.profile_txt_age))		.setText(_user.getDescription().getAge().getMin() + "");
			((Spinner)	this.findViewById(R.id.profile_spn_gender))		.setSelection(_user.getDescription().getGender().getList().get(0).ordinal());
			((Spinner)	this.findViewById(R.id.profile_spn_sexuality))	.setSelection(_user.getDescription().getSexuality().getList().get(0).ordinal());
			((Spinner)	this.findViewById(R.id.profile_spn_area))		.setSelection(_user.getDescription().getArea().getList().get(0).ordinal());
			((Spinner)	this.findViewById(R.id.profile_spn_smoking))	.setSelection(_user.getDescription().getSmoking().getList().get(0).ordinal());
			((Spinner)	this.findViewById(R.id.profile_spn_drinking))	.setSelection(_user.getDescription().getDrinking().getList().get(0).ordinal());
			((EditText) this.findViewById(R.id.profile_txt_longitude))	.setText(finalLongitude);
			((EditText) this.findViewById(R.id.profile_txt_latitude))	.setText(finalLatitude);
		}
		catch (Exception e)
		{
			// do something
		}
	}

	public void Birthday_onClick(View view)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(_birthday);
		DatePickerDialog dialog = new DatePickerDialog(this, datePickerListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		dialog.show();
	}
	 
	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener()
	{
		// when dialog box is closed, below method will be called.
		@Override
		public void onDateSet(DatePicker view, int selectedYear,
		int selectedMonth, int selectedDay)
		{
			Calendar cal = Calendar.getInstance();
			cal.set(selectedYear, selectedMonth, selectedDay);
			_birthday = cal.getTime();
			_birthdaybtn.setText(DateFormat.format(BIRTHDATE_FORMAT, _birthday));
			int age = (int)((new Date().getTime() - _birthday.getTime()) / 31556952000L);
			_agedisplay.setText(Integer.toString(age));
		}
	};

	public void Save_onClick(View view)
	{
		//WebServiceAccess.saveProfile(_user);
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
		request.addProperty("saveProfile",_user.getUniqueID().toString());
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
		/*try
		{
			_user.setUsername(((EditText)this.findViewById(R.id.profile_txt_username)).getText().toString());
			_user.setEmail(((EditText)this.findViewById(R.id.profile_txt_email)).getText().toString());
			_user.setFirstName(((EditText)this.findViewById(R.id.profile_txt_firstname)).getText().toString());
			_user.setLastName(((EditText)this.findViewById(R.id.profile_txt_lastname)).getText().toString());
			_user.setBirthday(_birthday);
			_user.getDescription().setAge(new Range(Integer.parseInt(((EditText)this.findViewById(R.id.profile_txt_age)).getText().toString())));
			_user.getDescription().setGender(new GenderList(GenderType.values()[((Spinner)this.findViewById(R.id.profile_spn_gender)).getSelectedItemPosition()]));
			_user.getDescription().setSexuality(new SexualityList(SexualityType.values()[((Spinner)this.findViewById(R.id.profile_spn_sexuality)).getSelectedItemPosition()]));
			_user.getDescription().setArea(new AreaList(AreaType.values()[((Spinner)this.findViewById(R.id.profile_spn_area)).getSelectedItemPosition()]));
			_user.getDescription().setSmoking(new SmokingList(SmokingType.values()[((Spinner)this.findViewById(R.id.profile_spn_smoking)).getSelectedItemPosition()]));
			_user.getDescription().setDrinking(new DrinkingList(DrinkingType.values()[((Spinner)this.findViewById(R.id.profile_spn_drinking)).getSelectedItemPosition()]));

			//finish();
		}
		catch (Exception e)
		{
			// Do something on fail
		}*/
	}

	public void Reload_onClick(View view)
	{
		FillValues();
	}

	public void Cancel_onClick(View view)
	{
		finish();
	}
}
