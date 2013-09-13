package com.example.collabtext;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	MasterControl lineCom = new MasterControl();
	//long int userID //based on surface/tablet's serial#?

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
		
	public void join(View view){	
		Intent i = new Intent(this, DocEdit.class);
		startActivity(i);		
	}
		
	public void create(View view){	
		Intent i = new Intent(this, DocEdit.class);
		startActivity(i);
	}
	
	public void sendText(View view){
		//handle incoming text from txtbox and forward it to the control
		//this puts the onus of deciding how large of a chunk to send at any one given time on the user.
		//will have to add a separate button for deleting. That way we dont have to stitch text into the box
		
		//view.getObjectbyID(sendTxt); 
		//lineCom.insert(uniqUserID, sendTxt.text, timestamp?);
		
		
	}
	
	public void movePointer(View view){
		//update this user's pointer location, and shift focus automatically to the text box
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
