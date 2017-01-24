package com.example.shopkeeper;


import android.app.Activity;



import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class ViewData extends Activity{
     TextView tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9;
	   @Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	   setContentView(R.layout.view_data);
	final TextView bill=(TextView)findViewById(R.id.textView1);
	final  EditText editBill=(EditText)findViewById(R.id.editText1);
	   Button view=(Button)findViewById(R.id.button1);
	   tv2=(TextView)findViewById(R.id.textView2);
	   tv3=(TextView)findViewById(R.id.textView3);
	   tv4=(TextView)findViewById(R.id.textView4);
	   tv5=(TextView)findViewById(R.id.textView5);
	   tv6=(TextView)findViewById(R.id.textView6);
	   tv7=(TextView)findViewById(R.id.textView7);
	   tv8=(TextView)findViewById(R.id.textView8);
	   tv9=(TextView)findViewById(R.id.textView9);
	   
	   
	   
	   view.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			try{
	
				String billData=editBill.getText().toString();
			SQLiteDatabase db=openOrCreateDatabase("ShopkeeperDB",MODE_PRIVATE,null);
			
			
	Cursor c=db.rawQuery("SELECT * FROM ShopkeeperTable" ,null);
	
	  while(c.moveToNext()){
		  Toast.makeText(ViewData.this,"Button was clicked",Toast.LENGTH_LONG).show();
		String _supplier=c.getString(0);
		String _billNo=c.getString(1);
		String _date=c.getString(2);
		int _contact=Integer.parseInt(c.getString(3));
		int _amount=Integer.parseInt(c.getString(4));
		int _paid=Integer.parseInt(c.getString(5));
		int _remain=Integer.parseInt(c.getString(6));
		String _company=(c.getString(7));
	Log.d("Data",_supplier);
		if(_billNo.equals(billData))
		  {
			 
			  tv2.setText("SupplierName     "+_supplier);
			  tv3.setText("Bill number      "+_billNo);
			  tv4.setText("Date             "+_date);
			  tv5.setText("Contact          "+_contact);
			 
			  tv6.setText("Amount 			"+_amount);
			  tv7.setText("Paid 			"+_paid);
			  tv8.setText("Remaining 		"+_remain);
			  tv9.setText("Company 			"+_company);
			
			
		
			break;
		  }
		
		  
	  }//end while
	 
		db.close();	
			}catch(Exception e){}
		}
	});
	   
	   
	   
	   }
	   
	   @Override
	   public boolean onCreateOptionsMenu(Menu menu)
	   {
		 MenuInflater inflater=getMenuInflater();
		 inflater.inflate(R.menu.view_options_menu,menu);
		   return  true;
	   }
     @Override
       public boolean onOptionsItemSelected(MenuItem item)
     {
    	 if(item.getItemId()==R.id.home)
    	 {
    		 //takes user back to home screen 
    		 startActivity(new Intent(ViewData.this,MainActivity.class));
    	 }
    	 
    	
    	
    	 if(item.getItemId()==R.id.call)
    	 {
    		 Log.d("call","Take you home");
    	 }
    	 
    	 if(item.getItemId()==R.id.sms)
    	 {
    		 Intent intent=new Intent(ViewData.this,SendMessage.class);
    		 intent.putExtra("sendingContact",tv5.getText().toString());
    		 startActivity(intent);
    	 }
    	 
    	 if(item.getItemId()==R.id.record)
    	 {
    		 startActivity(new Intent(ViewData.this,NewRecord.class));
    	 }
    	 
    	 if(item.getItemId()==R.id.contentAsSms)
    	 {
    		 Intent intent=new Intent(ViewData.this,SendMessage.class);
    		 intent.putExtra("sendingContent",tv2.getText().toString()+
    				 "\n"+tv3.getText().toString()+
    				 "\n"+tv4.getText().toString()+
    				 "\n"+tv5.getText().toString()+
    				"\n"+tv6.getText().toString()+
    				"\n"+tv7.getText().toString()+
    				"\n"+tv8.getText().toString()+
    				"\n"+tv9.getText().toString());
    		startActivity(intent);
				 
    	 }
    	 
		return super.onOptionsItemSelected(item);
     }

	   
}
