package dk.iensenfirippu.jrpg.stalkr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends Activity
{
	private Intent _intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		_intent = getIntent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public void Login_onClick(View view)
	{
		//TODO: Validate login
		//if (valid) {
			EditText txt_username = (EditText)this.findViewById(R.id.txt_username);
			String username = txt_username.getText().toString();
			_intent.putExtra("returnedData", username);
			setResult(RESULT_OK, _intent);
			finish();
		//}
	}
}