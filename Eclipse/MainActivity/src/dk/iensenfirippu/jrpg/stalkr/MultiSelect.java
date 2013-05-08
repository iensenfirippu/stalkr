package dk.iensenfirippu.jrpg.stalkr;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class MultiSelect extends Activity {

	String result;
	ListView list;
	String[] itemList;
	Button but;
    ItemAdapter adapter;

	protected void onCreate(Bundle savedInstanceState, Intent data) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multi_select);

		itemList = data.getStringArrayExtra("Options");

		list = (ListView)findViewById(R.id.preferences_list);
		but = (Button)findViewById(R.id.confirm_btn);

		list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		adapter = new ItemAdapter(this,itemList);
		list.setAdapter(adapter);

		list.setOnItemClickListener(new OnItemClickListener() 
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
				CheckedTextView tv = (CheckedTextView)arg1;
				adapter.toggle(tv);
			}

		});

		but.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Log.i("listview", ""+list.getChildCount());
				for(int i = 0;i<list.getChildCount();i++)
				{
					View view = list.getChildAt(i);
					CheckedTextView cv =(CheckedTextView)view.findViewById(R.id.preferences_checkList);
					if(cv.isChecked())
					{
						Log.i("listview", cv.getText().toString());
					}
				}
			}
		});
	}
			
		@Override
		public boolean onCreateOptionsMenu(Menu menu) 
		{
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_multi_select, menu);
			return true;
		}
	}
