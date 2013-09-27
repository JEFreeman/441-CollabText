package com.example.collabtext;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
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

	private int cursor_coordinate;
	private int prevStart;
	private int prevCount;
	private int prevBefore;
	private int beforeStart;

	private TextWatcher collectText;
	private Move move_to_add;
	private Move cur_move;
	private CircularBuffer<Move> undoRedoList;
	private EditText user_text;
	private DocEditActivity docEdit;

	// used for talking with Collaborify
	private string update;
	private Queue<Move> globalChange;

	// constructor
	User(EditText ref, DocEditActivity docEditSrc) {
		cursor_coordinate = 0;
		prevStart = 0;
		prevCount = 0;
		prevBefore = 0;
		beforeStart = 0;
		undoRedoList = new CircularBuffer<Move>();
		cur_move = new Move(0, 0, "", true); // if you undo or redo before
												// confirming a word
		user_text = ref;
		docEdit = docEditSrc;
		newTextWatch();
		user_text.addTextChangedListener(collectText);
	}

	private void newTextWatch() {
		prevStart = user_text.getSelectionStart();
		beforeStart = user_text.getSelectionStart();
		collectText = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				if (beforeStart != start) {
					if (count > after) {
						move_to_add = new Move(start, count, s.toString()
								.substring(start, start + count), REMOVE);
						Log.d("Adding a from before move:", move_to_add.change);
						printMove(move_to_add);
						undoRedoList.add(move_to_add);
						docEdit.broadcastMessage(REMOVE, move_to_add.start,
								move_to_add.change);
						checkUpdate();
						beforeStart = start;
					}
				}

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (prevStart != start) {
					if (count > before) {
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
				}
				prevCount = count;
				prevBefore = before;
				cur_move.start = start;
				cur_move.length = count;
				cur_move.type = INSERT;
			}
		};
	}

	public void undo() {
		if (cur_move != null) {
			undoRedoList.add(cur_move);
			cur_move = null;
		}
		Move temp_move;
		temp_move = undoRedoList.getUndo();
		if (temp_move == null) {
			Log.d("Nothing on the Stack:", "BUFFER HIT HEAD PTR");
			return;
		}
		user_text.removeTextChangedListener(collectText);
		Editable temp = user_text.getText();
		if (temp_move.type == INSERT) {
			temp.delete(temp_move.start, temp_move.start + temp_move.length);
			cursor_coordinate = temp_move.start;
			user_text.setText(temp);
			user_text.setSelection(cursor_coordinate);
		} 
		else{
			CharSequence insert = temp
					.insert(temp_move.start, temp_move.change);
			user_text.setText(insert);
			cursor_coordinate = temp_move.start + temp_move.length;
			user_text.setSelection(cursor_coordinate);
		}
		newTextWatch();
		user_text.addTextChangedListener(collectText);
	}

	public void redo() {
		Move temp_move;
		temp_move = undoRedoList.getRedo();
		if (temp_move == null) {
			Log.d("Nothing on the Stack:", "BUFFER HIT HEAD PTR");
			return;
		}
		user_text.removeTextChangedListener(collectText);
		Editable temp = user_text.getText();
		printMove(temp_move);
		if (temp_move.type == INSERT) {
			temp.delete(temp_move.start, temp_move.start + temp_move.length);
			cursor_coordinate = temp_move.start;
			user_text.setText(temp);
			user_text.setSelection(cursor_coordinate);
		} else {
			Log.d("REMOVE YOU NEED TO ADD", temp_move.change);
			CharSequence insert = temp
					.insert(temp_move.start, temp_move.change);
			user_text.setText(insert);
			cursor_coordinate = temp_move.start + temp_move.length;
			user_text.setSelection(cursor_coordinate);
		}
		newTextWatch();
		user_text.addTextChangedListener(collectText);
	}

	void updateLocal(int start, int length, String s, boolean type) {
		Move updated_move = new Move(start, length, s, type);
		globalChange.add(updated_move);
	}

	void checkUpdate() {
		Editable globalText;
		Move tempGlobal;
		globalText = user_text.getText();

		while (!globalChange.isEmpty()) {
			tempGlobal = globalChange.poll();
			if (tempGlobal.type) {
				globalText.delete(tempGlobal.start, tempGlobal.start
						+ tempGlobal.length);
			} else {
				globalText.insert(tempGlobal.start, tempGlobal.change);
			}
		}
	}
	
	//testing function
	private void printMove(Move m) {
		Log.i("MOVE_start_coordinate:", String.valueOf(m.start));
		Log.i("MOVE_length:", String.valueOf(m.length));
		Log.i("MOVE_change:", m.change);
		Log.i("MOVE_type:", String.valueOf(m.type));

	}

}
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
