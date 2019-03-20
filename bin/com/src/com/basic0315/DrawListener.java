package com.basic0315;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;

public class DrawListener extends MouseAdapter implements ActionListener{

	private Graphics g;
	private JButton button;
	Random random = new Random();
	private int way = 10;
	private int w = 0;
	private int t = 0;
	
	public DrawListener (Graphics g,JButton button) {
		this.g = g;
		this.button = button;
		
	}
	
	//如果鼠标在界面上点击了，就按照点击位置画出
    public void mouseClicked(MouseEvent e) {
    	int x = e.getX();
    	int y = e.getY();
    	
    	w = random.nextInt(7);
    	Color c[] = {Color.BLACK,Color.BLUE,Color.GREEN,Color.RED,Color.CYAN,Color.GRAY,Color.YELLOW};
    	g.setColor(c[w]);
    	
    	//不同方向的线随机画
    	t = random.nextInt(4);
    	if (t == 0) {
    		for (int i = 0;i<50;i++) {
        		x += way;
        		y -= way;
        		g.fillOval(x, y, way, way);
        		try {
    				Thread.sleep(15);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
    	}
    	
    	if (t == 1) {
    		for (int i = 0;i<50;i++) {
        		x += way;
        		y += way;
        		g.fillOval(x, y, way, way);
        		try {
    				Thread.sleep(20);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
    	}
    	
    	if (t == 2) {
    		for (int i = 0;i<50;i++) {
        		x -= way;
        		y -= way;
        		g.fillOval(x, y, way, way);
        		try {
    				Thread.sleep(20);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
    	}
    	
    	if (t == 3) {
    		for (int i = 0;i<50;i++) {
        		x -= way;
        		y += way;
        		g.fillOval(x, y, way, way);
        		try {
    				Thread.sleep(20);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
    	}
    	
    }
    //如果没有鼠标点击确定位置，就随机画
	public void actionPerformed(ActionEvent e) {

		int x = random.nextInt(400);
		int y = random.nextInt(300);
		
		w = random.nextInt(7);
    	Color c[] = {Color.BLACK,Color.BLUE,Color.GREEN,Color.RED,Color.CYAN,Color.GRAY,Color.YELLOW};
    	g.setColor(c[w]);
    	
    	//不同方向的线随机画
    	t = random.nextInt(4);
    	if (t == 0) {
    		for (int i = 0;i<50;i++) {
        		x += way;
        		y -= way;
        		g.fillOval(x, y, way, way);
        		try {
    				Thread.sleep(20);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
    	}
    	
    	if (t == 1) {
    		for (int i = 0;i<50;i++) {
        		x += way;
        		y += way;
        		g.fillOval(x, y, way, way);
        		try {
    				Thread.sleep(20);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
    	}
    	
    	if (t == 2) {
    		for (int i = 0;i<50;i++) {
        		x -= way;
        		y -= way;
        		g.fillOval(x, y, way, way);
        		try {
    				Thread.sleep(20);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
    	}
    	
    	if (t == 3) {
    		for (int i = 0;i<50;i++) {
        		x -= way;
        		y += way;
        		g.fillOval(x, y, way, way);
        		try {
    				Thread.sleep(20);
    			} catch (InterruptedException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
        	}
    	}
    	
	}

	

}
