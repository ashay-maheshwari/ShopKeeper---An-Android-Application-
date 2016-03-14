package com.example.shopkeeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class AboutPathak extends Activity{
   
	  @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_pathak);

	EditText et=(EditText)findViewById(R.id.editText1);
	Button back=(Button)findViewById(R.id.button2);
	Button home=(Button)findViewById(R.id.button1);
	
	et.setText("Nikhil Pathak,\n" +
			"Email-aaryaashay1848@gmail.com\n" +
			"Contact-8827893665\n" +
			"Engineering Student GGITM,Bhopal");
	et.setEnabled(false);
	
	back.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(AboutPathak.this,AboutDevelopers.class));
		}
	});
   home.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(AboutPathak.this,MainActivity.class));
			
		}
	});
	
	  }
}
