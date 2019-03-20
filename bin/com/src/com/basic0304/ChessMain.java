package com.basic0304;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class ChessMain extends JPanel implements Data{


	public static void main(String [] args) {
		ChessMain chess = new ChessMain();
		chess.initUI();
		
	}
	
	public void initUI() {
		JFrame frame = new JFrame("五子棋");
		frame.setSize(720,630);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		this.setPreferredSize(new Dimension(500,600));
		this.setBackground(Color.GRAY);
		frame.add(this, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(120,0));
		
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(100,40));
		panel.add(label);
		JButton but1 = new JButton("开始游戏");
		JButton but2 = new JButton("悔棋");
		JButton but3 = new JButton("认输");
		but1.setPreferredSize(new Dimension(100,60));
		but2.setPreferredSize(new Dimension(100,60));
		but3.setPreferredSize(new Dimension(100,60));
		panel.add(but1);
		panel.add(but2);
		panel.add(but3);
		
		JRadioButton radio1 = new JRadioButton("人人对战");
		JRadioButton radio2 = new JRadioButton("人机对战");
		radio1.setPreferredSize(new Dimension (100,40));
		radio2.setPreferredSize(new Dimension (100,40));
		ButtonGroup bg = new ButtonGroup();
		bg.add(radio1);
		bg.add(radio2);
		radio1.setSelected(true);

		panel.add(radio1);
		panel.add(radio2);
		
		JCheckBox cb = new JCheckBox("AI先下");
		cb.setEnabled(false);
		cb.setPreferredSize(new Dimension (100,40));
		panel.add(cb);
		
		frame.add(panel, BorderLayout.EAST);

		frame.setVisible(true);

//		Graphics g = this.getGraphics();
//		this.addMouseListener(chess);
		
		ChessListener gl = new ChessListener(this, but1, but2, but3, radio1, radio2, cb);
		but1.addActionListener(gl);
		but2.addActionListener(gl);
		but3.addActionListener(gl);
		radio1.addActionListener(gl);
		radio2.addActionListener(gl);
		cb.addActionListener(gl);
		
		//这里就不给棋盘面板添加鼠标事件监听方法了，在鼠标点击“开始游戏以后再把监听方法添加到面板”
		//this.addMouseListener(gl);

		
		
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		drawChessBorder(g);
		
	}
	
	public void drawChessBorder(Graphics g) {
		for (int i = 0;i < Row; i++)
			g.drawLine( X, Y + i * SIZE, X + (Colum -1) * SIZE, Y + i * SIZE );
		for (int i =0;i < Colum;i++)
			g.drawLine(X + SIZE * i, Y, X + SIZE * i, Y + SIZE * (Row - 1));
			
		for (int r = 0;r < arrays.length;r ++) {
			for (int c = 0;c < arrays[r].length;c ++) {
				if (arrays[r][c] != 0) {
					int x = c * SIZE + X - Chess_SIZE /2;
					int y = r * SIZE + Y - Chess_SIZE /2;
					if (arrays[r][c] == 1) 
						g.setColor(Color.BLACK);
					else
						g.setColor(Color.white);	
					g.fillOval(x, y, Chess_SIZE, Chess_SIZE);
				}
				
				
			}
			
		
		}
					
		
		
	}

}
