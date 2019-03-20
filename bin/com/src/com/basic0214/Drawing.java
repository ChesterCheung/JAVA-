package com.basic0214;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;


public class Drawing {


	public static void main(String args[]) {
		
		Drawing drawing = new Drawing();
		
		drawing.initUI();
	}

	
	public void initUI() {
		
		JFrame frame = new JFrame();
	
		FlowLayout flow = new FlowLayout();
		frame.setLayout(flow);
		frame.setTitle("��ͼ��");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		
		// 2.�ڽ������У�ʵ����DrawingListener�¼�������Ķ��󣬶�����dl��
		DrawingListener dl = new DrawingListener();
		// 2.1.��ȡ�����ϵĻ��ʶ���Ȼ�󽫻��ʶ��󴫵ݵ�dl�����е�g���ԡ�
		
		
		
		// �����ַ������飬�洢��ť��Ҫ��ʾ��������Ϣ��ѭ���������飬���������е����ݴ�����ť������ӵ�������
		String[] array = { "����", "Բ��","ֱ��","����������","������","ֱ��������" };
		for (int i = 0; i < array.length; i++) {
			JButton but1 = new JButton(array[i]);
			frame.add(but1);
			// ���¼�Դ����but1���addActionListener()�����¼��ӿڶ���ָ���¼�������Ķ���Ϊdl��
			but1.addActionListener(dl);
		}
		
		
		// ������ɫ���飬�洢��ť��Ҫ��ʾ����ɫ��Ϣ��ѭ���������飬���������е����ݴ�����ť������ӵ�������
		Color[] color_array = { Color.black, Color.red, Color.blue, Color.green ,Color.gray, Color.yellow, Color.magenta, Color.orange, Color.pink, Color.white};
		for (int i = 0; i < color_array.length; i++) {
			JButton but = new JButton();
			but.setBackground(color_array[i]);// ���ð�ť�ı�����ɫ
			but.setPreferredSize(new Dimension(30, 30));// ���ð�ť����Ĵ�С
			frame.add(but);
			// ���¼�Դ����but1���addActionListener()�����¼��ӿڶ���ָ���¼�������Ķ���Ϊdl��
			but.addActionListener(dl);
		}
		
		frame.setDefaultCloseOperation(3);
		
		frame.setVisible(true);

		dl.g = frame.getGraphics();//��ȡ���ʵ�ʱ��һ��Ҫ�ڴ���ɼ�֮���ȡ��
		

		// 3.��JFrame�¼�Դ�������addMouseListener()��궯������������ָ���¼�������Ķ���Ϊdl��
		frame.addMouseListener(dl);

	}

}
