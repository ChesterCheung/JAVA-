package com.basic0227;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.color.*;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class ChessMain extends JPanel implements Data{
	
	public static void main() {
		ChessMain chess = new ChessMain();
		chess.initUI();
	}
	
	public void initUI() {
		JFrame frame = new JFrame("五子棋");
		frame.setSize(600,500);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		this.setPreferredSize(new Dimension(450,500));
		frame.add(this, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(150,500));
		
		JButton but1 = new JButton("开始游戏");
		JButton but2 = new JButton("悔棋");
		JButton but3 = new JButton("认输");
		but1.setPreferredSize(new Dimension(40,30));
		but2.setPreferredSize(new Dimension(40,30));
		but3.setPreferredSize(new Dimension(40,30));
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		
		JRadioButton radio1 = new JRadioButton("人人对战");
		JRadioButton radio2 = new JRadioButton("人机对战");
		radio1.setPreferredSize(new Dimension (40,30));
		radio2.setPreferredSize(new Dimension (40,30));
		ButtonGroup bg = new ButtonGroup();
		bg.add(radio1);
		bg.add(radio2);
		radio1.setSelected(true);

		panel.add(radio1);
		panel.add(radio2);
		
		JCheckBox cb = new JCheckBox("AI先下");
		cb.setPreferredSize(new Dimension (40,30));
		panel.add(cb);
		
		frame.add(panel, BorderLayout.EAST);

		frame.setVisible(true);

		Graphics g = this.getGraphics();
		ChessListener chess  = new ChessListener(g);
		this.addMouseListener(chess);
		
		
		
		
		
		
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		drawChessBorder(g);
		
	}
	
	public void drawChessBorder(Graphics g) {
		for (int i = 0;i < Row; i++)
			g.drawLine( X, Y + i * SIZE, X + (Colum -1) * SIZE, Y + i*SIZE );
					
		
		
	}

}
