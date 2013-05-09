package dk.iensenfirippu.jrpg.stalkr;

import java.util.UUID;

import dk.iensenfirippu.jrpg.stalkrlib.Tools;
import dk.iensenfirippu.jrpg.ws.GetUserTask;
import dk.iensenfirippu.jrpg.ws.LoginTask;
import dk.iensenfirippu.jrpg.ws.bo.SimpleReturnStringBO;
import dk.iensenfirippu.jrpg.wsclient.AsyncTaskManager;
import dk.iensenfirippu.jrpg.wsclient.OnAsyncTaskCompleteListener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private AsyncTaskManager _taskManager;
    
	private String _username;
	private String _password;
	private String _id;
	private String _user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        _taskManager = new AsyncTaskManager(this);

		Intent intent = new Intent(this, LoginActivity.class);
		startActivityForResult(intent, 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == 0)
		{
			if (resultCode == RESULT_OK)
			{
				_username = data.getStringExtra("username");
				_password = data.getStringExtra("password");
				_id = data.getStringExtra("id");
				
		        TextView lbl_login = (TextView)this.findViewById(R.id.lbl_login);
		        TextView lbl_status = (TextView)this.findViewById(R.id.lbl_status);
				String welcome = this.getString(R.string.main_welcome);
				String welcometext = String.format(welcome, _username);
				lbl_login.setText(welcometext);
				//if (firsttime)
				//{
				//	lbl_status.setText(this.getText(R.string.main_status_first));
				//	lbl_status.setVisibility(View.VISIBLE);
				//}
			}
			else
			{
				finish();
			}
		}
	}

	public void Profile_onClick(View view)
	{
	    GetUserTask task = new GetUserTask();
	    _taskManager.executeTask(	task,
	    							GetUserTask.createRequest(_username, _password, _id),
	    							getString(R.string.ws_load_in_progress),
						            new OnAsyncTaskCompleteListener<SimpleReturnStringBO>()
						            {
							            @Override
							            public void onTaskCompleteSuccess(SimpleReturnStringBO result)
							            {
							            	if (Tools.ValidateUserString(result.getResponse()) >= 0.2f)
							            	{
							            		_user = result.getResponse();
							            		startProfileActivity();
							            	}
							            	else
							            	{
							                    showToastMessage(R.string.ws_load_failed);
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
	}
	
	private void startProfileActivity()
	{
		Intent intent = new Intent(this, ProfileActivity.class);
		intent.putExtra("username", _username);
		intent.putExtra("password", _password);
		intent.putExtra("user", _user);
		startActivityForResult(intent, 1);
	}

    private void showToastMessage(int messageId)
    {
        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
    }
}
