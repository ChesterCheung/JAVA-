package com.basic0309_2;

import java.util.ArrayList;

public class CartoonMove extends Thread {

	private Main main;
	private ArrayList<Cartoon> cartoonList;
	public CartoonMove(Main main, ArrayList cartoonList) {
		
	}
	
	//��дrun������ʹ�߳̿�ʼ����
	public void run() {
		while (true) {
			
			for(int i = 0;i < cartoonList.size();i ++) {
				cartoonList.get(i);
			}
			
			//���»������ϵ�����
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
