package com.basic0212;
import javax.swing.*;
import java.awt.*;
public class Play {
	
	
	public static void main(String args[]) {
		Play pl= new Play();
		pl.jiemian();
		
	}
	
	
	
	public void jiemian() {
		JFrame frame = new JFrame();
		frame.setTitle("�򵥽������");
		FlowLayout fl =new FlowLayout();//��ʽ���ֱ��������Ԫ�����ǰ
		ImageIcon photo = new ImageIcon("img/photo.jpg");
		JLabel label = new JLabel(photo);
		JLabel lab_name = new JLabel("�˺ţ�");
		JTextField txt_name =new JTextField(18);
		JButton bu_name = new JButton("��������");
		JLabel lab_name2 = new JLabel("���룺");
		JTextField txt_name2 =new JTextField(18);
		JButton bu_name2 = new JButton("ע���˺�");
		JButton name = new JButton("��¼");
		
		
		frame.setLayout(fl);
		frame.setLocationRelativeTo(null);
		frame.add(lab_name);
		frame.add(txt_name);
		frame.add(bu_name);
		frame.add(lab_name2);
		frame.add(txt_name2);
		frame.add(bu_name2);
		frame.add(name);
		frame.add(label);
	//	frame.dispose();
		
		
		frame.setSize(350,400);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);//�÷����������ܹ���
		
		LoginListener login = new LoginListener();
		name.addActionListener(login);
		
		
	}
}
