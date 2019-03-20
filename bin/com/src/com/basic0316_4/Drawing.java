package com.basic0316_4;

import java.awt.Graphics;

public class Drawing {

	public double x,y;

	
	public Drawing(double x,double y) {
		
		this.x = x;
		this.y = y;
	}
	
	public Drawing add(Drawing V) {
		Drawing V1 = new Drawing(this.x + V.x, this.y + V.y);
		return V1;
		
		
	}
	
	public Drawing multiple(double B) {
		Drawing B1 = new Drawing( this.x * B, this.y * B);
		return B1;
		
	}
	
}
