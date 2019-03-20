package com.basic0213;
import javax.swing.*;
import java.awt.*;
public class Play {
	
	
	public static void main(String args[]) {
		Play pl= new Play();
		pl.jiemian();
	
		
	}
	
	
	
	public void jiemian() {
		
		JFrame frame = new javax.swing.JFrame();
		frame.setLocationRelativeTo(null);
		frame.setTitle("简单界面程序");
		FlowLayout fl =new FlowLayout();//流式布局必须放置在元素组件前
		
		ImageIcon photo = new ImageIcon("img/photo.jpg");
		JLabel label = new JLabel(photo);
		
		JLabel lab_name = new JLabel("账号：");
		JTextField txt_name =new JTextField(18);
		JLabel bu_name = new JLabel("忘记密码");
		JLabel lab_name2 = new JLabel("密码：");
		JTextField txt_name2 =new JTextField(18);
		JLabel bu_name2 = new JLabel("注册账号");
		JButton name = new JButton("登录");
		
	
		frame.setLayout(fl);
		frame.add(lab_name);
		frame.add(txt_name);
		frame.add(bu_name);
		frame.add(lab_name2);
		frame.add(txt_name2);
		frame.add(bu_name2);
		frame.add(name);
		frame.add(label);
		frame.dispose();
		
		
		frame.setSize(330,400);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);//得放在最后面才能管用
		
		LoginListener login = new LoginListener();
		name.addActionListener(login);
		
		
		login.login = frame;
		
	}
}
