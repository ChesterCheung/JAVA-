package com.basic0227;

import java.applet.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

import javax.swing.*;

public class ChessListener extends MouseAdapter  {


	private Graphics g;
	int X,Y;
	
	
	public void ChessListener(Graphics g) {
		this.g = g;
	}
	
	
	public void mouseClicked(MouseEvent e) {
		
		X = e.getX();
		Y = e.getY();
		
	}

}
