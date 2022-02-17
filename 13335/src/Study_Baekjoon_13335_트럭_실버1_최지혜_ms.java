package study;
import java.util.*;
import java.io.*;

public class Study_Baekjoon_13335_트럭_실버1_최지혜_ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st= new StringTokenizer(br.readLine(), " ");
		int n= Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭의수 
		int w= Integer.parseInt(st.nextToken()); // 다리의 길이 ( 다리에 올라갈 수 있는 트럭갯수 ) 
		int L= Integer.parseInt(st.nextToken()); // 다리의 최대하중 
		
		Queue <Integer > truck = new LinkedList<>(); 
		Queue <Integer> bridge = new LinkedList<>();
		
		st= new StringTokenizer(br.readLine(), " "); // n개의 트럭 값 
		for(int i=0; i<n; i++) 
			truck.add(Integer.parseInt(st.nextToken()));
		
		bridge.add(truck.poll());
		int sumWeight = bridge.peek(); 
	
		int time =1;  // 총 소요시간 
		
		                                                                                                   
		while(!truck.isEmpty()) {
			
			// 트럭을 다리에 올릴 수 있는 상황 
			if( bridge.size() < w && sumWeight+truck.peek() <= L ) { 
				bridge.add(truck.peek());
				sumWeight+=truck.poll(); 

			}
			else { // 넣을 수 없으면  
				bridge.add(0);
	
			} time++;
			if(bridge.size()==2) {
				sumWeight-=bridge.peek();
				if(bridge.poll()!=0) time++;

				
			}
			
			
		} // end of while 
		
		
		
		System.out.println(time);

		/**
		 * 트럭에 대해서 ( 다리에 머문 시간, 트럭의 무게 ) 로 저장  ( 객체로 ? ) 
		 * 다리위에 올라간 트럭의 합 + 이제 올라갈 트럭 합 <= L 이고
		 * 큐에 있는 트럭들의 다리에 머문 시간 + 1 < w 이면 올라갈 수 있음 
		 * 트럭 ( 다리에 머문 시간 ) 이 w 가 되면 큐에서 빼기 
		 */
		
		
		// 큐에 무게값만 저장 
		// w 값 지나면 큐에서 자동배출 
	}
}
