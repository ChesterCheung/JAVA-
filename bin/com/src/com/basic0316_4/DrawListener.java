package com.basic0316_4;

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
    	for (;;) {
    		this.run();
    	}
   }
    public void run(){
    	
    	Drawing position = new Drawing(a, b); 
    	Drawing velocity = new Drawing(0, -c);
    	Drawing acceleration = new Drawing(30,d);
    	
    	double dt = 0.06;
		int R= random.nextInt(225);
		int G= random.nextInt(225);
		int B= random.nextInt(225);
		int S = 255;
		int k = 0,l = 0;
		
    	for(int i=0;i<30;i++){
    		
    		position = position.add(velocity.multiple(dt));
    		velocity = velocity.add(acceleration.multiple(dt));
    		
    		R++;G++;B++;S--;S--;S--;
    		
    		Color color = new Color(R,G,B,S);
    		g.setColor(color);
    		
    		g.fillOval((int)position.x, (int)position.y,k++ , l++);
    		
    		try {
				Thread.sleep(5);
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
		a = random.nextInt(350);
		b = random.nextInt(200)+100;
    	c = random.nextInt(30)+70;
    	d = random.nextInt(200);
		this.run();
	}



}
