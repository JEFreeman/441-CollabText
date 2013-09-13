package com.example.collabtext;

public class MasterControl {

	public void insert(int userID, char[] text, int timestamp){
		//use the user ID to find the local pointer location
		//or, be able to find local user... setUser()?
		
		//idea. move pointer by clicking, when selecting the stage, 
		//type in a box. this allows the user to make large edits and broadcast them instead of piecemeal
		//insert would effectively just be a broadcast of this box.
		
		//send text to the collabrify server.
		
	}
	
	public void remove(){
		
	}
	
	public void replace(){
		
	}
	
	public void move(){
		
	}
	
	public void cursorLoc(){
		//contain new actual index
		//contain relative change in index
		
	}
	
	public void undo(){
		
	}
	
	public void redo(){
		
	}
	
}

