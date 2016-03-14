package com.example.shopkeeper;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AboutDevelopers extends Activity {
	Button ashay,anurag,nikhil,home,back;
	@Override
   protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.about_developers);
        
	   ashay=(Button)findViewById(R.id.button1);
	   anurag=(Button)findViewById(R.id.button2);
	   nikhil=(Button)findViewById(R.id.button3);
	   home=(Button)findViewById(R.id.button4);
	   back=(Button)findViewById(R.id.button5);
	   Toast.makeText(AboutDevelopers.this,"Touch on the image of Developers to get more information.",Toast.LENGTH_LONG).show();
	   
	   ashay.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(AboutDevelopers.this,AboutAshay.class));
			
		}
	});
	   
	   
	   
	   anurag.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(AboutDevelopers.this,AboutAnurag.class));
			
		}
	});
	   
	   
	   nikhil.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(AboutDevelopers.this,AboutPathak.class));
			
		}
	});
	   
	   
	   home.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(AboutDevelopers.this,MainActivity.class));
			
		}
	});
	   
	   
	   back.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(AboutDevelopers.this,AboutClass.class));
			
		}
	});
	   
	   
	   
	   
   }
}
