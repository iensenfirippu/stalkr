package dk.iensenfirippu.jrpg.stalkr;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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
		        TextView lbl_login = (TextView)this.findViewById(R.id.lbl_login);
		        TextView lbl_status = (TextView)this.findViewById(R.id.lbl_status);
				String welcome = this.getString(R.string.main_welcome);
				String username = data.getStringExtra("returnedData");
				String welcometext = String.format(welcome, username);
				lbl_login.setText(welcometext);
				//if (firsttime)
				//{
					lbl_status.setText(this.getText(R.string.main_status_first));
					lbl_status.setVisibility(View.VISIBLE);
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
		Intent intent = new Intent(this, ProfileActivity.class);
		startActivityForResult(intent, 1);
	}
}
