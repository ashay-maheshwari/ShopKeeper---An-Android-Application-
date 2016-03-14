package com.example.shopkeeper;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AboutClass extends Activity implements OnInitListener{
	  private TextToSpeech textToSpeech;
	@Override
 
   
protected void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);
	setContentView(R.layout.about);
	
	EditText et=(EditText)findViewById(R.id.editText1);
final String text="Shopkeeper is an application specifically designed for small shop owners." +
		"The aplication provides him or her the ease of maintaing some small records related " +
		"to his or her shop in the Android smart phone,excluding the nessecity of carrying" +
		" bundle of papers for even smaller references.This is Release 1 with few " +
		"functionalities like inserting new records and performing operations on them." +
		"Application also provides calling and sending message as a facility from within it. " ;
  
   et.setText(text);
   et.setEnabled(false);
   
       textToSpeech = new TextToSpeech(this, this);
    
       Button enable=(Button)findViewById(R.id.button1);
       Button dev=(Button)findViewById(R.id.button2);
       
       enable.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			convertToSpeech(text);
			
		}
	});
       
       dev.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		startActivity(new Intent(AboutClass.this,AboutDevelopers.class));
			
		}
	});
   
   }

@Override
   public void onInit(int status) {
	  if(status==TextToSpeech.SUCCESS)
	  {
		  int result=textToSpeech.setLanguage(Locale.UK);
		  if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
Toast.makeText(AboutClass.this, "Sorry this language is not supported",Toast.LENGTH_LONG).show();
            		  }//ENDS IF
		  else {
          Log.e("error", "Failed  to Initilize!");
      }//ENDS ELSE
	
	  }//ENDS INIT
}   @Override
         public void onDestroy() {
           super.onDestroy();
             textToSpeech.shutdown();
    }//ENDS ON-DESTROY

   private void convertToSpeech(String text) {
     textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
           }//ENDS CONVERT-TO-SPEECH



}