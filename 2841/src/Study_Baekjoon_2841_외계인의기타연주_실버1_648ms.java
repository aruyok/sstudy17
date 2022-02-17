package study;
import java.util.*;
import java.io.*;

public class Study_Baekjoon_2841_�ܰ����Ǳ�Ÿ����_�ǹ�1_648ms {
	/**
	 * 
	 * 6���� ���� �����Ƿ�, 6�� ���� ����
	 * peek : ������ ���� ���� �� , prat : �Է°� 
	 * peek > prat : prat ���� �۰ų� ���� ���� ���ö� ���� pop �ݺ� , count ++ �ϸ鼭 
	 * peek < prat : prat �� �װ�, count ++
	 * peek = prat : �ƹ��� ���� �� �ʿ� x 
	 * ������ ��������� prat �� �װ�  , count ++ 
	 * 	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		Stack<Integer>[] stack = new Stack[7]; 
		for(int i=0; i<7; i++) {
			stack[i]=new Stack<>();
		}
		
		
		st= new StringTokenizer(br.readLine(), " ");
		int N=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		int count=0;
		
		while(N-->0) {

			st= new StringTokenizer(br.readLine(), " ");
			int number=Integer.parseInt(st.nextToken());
			int prat= Integer.parseInt(st.nextToken());
			
//			while(!stack[number].isEmpty() & stack[number].peek()>prat  ) { //  ������ ����ִ���, '&'�̰��̱� ������ �˻縦 �Ѵ� �ؾ��ϹǷ�, peek()���� ���ܹ߻�
			while(!stack[number].isEmpty() && stack[number].peek()>prat  ) {
				
				stack[number].pop();
				count++;
			}
			if(stack[number].isEmpty() || (!stack[number].isEmpty()&&stack[number].peek() <prat)) {
				stack[number].push(prat);
				count++;
			}
			
			
			
		}// end of while
		
		System.out.println(count);
		
		
		
	}
}
