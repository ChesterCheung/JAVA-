package com.basic0304;

import java.util.HashMap;

public class ChessAI implements Data{

	public static HashMap <String,Integer> map = new HashMap <String,Integer>();
	static{
		map.put("212", 5);
		map.put("121", 5);
		map.put("012", 10);
		map.put("021", 10);
		map.put("010",100);
		map.put("020",100);
		map.put("0112", 1000);
		map.put("0221", 1000);
		map.put("01001", 2000);
		map.put("02002", 2000);
		map.put("01112", 3000);
		map.put("12221", 1000);
		map.put("21112", 1000);
		map.put("01112", 3000);
		map.put("02221", 3000);
		map.put("0110", 4000);
		map.put("0220", 4000);
		map.put("01010", 4000);
		map.put("02020", 4000);
		map.put("01010", 4000);
		map.put("02220", 8000);
		map.put("01110", 8000);
		map.put("022020", 8000);
		map.put("011010", 8000);
		map.put("022020", 8000);
		map.put("0202020", 8000);
		map.put("0101010", 8000);
		map.put("02020020", 4000);
		map.put("01010010", 4000);
		map.put("211112", 5000);
		map.put("122221", 5000);
		map.put("011112", 10000);
		map.put("022221", 10000);
		map.put("022220", 10000);
		map.put("011110", 10000);
				

		
	}
	//��������洢ÿһ��û�¹����ӵ�λ�õ�Ȩ��
	public int [][] weightArray = new int [Row][Colum];
	
	public ChessAI() {

		for (int c = 0,r = 0;c<arrays[r].length;c++) {
			if (arrays[r][c]==0) {//��λ��û������
				//��Ϊ�ĸ�������в���
				//ˮƽ����
				String code1 = countH(r, c);
				Integer value = map.get(code1);
				if (value!=null) {
					weightArray[r][c]+=value;
				}
				
				
				//��ֱ����
				String code2 = countV(r, c);
				value = map.get(code2);
				if (value!=null) {
					weightArray[r][c]+=value;
				}
				//�������·���
				String code3 = countX1(r, c);
				value = map.get(code3);
				if (value!=null) {
					weightArray[r][c]+=value;
				}
				//�������Ϸ���
				String code4 = countX2(r, c);
				value = map.get(code4);
				if(value!=null){
					weightArray[r][c]+=value;
				}
				
			}
		}
		return;
	}
	
	
	
