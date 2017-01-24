package com.example.shopkeeper;








import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewRecord extends Activity  implements OnInitListener{
  EditText sup,bill,date,contact,amount,paid,company;
  Button insert,reset;
  private TextToSpeech textToSpeech;
  
	//STARTS ONCREATE 
  @Override  
     protected void onCreate(Bundle savedInstanceState) {  
         super.onCreate(savedInstanceState);  
         setContentView(R.layout.new_record);  
      
         sup=(EditText)findViewById(R.id.editText1);
       bill=(EditText)findViewById(R.id.editText2);
       date=(EditText)findViewById(R.id.editText3);
       contact=(EditText)findViewById(R.id.editText4);
       amount=(EditText)findViewById(R.id.editText5);
       paid=(EditText)findViewById(R.id.editText6);
      
       company=(EditText)findViewById(R.id.editText8);
       
       insert=(Button)findViewById(R.id.button1);
       reset=(Button)findViewById(R.id.button2);
      
       
   	
   
       
       textToSpeech = new TextToSpeech(this, this);
       
     final SQLiteDatabase db=openOrCreateDatabase("ShopkeeperDB", MODE_PRIVATE, null);
      
     
     String create_query="CREATE TABLE IF NOT EXISTS ShopkeeperTable(SUPPLIER TEXT,BILLNO VARCHAR,DATE VARCHAR,CONTACT INT,AMOUNT INT,PAID INT,REMAINING INT,COMPANY TEXT);";
     db.execSQL(create_query);
     
       //STARTS ONcLICKlISTENER FOR THIS
       insert.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View view) {
        
			try{
      String supplierName=sup.getText().toString();
      String billno=bill.getText().toString();
      String ddate=date.getText().toString();
      int cntct=Integer.parseInt(contact.getText().toString());
      int amt=Integer.parseInt(amount.getText().toString());
      int pad=Integer.parseInt(paid.getText().toString());
     int remain=amt-pad;
      String comp=company.getText().toString();
      if(supplierName!="" && billno!="" && ddate!="" &&  comp!="" )
      {
 String insert_query="INSERT INTO ShopkeeperTable VALUES('"+supplierName+"','"+billno+"','"+ddate+"',"+cntct+","+amt+","+pad+","+remain+",'"+comp+"');";
 
 		db.execSQL(insert_query);      
      }//ENDS IF
      else
      {
    	  sup.setError("FIELD IS EMPTY!!");
    	  bill.setError("FIELD IS EMPTY!!");
    	  date.setError("FIELD IS EMPTY!!");
    	  contact.setError("FIELD IS EMPTY!!");
    	  amount.setError("FIELD IS EMPTY!!");
    	  paid.setError("FIELD IS EMPTY!!");
    	  company.setError("FIELD IS EMPTY!!");
      }//END ELSE
      
      
	          // Inserting Contacts  
	        
	         Log.d("Insert: ", "Inserting ..");  
	         convertToSpeech("data inserted successfully");
	         Toast.makeText(NewRecord.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
	        // TODO Auto-generated method stub
           }catch(Exception e){}	
}//END ONCLICK
		});	//END ONCLICKLISTENER	
	   
      
       //RESETS ALL TEXTFIELDS
       reset.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		sup.setText("");
		bill.setText("");date.setText("");
	    contact.setText("");amount.setText("");
		paid.setText("");
		company.setText("");
		
			
		}//END ONCLICK
	});//END ONCLICKLISTENER
       
       
         
    
         
     } //END ONCREATE 
   
	 @Override
	   public boolean onCreateOptionsMenu(Menu menu)
	   {
		 MenuInflater inflater=getMenuInflater();
		 inflater.inflate(R.menu.new_record_options_menu,menu);
		   return  true;
	   }//END METHOD FOR OPTION SMENU
	 
    //METHOD TO SELECT A MENU OPTION
	 @Override
       public boolean onOptionsItemSelected(MenuItem item)
     {
    	 if(item.getItemId()==R.id.home)
    	 {
    		 //takes user back to home screen 
    		 startActivity(new Intent(NewRecord.this,MainActivity.class));
    	 }//END IF
    	 
    	 
    	 if(item.getItemId()==R.id.exit)
    	 {
    convertToSpeech("Are you sure you want to exit the application.");		
    		 AlertDialog.Builder builder=new AlertDialog.Builder(NewRecord.this);
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
    	 }//END IF
    	 
    	 if(item.getItemId()==R.id.back)
    	 {
    		 moveTaskToBack(true);
    			this.finish();
    			
    	 }//END IF
    	 if(item.getItemId()==R.id.sharestuff)
    	 {
    		 startActivity(new Intent(NewRecord.this,ShareData.class));
    	 }//END IF
    	 if(item.getItemId()==R.id.call)
    	 {
    		 startActivity(new Intent(NewRecord.this,CallActivity.class));
    	 }
    	 if(item.getItemId()==R.id.message)
    	 {
    		 Intent intent=new Intent(NewRecord.this,SendMessage.class);
    		 intent.putExtra("sendingContact",contact.getText().toString());
    		 startActivity(intent);
    	 }//END IF
		return super.onOptionsItemSelected(item);
     }

	 //STARTS INIT
	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.UK);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(NewRecord.this, "Language is not supported",Toast.LENGTH_SHORT).show();
           
            }
        } else {
        	Toast.makeText(NewRecord.this, "Language is not supported",Toast.LENGTH_SHORT).show();  
	}
		
 }//ENDS INIT    
	
	private void convertToSpeech(String text) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
     }//END CONVERT-TO-SPEEECH
	
	
	
	
}