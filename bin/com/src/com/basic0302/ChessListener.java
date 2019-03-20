package com.basic0302;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
//ʹ��ArrayList��̬�������洢��Ϣ
import java.util.ArrayList;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class ChessListener extends MouseAdapter implements Data , ActionListener {

	private ChessMain chessmain;
	public  Graphics g;
	private JButton but1,but2,but3;
	private JCheckBox cb;
	private JRadioButton radio1,radio2;
	private boolean flag = true;
	private boolean ai = false;
	private String str = "���˶�ս";
	private ArrayList<Point> list = new ArrayList<Point>();
	
	//ʵ����ChessListener�¼���������
	public  ChessListener(ChessMain chessmain, JButton but1, JButton but2, JButton but3, 
			JRadioButton radio1, JRadioButton radio2, JCheckBox cb) {
		this.chessmain = chessmain;
		this.but1 = but1;
		this.but2 = but2;
		this.but3 = but3;
		this.radio1 = radio1;
		this.radio2 = radio2;
		this.cb = cb;
		
	}
	

	public void mouseClicked(MouseEvent e) {
		g = chessmain.getGraphics();
		int x = e.getX();
		int y = e.getY();
		
		if (str.equals("���˶�ս")) {
			
			if (x >= X && y >= Y && x <= X + (Colum -1) * SIZE && y <= Y + (Row -1) * SIZE) {
				int r = (y - Y + SIZE / 2) / SIZE;
				int c = (x - X + SIZE / 2) / SIZE;
				if (arrays[r][c] == 0) {
					x = c * SIZE + X - Chess_SIZE /2;
					y = r * SIZE + Y - Chess_SIZE /2;
					if (flag) {
						g.setColor(Color.BLACK);
						arrays[r][c] = 1;
					} else {
						g.setColor(Color.white);
						arrays[r][c] = 2;
					}
					g.fillOval(x, y, Chess_SIZE, Chess_SIZE);
					
					list.add(new Point(r, c));//��¼���ӵ��к���
					
					if (ChessWin.victory(r, c)) {
						String std = flag ?"����ʤ����":"����ʤ����";
						//showMessageDialog���ڸ�֪�û�ĳ���Ѿ�����
						JOptionPane.showMessageDialog(chessmain, std);
						chessmain.removeMouseListener(this);
						but1.setEnabled(true);
						but2.setEnabled(false);
						but3.setEnabled(false);
						radio1.setEnabled(true);
						radio2.setEnabled(true);
						cb.setEnabled(true);
					}
					flag =! flag;
				}
				
			}
		}
		else {
			JOptionPane.showMessageDialog(chessmain, "�˻���ս��δʵ�֣����Ժ�......");
			chessmain.removeMouseListener(this);
			but1.setEnabled(true);
			but2.setEnabled(false);
			but3.setEnabled(false);
			radio1.setEnabled(true);
			radio2.setEnabled(true);
			cb.setEnabled(true);
		}
	}


	public void actionPerformed(ActionEvent e) {
		String ch = e.getActionCommand();
		if (ch.equals("��ʼ��Ϸ")) {
			but1.setEnabled(false);
			but2.setEnabled(true);
			but3.setEnabled(true);
			radio1.setEnabled(false);
			radio2.setEnabled(false);
			cb.setEnabled(false);
			
			chessmain.addMouseListener(this);
			
			//�����������Ĵ洢
			for (int r = 0; r < arrays.length;r++) {
				for (int c = 0; c < arrays[r].length; c++) {
					arrays[r][c] = 0;
				}
			}
			//�������������ػ�
			chessmain.repaint();
			//�����ӵı�־λ��λ������
			flag = true;
			
			
			
		} else if (ch.equals("����")) {

			if (str.equals("���˶�ս")) {
				if (list.size() > 2) {
					Point point = list.remove(list.size()-1);
					arrays[point.x][point.y] = 0;
					flag = ! flag;
					chessmain.repaint();
				}
			} else {
				
			}
			
		} else if (ch.equals("����")) {
			
			if (str.equals("���˶�ս")) {
				String msg = flag ?"�������䣬����ʤ����":"�������䣬����ʤ����";
				JOptionPane.showMessageDialog(chessmain,msg);
				//�Ƴ���������ϵ�����¼������������¼�������
				chessmain.removeMouseListener(this);
				
				but1.setEnabled(true);
				but2.setEnabled(false);
				but3.setEnabled(false);
				radio1.setEnabled(true);
				radio2.setEnabled(true);
				cb.setEnabled(ai ? true : false);
			} else {
				
			}
			
		} else if (ch.equals("���˶�ս")) {

			cb.setEnabled(false);
			str = ch;
		} else if (ch.equals("�˻���ս")) {

			cb.setEnabled(true);
			str = ch;
		} else if (ch.equals("AI����")) {

			radio1.setEnabled(false);
			cb.setEnabled(true);
			ai =! ai;
		}
	}
}
