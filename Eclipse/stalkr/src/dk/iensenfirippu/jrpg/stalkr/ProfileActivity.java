package dk.iensenfirippu.jrpg.stalkr;

import java.util.Calendar;
import java.util.Date;

import dk.iensenfirippu.jrpg.stalkrlib.*;
import dk.iensenfirippu.jrpg.stalkrlib.EnumList.AreaType;
import dk.iensenfirippu.jrpg.stalkrlib.EnumList.DrinkingType;
import dk.iensenfirippu.jrpg.stalkrlib.EnumList.GenderType;
import dk.iensenfirippu.jrpg.stalkrlib.EnumList.SexualityType;
import dk.iensenfirippu.jrpg.stalkrlib.EnumList.SmokingType;
import dk.iensenfirippu.jrpg.ws.GetUserTask;
import dk.iensenfirippu.jrpg.ws.SaveUserTask;
import dk.iensenfirippu.jrpg.ws.bo.SimpleReturnStringBO;
import dk.iensenfirippu.jrpg.wsclient.AsyncTaskManager;
import dk.iensenfirippu.jrpg.wsclient.OnAsyncTaskCompleteListener;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.location.LocationManager;


public class ProfileActivity extends Activity
{
	private static final String BIRTHDATE_FORMAT = "yyyy MM/dd";

	private Intent _intent;
    private AsyncTaskManager _taskManager;
    
	private Date _birthday;
	private Button _birthdaybtn;
	private EditText _agedisplay;

	private String _username;
	private String _password;
	private User _user;

	StalkrLocationListener locListener = new StalkrLocationListener();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);

		_intent = getIntent();
        _taskManager = new AsyncTaskManager(this);

		_username = _intent.getStringExtra("username");
		_password = _intent.getStringExtra("password");
		_user = Tools.UserFromString(_intent.getStringExtra("user"));
		
		_birthdaybtn = ((Button)this.findViewById(R.id.profile_btn_birthday));
		_agedisplay = ((EditText)this.findViewById(R.id.profile_txt_age));
		
		LocationManager locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
		
		// Fills the spinners with the enum values
		FillSpinners();
		
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
		
		try
		{
			((EditText)	this.findViewById(R.id.profile_txt_username))	.setText(_user.getUsername());
			((EditText)	this.findViewById(R.id.profile_txt_email))		.setText(_user.getEmail());
			((EditText)	this.findViewById(R.id.profile_txt_firstname))	.setText(_user.getFirstName());
			((EditText)	this.findViewById(R.id.profile_txt_lastname))	.setText(_user.getLastName());
			((Button)	this.findViewById(R.id.profile_btn_birthday))	.setText(DateFormat.format(BIRTHDATE_FORMAT, _birthday));
			((EditText)	this.findViewById(R.id.profile_txt_age))		.setText(_user.getDescription().getAge().getMin() + "");
			((Spinner)	this.findViewById(R.id.profile_spn_gender))		.setSelection(_user.getDescription().getGender().getSelectedIndex());
			((Spinner)	this.findViewById(R.id.profile_spn_sexuality))	.setSelection(_user.getDescription().getSexuality().getSelectedIndex());
			((Spinner)	this.findViewById(R.id.profile_spn_area))		.setSelection(_user.getDescription().getArea().getSelectedIndex());
			((Spinner)	this.findViewById(R.id.profile_spn_smoking))	.setSelection(_user.getDescription().getSmoking().getSelectedIndex());
			((Spinner)	this.findViewById(R.id.profile_spn_drinking))	.setSelection(_user.getDescription().getDrinking().getSelectedIndex());
			((EditText) this.findViewById(R.id.profile_txt_latitude))	.setText(Double.toString(latitude));
			((EditText) this.findViewById(R.id.profile_txt_longitude))	.setText(Double.toString(longitude));
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
		try
		{
			_user.setUsername(((EditText)this.findViewById(R.id.profile_txt_username)).getText().toString());
			_user.setEmail(((EditText)this.findViewById(R.id.profile_txt_email)).getText().toString());
			_user.setFirstName(((EditText)this.findViewById(R.id.profile_txt_firstname)).getText().toString());
			_user.setLastName(((EditText)this.findViewById(R.id.profile_txt_lastname)).getText().toString());
			_user.setBirthday(_birthday);
			_user.getDescription().setAge(Integer.parseInt(((EditText)this.findViewById(R.id.profile_txt_age)).getText().toString()));
			_user.getDescription().setGender(((Spinner)this.findViewById(R.id.profile_spn_gender)).getSelectedItemPosition());
			_user.getDescription().setSexuality(((Spinner)this.findViewById(R.id.profile_spn_sexuality)).getSelectedItemPosition());
			_user.getDescription().setArea(((Spinner)this.findViewById(R.id.profile_spn_area)).getSelectedItemPosition());
			_user.getDescription().setSmoking(((Spinner)this.findViewById(R.id.profile_spn_smoking)).getSelectedItemPosition());
			_user.getDescription().setDrinking(((Spinner)this.findViewById(R.id.profile_spn_drinking)).getSelectedItemPosition());
			_user.setLocation(new GeoLocation(
				Float.parseFloat(((EditText)this.findViewById(R.id.profile_txt_latitude)).getText().toString()),
				Float.parseFloat(((EditText)this.findViewById(R.id.profile_txt_longitude)).getText().toString())
			));

		    SaveUserTask task = new SaveUserTask();
		    _taskManager.executeTask(
		    	task,
				SaveUserTask.createRequest(_username, _password, Tools.UserToString(_user, false)),
				getString(R.string.ws_save_in_progress),
				new OnAsyncTaskCompleteListener<SimpleReturnStringBO>()
				{
				    @Override
				    public void onTaskCompleteSuccess(SimpleReturnStringBO result)
				    {
				    	if (result.getResponse().equals("E10"))
				    	{
				            showToastMessage(R.string.ws_save_success);
				    	}
				    	else
				    	{
				            showToastMessage(R.string.ws_save_failed);
				    	}
				    }
				
				    @Override
				    public void onTaskFailed(Exception cause)
				    {
				        Log.e(GetUserTask.TAG, cause.getMessage(), cause);
				        showToastMessage(R.string.ws_connection_failed);
				    }
				}
		    );
			//finish();
		}
		catch (Exception e)
		{
			// Do something on fail
		}
	}

	public void Reload_onClick(View view)
	{
		FillValues();
	}

	public void Cancel_onClick(View view)
	{
		finish();
	}

    private void showToastMessage(int messageId)
    {
        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
    }
}
