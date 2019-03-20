package com.basic0226_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * ʵ��ֱ�ߣ����Σ�Բ��ͼƬ�����֣������Σ�������
 * @author Lenovo
 *
 */
public class DrawingListener implements MouseListener, ActionListener {

	// 1.1.�����ĸ����ԣ������洢���º��ͷŵ�����ֵ��
	private int x1, y1, x2, y2;
	
	public String type = "ֱ��";
	public Graphics g;
	public Color color = Color.BLACK;
	private Robot robot;
	private JFrame frame;
	private BufferedImage image;
	private int  arrays[][];
	private int a,b;
	DrawingListener dl;
		
	public DrawingListener(JFrame frame) {
		this.frame = frame;
		try {
			robot = new Robot();
		}catch(AWTException e){
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
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
	
		Capture();

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 * 
	 * @param e the event to be processed
	 */
	public void mousePressed(MouseEvent e) {
		System.out.println("����");
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
		x2 = e.getX();
		y2 = e.getY();
		
		g.setColor(color);
		
		
		if (type.equals("ֱ��")) {
			g.drawLine(x1, y1, x2, y2);
			
		} 
		else if (type.equals("������")) {
			if (x2 > x1 && y2 > y1) 
				g.fillRect(x1, y1, x2 - x1, y2 - y1); 
			else if (x2 < x1 && y2 < y1)
				g.fillRect(x2, y2, x1 - x2, y1 - y2);
			else if (x2 > x1 && y2 < y1)
				g.fillRect(x1, y2, x2 - x1, y2 - y1);
			else if (x2 < x1 && y2 > y1)
				g.fillRect(x2, y1, x1 - x2, y2 - y1);
		}

		else if (type.equals("����")) {
			if (x2 > x1 && y2 > y1) 
				g.drawRect(x1, y1, x2 - x1, y2 - y1); 
			else if (x2 < x1 && y2 < y1)
				g.drawRect(x2, y2, x1 - x2, y1 - y2);
			else if (x2 > x1 && y2 < y1)
				g.drawRect(x1, y2, x2 - x1, y2 - y1);
			else if (x2 < x1 && y2 > y1)
				g.drawRect(x2, y1, x1 - x2, y2 - y1);
		}
			
		else if (type.equals("Բ��")) {
			if (x2 > x1 && y2 > y1) 
				g.drawOval(x1, y1, x2 - x1, y2 - y1); 
			else if (x2 < x1 && y2 < y1)
				g.drawOval(x2, y2, x1 - x2, y1 - y2);
			else if (x2 > x1 && y2 < y1)
				g.drawOval(x1, y2, x2 - x1, y1 - y2);
			else if (x2 < x1 && y2 > y1)
				g.drawOval(x2, y1, x1 - x2, y2 - y1);
			
		}
		
		else if (type.equals("���Բ��")) {
			if (x2 > x1 && y2 > y1) 
				g.fillOval(x1, y1, x2 - x1, y2 - y1); 
			else if (x2 < x1 && y2 < y1)
				g.fillOval(x2, y2, x1 - x2, y1 - y2);
			else if (x2 > x1 && y2 < y1)
				g.fillOval(x1, y2, x2 - x1, y1 - y2);
			else if (x2 < x1 && y2 > y1)
				g.fillOval(x2, y1, x1 - x2, y2 - y1);
			
		}
			
		else if (type.equals("����������")) {
			g.drawLine(x1, y2, x2, y2);
			g.drawLine((x1+x2)/2, y1, x1, y2);
			g.drawLine((x1+x2)/2, y1, x2, y2);


		}
		else if (type.equals("ֱ��������")) {
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x1, y2, x2, y2);
			g.drawLine(x1, y2, x1, y1);
			
		}
		else if (type.equals("������")) {
			if (x2 > x1 && y2 > y1) {
				g.drawRect(x1, y1, x2 - x1, y2 - y1);
				g.drawLine(x2, y1, x2+15, y1-15);
				g.drawLine(15+x1, y1-15, x2+15, y1-15);
				g.drawLine(15+x1, y1-15, x1, y1);
				g.drawLine(x2+15, y2-15, x2+15, y1-15);
				g.drawLine(x2+15, y2-15, x2,y2);
				g.drawLine(x1+15, y2 -15,15+x1, y1-15);
				g.drawLine(x1, y2, x1+15, y2-15);
				g.drawLine(x1+15, y2 -15, x2+15, y2-15);
			} else if (x2 < x1 && y2 < y1) {
				g.drawRect(x2, y2, x1 - x2, y1 - y2);
				g.drawLine(x1, y2, x1+15, y2-15);
				g.drawLine(15+x2, y2-15, x1+15, y2-15);
				g.drawLine(15+x2, y2-15, x2, y2);
				g.drawLine(x1+15, y1-15, x1+15, y2-15);
				g.drawLine(x1+15, y1-15, x1,y1);
				g.drawLine(x2+15, y1 -15,15+x2, y2-15);
				g.drawLine(x2, y1, x2+15, y1-15);
				g.drawLine(x2+15, y1 -15, x1+15, y1-15);
			} else if (x2 > x1 && y2 < y1) {
				g.drawRect(x1, y2, x2 - x1, y1-y2);
				g.drawLine(x1+15, y2-15, x1, y2);
				g.drawLine(x2, y2, x2+15, y2-15);
				g.drawLine(x1+15, y2-15, x2+15, y2-15);
				g.drawLine(x2, y1, x2+15, y1-15);
				g.drawLine(x1, y1, x1+15, y1-15);
				g.drawLine(x2+15, y1-15, x1+15, y1-15);
				g.drawLine(x1+15, y2-15, x1+15, y1-15);
				g.drawLine(x2+15, y2-15, x2+15, y1-15);
			} else if (x2 < x1 && y2 > y1) {
				g.drawRect(x2, y1, x1-x2, y2-y1);
				g.drawLine(x2, y1, x2+15, y1-15);
				g.drawLine(x1, y1, x1+15, y1-15);
				g.drawLine(x2+15, y1-15, x1+15, y1-15);
				g.drawLine(x2, y2, x2+15, y2-15);
				g.drawLine(x1, y2, x1+15, y2-15);
				g.drawLine(x2+15, y2-15, x1+15, y2-15);
				g.drawLine(x2+15, y2-15, x2+15, y1-15);
				g.drawLine(x1+15, y2-15, x1+15, y1-15);
			}
				
		
		}
		else if (type.equals("���")) {
			if (x2 > x1 && y2 > y1) 
				g.clearRect(x1, y1, x2 - x1, y2 - y1); 
			else if (x2 < x1 && y2 < y1)
				g.clearRect(x2, y2, x1 - x2, y1 - y2);
			else if (x2 > x1 && y2 < y1)
				g.clearRect(x1, y2, x2 - x1, y1 - y2);
			else if (x2 < x1 && y2 > y1)
				g.clearRect(x2, y1, x1 - x2, y2 - y1);
		} 
		
		Capture();

	}


	
	public void Capture() {
		Rectangle rect = new Rectangle(0,0,frame.getHeight(),frame.getWidth());
		image = robot.createScreenCapture(rect);
		arrays = new int [image.getHeight()][image.getWidth()];
		for(a = 0; a <image.getHeight(); a++) {
			for(b = 0; b< image.getWidth(); b++) {
				arrays[a][b] = image.getRGB(a, b);
				
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
	

	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}
	


	public int [][] getRGBarrays () {
		// TODO Auto-generated method stub
		return arrays;
	}
}



