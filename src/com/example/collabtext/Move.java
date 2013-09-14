package com.example.collabtext;

public class Move {

	public int start_x;
	public int start_y;
	public int end_x;
	public int end_y;	
	public String change;
	public MoveType type;
	
	public enum MoveType {
		INSERT,
		REMOVE,
		REPLACE,
		MOVING,
		CURSOR_CHANGE
	}
	
}
