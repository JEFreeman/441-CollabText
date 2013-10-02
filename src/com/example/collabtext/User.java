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


@SuppressWarnings("unused")
public class User {

	private static final boolean REMOVE = true;
	private static final boolean INSERT = false;

	private int cursor_coordinate;
	private int user_id;
	
	private Random r;
	private TextWatcher collectText;
	private Move move_to_add;
	private CircularBuffer undoRedoList;
	private EditText user_text;
	private DocEditActivity docEdit;

	//used for talking with Collaborify
	private String globalText;
	
	//constructor
	User(EditText ref, DocEditActivity docEditSrc){
		user_id = 555;
		cursor_coordinate = 0;
		undoRedoList = new CircularBuffer();
		user_text = ref;
		docEdit = docEditSrc;
		globalText = "";
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
					if (count > after) {
						move_to_add = new Move(start+after, count-after, s.toString()
								.substring(start+after, start+count), REMOVE);
						Log.e("Adding a from before move:", move_to_add.change);
						printMove(move_to_add);
						undoRedoList.add(move_to_add);
						cursor_coordinate = move_to_add.start;
						docEdit.broadcastMessage(REMOVE, move_to_add.start,
								move_to_add.change, user_id);
					}
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				
				if(count > before){
					move_to_add = new Move(start+before, count-before, s
							.toString().substring(start+before, start+count), INSERT);
					Log.e("Adding a from on move:", move_to_add.change);
					printMove(move_to_add);
					undoRedoList.add(move_to_add);
					cursor_coordinate = move_to_add.start+move_to_add.length;
					docEdit.broadcastMessage(INSERT, move_to_add.start,
							move_to_add.change, user_id);
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
		
		Log.e("DANS ERROR for START: ", String.valueOf(start));
		Log.e("DANS ERROR for length: ", String.valueOf(length));
		Log.e("DANS ERROR for s: ",  s);
		Log.e("DANS ERROR for type: ", String.valueOf(type));
		Log.e("DANS ERROR for STRING: ", globalText);
		Log.e("DANS ERROR for id: ", id + "");
		Log.e("DANS ERROR for myID: ", user_id + "");
		user_text.removeTextChangedListener(collectText);
		
		int curLoc = user_text.getSelectionStart();
		Log.e("DANS ERROR for curAt: ", "" + curLoc);
		if(start > globalText.length()){
			start = globalText.length();
		}
		String temp_first = globalText.substring(0, start);
		if(type == REMOVE){
			String temp_second = globalText.substring(start+length);
			temp_first = temp_first.concat(temp_second);
		}
		else{
			String temp_second = globalText.substring(start);
			temp_first = temp_first.concat(s);
			temp_first = temp_first.concat(temp_second);
		}
		globalText = temp_first;
		//if(id != user_id){
			undoRedoList.offset(start, length, type);
			user_text.setText((CharSequence) globalText);
			if(type && curLoc > start){
				Log.e("DANS ERROR for cur go delete: ", curLoc-length + "");
				if(curLoc-length >= 0 && curLoc-length < globalText.length() )
					user_text.setSelection(curLoc- length);
				
			}
			else if(!type && curLoc > start){
				Log.e("DANS ERROR for cur go add: ", curLoc + length + "");
				if(curLoc+length >= 0 && curLoc+length < globalText.length() )
					user_text.setSelection(curLoc+length);
			}
			else{
				Log.e("DANS ERROR for cur leave it: ", curLoc + "");
				if(curLoc >= 0 && curLoc < globalText.length() )
					user_text.setSelection(curLoc);
			}
		//}
		newTextWatch();
		user_text.addTextChangedListener(collectText);
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

Log.w("Start:", String.valueOf(start));
					Log.w("Count:", String.valueOf(count));
					Log.w("After:", String.valueOf(after));
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
