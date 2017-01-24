package com.example.shopkeeper;



import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessage extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_message);
		
		final EditText phone=(EditText)findViewById(R.id.editText1);
	final EditText msg=(EditText)findViewById(R.id.editText2);
	Button send=(Button)findViewById(R.id.button1);
	Button reset=(Button)findViewById(R.id.button2);
	phone.setText(getIntent().getExtras().getString("sendingContact"));
	
	msg.setText(getIntent().getExtras().getString("sendingContent"));
			
	
	
send.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			 String phoneNo = phone.getText().toString();
		      String message = msg.getText().toString();
		      try {
			         SmsManager smsManager = SmsManager.getDefault();
			         smsManager.sendTextMessage(phoneNo, null, message, null, null);
			         Toast.makeText(getApplicationContext(), "SMS sent.",
			         Toast.LENGTH_LONG).show();
			      } catch (Exception e) {
			         Toast.makeText(getApplicationContext(),
			         "SMS failed, please try again.",
			         Toast.LENGTH_LONG).show();
			         e.printStackTrace();
			      }
		}
	});	
reset.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		msg.setText("");
		
	}
});
	
	}
}
