package com.basic0316_3;

import java.util.Arrays;
import java.util.HashMap;

public class ChessAI implements Data{

	public static HashMap <String,Integer> map = new HashMap <String,Integer>();
	static{
		
		map.put("00200", 5);
		map.put("00100", 5);
		map.put("0021200", 20);
		map.put("0012100", 20);
		map.put("001200", 50);
		map.put("002100", 50);
		map.put("0011200", 1000);
		map.put("0022100", 1000);
		map.put("00100100", 2000);
		map.put("00200200", 2000);
		map.put("001222100", 1000);
		map.put("002111200", 1000);
		map.put("00111200", 3000);
		map.put("00222100", 3000);
		map.put("001100", 4000);
		map.put("002200", 4000);
		map.put("0010100", 4000);
		map.put("0020200", 4000);
		map.put("0010100", 4000);
		map.put("0022200", 8000);
		map.put("0011100", 8000);
		map.put("00220200", 8000);
		map.put("00110100", 8000);
		map.put("00220200", 8000);
		map.put("002020200", 8000);
		map.put("001010100", 8000);
		map.put("0020200200", 4000);
		map.put("0010100100", 4000);
		map.put("0021111200", 5000);
		map.put("0012222100", 5000);
		map.put("001111200", 10000);
		map.put("002222100", 10000);
		map.put("00222200", 10000);
		map.put("00111100", 10000);
				
		
	}
	
	//定义数组存储每一个没下过棋子的位置的权重
	public int [][] weightArray = new int [Row][Colum];
	
	public ChessAI() {
		for (int r = 0;r<arrays.length;r++) {
			for (int c = 0;c<arrays[r].length;c++) {
				if (arrays[r][c]==0) {//此位置没有棋子
					//分为四个方向进行查找
					//水平方向
					String code1 = countH(r, c);
					System.out.println(code1);
					Integer value = map.get(code1);
					if (value!=null) {
						weightArray[r][c] += value ;

					}
					
					//垂直方向
					String code2 = countV(r, c);
					System.out.println(code2);
					value = map.get(code2);
					if (value!=null) {
						weightArray[r][c]+=value;
						System.out.println(Arrays.toString(weightArray[r]));
					}
					//左上右下方向
					String code3 = countX1(r, c);
					System.out.println(code3);
					value = map.get(code3);
					if (value!=null) {
						weightArray[r][c]+=value;
						System.out.println(Arrays.toString(weightArray[r]));
					}
					//左下右上方向
					String code4 = countX2(r, c);
					System.out.println(code4);
					value = map.get(code4);
					if(value!=null){
						weightArray[r][c]+=value;
						System.out.println(Arrays.toString(weightArray[r]));
					}
					
				}
				
			}
		}
		
		for (int r = 0;r< arrays.length;r++) {
			System.out.println(Arrays.toString(weightArray[r]));
		}
	}
	
		
	//统计水平方向上棋子相连的情况，返回值统计后的结果
	private String countH(int r,int c){
		String code = "0";//存储棋子相连情况，默认存储r,c位置的内容
		int chess = 0;//存储第一次出现棋子的变量
		int number = 0;//存储空位出现的次数

		//往左找
		for(int c1=c-1;c1>=0;c1--){
			if(arrays[r][c1]==0){//表示没有棋子
				if(c==c1+1){//相邻
					continue;
				}else if(number==0){
					code += arrays[r][c1];//记录棋子相连情况
				//	System.out.println(code);
					number++;
					continue;
				}else if(number==1 && arrays[r][c1] == arrays[r][c1+1]) {
					if (arrays[r][c1] == 0) {
						code += arrays[r][c1];
						break;
					}
					else { 
						code += arrays[r][c1];
						continue;
					}

				}else if(number==1 && arrays[r][c1] != arrays[r][c1+1]){
					code += arrays[r][c1];//记录棋子相连情况
					System.out.println("&&&&&&");
					continue;
				}
				
			}else{//表示有棋子
				if(chess==0){//判断之前是否没有出现过棋子
					chess = arrays[r][c1];//记录第一次的棋子颜色
					code += chess;//记录棋子相连情况
					System.out.println("!!!");
				} else if(chess==arrays[r][c1]){
					code += chess;//记录棋子相连情况
				} else{
					code += chess;//记录棋子相连情况
					//可以不记录
					break;
				}
			}
			return code;
		}
		//往右
		for (int c1 = c+1;c1 < arrays[r].length;c1++) {
			if(arrays[r][c1]==0){//表示没有棋子
				if(c==c1-1){//相邻
					continue;
				}else if(number==0){
					code += arrays[r][c1];//记录棋子相连情况
					number++;
				}else if(number==1 && arrays[r][c1] == arrays[r][c1-1]){
					if (arrays[r][c1] == 0) {
						code += arrays[r][c1];
						break;
					}
					else {
						code += arrays[r][c1];
						continue;
					}
				}else if(number==1 && arrays[r][c1] != arrays[r][c1-1]){
					code += arrays[r][c1];//记录棋子相连情况
					continue;
				}
				
			}else{//表示有棋子
				if(chess==0){//判断之前是否没有出现过棋子
					chess = arrays[r][c1];//记录第一次的棋子颜色
					code += chess;//记录棋子相连情况
				}else if(chess==arrays[r][c1]){
					code += chess;//记录棋子相连情况
				}else{
					code += chess;//记录棋子相连情况
					//可以不记录
					break;
				}
			}
		}
		return code;
	}
	
