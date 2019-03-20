package com.basic0319;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class DrawListener extends Thread implements  ActionListener, ChangeListener {

	private Graphics g;
	private String type = null;
	public static String image = "img/girl3.jpg";
	private int i,j;
	private int pixel;
	private int w,h;
	private int[][] ImageArray;
	public static BufferedImage bi = null;
	private JSlider slider;
	private int a = 480,b = 360;
	Picture pi = new Picture();
	private int c = 240,d = 180;
	private Picture picture ;
	private int m;
	

	public DrawListener(Graphics g,Picture picture) {
		this.g = g;
		this.picture = picture;
	
	}

	//导入原图片
    public void run1(){
    	this.getImagePixel1(image);
    }
    public int[][] getImagePixel1(String image){

    	File file = new File(image);
    	try {
			bi = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	g.drawImage(bi, c, d, a,b, null);
    	
    	return null;
    }

    
    //画出热感应图
    public void run2() {
    	this.getImagePixel(image);
    	this.Image(image);
    }
    
    public int[][] Image(String image){
    	
    	for (i = 0;i < w;i++) {
    		for (j = 0;j < h;j++) {
        		Color color = new Color(ImageArray[i][j]*m);
        		g.setColor(color);
    			g.drawRect(i, j, 1, 1);
    			
    		}

    	}
    	
		return ImageArray;
    
    }
    
    //画出模糊化图
    public void run3() {
    	this.getImagePixel(image);
    	this.Image1(image);
    }
    public void Image1(String image){
    	
    	for (i = 0;i < w;i+=3) {
    		for (j = 0;j < h;j+=3) {
        		Color color = new Color(ImageArray[i][j]);
        		g.setColor(color);
    			g.drawRect(i, j, 20, 20);
    			
    		}

    	}
    	    	
    }

    
    public void run4() {
		this.getImagePixel(image);
		this.Image2(image);
    }
    
    public void getImagePixel(String image) {
    	File file = new File(image);
		try {
			bi = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		w = bi.getWidth();
		h = bi.getHeight();
    	ImageArray = new int [w][h];
    	
    	for (i = 0;i < w;i++) {
    		for (j = 0;j < h;j++) {
    			pixel = bi.getRGB(i, j);
    			ImageArray[i][j] = pixel;
    			
    		}
    	}
    }
    
    public void Image2(String image) {
    	getImagePixel(image);

    	for (int i = 0;i < w;i+=250) {
    		for (int j = 0;j < h;j+=200) {
    			g.drawImage(bi, i, j, 250, 200, new Color(ImageArray[i][j]),null);
    		}
    	}
    	
    }
    
    
    public void run5() {
		this.getImagePixel5(image);
    }
    
    public int[][] getImagePixel5(String image){
    	File file = new File(image);
    	try {
			bi = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	for (int m = 0;m < 4;m++) {
    		g.drawImage(bi, c, d, a,b, null);
    		c = c+28; d = d+21;
    		a = a-56; b = b-42;
    	}
    	
    	
    	return null;
    }
    
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("导入图片")) {
			this.run1();
		} else if (e.getActionCommand().equals("热感应")){
			this.run2();
		} else if (e.getActionCommand().equals("模糊化")) {
			this.run3();
		} else if (e.getActionCommand().equals("流行拼接")) {
			this.run4();
		} else if (e.getActionCommand().equals("万花筒")) {
			this.run5();
		}
	}
	
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (e.equals("改变大小")) {
			JSlider source = (JSlider) e.getSource();
			e.getSource();
			a = source.getValue();
			b = (int) (source.getValue()*0.75);
			c = (960 - a)/2;
			d = (720 - b)/2;
			System.out.println("a=="+a+"  b==="+b);
		} else if (e.equals("调整参数")) {
			JSlider source = (JSlider) e.getSource();
			e.getSource();
			m = source.getValue();
		}
		
	}


}
