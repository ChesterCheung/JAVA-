package com.basic0312;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ticket extends JFrame{


	
	public static void main(String [] args) {
		Ticket ticket = new Ticket();
		ticket.initUI();
		
	}
	
	public void initUI() {
		ImageIcon image = new ImageIcon("img/photo.jpg");
		JLabel label = new JLabel(image);
		this.add(label);

		this.setTitle("幸运大抽奖");
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		
		JButton button = new JButton("点我抽奖");
		button.setPreferredSize(new Dimension(50,50));
		this.add(button, BorderLayout.NORTH);
		
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(50,50));
		this.add(text, BorderLayout.CENTER);
		
		JButton but = new JButton("查看抽奖结果");
		but.setPreferredSize(new Dimension(40,40));
		this.add(but);
		
		this.setVisible(true);
		
		
		TicketListener listener = new TicketListener(text);
		
		button.addActionListener(listener);
		this.add(button,BorderLayout.NORTH);
		
		but.addActionListener(listener);
		this.add(but,BorderLayout.SOUTH);
		Win win = new Win();
		win.login = this;
	}
	
	public void paint (Graphics g) {
		super.paint(g);
	}
	
	
}