	//统计垂直方向上棋子相连的情况，返回值统计后的结果
		private String countV(int r,int c){
			String code = "0";//存储棋子相连情况，默认存储r,c位置的内容
			int chess = 0;//存储第一次出现棋子的变量
			int number = 0;//存储空位出现的次数
			
			//往上找
			for (int r1 = r-1 ;r1 > 0;r1--) {
				if(arrays[r1][c]==0){//表示没有棋子
					if(r==r1+1){//相邻
						continue;
					}else if(number==0){
						code += arrays[r1][c];//记录棋子相连情况
						number++;
					}else if(number==1 && arrays[r1][c] == arrays[r1+1][c]){
						if (arrays[r1][c] == 0) {
							code += arrays[r1][c];
							break;
						}
						else {
							code += arrays[r1][c];
							continue;
						}
					}else if(number==1 && arrays[r1][c] != arrays[r1+1][c]){
						code += arrays[r1][c];//记录棋子相连情况
						continue;
					}
					
				}else{//表示有棋子
					if(chess==0){//判断之前是否没有出现过棋子
						chess = arrays[r1][c];//记录第一次的棋子颜色
						code += chess;//记录棋子相连情况
					}else if(chess==arrays[r1][c]){
						code += chess;//记录棋子相连情况
					}else{
						code += chess;//记录棋子相连情况
						//可以不记录
						break;
					}
				}
			}
			//往下
			for (int r1 = r+1 ;r1 < arrays.length;r1++) {
				if(arrays[r1][c]==0){//表示没有棋子
					if(r==r1+1){//相邻
						continue;
					}else if(number==0){
						code += arrays[r1][c];//记录棋子相连情况
						number++;
					}else if(number==1 && arrays[r1][c] == arrays[r1-1][c]){
						if (arrays[r1][c] == 0) {
							code += arrays[r1][c];
							break;
						}
						else {
							code += arrays[r1][c];
							continue;
						}
					}else if(number==1 && arrays[r1][c] != arrays[r1-1][c]){
						code += arrays[r1][c];//记录棋子相连情况
						continue;
					}
					
				}else{//表示有棋子
					if(chess==0){//判断之前是否没有出现过棋子
						chess = arrays[r1][c];//记录第一次的棋子颜色
						code += chess;//记录棋子相连情况
					}else if(chess==arrays[r1][c]){
						code += chess;//记录棋子相连情况
					}else{
						code += chess;//记录棋子相连情况
						//可以不记录
						break;
					}
				}
			}
			return code;
		}
		
