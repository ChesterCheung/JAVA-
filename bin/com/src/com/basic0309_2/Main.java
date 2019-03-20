package com.basic0309_2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class Main extends JFrame {

	public static void main(String[] args) {
		
		Main main = new Main();
		main.initUI();
	}
	
	private ArrayList<Cartoon> cartoonList;
	
	public void initUI() {
		this.setTitle("简单线程动画");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		
		Random random = new Random();
		cartoonList = new ArrayList<Cartoon>();
		
		int size = random.nextInt(10)+10;
		for (int i = 0;i < size;i++) {
			cartoonList.add(new Cartoon(random.nextInt(this.getX()),random.nextInt(this.getY()),150,150,Color.BLACK));

		}
		
		CartoonMove cartoonmove = new CartoonMove(this, cartoonList);
		cartoonmove.start();
	}
	//重写paint方法
	public void paint(Graphics g) {
		super.paint(g);	
		for (int i = 0;i < cartoonList.size();i++) {
			Cartoon car = cartoonList.get(5);
			car.drawOval(g);
		}

	}
	
}
