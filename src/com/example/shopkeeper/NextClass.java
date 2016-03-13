package com.example.shopkeeper;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NextClass extends Activity {
   Button newRecord,notes,manage;
	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
  setContentView(R.layout.next);
    newRecord=(Button)findViewById(R.id.button1);
    notes=(Button)findViewById(R.id.button2);
    manage=(Button)findViewById(R.id.button3);
    
    registerForContextMenu(manage);
   
    newRecord.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			startActivity(new Intent(NextClass.this,NewRecord.class));
		}
	});
    
    
   notes.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			startActivity(new Intent(NextClass.this,NotePadActivity.class));
		}
	});
   

  
  
   }//end onCreate
	
	 @Override
	   public void onCreateContextMenu(ContextMenu menu,View view,ContextMenuInfo menuInfo)
	    {
		 super.onCreateContextMenu(menu,view,menuInfo);
	    MenuInflater inflater=getMenuInflater();
	    inflater.inflate(R.menu.manage_context_menu,menu);
		 
	    	
	    }
	
	 @Override
	 public boolean onContextItemSelected(MenuItem item){
		
		 if(item.getItemId()==R.id.view)
		 {
	   startActivity(new Intent(NextClass.this,ViewData.class));
		 }
		 
		 if(item.getItemId()==R.id.delete)
		 {
 	
		 }
		 if(item.getItemId()==R.id.update)
		 {
			 Log.d("Update","IN update");
		 }
		 if(item.getItemId()==R.id.share)
		 {
	startActivity(new Intent(NextClass.this,ShareData.class));		 
		 }
		 return super.onContextItemSelected(item); 
		 
	 }
	 
	@Override
	   public boolean onCreateOptionsMenu(Menu menu)
	   {
		 MenuInflater inflater=getMenuInflater();
		 inflater.inflate(R.menu.next_class_options_menu,menu);
		   return  true;
	   }
  @Override
    public boolean onOptionsItemSelected(MenuItem item)
  {
 	 if(item.getItemId()==R.id.home)
 	 {
 		 //takes user back to home screen 
 		 startActivity(new Intent(NextClass.this,MainActivity.class));
 	 }
 	 if(item.getItemId()==R.id.shareit)
 	 {
 		 startActivity(new Intent(NextClass.this,ShareData.class));
 	 }
 	 if(item.getItemId()==R.id.exit)
 	 {
 		
 		 AlertDialog.Builder builder=new AlertDialog.Builder(NextClass.this);
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
	return super.onOptionsItemSelected(item);
  }
 
	
	
}
