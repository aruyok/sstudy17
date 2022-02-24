package study;
import java.io.*;
import java.util.*;
/*
 * 25C7��, 7���� ������ ������  t�� �ٲ��� 
 * bfs �� ���� ����  
 * s�� 4�� �̻��̾�� �� 
 * �� �����̶�, 7�� ���� ���� 1���� �迭�� 
 * ������ 5�ϸ� x��ǥ��, �� �������� y ��ǥ �ΰ� �̿� 
 */

public class Study_Baekjoon_1941_�ҹ���ĥ����_���3_������_232ms2 {
	static int dx[]= {-1, 1, 0, 0};
	static int dy[]= {0 , 0 ,1,-1};
	static char[][] student = new char[5][5]; 
	static boolean[] visited = new boolean[25];
	static int princess[]= new int[7]; // ĥ���� 
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
			
			visited[i] = false; // �̰� ���� �ϱ� !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
	}
	
	public static boolean bfs() {
		int counting= 1; 
		boolean isSelected [] = new boolean[25];
		Queue<Integer> que = new LinkedList<>();
		que.add(princess[0]); // ���� �� �� �������� ���� �� �������� 
		
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
				
				/**���ȿ� �ְ�, ���� 7�� ���� Ȯ�� ���߰�, 7������ �� �Ѹ��̸� */
				counting++;
				isSelected[index] = true;
				que.add(index); // �ϴ� �� ���⿡ ���ؼ� ĥ���� ������ ť�� �߰��ϱ�   
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
