package study;
import java.io.*;
import java.util.*;
/*
 * 25C7로, 7개의 조합을 꺼내고  t로 바꿔줌 
 * bfs 로 인접 여부  
 * s가 4개 이상이어야 함 
 * 걍 조합이랑, 7명 연결 여부 1차원 배열로 
 * 나누기 5하면 x좌표고, 그 나머지는 y 좌표 인거 이용 
 */

public class Study_Baekjoon_1941_소문난칠공주_골드3_최지혜_232ms2 {
	static int dx[]= {-1, 1, 0, 0};
	static int dy[]= {0 , 0 ,1,-1};
	static char[][] student = new char[5][5]; 
	static boolean[] visited = new boolean[25];
	static int princess[]= new int[7]; // 칠공주 
	private static int res=0; 

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++)
			student[i]= br.readLine().toCharArray();

		combi(0,0,0);
		System.out.println(res);
		
	} // end of main
	/**25C7*/
	public static void combi(int start, int count, int som) {
		if(count==7) {
			if(som>=4) {
				if(bfs()) 
					res++;
				return ; 
			}
			return ;
		}
		
		for(int i=start; i<25; i++) {
			visited[i] = true;
			princess[count]=i;
			
			int row = i/5;
			int col = i%5;
			if(student[row][col]=='S') 
				combi(i+1, count+1, som+1);
			else	
				combi(i+1, count+1, som);
			
			visited[i] = false; // 이거 제발 하기 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
	}
	
	public static boolean bfs() {
		int counting= 1; 
		boolean isSelected [] = new boolean[25];
		Queue<Integer> que = new LinkedList<>();
		que.add(princess[0]); // 조합 중 젤 마지막에 들어온 애 기준으로 
		
		while(!que.isEmpty()) {
			int first= que.poll();
			isSelected[first] = true;
			
			int row= first / 5;
			int col= first % 5;
			
			for(int i=0; i<dx.length; i++) {
				int nx = row+dx[i];
				int ny = col+dy[i];
				
				int index = 5*nx+ny;
				if(!inBoundary(nx,ny) || isSelected[index] || !visited[index]) continue; 
				
				/**경계안에 있고, 아직 7명 연결 확인 안했고, 7명조합 중 한명이면 */
				counting++;
				isSelected[index] = true;
				que.add(index); // 일단 네 방향에 대해서 칠공주 있으면 큐에 추가하기   
			}
		}
		
	
		if(counting==7) 
			return true ;
		
		else 
			return false; 
	}
	public static boolean inBoundary(int x, int y) {
		return (x>=0 && x<5 && y>=0 && y<5);
	}
} // end of class 
