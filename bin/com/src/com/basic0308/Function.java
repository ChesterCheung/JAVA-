package com.basic0308;

public class Function extends Thread{

	public Demo demo;
	//构造Function方法
	public Function (Demo demo) {
		this.demo = demo;
		
	}
	
	//线程的运行方法，run结束后，线程也就结束了
	public void run () {
		
		while (demo.num <30) {
			demo.print();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(Demo[] args) {
		  Demo demo = new Demo(1);
		//循环20次，多条线程同时进行
		for (int i = 0;i<10;i++) {
			//相当于string.start();
			Function f = new Function(demo);
			//相当于f.start();
			Thread t = new Thread (f);
			t.start();
		}
		System.out.println(Thread.currentThread());
		
	}
	
}
