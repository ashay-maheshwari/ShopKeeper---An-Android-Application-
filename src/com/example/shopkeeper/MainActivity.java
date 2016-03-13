package com.example.shopkeeper;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnInitListener{
 Button next,help,about,exit;
 private TextToSpeech textToSpeech;
 

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    next=(Button)findViewById(R.id.button1);
    help=(Button)findViewById(R.id.button2);
    about=(Button)findViewById(R.id.button3);
    exit=(Button)findViewById(R.id.button4);
    
    next.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			String text="next";
			convertToSpeech(text);
		startActivity(new Intent(MainActivity.this,NextClass.class));	
		}
	});
    textToSpeech = new TextToSpeech(this, this);
    
    help.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			String text="help";
			convertToSpeech(text);
			startActivity(new Intent(MainActivity.this,HelpClass.class));	
		}
	});
    
    about.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			String text="about";
			convertToSpeech(text);
			startActivity(new Intent(MainActivity.this,AboutClass.class));	
		}
	});
    
    exit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			String text="Are you sure you want to exit the application???";
			convertToSpeech(text);
			AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
	 		 builder.setMessage("Are you sure you want to exit the application???");
	 		 builder.setCancelable(false);
	 		 builder.setPositiveButton("YES",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int arg1) {
						
						
						finish();
						
					}
				});
	 	 builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int arg1) {
					
					dialog.cancel();
				}
			});
	 	 AlertDialog alert=builder.create();
	 	 alert.show();
		}
	});
     
	}


	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.UK);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("error", "Language is not supported");
           
            }
        } else {
            Log.e("error", "Failed  to Initilize!");
        }
		
	}@Override
    public void onDestroy() {
        super.onDestroy();
        textToSpeech.shutdown();
    }
	
	private void convertToSpeech(String text) {
        
        
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


}
