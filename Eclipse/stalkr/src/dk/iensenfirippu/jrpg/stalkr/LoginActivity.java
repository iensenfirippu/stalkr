package dk.iensenfirippu.jrpg.stalkr;

import dk.iensenfirippu.jrpg.wsclient.AsyncTaskManager;
import dk.iensenfirippu.jrpg.wsclient.OnAsyncTaskCompleteListener;
import dk.iensenfirippu.jrpg.ws.LoginTask;
import dk.iensenfirippu.jrpg.ws.bo.SimpleReturnStringBO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity
{
	private Intent _intent;
    private AsyncTaskManager _taskManager;
    
	private String _username;
	private String _password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		((EditText)this.findViewById(R.id.txt_username)).setText("tester");
		((EditText)this.findViewById(R.id.txt_password)).setText("1234");
		
		_intent = getIntent();
        _taskManager = new AsyncTaskManager(this);
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
		_username = ((EditText)this.findViewById(R.id.txt_username)).getText().toString();
		_password = ((EditText)this.findViewById(R.id.txt_password)).getText().toString();
		
        LoginTask task = new LoginTask();
        _taskManager.executeTask(	task,
        							LoginTask.createRequest(_username, _password),
        							getString(R.string.ws_login_in_progress),
						            new OnAsyncTaskCompleteListener<SimpleReturnStringBO>()
						            {
							            @Override
							            public void onTaskCompleteSuccess(SimpleReturnStringBO result)
							            {
							            	if (result.getResponse().length() > 3)
							            	{
							        			_intent.putExtra("username", _username);
							        			_intent.putExtra("password", _password);
							        			_intent.putExtra("id", result.getResponse());
							        			setResult(RESULT_OK, _intent);
							        			finish();
							            	}
							            	else
							            	{
							                    showToastMessage(R.string.ws_login_failed);
							            	}
							            }
							
							            @Override
							            public void onTaskFailed(Exception cause)
							            {
							                Log.e(LoginTask.TAG, cause.getMessage(), cause);
						                    showToastMessage(R.string.ws_connection_failed);
							            }
						            }
        );
	}

    private void showToastMessage(int messageId)
    {
        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
    }
}