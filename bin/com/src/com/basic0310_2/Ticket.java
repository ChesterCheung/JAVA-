package com.basic0310_2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ticket  extends JFrame{


	
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
		
		JLabel label1 = new JLabel();
		label1.setPreferredSize(new Dimension (150,50));
		this.add(label1, BorderLayout.WEST);
		
		JLabel label2 = new JLabel();
		label2.setPreferredSize(new Dimension (150,50));
		this.add(label2, BorderLayout.EAST);
		
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(50,50));
		this.add(text, BorderLayout.CENTER);
		
		this.setVisible(true);
		
		
		TicketListener listener = new TicketListener(text);
		button.addMouseListener(listener);
	}
	
	public void paint (Graphics g) {
		super.paint(g);
	}
	
	
}
