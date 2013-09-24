package com.example.collabtext;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.content.Intent;

public class DocEditActivity extends Activity {
	
	User notepad;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_edit);
        EditText ref = (EditText) findViewById(R.id.editText1);
        notepad = new User(ref);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.doc_edit, menu);
        return true;
    }
    
    public void undo(MenuItem menu){
    	notepad.undo();
    }
    
    public void redo(MenuItem menu){
    	//notepad.redo();
    }
    
    public void backToMain(MenuItem menu){
    	Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
    }
    
}
