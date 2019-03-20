package com.basic0226_1;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Drawing extends JFrame{

	private DrawingListener dl;
	private int a,b;
	
	
	public static void main(String args[]) {
		
		Drawing drawing = new Drawing();
		
		drawing.initUI();
	}

	
	public void initUI() {
		
		//JFrame frame = new JFrame();
	
		FlowLayout flow = new FlowLayout();
		this.setLayout(flow);
		this.setTitle("画图板");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		

		dl = new DrawingListener(this);

		
		
		
		String array[] = { "矩形","填充矩形","圆形","填充圆形","直线","等腰三角形","立方体","直角三角形"};
		for (int i = 0; i < array.length; i++) {
			JButton but1 = new JButton(array[i]);
			this.add(but1);
			but1.addActionListener(dl);
		}
		
		Color color_array[] = { Color.black, Color.DARK_GRAY, Color.gray, Color.lightGray, Color.red, Color.blue, Color.green , Color.yellow, Color.magenta, Color.orange, Color.pink, Color.white,Color.CYAN};
		for (int i = 0; i < color_array.length; i++) {
			JButton but = new JButton();
			but.setBackground(color_array[i]);
			but.setPreferredSize(new Dimension(40, 40));
			this.add(but);
			but.addActionListener(dl);
		}
		
		JButton bu2 = new JButton("清除");
		bu2.setPreferredSize(new Dimension(60,40));
		this.add(bu2);
		bu2.addActionListener(dl);
		
		
		this.setDefaultCloseOperation(3);
		
		this.setVisible(true);

		dl.g = this.getGraphics();//获取画笔的时候一定要在窗体可见之后获取。
		

		// 3.给JFrame事件源对象，添加addMouseListener()鼠标动作监听方法，指定事件处理类的对象为dl。
		this.addMouseListener(dl);

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage image = dl.getImage();
		if (image != null) {
			g.drawImage(image, 0, 0, this);
		}
		
		int arrays[][] = dl.getRGBarrays();
		
		if (arrays != null) {
			for(a = 0; a <arrays.length; a++) {
				for(b = 0; b< arrays[a].length; b++) {
					Color color = new Color (arrays[a][b]);
					g.setColor(color);
					g.drawLine(a, b, a, b);
					
				}
			}
		}
		
	
	}

}
