package dk.iensenfirippu.jrpg.stalkr;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class PreferencesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preferences, menu);
		return true;
	}
	
	public void Cancel_onClick(View view)
	{
		finish();
	}
	
	public void Gender_onClick(View view)
	{
		String[] genderOptions = new String[] {"OTHER", "MALE", "FEMALE", "HERMAPHRODITE", "TRANSGENDER"};
		Intent intent = new Intent(this, MultiSelect.class);
		intent.putExtra("Options", genderOptions);
		startActivityForResult(intent, 1);
	}
	
	public void Area_onClick(View view)
	{
		
	}
	
	public void Drinking_onClick(View view)
	{
		
	}
	
	public void Smoking_onClick(View view)
	{
		
	}
		
	public void Save_onClick(View view)
	{
		
	}

}
