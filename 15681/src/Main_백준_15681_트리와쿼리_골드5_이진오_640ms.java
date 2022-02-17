import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Main_백준_15681_트리와쿼리_골드5_640ms
 */
public class Main_백준_15681_트리와쿼리_골드5_이진오_640ms {
	private static ArrayList<Integer>[] graph;
	private static int[] size;
	
	
	public static int getSize(int v) {
		size[v] = 1;
		
		// graph v의 다음 노드에 대해 size를 구하기
		for (Integer v0 : graph[v]) {
			if (size[v0] == 0)
				size[v] += getSize(v0);
		}
		
		return size[v];
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		// 그래프 활용
		graph = new ArrayList[N+1];
		size = new int[N+1];
		
		// 그래프 초기화
		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		// N-1개의 간선 입력 처리
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 간선의 두 정점 v1, v2
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		// 각 노드에 대해, 서브트리의 크기 구하기
		getSize(R);
		
		// 쿼리 처리
		for (int i = 0; i < Q; i++) {
			int query = Integer.parseInt(br.readLine());
			sb.append(size[query]).append("\n");
		}
		
		// 전체 출력문 처리
		System.out.print(sb.toString());
	} // end of main
} // end of class
