package com.basic0213;

import java.awt.event.ActionEvent;
public class Listener extends Play implements Mouse{
	
	public void draw() {
		System.out.println(I);
	}
	
	public void actionPerformed(ActionEvent e) {

	}
	
	public static void main(String args[]) {
		
		Mouse mon = new Listener();
		mon.draw();
	}
}
