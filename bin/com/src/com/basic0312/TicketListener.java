package com.basic0312;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JTextField;

public class TicketListener  extends Thread implements  MouseListener, ActionListener {
	
	private JTextField text;
	private String x = "";
	private boolean flag = true;
	public Random rand = new Random();
	private int a =0;
		
	public TicketListener (JTextField text) {
		this.text=text;
		
	}
	
    public void mouseClicked(MouseEvent e) {
    	if(a == 0) {
       		this.start();
        	a = 1;    		
       	} else if (a ==1) {

       		flag = false;
       		a = 2;
			//抽取结果为9时表示抽中奖
			if (x == "9") {
				
			}
    	
       	} else if (a == 2) {
       		
       		flag = true;
       		a = 1;
       	}
    	 
    }

	  public void run() {
			 while (true) {
				 if (flag) {
						x=""+rand.nextInt(10);
						text.setFont(new Font("字体",Font.PLAIN,80));
						text.setHorizontalAlignment(text.CENTER);
						text.setText(x);
						
				 }
				 try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
	  }

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Win shu = new Win();
		shu.Login();
	}

}

