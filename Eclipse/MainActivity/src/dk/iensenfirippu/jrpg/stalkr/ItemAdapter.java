package dk.iensenfirippu.jrpg.stalkr;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.os.Bundle;
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

class ItemAdapter extends BaseAdapter {
	String[] items;
	LayoutInflater vi;
	
	public ItemAdapter(Context context, String[] item) {
		this.items = item;
	}

	//@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) 
		{
			
		} 
		CheckedTextView post = (CheckedTextView) v.findViewById(R.id.preferences_checkList);
		post.setText(items[position]);
		return v;
	}

	public int getCount() {
		return items.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

public void toggle(CheckedTextView v)
{
	if (v.isChecked())
	{
		v.setChecked(false);
	}
	else
	{
		v.setChecked(true);
	}
}
}
