package dk.iensenfirippu.jrpg.stalkr;

import dk.iensenfirippu.jrpg.stalkrlib.*;
import dk.iensenfirippu.jrpg.ws.GetUserTask;
import dk.iensenfirippu.jrpg.ws.SaveUserTask;
import dk.iensenfirippu.jrpg.ws.bo.SimpleReturnStringBO;
import dk.iensenfirippu.jrpg.wsclient.AsyncTaskManager;
import dk.iensenfirippu.jrpg.wsclient.OnAsyncTaskCompleteListener;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PreferencesActivity extends Activity
{
	private Intent _intent;
    private AsyncTaskManager _taskManager;
    
	private String _username;
	private String _password;
	private User _user;
	
	private String _genderstring;
	private String _sexualitystring;
	private String _areastring;
	private String _smokingstring;
	private String _drinkingstring;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences);

		_intent = getIntent();
        _taskManager = new AsyncTaskManager(this);

		_username = _intent.getStringExtra("username");
		_password = _intent.getStringExtra("password");
		_user = Tools.UserFromString(_intent.getStringExtra("user"));
		
		if (_user.getPreferences().size() == 0)
		{
			_user.getPreferences().add(new Description());
		}
		
		// Fill in the values from the user object
		FillValues();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preferences, menu);
		return true;
	}
	
	private void FillValues()
	{
		try
		{
			((EditText)	this.findViewById(R.id.preferences_txt_min_age))	.setText(Integer.toString(_user.getPreferences().get(0).getAge().getMin()));
			((EditText)	this.findViewById(R.id.preferences_txt_max_age))	.setText(Integer.toString(_user.getPreferences().get(0).getAge().getMax()));
		}
		catch (Exception e)
		{
			// do something
		}
	}
	
	public void Gender_onClick(View view)
	{
		String[] options = getResources().getStringArray(R.array.enum_gender);
		Intent intent = new Intent(this, MultiSelect.class);
		intent.putExtra("binarystring", _user.getPreferences().get(0).getGender().toString());
		intent.putExtra("options", options);
		startActivityForResult(intent, 1);
	}
	
	public void Sexuality_onClick(View view)
	{
		String[] options = getResources().getStringArray(R.array.enum_sexuality);
		Intent intent = new Intent(this, MultiSelect.class);
		intent.putExtra("binarystring", _user.getPreferences().get(0).getSexuality().toString());
		intent.putExtra("options", options);
		startActivityForResult(intent, 2);
	}
	
	public void Area_onClick(View view)
	{
		String[] options = getResources().getStringArray(R.array.enum_area);
		Intent intent = new Intent(this, MultiSelect.class);
		intent.putExtra("binarystring", _user.getPreferences().get(0).getArea().toString());
		intent.putExtra("options", options);
		startActivityForResult(intent, 3);
	}
	
	public void Smoking_onClick(View view)
	{
		String[] options = getResources().getStringArray(R.array.enum_smoking);
		Intent intent = new Intent(this, MultiSelect.class);
		intent.putExtra("binarystring", _user.getPreferences().get(0).getSmoking().toString());
		intent.putExtra("options", options);
		startActivityForResult(intent, 4);
	}
	
	public void Drinking_onClick(View view)
	{
		String[] options = getResources().getStringArray(R.array.enum_drinking);
		Intent intent = new Intent(this, MultiSelect.class);
		intent.putExtra("binarystring", _user.getPreferences().get(0).getDrinking().toString());
		intent.putExtra("options", options);
		startActivityForResult(intent, 5);
	}

	public void Save_onClick(View view)
	{
		try
		{
			_user.getPreferences().get(0).setAge(
					Integer.parseInt(((EditText)this.findViewById(R.id.preferences_txt_min_age)).getText().toString()),
					Integer.parseInt(((EditText)this.findViewById(R.id.preferences_txt_min_age)).getText().toString())
			);
			//_user.getPreferences().get(0).setGender(_genderstring);
			//_user.getPreferences().get(0).setSexuality(_sexualitystring);
			//_user.getPreferences().get(0).setArea(_areastring);
			//_user.getPreferences().get(0).setSmoking(_smokingstring);
			//_user.getPreferences().get(0).setDrinking(_drinkingstring);

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
			// Do something
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK)
		{
			//int buttonindex = data.getIntExtra("buttonindex", -1);
			String returnstring = data.getStringExtra("return");
			
			switch (requestCode)
			{
			case 1:
				_genderstring = returnstring;
				((Button)this.findViewById(R.id.preferences_btn_gender)).setText(returnstring);
				break;
			case 2:
				_sexualitystring = returnstring;
				((Button)this.findViewById(R.id.preferences_btn_sexuality)).setText(returnstring);
				break;
			case 3:
				_areastring = returnstring;
				((Button)this.findViewById(R.id.preferences_btn_area)).setText(returnstring);
				break;
			case 4:
				_smokingstring = returnstring;
				((Button)this.findViewById(R.id.preferences_btn_smoking)).setText(returnstring);
				break;
			case 5:
				_drinkingstring = returnstring;
				((Button)this.findViewById(R.id.preferences_btn_drinking)).setText(returnstring);
				break;
			default:
				break;
			}
		}
	}
	
	public void Cancel_onClick(View view)
	{
		finish();
	}
	
	public void Reload_onClick(View view)
	{
		FillValues();
	}

    private void showToastMessage(int messageId)
    {
        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
    }
}
