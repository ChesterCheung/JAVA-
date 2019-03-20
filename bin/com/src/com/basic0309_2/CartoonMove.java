package com.basic0309_2;

import java.util.ArrayList;

public class CartoonMove extends Thread {

	private Main main;
	private ArrayList<Cartoon> cartoonList;
	public CartoonMove(Main main, ArrayList cartoonList) {
		
	}
	
	//重写run方法，使线程开始运行
	public void run() {
		while (true) {
			
			for(int i = 0;i < cartoonList.size();i ++) {
				cartoonList.get(i);
			}
			
			//重新画界面上的内容
			main.repaint();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
