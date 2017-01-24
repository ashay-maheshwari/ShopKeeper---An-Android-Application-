package com.example.shopkeeper;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ShareData extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_data);
	
	Button b1=(Button)findViewById(R.id.button1);
	EditText et1=(EditText)findViewById(R.id.editText1);
	et1.setText("Have the pleasure to share stuff like images,video,sound," +
			"messages,text,capture image,record sound." +
			"And more than that enjoy the MESSENGER...");
	et1.setEnabled(false);
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT,"wrie your text here...");
			startActivity(Intent.createChooser(intent,"share this text via"));
			
		}
	});
	}

	
}
