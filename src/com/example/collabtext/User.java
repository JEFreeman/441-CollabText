package com.example.collabtext;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
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


/*Need to add a timer actually you won't if you do it char by char
 * char by char
 * some sort of offset for the moves
 * 
 */

@SuppressWarnings("unused")
public class User {

	private static final boolean REMOVE = true;
	private static final boolean INSERT = false;

	private int cursor_coordinate;
	private int user_id;
	
	private Random r;
	private TextWatcher collectText;
	private Move move_to_add;
	private CircularBuffer<Move> undoRedoList;
	private EditText user_text;
	private DocEditActivity docEdit;

	//used for talking with Collaborify
	private Editable globalText;
	
	//constructor
	User(EditText ref, DocEditActivity docEditSrc){
		user_id = 585858558;
		cursor_coordinate = 0;
		undoRedoList = new CircularBuffer<Move>();
		user_text = ref;
		docEdit = docEditSrc;
		globalText = user_text.getText();
		newTextWatch();
		user_text.addTextChangedListener(collectText);
	}

	private void newTextWatch(){
		collectText = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
					//reset the buffer
					Log.w("Start:", String.valueOf(start));
					Log.w("Count:", String.valueOf(count));
					Log.w("After:", String.valueOf(after));
					
					if (count > after) {
						move_to_add = new Move(start+after, count-after, s.toString()
								.substring(start+after, start+count), REMOVE);
						Log.i("Adding a from before move:", move_to_add.change);
						printMove(move_to_add);
						undoRedoList.add(move_to_add);
						docEdit.broadcastMessage(REMOVE, move_to_add.start,
								move_to_add.change, user_id);
						//checkUpdate();
					}
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
				if(count > before){
					move_to_add = new Move(start+before, count-before, s
							.toString().substring(start+before, start+count), INSERT);
					Log.i("Adding a from on move:", move_to_add.change);
					printMove(move_to_add);
					undoRedoList.add(move_to_add);
					docEdit.broadcastMessage(INSERT, move_to_add.start,
							move_to_add.change, user_id);
					//checkUpdate();
				}
			}
		};
	}

	public void undo(){
		Move temp_move;
		temp_move = undoRedoList.getUndo();
		if (temp_move == null) {
			Log.d("Nothing on the Stack:", "BUFFER HIT HEAD PTR");
			return;
		}
		user_text.removeTextChangedListener(collectText);
		Editable temp = user_text.getText();
		
		Log.d("CURRENT MOVE: ", temp.toString());
		if (temp_move.type == INSERT) {
			temp.delete(temp_move.start, temp_move.start + temp_move.length);
			cursor_coordinate = temp_move.start;
			user_text.setText(temp);
			docEdit.broadcastMessage(REMOVE, temp_move.start,
					temp_move.change, user_id);
			user_text.setSelection(cursor_coordinate);
		} 
		else{
			CharSequence insert = temp
					.insert(temp_move.start, temp_move.change);
			user_text.setText(insert);
			docEdit.broadcastMessage(INSERT, temp_move.start,
					temp_move.change, user_id);
			cursor_coordinate = temp_move.start + temp_move.length;
			user_text.setSelection(cursor_coordinate);
		}
		newTextWatch();
		user_text.addTextChangedListener(collectText);
	}

	public void redo(){
		Move temp_move;
		temp_move = undoRedoList.getRedo();
		if(temp_move == null){
			Log.d("Nothing on the Stack:", "BUFFER HIT HEAD PTR");
			return;
		}
		user_text.removeTextChangedListener(collectText);
		Editable temp = user_text.getText();
		printMove(temp_move);
		Log.d("CURRENT MOVE: ", temp.toString());
		if(temp_move.type == REMOVE){
			temp.delete(temp_move.start, temp_move.start + temp_move.length);
			cursor_coordinate = temp_move.start;
			user_text.setText(temp);
			docEdit.broadcastMessage(REMOVE, temp_move.start,
					temp_move.change, user_id);
			user_text.setSelection(cursor_coordinate);
		} 
		else{
			CharSequence insert = temp
					.insert(temp_move.start, temp_move.change);
			user_text.setText(insert);
			docEdit.broadcastMessage(INSERT, temp_move.start,
					temp_move.change, user_id);
			cursor_coordinate = temp_move.start + temp_move.length;
			user_text.setSelection(cursor_coordinate);
		}
		newTextWatch();
		user_text.addTextChangedListener(collectText);
	}

	void updateLocal(int start, int length, String s, boolean type, int id){
		if(user_id != id){
			if(type){
				globalText.delete(start, start+length);
			}
			else{
				globalText.insert(start, (CharSequence) s);
			}
		}
	}
	
	//testing function
	private void printMove(Move m) {
		Log.d("MOVE_start_coordinate:", String.valueOf(m.start));
		Log.d("MOVE_length:", String.valueOf(m.length));
		Log.d("MOVE_change:", m.change);
		Log.d("MOVE_type:", String.valueOf(m.type));
	}

}


//START TIMER IN HERE
/*if (count > before) {
	move_to_add = new Move(prevStart, prevCount, s
			.toString().substring(prevStart,
					prevStart + prevCount), INSERT);
	Log.d("Adding a from on move:", move_to_add.change);
	printMove(move_to_add);
	undoRedoList.add(move_to_add);
	docEdit.broadcastMessage(INSERT, move_to_add.start,
			move_to_add.change);
	checkUpdate();
	prevStart = start;
}
prevCount = count;
prevBefore = before;
cur_move.start = start;
cur_move.length = count;
cur_move.type = INSERT;*/
// debugging***********************************************
// Log.d("undo length:", "");
// Log.i("GetText:", temp.toString());
// Log.i("GetText Length:", String.valueOf(temp.length()));
// printMove(temp_move);
// ********************************************************
/*
 * Log.d("On Text Start:", String.valueOf(start)); Log.w("Count:",
 * String.valueOf(count)); Log.w("After:", String.valueOf(after));
 * Log.w("PrevStart:", String.valueOf(prevStart)); Log.w("GetText: ",
 * user_text.getText().toString()); /*
 * //debug**************************************** Log.d("On Text Start:",
 * String.valueOf(start)); Log.w("Count:", String.valueOf(count));
 * Log.w("Before:", String.valueOf(before)); Log.w("PrevStart:",
 * String.valueOf(prevStart)); //Log.w("GetText: ",
 * user_text.getText().toString()); //
 *//* ********************************************
	 * Log.d("On Text Start:", String.valueOf(start)); Log.w("Count:",
	 * String.valueOf(count)); Log.w("After:", String.valueOf(after));
	 * Log.w("BeforeStart:", String.valueOf(beforeStart));
	 */
