package com.basic0216;

public class Transfer {
	

	
	public static void mian(String args[]) {
		
		Job job = new Job(13,56,43);
		job.hour = 15;
		job.minute = 25;
		job.second = 35;
		
		
		System.out.println(job.test());
		
		
	}

}
