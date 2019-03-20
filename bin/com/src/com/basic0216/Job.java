package com.basic0216;

public class Job {
	
	
	public int hour = 24;
	public int minute = 60;
	public int second = 60;
	
	public Job() {
		
	}
	
	public Job(int hour,int minute,int second ) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
		
		
	}
	public  String test() {
		System.out.println();
		hour++;
		minute++;
		second++;
		return "The left time is"+hour+"hour\t"+minute+"minute\t"+second+"second\t" ;
		
	}

}
