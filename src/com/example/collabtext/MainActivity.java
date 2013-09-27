package com.example.collabtext;

import java.util.logging.Level;
import java.util.logging.Logger;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends Activity {

	//long int userID //based on surface/tablet's serial#?
	  private static final Level LOGGING_LEVEL = Level.ALL;
	  private Button joinSessionButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		joinSessionButton = (Button) findViewById(R.id.joinSession);
	    // enable logging
	    Logger.getLogger("edu.umich.imlc.collabrify.client").setLevel(LOGGING_LEVEL);  
	};
	
	public void join()
	{
		Intent i = new Intent(this, DocEditActivity.class);
		startActivity(i);
	}
}