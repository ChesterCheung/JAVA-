package com.basic0318;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Picture extends JFrame{

	public double x,y;
	private JFrame frame = this;
	
	public static void main(String[] args) {
		Picture line = new Picture();
		line.initUI();
		
	}
	
	public void initUI() {
		
		JFrame frame = new JFrame();
		FlowLayout flow = new FlowLayout();
		this.setTitle("来一波");
		this.setSize(960, 720);
		this.setLayout(flow);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		
		JPanel panel = new JPanel();
		this.add(panel);
		this.setBackground(Color.BLACK);
		
		JButton button1 = new JButton("导入图片");
		button1.setPreferredSize(new Dimension(100,30));
		this.add(button1);
		
		JButton button2 = new JButton("热感应");
		button2.setPreferredSize(new Dimension(100,30));
		this.add(button2);
		
		JButton button3 = new JButton("模糊化");
		button3.setPreferredSize(new Dimension(100,30));
		this.add(button3);
		
		JButton button4 = new JButton("流行拼接");
		button4.setPreferredSize(new Dimension(100,30));
		this.add(button4);
		
		
		this.setVisible(true);
		
		Graphics g = this.getGraphics();//传画笔的操作一定要在设置界面可见后进行
		
		DrawListener ml = new DrawListener(g,frame);
		button1.addActionListener(ml);
		button2.addActionListener(ml);
		button3.addActionListener(ml);
		button4.addActionListener(ml);
		
	}
	
	public void actionPerformed(ActionEvent e) {
    	DrawListener dl = new DrawListener(null, frame);
    	dl.start();
    	
	}
	
}
