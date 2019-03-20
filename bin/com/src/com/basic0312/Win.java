package com.basic0312;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Win  implements ActionListener {

	public JFrame login;
	public void Login(){
		
		JFrame f = new JFrame();
		FlowLayout flow = new FlowLayout();
		f.setSize(300,200);
		JLabel label = new JLabel("恭喜您获得一等奖！");
//		label.setHorizontalAlignment(label.CENTER);
		
		f.setTitle("抽奖结果");
		f.setLayout(flow);
		f.add(label);
		label.setLocation(500, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(3);
		
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
}
