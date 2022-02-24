package study;
import java.io.*;
import java.util.*;

/**
 * ����Ʈ���� �����ϱ� ���� ���� ������ ���� �� 
 * -> �� <- ���� �� �� �������� ������ ���� min �� �ְ� �߰� 
 *
 */
public class Study_BaekJoon_1414_�ҿ��̿�����_���2_������_80ms {
	static int N;
	static int [][] adjMatrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine()); // ��ǻ���� ����
		boolean[] visited = new boolean[N]; // �ش� ������ ����Ʈ���� ���� ? 
		adjMatrix= new int [N][N];
		int[] minEdge = new int[N]; // Ÿ�������� �ּҰ��� �Ÿ� ���� 
		int AllComputer=0; // ��ü ������ ���� 
		// �Է¹޾Ƽ� ���ڷ� ��ȯ 
		for(int i=0; i<N; i++) {
			String s= br.readLine();
			for(int j=0; j<N; j++) {
				char ch = s.charAt(j);
				int val =0; 
				if(ch >='a' && ch <='z') val = ch-96;
				else if (ch>='A' && ch<='Z') val= ch-38;
				adjMatrix[i][j] = val;
				AllComputer+=val;
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		

		int result = 0;
		minEdge[0]= 0 ; // ������ : 0 
		
		for(int a=0; a<N; a++) {
			/**����Ʈ���� ���� ���Ե��� ���� ������ �� ���� ������ ����ġ�� ������ �����ؼ� ���� */
			int min = Integer.MAX_VALUE;
			int minVertex=0;
			// �ּҰ��� ã�Ƽ� �ϴ� ����Ʈ�� ���� 
			for(int i=0; i<N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i ;
					
				}
			}
			
			visited[minVertex] = true;
			result+=min;
			
			// �� �̷��� �ϸ�, �ϳ��� ������  min( ���ᰣ�� �ִ� �� �Ÿ�, 0 ) = 0 �̶�, ������ �� ���� ó���� �ȴ� . 
//			for(int i=0; i<N; i++) {
//				if(!visited[i] && (adjMatrix[minVertex][i]!=0 | adjMatrix[i][minVertex]!=0) && 
//						minEdge[i]>Math.min(adjMatrix[minVertex][i], adjMatrix[i][minVertex])) {
//					minEdge[i] = Math.min(adjMatrix[minVertex][i], adjMatrix[i][minVertex]); 
//				}
//				
//			}
			
			for(int i=0; i<N; i++) {
				if (visited[i] || (adjMatrix[minVertex][i] == 0 && adjMatrix[i][minVertex] == 0)) continue;
				// ������ �ϳ��� ���� �� 
				if (adjMatrix[minVertex][i] == 0) minEdge[i] = Math.min(minEdge[i], adjMatrix[i][minVertex]) ;
				if (adjMatrix[i][minVertex] == 0) minEdge[i] = Math.min(minEdge[i], adjMatrix[minVertex][i]) ;
				// ������ �ΰ� ������ �� 
				if (adjMatrix[minVertex][i] != 0 && adjMatrix[i][minVertex] != 0) {
					minEdge[i]=Math.min(minEdge[i], Math.min(adjMatrix[minVertex][i], adjMatrix[i][minVertex]));
				
				}
			}
			
		} // end of for
		boolean flag = false ; 
		for(int i=0; i<N; i++) {
			if(minEdge[i]==Integer.MAX_VALUE) {
				flag = true; 
			}
		}
		if(flag) System.out.println(-1);
		else System.out.println(AllComputer - result);
	} // end of main 
} // end of class 
