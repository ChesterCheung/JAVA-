package com.basic0309;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics;
//使用ArrayList动态数组来存储信息
import java.util.ArrayList;
import java.awt.Point;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class ChessListener extends MouseAdapter implements Data, ActionListener {

	private ChessMain chessmain;
	public Graphics g;
	private JButton but1, but2, but3;
	private JCheckBox cb;
	private JRadioButton radio1, radio2;
	private boolean flag = true;
	private boolean ai = false;
	private boolean ai2 = false;
	private String str = "人人对战";
	private ArrayList<Point> list = new ArrayList<Point>();

	// 重写ChessListener事件监听的构造方法
	public ChessListener(ChessMain chessmain, JButton but1, JButton but2, JButton but3, JRadioButton radio1,
			JRadioButton radio2, JCheckBox cb,Graphics g) {
		this.chessmain = chessmain;
		this.but1 = but1;
		this.but2 = but2;
		this.but3 = but3;
		this.radio1 = radio1;
		this.radio2 = radio2;
		this.cb = cb;
		this.g = g;

	}

	public void mouseClicked(MouseEvent e) {

		g = chessmain.getGraphics();
		int x = e.getX();
		int y = e.getY();

		if (str.equals("人人对战")) {

			if (x >= X && y >= Y && x <= X + (Colum - 1) * SIZE && y <= Y + (Row - 1) * SIZE) {
				int r = (y - Y + SIZE / 2) / SIZE;
				int c = (x - X + SIZE / 2) / SIZE;
				if (arrays[r][c] == 0) {
					x = c * SIZE + X - Chess_SIZE / 2;
					y = r * SIZE + Y - Chess_SIZE / 2;
					if (flag) {
						g.setColor(Color.BLACK);
						arrays[r][c] = 1;
					} else {
						g.setColor(Color.white);
						arrays[r][c] = 2;
					}
				}
				// 根据棋子所在位置画出棋子
				g.fillOval(x, y, Chess_SIZE, Chess_SIZE);

				list.add(new Point(r, c));// 记录棋子的行和列

				// 设置开始黑棋先下

//				//根据棋子所在位置画出棋子
//				g.fillOval(x, y, Chess_SIZE, Chess_SIZE);
				// 调用五子棋获胜的方法，判断游戏是否结束
				if (ChessWin.victory(r, c)) {
					String std = flag ? "黑棋胜利！" : "白棋胜利！";
					// showMessageDialog用于告知用户某事已经发生
					JOptionPane.showMessageDialog(chessmain, std);
					chessmain.removeMouseListener(this);
					but1.setEnabled(true);
					but2.setEnabled(false);
					but3.setEnabled(false);
					radio1.setEnabled(true);
					radio2.setEnabled(true);
					cb.setEnabled(true);
				}
				flag = !flag;
			}

		} else if (str.equals("人机对战")) {
			if (!ai&&!ai2) {
			if (x >= X && y >= Y && x <= X + (Colum - 1) * SIZE && y <= Y + (Row - 1) * SIZE) {
				
				int r = (y - Y + SIZE / 2) / SIZE;
				int c = (x - X + SIZE / 2) / SIZE;
				if (arrays[r][c] == 0) {
					x = c * SIZE + X - Chess_SIZE / 2;
					y = r * SIZE + Y - Chess_SIZE / 2;
					g.setColor(Color.white);//根据ai的值设置棋子颜色
					arrays[r][c] = 2;//根据ai的值设置棋子的值
					g.fillOval(x, y, Chess_SIZE, Chess_SIZE);
				}
				// 判断人机游戏是否结束
				if (ChessWin.victory(r, c)) {
					String std = ai ? "黑棋胜利！" : "白棋胜利！";
					JOptionPane.showMessageDialog(chessmain, std);
					chessmain.removeMouseListener(this);
					but1.setEnabled(true);
					but2.setEnabled(false);
					but3.setEnabled(false);
					radio1.setEnabled(true);
					radio2.setEnabled(true);
					cb.setEnabled(true);
					ai=!ai;
					return;//如果游戏结束，则不再运行下面的代码
				}
				for(r=0;r<arrays.length;r++) {
					for(c=0;c<arrays[r].length;c++) {
						System.out.print(arrays[r][c]);}
					System.out.println();}
				
				// 实例化AI算法对象
				ChessAI chessai = new ChessAI();
				// 遍历棋盘每个位置，比较找出出权重最大的位置
				int AIx = 0,AIy = 0;
				int weightmax = 0;
				for (int d = 0; d < chessai.weightArray.length; d++) {
					for (int f = 0; f < chessai.weightArray[d].length; f++) {
						//找最大权值所在的行和列，存储起来
						if (chessai.weightArray[d][f] >= weightmax) {
							AIx = d;
							AIy = f;
							weightmax = chessai.weightArray[d][f];

						}
					}
				}
				//随机获取
					//根据行和列计算坐标值
					x = AIx * SIZE + X - Chess_SIZE / 2;
					y = AIy * SIZE + Y - Chess_SIZE / 2;
					
					// 在权重最大的位置画出所下的棋子
					g.setColor(Color.black);
					g.fillOval(x, y, Chess_SIZE, Chess_SIZE);
					
					//存储棋子
					arrays[AIx][AIy] = 1;
				
				//判断输赢
				if (ChessWin.victory(AIx, AIy)) {
					String std = ai ? "白棋胜利！" : "黑棋胜利！";
					JOptionPane.showMessageDialog(chessmain, std);
					chessmain.removeMouseListener(this);
					//把存放权值的数组清空
					for(int d=0;d<chessai.weightArray.length;d++) {
						for(int f=0;f<chessai.weightArray[d].length;f++) {
							chessai.weightArray[d][f]=0;
						}
					}
				
				
				}
				
			}
			}else if (ai2){
				if (x >= X && y >= Y && x <= X + (Colum - 1) * SIZE && y <= Y + (Row - 1) * SIZE) {
					
					int r = (y - Y + SIZE / 2) / SIZE;
					int c = (x - X + SIZE / 2) / SIZE;
					if (arrays[r][c] == 0) {
						x = c * SIZE + X - Chess_SIZE / 2;
						y = r * SIZE + Y - Chess_SIZE / 2;
						g.setColor(Color.white);//根据ai的值设置棋子颜色
						arrays[r][c] = 2;//根据ai的值设置棋子的值
						g.fillOval(x, y, Chess_SIZE, Chess_SIZE);
					}
					// 判断人机游戏是否结束
					if (ChessWin.victory(r, c)) {
						String std = ai ? "黑棋胜利！" : "白棋胜利！";
						JOptionPane.showMessageDialog(chessmain, std);
						chessmain.removeMouseListener(this);
						but1.setEnabled(true);
						but2.setEnabled(false);
						but3.setEnabled(false);
						radio1.setEnabled(true);
						radio2.setEnabled(true);
						cb.setEnabled(true);
						return;//如果游戏结束，则不再运行下面的代码
					}
					
					// 实例化AI算法对象
					ChessAI chessai = new ChessAI();
					// 遍历棋盘每个位置，比较找出出权重最大的位置
					int AIx = 0,AIy = 0;
					int weightmax = 0;
					for (int d = 0; d < chessai.weightArray.length; d++) {
						for (int f = 0; f < chessai.weightArray[d].length; f++) {
							//找最大权值所在的行和列，存储起来
							if (chessai.weightArray[d][f] >= weightmax) {
								AIx = d;
								AIy = f;
								weightmax = chessai.weightArray[d][f];

							}
						}
					}
					//随机获取
						//根据行和列计算坐标值
						x = AIx * SIZE + X - Chess_SIZE / 2;
						y = AIy * SIZE + Y - Chess_SIZE / 2;
						
						// 在权重最大的位置画出所下的棋子
						g.setColor(Color.black);
						g.fillOval(x, y, Chess_SIZE, Chess_SIZE);
						
						//存储棋子
						arrays[AIx][AIy] = 1;
					
					//判断输赢
					if (ChessWin.victory(AIx, AIy)) {
						String std = ai ? "白棋胜利！" : "黑棋胜利！";
						JOptionPane.showMessageDialog(chessmain, std);
						chessmain.removeMouseListener(this);
						//把存放权值的数组清空
						for(int d=0;d<chessai.weightArray.length;d++) {
							for(int f=0;f<chessai.weightArray[d].length;f++) {
								chessai.weightArray[d][f]=0;
							}
						}
					
					
					}
					
				}			}
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		String ch = e.getActionCommand();
		if (ch.equals("开始游戏")) {
			but1.setEnabled(false);
			but2.setEnabled(true);
			but3.setEnabled(true);
			radio1.setEnabled(false);
			radio2.setEnabled(false);
			cb.setEnabled(false);

			chessmain.addMouseListener(this);

			// 用来清空数组的存储
			for (int r = 0; r < arrays.length; r++) {
				for (int c = 0; c < arrays[r].length; c++) {
					arrays[r][c] = 0;
				}
			}
			// 把下棋面板进行重绘
			chessmain.repaint();
			// 将棋子的标志位归位到黑棋
			flag = true;
			
			//判断ai的值，如果是机器先手，则此处下第一颗棋子(黑棋)

			if (ai == true) {

				int a = 7 * SIZE + X - Chess_SIZE / 2;
				int b = 7 * SIZE + Y - Chess_SIZE / 2;
				g.setColor(Color.BLACK);//根据ai的值设置棋子颜色
				
				arrays[7][7] = 1;
				g.fillOval(a, b, Chess_SIZE, Chess_SIZE);
				ai =!ai;
			} 
		} else if (ch.equals("悔棋")) {

			if (str.equals("人人对战")) {
				if (list.size() > 2) {
					Point point = list.remove(list.size() - 1);
					arrays[point.x][point.y] = 0;
					flag = !flag;
					chessmain.repaint();
					
				}
			} else {

			}

		} else if (ch.equals("认输")) {

			if (str.equals("人人对战")) {
				String msg = flag ? "黑棋认输，白棋胜利！" : "白棋认输，黑棋胜利！";
				JOptionPane.showMessageDialog(chessmain, msg);
				// 移除下棋面板上的鼠标事件监听方法和事件处理类
				chessmain.removeMouseListener(this);

				but1.setEnabled(true);
				but2.setEnabled(false);
				but3.setEnabled(false);
				radio1.setEnabled(true);
				radio2.setEnabled(true);
				cb.setEnabled(ai ? true : false);
			} else if (str.equals("人机对战")) {
				if (!ai) {
					String str1 = "黑棋认输，白棋胜利！";
					JOptionPane.showMessageDialog(chessmain, str1);
				} else {
					String str2 = "白棋认输，黑棋胜利！";
					JOptionPane.showMessageDialog(chessmain, str2);

				}
				but1.setEnabled(true);
				but2.setEnabled(false);
				but3.setEnabled(false);
				radio1.setEnabled(true);
				radio2.setEnabled(true);
				cb.setEnabled(ai ? true : false);
				ai =! ai;
			}

		} else if (ch.equals("人人对战")) {

			cb.setEnabled(false);
			str = ch;
		} else if (ch.equals("人机对战")) {

			cb.setEnabled(true);
			str = ch;
			ai2 =!ai2;
		} else if (ch.equals("AI先下")) {

			radio1.setEnabled(false);
			cb.setEnabled(true);
			ai = !ai;
			ai2 = false;
		}
	}
}