		//左上右下
		private String countX1(int r,int c){
			String code = "0";//存储棋子相连情况，默认存储r,c位置的内容
			int chess = 0;//存储第一次出现棋子的变量
			int number = 0;//存储空位出现的次数
			
			//往上找
			for (int r1 = r-1 , c1 = c-1;r1 > 0 && c1 > 0;r1--,c1--) {
				if(arrays[r1][c1]==0){//表示没有棋子
					if(r==r1+1 && c == c1+1){//相邻
						continue;
					}else if(number==0){
						code += arrays[r1][c1];//记录棋子相连情况
						number++;
					}else if(number==1 && arrays[r1][c1] == arrays[r1+1][c1+1]){
						if (arrays[r1][c1] == 0) {
							code += arrays[r1][c1];
							break;
						}
						else {
							code += arrays[r1][c1];
							continue;
						}
					}else if(number==1 && arrays[r1][c1] != arrays[r1+1][c1+1]){
						code += arrays[r1][c1];//记录棋子相连情况
						continue;
					}
					
				}else{//表示有棋子
					if(chess==0){//判断之前是否没有出现过棋子
						chess = arrays[r1][c1];//记录第一次的棋子颜色
						code += chess;//记录棋子相连情况
					}else if(chess==arrays[r1][c1]){
						code += chess;//记录棋子相连情况
					}else{
						code += chess;//记录棋子相连情况
						//可以不记录
						break;
					}
				}
			}
			//往下找
			for (int  r1 = r+1, c1 = c+ 1; r1 < arrays.length && c1 < arrays[r].length; r1++,c1++) {
				if(arrays[r1][c1]==0){//表示没有棋子
					if(r==r1+1 && c == c1+1){//相邻
						continue;
					}else if(number==0){
						code += arrays[r1][c1];//记录棋子相连情况
						number++;
					}else if(number==1 && arrays[r1][c1] == arrays[r1-1][c1-1]){
						if (arrays[r1][c1] == 0) {
							code += arrays[r1][c1];
							break;
						}
						else {
							code += arrays[r1][c1];
							continue;
						}
					}else if(number==1 && arrays[r1][c1] != arrays[r1-1][c1-1]){
						code += arrays[r1][c1];//记录棋子相连情况
						continue;
					}
					
				}else{//表示有棋子
					if(chess==0){//判断之前是否没有出现过棋子
						chess = arrays[r1][c1];//记录第一次的棋子颜色
						code += chess;//记录棋子相连情况
					}else if(chess==arrays[r1][c1]){
						code += chess;//记录棋子相连情况
					}else{
						code += chess;//记录棋子相连情况
						//可以不记录
						break;
					}
				}
			}
			return code;
		}
		
		//左下右上
		private String countX2(int r,int c){
			String code = "0";//存储棋子相连情况，默认存储r,c位置的内容
			int chess = 0;//存储第一次出现棋子的变量
			int number = 0;//存储空位出现的次数
			
			//往下找
			for (int r1 = r-1,c1 = c+1 ;r1 > 0 && c1 < arrays[r].length; r1--,c1++) {
				if(arrays[r1][c1]==0){//表示没有棋子
					if(r==r1+1 && c== c1-1){//相邻
						continue;
					}else if(number==0){
						code += arrays[r1][c1];//记录棋子相连情况
						number++;
					}else if(number==1 && arrays[r1][c1] == arrays[r1+1][c1-1]){
						if (arrays[r1][c1] == 0) {
							code += arrays[r1][c1];
							break;
						}
						else {
							code += arrays[r1][c1];
							continue;
						}
					}else if(number==1 && arrays[r1][c1] != arrays[r1+1][c1-1]){
						code += arrays[r1][c1];//记录棋子相连情况
						continue;
					}
					
				}else{//表示有棋子
					if(chess==0){//判断之前是否没有出现过棋子
						chess = arrays[r1][c1];//记录第一次的棋子颜色
						code += chess;//记录棋子相连情况
					}else if(chess==arrays[r1][c1]){
						code += chess;//记录棋子相连情况
					}else{
						code += chess;//记录棋子相连情况
						//可以不记录
						break;
					}
				}
			}
			//往上找
			for (int  r2 = r+1,c1 = c-1; r2 < arrays.length && c1 > 0; r2++,c1--) {
				if(arrays[r2][c1]==0){//表示没有棋子
					if(r==r2+1){//相邻
						continue;
					}else if(number==0){
						code += arrays[r2][c1];//记录棋子相连情况
						number++;
					}else if(number==1 && arrays[r2][c1] == arrays[r2-1][c1+1]){
						if (arrays[r2][c1] == 0) {
							code += arrays[r2][c1];
							break;
						}
						else {
							code += arrays[r2][c1];
							continue;
						}
					}else if(number==1 && arrays[r2][c1] != arrays[r2-1][c1+1]){
						code += arrays[r2][c1];//记录棋子相连情况
						continue;
					}
					
				}else{//表示有棋子
					if(chess==0){//判断之前是否没有出现过棋子
						chess = arrays[r2][c1];//记录第一次的棋子颜色
						code += chess;//记录棋子相连情况
					}else if(chess==arrays[r2][c1]){
						code += chess;//记录棋子相连情况
					}else{
						code += chess;//记录棋子相连情况
						//可以不记录
						break;
					}
				}
			}
			return code;
		}




	
}
