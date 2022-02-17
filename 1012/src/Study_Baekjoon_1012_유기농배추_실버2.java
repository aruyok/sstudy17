package study;
import java.util.*;
import java.io.*;

public class Study_Baekjoon_1012_��������_�ǹ�2 {	
	
	public static int dx[]= {-1, 0, 1, 0};
	public static int dy[]= {0, -1, 0, 1 }; // �� �� �� �� 
	private static int[][] arr;
	private static int M,N;
	
	
	static boolean boundary(int x, int y) {
		return ( x>=0 && x<M && y>=0 && y<N); // ���ȿ� ���� 
	}
	public static void dfs(int x, int y) {
		arr[x][y]=0;
		for(int dir=0; dir<dx.length; dir++) {
			int nx= x+dx[dir];
			int ny= y+dy[dir]; 
			
			if(boundary(nx, ny) && arr[nx][ny]==1 ) {
				
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ; 
		int c=Integer.parseInt(br.readLine()); // ���� ���� 
		
		while(c-->0) {
			st= new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr=new int[M][N] ;
			
			int count=0; // ���߹��� ����  
			
			int num= Integer.parseInt(st.nextToken()); // ���� ���� 
			for(int i=0; i<num; i++) {
				st= new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				arr[X][Y]=1;                                                   
			} // ���� �ɾ��� �ִ� �� -> 1 
			
			
			for(int x=0; x<M; x++) {
				for(int y=0; y<N; y++) {
					if(arr[x][y]==1) {
						//System.out.println(x+" "+y);// ���߰� �ִ� ���̶��, 
						count++;dfs(x, y);
						
					}
				}
			}
			System.out.println(count);
		}
	}
	
}
