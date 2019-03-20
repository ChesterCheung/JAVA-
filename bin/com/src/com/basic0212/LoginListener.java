package com.basic0212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class LoginListener implements ActionListener {

	public JFrame login;
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		LoginListener aa = new LoginListener();
		aa.login();
	
		
	}
	
	public void login() {
		JFrame frame = new JFrame();
		FlowLayout flow = new FlowLayout();
		JTextField text = new JTextField(20);
		ImageIcon img = new ImageIcon("img/timg.jpg");
		JLabel label = new JLabel(img);
		
		frame.setTitle("跳转界面1");
		frame.setSize(150, 150);
		frame.setLocationRelativeTo(null);
		frame.setLayout(flow);
		frame.add(text);
		frame.add(label);
		frame.setDefaultCloseOperation(3);// 设置窗体的关闭操作
		frame.setVisible(true);
		
	//	login.dispose();
		
		
	}

}
