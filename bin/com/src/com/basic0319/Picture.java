package com.basic0319;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Picture extends JFrame{

	public double x,y;
//	private JFrame frame = this;
	
	JSlider slider1 = new JSlider(0,960,480);
	JSlider slider2 = new JSlider(-100,100,0);
	
	public static void main(String[] args) {
		Picture line = new Picture();
		line.initUI();
		
	}
	
	public void initUI() {
		
//		JFrame frame = new JFrame();
		FlowLayout flow = new FlowLayout();
		this.setTitle("��һ��");
		this.setSize(960, 720);
		this.setLayout(flow);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		
		
		JPanel panel = new JPanel();
		this.add(panel);
		this.setBackground(Color.BLACK);
		
		slider1.setName("�ı��С");
		slider1.setMinorTickSpacing(20);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		this.add(slider1);
		
		JButton button1 = new JButton("����ͼƬ");
		button1.setPreferredSize(new Dimension(100,30));
		this.add(button1);
		
		JButton button2 = new JButton("�ȸ�Ӧ");
		button2.setPreferredSize(new Dimension(100,30));
		this.add(button2);
		
		JButton button3 = new JButton("ģ����");
		button3.setPreferredSize(new Dimension(100,30));
		this.add(button3);
		
		JButton button4 = new JButton("����ƴ��");
		button4.setPreferredSize(new Dimension(100,30));
		this.add(button4);
		
		JButton button5 = new JButton("��Ͳ");
		button5.setPreferredSize(new Dimension(100,30));
		this.add(button5);
		
		slider2.setName("��������");
		slider2.setMinorTickSpacing(20);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		this.add(slider2);
		
		this.setVisible(true);
		
		Graphics g = this.getGraphics();//�����ʵĲ���һ��Ҫ�����ý���ɼ������
		
		DrawListener ml = new DrawListener(g,this);
		button1.addActionListener(ml);
		button2.addActionListener(ml);
		button3.addActionListener(ml);
		button4.addActionListener(ml);
		button5.addActionListener(ml);
		slider1.addChangeListener(ml);
		slider2.addChangeListener(ml);
		
	}
	
	public void actionPerformed(ActionEvent e) {
    	DrawListener dl = new DrawListener(null, this);
    	dl.start();
    	
	}
	public void paint(Graphics g) {
		super.paint(g);
	}

	
}
