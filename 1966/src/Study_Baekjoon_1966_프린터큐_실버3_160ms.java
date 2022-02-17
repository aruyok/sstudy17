package study;
import java.util.*;
import java.io.*;
public class Study_Baekjoon_1966_������ť_�ǹ�3_160ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		while(tc-->0) {
			
			LinkedList <int[]> que = new LinkedList<>(); 
			st= new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // ������ ���� 
			int M = Integer.parseInt(st.nextToken()); // ���� ��ġ 
			
			st=new StringTokenizer(br.readLine(), " "); // ���� �߿䵵 
			for(int i=0; i<N; i++)
				que.add(new int[] {i, Integer.parseInt(st.nextToken())}); // [�ε���, �߿䵵] 
			
			
			int count=0;
			
			while(!que.isEmpty()) {
				
				int front[] = que.poll(); // front �� �� 
				boolean isMax=true; // for�� ���ο��� break ���� Ÿ�� ���°�����, ���Ŀ� �� ū���� ��� for ���� �׳� ������ ������ ���ϱ� ���� flag 
				
				for(int i=0; i<que.size(); i++) {
				
					if(front[1] < que.get(i)[1]) {
						isMax=false;
						que.add(front);  // ���� �ڷ� ������ 
						break;
					}
				
				}// end of for
				// �ִ밪�̸� 
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
