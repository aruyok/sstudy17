package study;
import java.util.*;
import java.io.*;
public class Study_Baekjoon_1966_프린터큐_실버3_160ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		while(tc-->0) {
			
			LinkedList <int[]> que = new LinkedList<>(); 
			st= new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 문서의 갯수 
			int M = Integer.parseInt(st.nextToken()); // 현재 위치 
			
			st=new StringTokenizer(br.readLine(), " "); // 문서 중요도 
			for(int i=0; i<N; i++)
				que.add(new int[] {i, Integer.parseInt(st.nextToken())}); // [인덱스, 중요도] 
			
			
			int count=0;
			
			while(!que.isEmpty()) {
				
				int front[] = que.poll(); // front 의 값 
				boolean isMax=true; // for문 내부에서 break 문을 타고 나온것인지, 이후에 더 큰값이 없어서 for 문을 그냥 지나온 것인지 비교하기 위한 flag 
				
				for(int i=0; i<que.size(); i++) {
				
					if(front[1] < que.get(i)[1]) {
						isMax=false;
						que.add(front);  // 제일 뒤로 보내기 
						break;
					}
				
				}// end of for
				// 최대값이면 
				if(isMax) {            
					count++;
				if(front[0]==M) break;
				}
				
			}// end of while
			
			sb.append(count).append("\n");
			
			
		} // end of testcase while
		System.out.println(sb);
	}

}
