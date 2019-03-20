package com.basic0318;

import java.awt.Color;
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


public class DrawListener extends Thread implements  ActionListener {

	private JFrame frame;
	private Graphics g;
	private String type = null;
	private String image = "img/girl3.jpg";
	private int i,j;
	private int pixel;
	private int pp;
	private int w,h;
	private int[][] ImageArray;
	private BufferedImage bi = null;

	public DrawListener(Graphics g,JFrame frame) {
		this.g = g;
		this.frame = frame;
	
	}

	//����ԭͼƬ
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
    	g.drawImage(bi, 0, 0, 960,720, null);

    	return null;
    }

    //�����ȸ�Ӧͼ
    public void run2() {
    	this.getImagePixel(image);
    	this.Image(image);
    }
    public int[][] Image(String image){
    	
    	for (i = 0;i < w;i++) {
    		for (j = 0;j < h;j++) {
        		Color color = new Color(ImageArray[i][j]*99/100);
        		g.setColor(color);
    			g.drawRect(i, j, 1, 1);
    			
    		}

    	}
    	
		return ImageArray;
    	
    
    }
    
    //����ģ����ͼ
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
    
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("����ͼƬ")) {
			this.run1();
		} else if (e.getActionCommand().equals("�ȸ�Ӧ")){
			this.run2();
		} else if (e.getActionCommand().equals("ģ����")) {
			this.run3();
		} else if (e.getActionCommand().equals("����ƴ��")) {
			this.run4();
		}
		
	}


}
