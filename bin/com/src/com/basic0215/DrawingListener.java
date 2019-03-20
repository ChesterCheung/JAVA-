package com.basic0215;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * ʵ��ֱ�ߣ����Σ�Բ��ͼƬ�����֣������Σ�������
 * @author Lenovo
 *
 */
public class DrawingListener implements MouseListener, ActionListener {

	// 1.1.�����ĸ����ԣ������洢���º��ͷŵ�����ֵ��
	public int x1, y1, x2, y2;
	
	public String type = "ֱ��";
	
	// 1.4.����Graphics���ʶ�������(Ҫ��JFrame�ϻ���ͼ�Σ�JFrame����ǻ������ģ����ʾʹ�JFrame�ϻ�ȡ)��
	public Graphics g;
	
	public Color color = Color.BLACK;
	public Data array[];
	public int index = 0;

	//������д������ť�ϵ����ָ����ַ���
	public void actionPerformed(ActionEvent e) {
		// �жϵ�����Ƿ�����ɫ��ť
		if (e.getActionCommand().equals("")) {

			JButton button = (JButton) e.getSource();

			color = button.getBackground();
			System.out.println("color = " + color);
		} 
		else {
			type = e.getActionCommand();
			System.out.println("type = " + type);
		}
	}
	

	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a
	 * component.
	 * 
	 * @param e the event to be processed
	 */
	public void mouseClicked(MouseEvent e) {
		System.out.println("���");
	
		

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 * 
	 * @param e the event to be processed
	 */
	public void mousePressed(MouseEvent e) {
		System.out.println("����");
		// 1.2.�ڰ��µķ����л�ȡ��������ֵ��
		x1 = e.getX();
		y1 = e.getY();
		
		
	}


	/**
	 * Invoked when a mouse button has been released on a component.
	 * 
	 * @param e the event to be processed
	 */
	public void mouseReleased(MouseEvent e) {
		System.out.println("�ͷ�");
		// 1.3.���ͷŵķ����л�ȡ�ͷ�����ֵ��
		x2 = e.getX();
		y2 = e.getY();
		
		g.setColor(color);
		
		
		if (type.equals("ֱ��")) {
			g.drawLine(x1, y1, x2, y2);// ����ֱ��
			// ����ͼ�ε�����ʵ����һ��ͼ�ζ���
			Data d = new Data(x1, y1, x2, y2,color, type);
			if (index < 1000) {// �ж��Ƿ�δ����
				array[index++] = d;// ��������뵽������
			}
		} else if (type.equals("����")) {
			g.fillRect(x1, y1, x2 - x1, y2 - y1);// ���ƾ���
			// ����ͼ�ε�����ʵ����һ��ͼ�ζ���
			Data d = new Data(x1, y1, x2 , y2,color , type);
			if (index < 1000) {// �ж��Ƿ�δ����
				array[index++] = d;// ��������뵽������
			}
		}


		// 1.5.ʹ��Graphics���ʶ������ԣ�Ȼ���������ֵ������ͼ�Ρ�
//		if (args.equals("����")) {
//			g.fillRect(x1, y1, x2 - x1, y2 - y1);// ���ƾ���
//			Data d = new Data(x1, y1, x2, y2, color, type);
//		}
			
		else if (type.equals("Բ��")) {
			g.drawOval(x1, y1, x2 - x1, y2 - y1);// ����Բ��
			Data d = new Data(x1, y1, x2, y2, color, type);
			if (index < 1000) {
				array[index++] = d;
			}
		}
			
//		else if (args.equals("ֱ��")) {
//			g.drawLine(x1, y1, x2, y2);// ����ֱ��
//			Data d = new Data(x1, y1, x2, y2, color, type);
//		}
			
		else if (type.equals("����������")) {
			g.drawLine(x1, y2, x2, y2);
			g.drawLine((x1+x2)/2, y1, x1, y2);
			g.drawLine((x1+x2)/2, y1, x2, y2);
			Data d = new Data(x1,y1,x2,y2,color,type);
			if (index < 1000) {
				array[index++] = d;
			}

		}
		else if (type.equals("ֱ��������")) {
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x1, y2, x2, y2);
			g.drawLine(x1, y2, x1, y1);
			Data d = new Data(x1,y1,x2,y2,color,type);
			if (index < 1000) {
				array[index ++] = d;
			}
		}
		else if (type.equals("������")) {
			g.fillRect(x1, y1, x2 - x1, y2 - y1);
			g.drawLine(x2, y1, x2+9, y1-9);
			g.drawLine(9+x1, y1-9, x2+9, y1-9);
			g.drawLine(9+x1, y1-9, x1, y1);
			g.drawLine(x2+9, y2-9, x2+9, y1-9);
			g.drawLine(x2+9, y2-9, x2,y2);
			Data d = new Data(x1,y1,x2,y2,color,type);
			if (index < 1000) {
				array[index++] = d;
			}
		}
			

	}



	/**
	 * Invoked when the mouse enters a component.
	 * 
	 * @param e the event to be processed
	 */
	public void mouseEntered(MouseEvent e) {
		System.out.println("����");
	}

	/**
	 * Invoked when the mouse exits a component.
	 * 
	 * @param e the event to be processed
	 */
	public void mouseExited(MouseEvent e) {
		System.out.println("�뿪");

	}
}