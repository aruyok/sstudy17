package study;
import java.io.*;
import java.util.*;

/**
 * 신장트리를 구성하기 위한 다음 정점을 정할 떄 
 * -> 과 <- 방향 중 더 작은값을 가지는 것을 min 에 넣고 추가 
 *
 */
public class Study_BaekJoon_1414_불우이웃돕기_골드2_최지혜_80ms {
	static int N;
	static int [][] adjMatrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine()); // 컴퓨터의 갯수
		boolean[] visited = new boolean[N]; // 해당 정점이 신장트리에 포함 ? 
		adjMatrix= new int [N][N];
		int[] minEdge = new int[N]; // 타정점과의 최소간선 거리 저장 
		int AllComputer=0; // 전체 랜선의 길이 
		// 입력받아서 숫자로 변환 
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
		minEdge[0]= 0 ; // 시작점 : 0 
		
		for(int a=0; a<N; a++) {
			/**신장트리에 아직 포함되지 않은 정점들 중 가장 간선의 가중치가 작은것 선택해서 포함 */
			int min = Integer.MAX_VALUE;
			int minVertex=0;
			// 최소간선 찾아서 일단 신장트리 생성 
			for(int i=0; i<N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i ;
					
				}
			}
			
			visited[minVertex] = true;
			result+=min;
			
			// ↓ 이렇게 하면, 하나만 있을때  min( 연결간선 있는 거 거리, 0 ) = 0 이라서, 연결할 수 없는 처리가 된다 . 
//			for(int i=0; i<N; i++) {
//				if(!visited[i] && (adjMatrix[minVertex][i]!=0 | adjMatrix[i][minVertex]!=0) && 
//						minEdge[i]>Math.min(adjMatrix[minVertex][i], adjMatrix[i][minVertex])) {
//					minEdge[i] = Math.min(adjMatrix[minVertex][i], adjMatrix[i][minVertex]); 
//				}
//				
//			}
			
			for(int i=0; i<N; i++) {
				if (visited[i] || (adjMatrix[minVertex][i] == 0 && adjMatrix[i][minVertex] == 0)) continue;
				// 간선이 하나만 있을 때 
				if (adjMatrix[minVertex][i] == 0) minEdge[i] = Math.min(minEdge[i], adjMatrix[i][minVertex]) ;
				if (adjMatrix[i][minVertex] == 0) minEdge[i] = Math.min(minEdge[i], adjMatrix[minVertex][i]) ;
				// 간선이 두개 존재할 때 
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