	//ͳ��ˮƽ�������������������������ֵͳ�ƺ�Ľ��
	private String countH(int r,int c){
		String code = "0";//�洢�������������Ĭ�ϴ洢r,cλ�õ�����
		int chess = 0;//�洢��һ�γ������ӵı���
		int number = 0;//�洢��λ���ֵĴ���
		
		//������
		for(int c1=c-1;c1>=0;c1--){
			if(arrays[r][c1]==0){//��ʾû������
				if(c==c1+1){//����
					break;
				}else if(number==0){
					code += arrays[r][c1];//��¼�����������
					number++;
				}else if(number==1 && arrays[r][c1] == arrays[r][c1+1]){
					break;
				}else if(number==1 && arrays[r][c1] != arrays[r][c1+1]){
					code += arrays[r][c1];//��¼�����������
				}
				
			}else{//��ʾ������
				if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
					chess = arrays[r][c1];//��¼��һ�ε�������ɫ
					code += chess;//��¼�����������
				}else if(chess==arrays[r][c1]){
					code += chess;//��¼�����������
				}else{
					code += chess;//��¼�����������
					//���Բ���¼
					break;
				}
			}
		}
		//����
		for (int c1 = c+1;c1 < arrays[r].length;c1++) {
			if(arrays[r][c1]==0){//��ʾû������
				if(c==c1-1){//����
					break;
				}else if(number==0){
					code += arrays[r][c1];//��¼�����������
					number++;
				}else if(number==1 && arrays[r][c1] == arrays[r][c1-1]){
					break;
				}else if(number==1 && arrays[r][c1] != arrays[r][c1-1]){
					code += arrays[r][c1];//��¼�����������
				}
				
			}else{//��ʾ������
				if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
					chess = arrays[r][c1];//��¼��һ�ε�������ɫ
					code += chess;//��¼�����������
				}else if(chess==arrays[r][c1]){
					code += chess;//��¼�����������
				}else{
					code += chess;//��¼�����������
					//���Բ���¼
					break;
				}
			}
		}
		return code;
	}
	
	//ͳ�ƴ�ֱ�������������������������ֵͳ�ƺ�Ľ��
		private String countV(int r,int c){
			String code = "0";//�洢�������������Ĭ�ϴ洢r,cλ�õ�����
			int chess = 0;//�洢��һ�γ������ӵı���
			int number = 0;//�洢��λ���ֵĴ���
			
			//������
			for (int r1 = r-1 ;r1 > 0;r1--) {
				if(arrays[r1][c]==0){//��ʾû������
					if(r==r1+1){//����
						break;
					}else if(number==0){
						code += arrays[r1][c];//��¼�����������
						number++;
					}else if(number==1 && arrays[r1][c] == arrays[r1+1][c]){
						break;
					}else if(number==1 && arrays[r1][c] != arrays[r1+1][c]){
						code += arrays[r1][c];//��¼�����������
					}
					
				}else{//��ʾ������
					if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
						chess = arrays[r1][c];//��¼��һ�ε�������ɫ
						code += chess;//��¼�����������
					}else if(chess==arrays[r1][c]){
						code += chess;//��¼�����������
					}else{
						code += chess;//��¼�����������
						//���Բ���¼
						break;
					}
				}
			}
			//����
			for (int r1 = r+1 ;r1 < arrays.length;r1++) {
				if(arrays[r1][c]==0){//��ʾû������
					if(r==r1+1){//����
						break;
					}else if(number==0){
						code += arrays[r1][c];//��¼�����������
						number++;
					}else if(number==1 && arrays[r1][c] == arrays[r1-1][c]){
						break;
					}else if(number==1 && arrays[r1][c] != arrays[r1-1][c]){
						code += arrays[r1][c];//��¼�����������
					}
					
				}else{//��ʾ������
					if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
						chess = arrays[r1][c];//��¼��һ�ε�������ɫ
						code += chess;//��¼�����������
					}else if(chess==arrays[r1][c]){
						code += chess;//��¼�����������
					}else{
						code += chess;//��¼�����������
						//���Բ���¼
						break;
					}
				}
			}
			return code;
		}
		
		//��������
		private String countX1(int r,int c){
			String code = "0";//�洢�������������Ĭ�ϴ洢r,cλ�õ�����
			int chess = 0;//�洢��һ�γ������ӵı���
			int number = 0;//�洢��λ���ֵĴ���
			
			//������
			for (int r1 = r-1 , c1 = c-1;r1 > 0 && c1 > 0;r1--,c1--) {
				if(arrays[r1][c1]==0){//��ʾû������
					if(r==r1+1 && c == c1+1){//����
						break;
					}else if(number==0){
						code += arrays[r1][c1];//��¼�����������
						number++;
					}else if(number==1 && arrays[r1][c1] == arrays[r1+1][c1+1]){
						break;
					}else if(number==1 && arrays[r1][c1] != arrays[r1+1][c1+1]){
						code += arrays[r1][c1];//��¼�����������
					}
					
				}else{//��ʾ������
					if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
						chess = arrays[r1][c1];//��¼��һ�ε�������ɫ
						code += chess;//��¼�����������
					}else if(chess==arrays[r1][c1]){
						code += chess;//��¼�����������
					}else{
						code += chess;//��¼�����������
						//���Բ���¼
						break;
					}
				}
			}
			//������
			for (int  r1 = r+1, c1 = c+ 1; r1 < arrays.length && c1 < arrays[r].length; r1++,c1++) {
				if(arrays[r1][c1]==0){//��ʾû������
					if(r==r1+1 && c == c1+1){//����
						break;
					}else if(number==0){
						code += arrays[r1][c1];//��¼�����������
						number++;
					}else if(number==1 && arrays[r1][c1] == arrays[r1-1][c1-1]){
						break;
					}else if(number==1 && arrays[r1][c1] != arrays[r1-1][c1-1]){
						code += arrays[r1][c1];//��¼�����������
					}
					
				}else{//��ʾ������
					if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
						chess = arrays[r1][c1];//��¼��һ�ε�������ɫ
						code += chess;//��¼�����������
					}else if(chess==arrays[r1][c1]){
						code += chess;//��¼�����������
					}else{
						code += chess;//��¼�����������
						//���Բ���¼
						break;
					}
				}
			}
			return code;
		}
		
		//��������
		private String countX2(int r,int c){
			String code = "0";//�洢�������������Ĭ�ϴ洢r,cλ�õ�����
			int chess = 0;//�洢��һ�γ������ӵı���
			int number = 0;//�洢��λ���ֵĴ���
			
			//������
			for (int r1 = r-1,c1 = c+1 ;r1 > 0 && c1 < arrays[r].length; r1--,c1++) {
				if(arrays[r1][c1]==0){//��ʾû������
					if(r==r1+1 && c== c1-1){//����
						break;
					}else if(number==0){
						code += arrays[r1][c1];//��¼�����������
						number++;
					}else if(number==1 && arrays[r1][c1] == arrays[r1+1][c1-1]){
						break;
					}else if(number==1 && arrays[r1][c1] != arrays[r1+1][c1-1]){
						code += arrays[r1][c1];//��¼�����������
					}
					
				}else{//��ʾ������
					if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
						chess = arrays[r1][c1];//��¼��һ�ε�������ɫ
						code += chess;//��¼�����������
					}else if(chess==arrays[r1][c1]){
						code += chess;//��¼�����������
					}else{
						code += chess;//��¼�����������
						//���Բ���¼
						break;
					}
				}
			}
			//������
			for (int  r2 = r+1,c1 = c-1; r2 < arrays.length && c1 > 0; r2++,c1--) {
				if(arrays[r2][c1]==0){//��ʾû������
					if(r==r2+1){//����
						break;
					}else if(number==0){
						code += arrays[r2][c1];//��¼�����������
						number++;
					}else if(number==1 && arrays[r2][c1] == arrays[r2-1][c1+1]){
						break;
					}else if(number==1 && arrays[r2][c1] != arrays[r2-1][c1+1]){
						code += arrays[r2][c1];//��¼�����������
					}
					
				}else{//��ʾ������
					if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
						chess = arrays[r2][c1];//��¼��һ�ε�������ɫ
						code += chess;//��¼�����������
					}else if(chess==arrays[r2][c1]){
						code += chess;//��¼�����������
					}else{
						code += chess;//��¼�����������
						//���Բ���¼
						break;
					}
				}
			}
			return code;
		}




	
}
