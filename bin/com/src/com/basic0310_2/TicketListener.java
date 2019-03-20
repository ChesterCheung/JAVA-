package com.basic0310_2;


import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JTextField;

public class TicketListener  extends Thread implements  MouseListener {
	
	private JTextField text;
	private String x = "";
	private boolean flag = true;
	private boolean flag2 = false;
	public Random rand = new Random();
	private int a =0;
		
	public TicketListener (JTextField text) {
		this.text=text;

	}
	
    public void mouseClicked(MouseEvent e) {
    	if(flag) {
    		if (a == 0) {
        		this.start();
        		a++;
    		}
    		flag = !flag;
    		flag2 = !flag2;
    		System.out.println("flag is <>"+flag);
    		System.out.println("flag2 is <>"+flag2);

//    	}else 
    	} else {
    		this.interrupted();
			flag= !flag;
			flag2 = !flag2;
    		System.out.println("flag is <>"+flag);
    		System.out.println("flag2 is <>"+flag2);
    	}
    	 
    }

	  public void run() {
			 while (flag2) {
						x="           "+rand.nextInt(10);
						text.setFont(new Font("×ÖÌå",Font.PLAIN,25));
						text.setText(x);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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

}

