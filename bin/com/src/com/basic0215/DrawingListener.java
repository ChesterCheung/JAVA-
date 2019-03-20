package com.basic0215;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 实现直线，矩形，圆，图片，文字，三角形，立方体
 * @author Lenovo
 *
 */
public class DrawingListener implements MouseListener, ActionListener {

	// 1.1.定义四个属性，用来存储按下和释放的坐标值；
	public int x1, y1, x2, y2;
	
	public String type = "直线";
	
	// 1.4.声明Graphics画笔对象属性(要在JFrame上绘制图形，JFrame组件是画出来的，画笔就从JFrame上获取)；
	public Graphics g;
	
	public Color color = Color.BLACK;
	public Data array[];
	public int index = 0;

	//方法重写，将按钮上的文字赋给字符串
	public void actionPerformed(ActionEvent e) {
		// 判断点击的是否是颜色按钮
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
		System.out.println("点击");
	
		

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 * 
	 * @param e the event to be processed
	 */
	public void mousePressed(MouseEvent e) {
		System.out.println("按下");
		// 1.2.在按下的方法中获取按下坐标值；
		x1 = e.getX();
		y1 = e.getY();
		
		
	}


	/**
	 * Invoked when a mouse button has been released on a component.
	 * 
	 * @param e the event to be processed
	 */
	public void mouseReleased(MouseEvent e) {
		System.out.println("释放");
		// 1.3.在释放的方法中获取释放坐标值；
		x2 = e.getX();
		y2 = e.getY();
		
		g.setColor(color);
		
		
		if (type.equals("直线")) {
			g.drawLine(x1, y1, x2, y2);// 绘制直线
			// 根据图形的数据实例化一个图形对象
			Data d = new Data(x1, y1, x2, y2,color, type);
			if (index < 1000) {// 判断是否还未存满
				array[index++] = d;// 将对象存入到数组中
			}
		} else if (type.equals("矩形")) {
			g.fillRect(x1, y1, x2 - x1, y2 - y1);// 绘制矩形
			// 根据图形的数据实例化一个图形对象
			Data d = new Data(x1, y1, x2 , y2,color , type);
			if (index < 1000) {// 判断是否还未存满
				array[index++] = d;// 将对象存入到数组中
			}
		}


		// 1.5.使用Graphics画笔对象属性，然后根据坐标值来绘制图形。
//		if (args.equals("矩形")) {
//			g.fillRect(x1, y1, x2 - x1, y2 - y1);// 绘制矩形
//			Data d = new Data(x1, y1, x2, y2, color, type);
//		}
			
		else if (type.equals("圆形")) {
			g.drawOval(x1, y1, x2 - x1, y2 - y1);// 绘制圆形
			Data d = new Data(x1, y1, x2, y2, color, type);
			if (index < 1000) {
				array[index++] = d;
			}
		}
			
//		else if (args.equals("直线")) {
//			g.drawLine(x1, y1, x2, y2);// 绘制直线
//			Data d = new Data(x1, y1, x2, y2, color, type);
//		}
			
		else if (type.equals("等腰三角形")) {
			g.drawLine(x1, y2, x2, y2);
			g.drawLine((x1+x2)/2, y1, x1, y2);
			g.drawLine((x1+x2)/2, y1, x2, y2);
			Data d = new Data(x1,y1,x2,y2,color,type);
			if (index < 1000) {
				array[index++] = d;
			}

		}
		else if (type.equals("直角三角形")) {
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x1, y2, x2, y2);
			g.drawLine(x1, y2, x1, y1);
			Data d = new Data(x1,y1,x2,y2,color,type);
			if (index < 1000) {
				array[index ++] = d;
			}
		}
		else if (type.equals("立方体")) {
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
		System.out.println("进入");
	}

	/**
	 * Invoked when the mouse exits a component.
	 * 
	 * @param e the event to be processed
	 */
	public void mouseExited(MouseEvent e) {
		System.out.println("离开");

	}
}