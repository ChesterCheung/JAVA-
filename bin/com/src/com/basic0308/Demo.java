package com.basic0308;

public class Demo {

	public int num;
	
	public Demo (int num) {
		this.num = num;
		
	}
	
	public void print () {
		num ++;
		System.out.println(Thread.currentThread()+"num = "+num);
		
	}
	
}
