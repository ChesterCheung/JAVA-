package com.basic0310;

import java.util.Arrays;
import java.util.HashMap;

public class ChessAI implements Data{

	public static HashMap <String,Integer> map = new HashMap <String,Integer>();
	static{
		
		map.put("020", 5);
		map.put("010", 5);
		map.put("02120", 20);
		map.put("01210", 20);
		map.put("0120", 50);
		map.put("0210", 50);
		map.put("01120", 1000);
		map.put("02210", 1000);
		map.put("010010", 2000);
		map.put("020020", 2000);
		map.put("0122210", 1000);
		map.put("0211120", 1000);
		map.put("011120", 3000);
		map.put("022210", 3000);
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
		map.put("02111120", 5000);
		map.put("01222210", 5000);
		map.put("0111120", 10000);
		map.put("0222210", 10000);
		map.put("022220", 10000);
		map.put("011110", 10000);
				

		
	}
	//��������洢ÿһ��û�¹����ӵ�λ�õ�Ȩ��
	public int [][] weightArray = new int [Row][Colum];
	
	public ChessAI() {
		for (int r = 0;r<arrays.length;r++) {
			for (int c = 0;c<arrays[r].length;c++) {
				if (arrays[r][c]==0) {//��λ��û������
					//��Ϊ�ĸ�������в���
					//ˮƽ����
					String code1 = countH(r, c);
					System.out.println(code1);
					Integer value = map.get(code1);
					if (value!=null) {
						weightArray[r][c] += value ;

					}
					
					//��ֱ����
					String code2 = countV(r, c);
					value = map.get(code2);
					if (value!=null) {
						weightArray[r][c]+=value;
						System.out.println(Arrays.toString(weightArray[r]));
					}
					//�������·���
					String code3 = countX1(r, c);
					value = map.get(code3);
					if (value!=null) {
						weightArray[r][c]+=value;
						System.out.println(Arrays.toString(weightArray[r]));
					}
					//�������Ϸ���
					String code4 = countX2(r, c);
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
	
	
	
	//ͳ��ˮƽ�������������������������ֵͳ�ƺ�Ľ��
	private String countH(int r,int c){
		String code = "0";//�洢�������������Ĭ�ϴ洢r,cλ�õ�����
		int chess = 0;//�洢��һ�γ������ӵı���
		int number = 0;//�洢��λ���ֵĴ���

		//������
		for(int c1=c-1;c1>=0;c1--){
			if(arrays[r][c1]==0){//��ʾû������
				if(c==c1+1){//����
					continue;
				}else if(number==0){
					code += arrays[r][c1];//��¼�����������
				//	System.out.println(code);
					number++;
					continue;
				}else if(number==1 && arrays[r][c1] == arrays[r][c1+1]) {
					System.out.println("%%%%%%%");
					break;

				}else if(number==1 && arrays[r][c1] != arrays[r][c1+1]){
					code += arrays[r][c1];//��¼�����������
					System.out.println("&&&&&&");
					continue;

				}
				
			}else{//��ʾ������
				if(chess==0){//�ж�֮ǰ�Ƿ�û�г��ֹ�����
					chess = arrays[r][c1];//��¼��һ�ε�������ɫ
					code += chess;//��¼�����������
					System.out.println("22222");
				} else if(chess==arrays[r][c1]){
					code += chess;//��¼�����������
				} else{
					code += chess;//��¼�����������
					//���Բ���¼
					break;
				}
			}
			return code;
		}
		//����
		for (int c1 = c+1;c1 < arrays[r].length;c1++) {
			if(arrays[r][c1]==0){//��ʾû������
				if(c==c1-1){//����
					continue;
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
						continue;
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
						continue;
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
						continue;
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
						continue;
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
						continue;
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
						continue;
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
