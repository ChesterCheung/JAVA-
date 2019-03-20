package com.basic0316;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DrawListener extends Thread implements MouseListener, ActionListener {

	private JFrame frame;
	public double x ,y ;
	private Graphics g;
	Random random = new Random();
	private int a,b,c,d;
	
	public DrawListener(Graphics g,JFrame frame) {
		this.g = g;
		this.frame = frame;
	
	}
	
    public void mouseClicked(MouseEvent e) {
    	a = e.getX();
    	b = e.getY();
    	c = random.nextInt(30)+70;
    	d = random.nextInt(200);
    	this.run();
   }
    public void run(){
    	
    	Drawing position = new Drawing(a, b); 
    	Drawing velocity = new Drawing(10, -c);
    	Drawing acceleration = new Drawing(50,d);
    	
    	double dt = 0.1;
    	
    	for(int i=0;i<100;i++){
    		
    		position = position.add(velocity.multiple(dt));
    		velocity = velocity.add(acceleration.multiple(dt));
    		
    		Color p[] = {Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,Color.YELLOW,Color.RED,Color.WHITE};
    		int w = random.nextInt(7);
    		g.setColor(p[w]);
    		
    		g.fillOval((int)position.x, (int)position.y, 10, 10);
    		
    		try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
    	}
     
    }
        
	

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		a = random.nextInt(300);
		b = random.nextInt(100)+200;
    	c = random.nextInt(30)+70;
    	d = random.nextInt(200);
		this.run();
	}



}
