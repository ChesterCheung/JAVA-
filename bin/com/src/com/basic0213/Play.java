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
		frame.setTitle("�򵥽������");
		FlowLayout fl =new FlowLayout();//��ʽ���ֱ��������Ԫ�����ǰ
		
		ImageIcon photo = new ImageIcon("img/photo.jpg");
		JLabel label = new JLabel(photo);
		
		JLabel lab_name = new JLabel("�˺ţ�");
		JTextField txt_name =new JTextField(18);
		JLabel bu_name = new JLabel("��������");
		JLabel lab_name2 = new JLabel("���룺");
		JTextField txt_name2 =new JTextField(18);
		JLabel bu_name2 = new JLabel("ע���˺�");
		JButton name = new JButton("��¼");
		
	
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
		frame.setVisible(true);//�÷����������ܹ���
		
		LoginListener login = new LoginListener();
		name.addActionListener(login);
		
		
		login.login = frame;
		
	}
}
