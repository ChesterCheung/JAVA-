package com.basic0302;

public class ChessWin implements Data {

	public static boolean victory(int r, int c) {
		if (countH(r,c) >= 5 || countV(r,c) >= 5 || countX1(r,c) >= 5 || countX2(r,c) >=5) 
			return true ;
		else 
			return false;
		
	}
	
	private  static int  countH(int r,int c) {
		int num = 1;
		//往左
		for (int c1 = c-1 ;c1 > 0;c1--) {
			if (arrays[r][c] == arrays[r][c1])
				num++;
			else 
				break;			
		}

		//往右
		for (int c1 = c+1;c1 < arrays[r].length;c1++) {
			if (arrays[r][c] == arrays[r][c1])
				num++;
			else 
				break;
		}
		return num;

	}
	private static int countV(int r,int c) {
		int num = 1;
		//往上
		for (int r1 = r-1 ;r1 > 0;r1--) {
			if (arrays[r][c] == arrays[r1][c])
				num++;
			else 
				break;
		}
			
		

		//往下
		for (int r1 = r+1;r1 < arrays.length;r1++) {
			if (arrays[r][c] == arrays[r1][c])
				num++;
			else 
				break;
		}
		return num;
		
	}
	//左上右下
	private static int countX1(int r,int c) {
		int num = 1;
		//往上
		for (int r1 = r-1 , c1 = c-1;r1 > 0 && c1 > 0;r1--,c1--) {
			if (arrays[r][c] == arrays[r1][c1])
				num++;
			else 
				break;			
		}

		//往下
		for (int  r1 = r+1, c1 = c+ 1; r1 < arrays.length && c1 < arrays[r].length; r1++,c1++) {
			
			if (arrays[r][c] == arrays[ r1][c1])
				num++;
			else 
				break;
		}
		return num;
		
	}
	
	
	//左下右上
	private static int countX2(int r,int c) {
		int num = 1;
		//往下
		for (int r1 = r-1,c1 = c+1 ;r1 > 0 && c1 < arrays[r].length; r1--,c1++) {
			if (arrays[r][c] == arrays[r1][c1])
				num++;
			else 
				break;
		}

		//往上
		for (int  r2 = r+1,c1 = c-1; r2 < arrays.length && c1 > 0; r2++,c1--) {
			if (arrays[r][c] == arrays[r2][c1])
				num++;
			else 
				break;
		}
		return num;
		
	}
	
}
