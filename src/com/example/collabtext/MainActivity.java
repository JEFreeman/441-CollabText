package com.example.collabtext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.umich.imlc.android.common.Utils;
import edu.umich.imlc.collabrify.client.CollabrifyAdapter;
import edu.umich.imlc.collabrify.client.CollabrifyClient;
import edu.umich.imlc.collabrify.client.CollabrifyListener;
import edu.umich.imlc.collabrify.client.CollabrifySession;
import edu.umich.imlc.collabrify.client.exceptions.CollabrifyException;
import com.example.collabtext.CollabTextProto.globalMove;
import com.google.protobuf.InvalidProtocolBufferException;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	//long int userID //based on surface/tablet's serial#?

	/**
	   * Logging level for HTTP requests/responses.
	   * <p>
	   * To turn on, set to {@link Level#CONFIG} or {@link Level#ALL} and run this
	   * from command line: {@code adb shell setprop log.tag.HttpTransport DEBUG}.
	   * </p>
	   */
	  private static final Level LOGGING_LEVEL = Level.ALL;

	  private static String TAG = "collabText";

	  private CollabrifyClient myClient;
	  private TextView textViewer;
	  private EditText broadcastText;
	  private Button broadcastButton;
	  private Button createButton;
	  private Button joinSessionButton;
	  private Button leaveSessionButton;
	  private CheckBox withBaseFile;
	  private CollabrifyListener collabrifyListener;
	  private long sessionId;
	  private String sessionName;
	  private ByteArrayInputStream baseFileBuffer;
	  private ByteArrayOutputStream baseFileReceiveBuffer;
	  private ArrayList<String> tags = new ArrayList<String>();
	  private DocEditActivity docEdit = new DocEditActivity();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createButton = (Button) findViewById(R.id.createSession);
		joinSessionButton = (Button) findViewById(R.id.joinSession);

		//withBaseFile = (CheckBox) findViewById(R.id.withBaseFileCheckBox);

		/*broadcastText = (EditText) findViewById(R.id.sendTxt);
		textViewer = (EditText) findViewById(R.id.editText1);
	    broadcastButton = (Button) findViewById(R.id.sendButton);
	    
	    joinSessionButton = (Button) findViewById(R.id.joinButt);
	    leaveSessionButton = (Button) findViewById(R.id.leaveButt);
		 */
		
	    // enable logging
	    Logger.getLogger("edu.umich.imlc.collabrify.client").setLevel(LOGGING_LEVEL);
	    

	    createButton.setOnClickListener(new OnClickListener()
	    {

	      @Override
	      public void onClick(View v)
	      {
	        //try
	        //{
	          /*Random rand = new Random();
	          sessionName = "C0llabT3xt " + rand.nextInt(Integer.MAX_VALUE);
	          myClient.createSession(sessionName, tags, null, 0);
	          Log.i(TAG, "Session name is " + sessionName);
	          */
	    	  Intent i = new Intent(null, DocEditActivity.class);
	    	  startActivity(i);
	        	//}
	       // catch( CollabrifyException e ){Log.e(TAG, "error", e);}
	      }
	    });

	    joinSessionButton.setOnClickListener(new OnClickListener()
	    {

	      @Override
	      public void onClick(View v)
	      {
	    	  Intent i = new Intent(null, DocEditActivity.class);
	    	  startActivity(i);
	      }
	    });
	}
}