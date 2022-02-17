package study;
import java.util.*;
import java.io.*;

public class Study_Baekjoon_13335_Ʈ��_�ǹ�1_������_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st= new StringTokenizer(br.readLine(), " ");
		int n= Integer.parseInt(st.nextToken()); // �ٸ��� �ǳʴ� Ʈ���Ǽ� 
		int w= Integer.parseInt(st.nextToken()); // �ٸ��� ���� ( �ٸ��� �ö� �� �ִ� Ʈ������ ) 
		int L= Integer.parseInt(st.nextToken()); // �ٸ��� �ִ����� 
		
		Queue <Integer > truck = new LinkedList<>(); 
		Queue <Integer> bridge = new LinkedList<>();
		
		st= new StringTokenizer(br.readLine(), " "); // n���� Ʈ�� �� 
		for(int i=0; i<n; i++) 
			truck.add(Integer.parseInt(st.nextToken()));
		
		bridge.add(truck.poll());
		int sumWeight = bridge.peek(); 
	
		int time =1;  // �� �ҿ�ð� 
		
		                                                                                                   
		while(!truck.isEmpty()) {
			
			// Ʈ���� �ٸ��� �ø� �� �ִ� ��Ȳ 
			if( bridge.size() < w && sumWeight+truck.peek() <= L ) { 
				bridge.add(truck.peek());
				sumWeight+=truck.poll(); 

			}
			else { // ���� �� ������  
				bridge.add(0);
	
			} time++;
			if(bridge.size()==2) {
				sumWeight-=bridge.peek();
				if(bridge.poll()!=0) time++;

				
			}
			
			
		} // end of while 
		
		
		
		System.out.println(time);

		/**
		 * Ʈ���� ���ؼ� ( �ٸ��� �ӹ� �ð�, Ʈ���� ���� ) �� ����  ( ��ü�� ? ) 
		 * �ٸ����� �ö� Ʈ���� �� + ���� �ö� Ʈ�� �� <= L �̰�
		 * ť�� �ִ� Ʈ������ �ٸ��� �ӹ� �ð� + 1 < w �̸� �ö� �� ���� 
		 * Ʈ�� ( �ٸ��� �ӹ� �ð� ) �� w �� �Ǹ� ť���� ���� 
		 */
		
		
		// ť�� ���԰��� ���� 
		// w �� ������ ť���� �ڵ����� 
	}
}
