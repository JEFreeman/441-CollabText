package com.example.collabtext;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import android.R.string;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.Selection;
import android.util.Log;

//class is made to separate the User from the "master" activity that manages what is 
//happening globally. 

@SuppressWarnings("unused")
public class User {

	private static final boolean REMOVE = true;
	private static final boolean INSERT = false;
	
	private int user_id;
	private int cursor_coordinate; 
	private Move current_move = new Move();
	private Stack<Move> test = new Stack<Move>();
	private CircularBuffer<Move> undoRedoList = new CircularBuffer<Move>();
	private EditText user_text;
	private int prevStart = 0; 
	private boolean undoRedoCall = true; // watch out for change from other users 
	
	//constructor 
	User(EditText ref){
		user_id = 0;
		cursor_coordinate = 0;
		user_text = ref;
		user_text.addTextChangedListener(new TextWatcher(){
			@Override
			 public void afterTextChanged(Editable s) {}
			@Override
		     public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
			@Override
		     public void onTextChanged(CharSequence s, int start, int before, int count) {
				cursor_coordinate = start + count;
				
				if(prevStart != start && current_move.change != " "){
					Log.d("Adding a move:", current_move.change);
					current_move.change.concat(" ");
					test.add(current_move);
					prevStart = start;
				}
				current_move.start_coordinate = start;
				current_move.old_length = before;
				current_move.new_length = count;
				current_move.change = s.toString().substring(start, start+count);
				if (before > count){
					current_move.type = REMOVE;
				}
				else{
					current_move.type = INSERT;
				}
			}
		});
	}
	
	//manipulating the user_id
	public int getUser(){
		return user_id;
	}
	
	//manipulating the cursor position
	public void setCursorPosition(int pos){
		cursor_coordinate = pos;
	}
	
	public int getCursorPosition(){
		return cursor_coordinate;
	}
	
	public void undo(){
		current_move = test.lastElement();
		current_move = test.pop();
		Editable temp = user_text.getText();
		if(current_move.type == INSERT){
			temp.delete(current_move.start_coordinate, current_move.start_coordinate + current_move.new_length);
			cursor_coordinate = current_move.start_coordinate;
		}else{
			CharSequence insert = temp.insert(current_move.start_coordinate, current_move.change);
			user_text.setText(insert);
			cursor_coordinate = current_move.start_coordinate + current_move.new_length;
		}
	}
	
	public void redo(){
		Editable temp = user_text.getText();
		current_move = undoRedoList.getRedo();
		//stemp.insert(where, text)
		user_text.setText(temp.toString());
	}

}
