package com.example.collabtext;

import android.R.string;

public class Move {

	public int start;
	public int length;
	public String change;
	public boolean type;
	
	Move(int str, int len, String s, boolean t){
		start = str;
		length = len;
		change = s;
		type = t;
	}
}
