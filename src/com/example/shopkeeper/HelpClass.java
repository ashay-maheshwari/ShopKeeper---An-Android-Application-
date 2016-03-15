package com.example.shopkeeper;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class HelpClass extends ListActivity{
  
	  @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.help);
	
	setListAdapter(new ArrayAdapter<String>( this, 
			android.R.layout.simple_list_item_1, 
			getResources().getStringArray(R.array.helpOptions)));
	 
	  }
}
