package com.basic0315;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Line extends JFrame{

	public static void main(String[] args) {
		Line line = new Line();
		line.initUI();
		
	}
	
	public void initUI() {
		
		JFrame frame = new JFrame();
		FlowLayout flow = new FlowLayout();
		this.setTitle("���߳���");
		this.setSize(400, 300);
		this.setLayout(flow);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		this.add(panel);
		this.setBackground(Color.BLACK);
		
		JButton button = new JButton("�����ֱ��");
		button.setPreferredSize(new Dimension(100,50));
		this.add(button);
		
		this.setVisible(true);
		
		Graphics g = this.getGraphics();//�����ʵĲ���һ��Ҫ�����ý���ɼ������
		
		DrawListener ml = new DrawListener(g,button);
		this.addMouseListener(ml);
		
		button.addActionListener(ml);
		
	}
	public void paint(Graphics g) {
		super.paint(g);
	}
}

