package com.basic0215;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;


public class Drawing extends JFrame{


	public static void main(String args[]) {
		
		Drawing drawing = new Drawing();
		
		drawing.initUI();
	}

	public Data array[] = new Data[1000];
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);
		System.out.println("已经进行了重绘");
		
		//添加循环语句，将之前所的绘图全部进行重绘，等到输出为空时结束循环
		for (int i = 0; i<array.length; i++) {
			Data d = array[i];
			if (d != null)
				d.draw(g);
			else
				break;
		}
	}
	
	
	
	public void initUI() {
		
//		JFrame frame = new JFrame();
	
		FlowLayout flow = new FlowLayout();
		this.setLayout(flow);
		this.setTitle("画图板");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		
		// 2.在界面类中，实例化DrawingListener事件处理类的对象，对象名dl。
		DrawingListener dl = new DrawingListener();
		// 2.1.获取窗体上的画笔对象，然后将画笔对象传递到dl对象中的g属性。
		
		
		
		// 定义字符串数组，存储按钮上要显示的文字信息，循环遍历数组，根据数组中的数据创建按钮对象，添加到窗体上
		String[] array = { "矩形", "圆形","直线","等腰三角形","立方体","直角三角形" };
		for (int i = 0; i < array.length; i++) {
			JButton but1 = new JButton(array[i]);
			this.add(but1);
			// 给事件源对象but1添加addActionListener()动作事件接口对象，指定事件处理类的对象为dl。
			but1.addActionListener(dl);
		}
		
		
		// 定义颜色数组，存储按钮上要显示的颜色信息，循环遍历数组，根据数组中的数据创建按钮对象，添加到窗体上
		Color[] color_array = { Color.black, Color.red, Color.blue, Color.green ,Color.gray, Color.yellow, Color.magenta, Color.orange, Color.pink, Color.white};
		for (int i = 0; i < color_array.length; i++) {
			JButton but = new JButton();
			but.setBackground(color_array[i]);// 设置按钮的背景颜色
			but.setPreferredSize(new Dimension(30, 30));// 设置按钮组件的大小
			this.add(but);
			// 给事件源对象but1添加addActionListener()动作事件接口对象，指定事件处理类的对象为dl。
			but.addActionListener(dl);
		}
		
		this.setDefaultCloseOperation(3);
		
		this.setVisible(true);

		dl.g = this.getGraphics();//获取画笔的时候一定要在窗体可见之后获取。
		dl.array = this.array;	// 必不可少的操作
		

		// 3.给JFrame事件源对象，添加addMouseListener()鼠标动作监听方法，指定事件处理类的对象为dl。
		this.addMouseListener(dl);

	}

}
