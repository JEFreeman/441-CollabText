package com.example.collabtext;

import java.util.Vector;

import android.util.Log;

//This is a templated class for storing undo/redo in a circular buffer
//I haven't tested it yet for improper indexing but I think it will work

public class CircularBuffer {
	
	final int MAXSIZE = 100;
	
	private Vector<Move> buffer;
	private int head_ptr;
	private int local_ptr;
	private int neg_ptr;
	
	
	CircularBuffer(){
		this.head_ptr = 0;
		this.local_ptr = 0;
		this.neg_ptr = MAXSIZE - 1;
		buffer = new Vector<Move>();
		buffer.setSize(MAXSIZE);
		//Log.d("constructor", String.valueOf(buffer.size()));
	}
	
	//update by an offset
	public void offset(int offset, int length){
		int temp_ptr = this.head_ptr;
		while(temp_ptr != neg_ptr){
			Move temp_move = buffer.elementAt(temp_ptr);
			if(offset < temp_move.start){
				temp_move.start += length;
			}
		}
	}
	
	public void add(Move addedObject){
		buffer.set(local_ptr, addedObject);
		//Log.d("ADDED", "Object");
		
		local_ptr++;
		if(local_ptr == MAXSIZE){
			local_ptr = 0;
		}
		
		head_ptr = local_ptr;
		
		if(head_ptr == neg_ptr){
			neg_ptr++;
		}
		if(neg_ptr == MAXSIZE){
			neg_ptr = 0;
		}
		
		buffer.set(neg_ptr, null);
	}
	
	public Move getUndo(){	
		local_ptr--;
		if(local_ptr == -1){
			local_ptr = MAXSIZE-1;
		}
		Log.w("Header_ptr:", String.valueOf(head_ptr));
		Log.w("local_ptr:", String.valueOf(local_ptr));
		if(local_ptr != neg_ptr){
			return buffer.get(local_ptr);
		}
		else{
			local_ptr++;
			if(local_ptr == MAXSIZE){
				local_ptr = 0;
			}
			return null; 
		}
	}

	public Move getRedo(){
		Log.w("Header_ptr:", String.valueOf(head_ptr));
		Log.w("local_ptr:", String.valueOf(local_ptr));
		if(local_ptr != head_ptr){
			Move temp =  buffer.get(local_ptr);
			local_ptr++;
			if(local_ptr == MAXSIZE){
				local_ptr = 0;
			}
			return temp;
		}
		else{
			return null; 
		}
	}
	
}
