package com.example.collabtext;

import java.util.ArrayList;

//This is a templated class for storing undo/redo in a circular buffer
//I haven't tested it yet for improper indexing but I think it will work

public class CircularBuffer<T> {
	
	final int MAXSIZE = 100;
	
	private ArrayList<T> buffer = new ArrayList<T>(MAXSIZE); 
	private int head_ptr;
	private int local_ptr;
	
	CircularBuffer(){
		this.head_ptr = 0;
		this.local_ptr = 0;
	}
	
	public void push(T addedObject){
		if(++head_ptr == MAXSIZE){
			head_ptr = 0;
		}
		local_ptr = head_ptr;
		buffer.set(head_ptr, addedObject);
	}
	
	public T get_undo(){	
		if(--local_ptr < 0){
			local_ptr = MAXSIZE;
		}
		if(local_ptr != head_ptr){
			return buffer.get(local_ptr);
		}
		else{
			return null; 
		}
	}

	public T get_redo(){
		if(++local_ptr >= MAXSIZE){
			local_ptr = 0;
		}
		if(local_ptr <= head_ptr){
			return buffer.get(local_ptr);
		}
		else{
			return null; 
		}
	}
	
}
