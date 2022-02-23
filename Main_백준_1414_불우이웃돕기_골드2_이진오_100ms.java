import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Main_백준_1414_불우이웃돕기_골드2_이진오_100ms
 * 
 *  - PRIM 알고리즘 구현
 *    : 방문한 노드(from)로부터, 방문하지 않은 노드(to)로의 거리 중 최소를 구함
 *  - 주의사항
 *    : 꼭 방문한 노드에서 시작하지 않아도 됨
 *    : 그래프가 전부 연결되어 있지 않을 수 있음
 * 
 */
public class Main_백준_1414_불우이웃돕기_골드2_이진오_100ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean visited[] = new boolean[N];
		int adjMatrix[][] = new int[N][N];
		int minEdge[] = new int[N];
		int lan[] = new int['a'+26];
		
		
		int w = 1;
		for (char c = 'a'; c <= 'z'; c++) {
			lan[c] = w++;
		}
		for (char c = 'A'; c <= 'Z'; c++) {
			lan[c] = w++;
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
		}
		
		int totalLan = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				int l = lan[line.charAt(j)];
				if (l != 0) {
					adjMatrix[i][j] = l;
					totalLan += l;
				}
			} // end of for j
			
		} // end of for i
		
		// 시작 노드 = 0
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		int cnt  = 0;
		int node = 0;
		int edge = 0;
		minEdge[0] = edge;
		
		// PRIM
		while(true) {
			totalLan -= edge;
			visited[node] = true;
			
			if (cnt == N-1) break;
			
			edge = Integer.MAX_VALUE;
			for (int from = 0; from < N; from++) { // n1 = 방문한 노드 
				if (!visited[from]) continue;
				
				for (int to = 0; to < N; to++) { // n2 = 방문하지 않은 노드
					if (visited[to]) continue;
					int fromTo = adjMatrix[from][to];
					int toFrom = adjMatrix[to][from];
					int min = Math.min(fromTo, toFrom);
					if (min < edge) {
						edge = min;
						node = to;
					}
				} // end of for to
				
			} // end of for from
			
			if (edge == Integer.MAX_VALUE) { // 어디에도 갈 수 없다면, 
				totalLan = -1;
				break;
			}
			cnt++; // 연결 완료
		} // end of while
		
		System.out.println(totalLan);
		
	} // end of main
} // end of class
