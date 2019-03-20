package com.basic0215;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Data {
	
	public int x1,y1,x2,y2,width,height;
	public String type;
	public Color color;
	public Graphics g;
	public ImageIcon icon;
	
	public Data(int x1,int y1,int x2,int y2,Color color,String type) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.type = type;
		
	}	
	
	//������Ҫ���з������أ����Ƴ�����ͼ�ε��ػ�
	
//	public Data(int x1,int y1,int width,int height, Color color, String type, ImageIcon icon) {
//		
//		this.x1 = x1;
//		this.y1 = y1;
//		this.x2 = x2;
//		this.y2 = y2;
//		this.color = color;
//		this.width = width;
//		this.height = height;
//		this.type = type;
//		this.icon = icon;
//		
//	}	


	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		if (type.equals("����"))
			g.fillRect(x1, y1, x2 - x1, y2 - y1);
		else if (type.equals("Բ��"))
			g.drawOval(x1, y1, x2 - x1, y2 - y1);
		else if (type.equals("ֱ��"))
			g.drawLine(x1, y1, x2, y2);
		else if (type.equals("����������")) {
			g.drawLine(x1, y2, x2, y2);
			g.drawLine((x1+x2)/2, y1, x1, y2);
			g.drawLine((x1+x2)/2, y1, x2, y2);
		}
		else if (type.equals("������")) {
			g.fillRect(x1, y1, x2 - x1, y2 - y1);
			g.drawLine(x2, y1, x2+9, y1-9);
			g.drawLine(9+x1, y1-9, x2+9, y1-9);
			g.drawLine(9+x1, y1-9, x1, y1);
			g.drawLine(x2+9, y2-9, x2+9, y1-9);
			g.drawLine(x2+9, y2-9, x2,y2);
		}
		else if (type.equals("ֱ��������")) {
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x1, y2, x2, y2);
			g.drawLine(x1, y2, x1, y1);
		}
	}




}
