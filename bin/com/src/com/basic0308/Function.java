package com.basic0308;

public class Function extends Thread{

	public Demo demo;
	//����Function����
	public Function (Demo demo) {
		this.demo = demo;
		
	}
	
	//�̵߳����з�����run�������߳�Ҳ�ͽ�����
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
		//ѭ��20�Σ������߳�ͬʱ����
		for (int i = 0;i<10;i++) {
			//�൱��string.start();
			Function f = new Function(demo);
			//�൱��f.start();
			Thread t = new Thread (f);
			t.start();
		}
		System.out.println(Thread.currentThread());
		
	}
	
}
