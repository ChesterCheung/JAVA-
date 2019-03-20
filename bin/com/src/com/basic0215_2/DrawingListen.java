package com.basic0215_2;

import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

public class DrawingListen implements MouseListener , ActionListener {
	public Graphics g;
	public void actionPerformed(ActionEvent e) {
		
	}
	

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	 public void mouseReleased(MouseEvent e) {
	    	double x = 0 , y = 0 ;
			double a = -1.7, b = -2.5, c = -2, d = -2;
			
			for (int i = 0; i<10000; i++) {
				x = d * Math.sin(a * x) - Math.sin(b * y);
				y = c * Math.cos(a * x) - Math.cos(b * y);
				
			}
			
			int m = (int) ((d * Math.sin(a * x))-Math.sin(b * y) * 100 +330);
			int n = (int) ((c * Math.cos(a * x))-Math.cos(b * y) * 100 +330);
			
	    }

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




}
