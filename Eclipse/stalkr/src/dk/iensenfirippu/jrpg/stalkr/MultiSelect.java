package dk.iensenfirippu.jrpg.stalkr;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.content.Intent;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class MultiSelect extends Activity
{
	private Intent _intent;
	
	private char[] _result;
	private ListView _listview;
	private ArrayAdapter<String> _adapter;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_multi_select);

		_intent = getIntent(); // not data

		_result = _intent.getStringExtra("binarystring").toCharArray();
		String[] values = _intent.getStringArrayExtra("options");

		_listview = (ListView)findViewById(R.id.multiselect_list);

		_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, values);
		_listview.setAdapter(_adapter);

		/*SparseBooleanArray positions = _listview.getCheckedItemPositions();
		Log.i("Multi", "pos size: " + positions.size());
		for (int i = 0; i < positions.size(); i++)
		{
			View view = _listview.getAdapter().getView(i, null, null);
			CheckedTextView cv = (CheckedTextView) view.findViewById(i);
			if (_result[i] == '1')
			{
				cv.toggle();
			}
		}*/

		_listview.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				CheckedTextView cv = (CheckedTextView)arg1;
				cv.toggle();

				if (cv.isChecked())	{ _result[_listview.getPositionForView(arg1)] = '1'; }
				else				{ _result[_listview.getPositionForView(arg1)] = '0'; }
			}

		});
	}

	public void Confirm_onClick(View v) 
	{
		_intent.putExtra("returnstring", _result.toString());
		setResult(RESULT_OK, _intent);
		finish();
	}

	public void Cancel_onClick(View v) 
	{
		setResult(RESULT_CANCELED, _intent);
		finish();
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_multi_select, menu);
		return true;
	}
}
