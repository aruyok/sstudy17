import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Main_백준_1414_불우이웃돕기_골드2_이진오_80ms
 * 
 *  - PRIM 알고리즘 구현
 *    : 방문한 노드(from)로부터, 방문하지 않은 노드(to)로의 거리 중 최소를 구함
 *    
 *  - minEdge[] 배열
 *    : MST로부터, i번째 정점까지의 최소 간선 비용
 *    : 가장 최근에 업데이트된 node와, MST에 포함되지 않은 정점들을 비교하며 update해준다. 
 *    
 *  - 주의사항
 *    : 꼭 방문한 노드에서 시작하지 않아도 됨 (DAG?)
 *    : 그래프가 전부 연결되어 있지 않을 수 있음
 * 
 */
public class Main_백준_1414_불우이웃돕기_골드2_이진오_80ms {
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
		int node, edge;
		minEdge[0] = 0;
		
		// PRIM
		while(true) {
			// MST에 포함되지 않은 정점들 중, MST와의 간선의 비용이 최소인 정점을 찾는다. 
			edge = Integer.MAX_VALUE;
			node = 0;
			for (int i = 0; i < N; i++) {
				if (!visited[i] && edge > minEdge[i]) {
					edge = minEdge[i];
					node = i;
				}
			}
			
			// 최소비용의 node를 선택, 비용을 update
			visited[node] = true;
			totalLan -= edge;
			if (++cnt == N) break; // 선택된 정점이 마지막 정점이라면
			
			for (int i = 0; i < N; i++) { // 현재 선택된 node와의 최소 비용 update
				if (visited[i]) continue;
				if (adjMatrix[node][i] == 0 && adjMatrix[i][node] == 0) continue;
				if (adjMatrix[node][i] == 0 && adjMatrix[i][node] < minEdge[i]) minEdge[i] = adjMatrix[i][node];
				if (adjMatrix[i][node] == 0 && adjMatrix[node][i] < minEdge[i]) minEdge[i] = adjMatrix[node][i];
				if (adjMatrix[node][i] != 0 && adjMatrix[i][node] != 0) {
					int e = Math.min(adjMatrix[node][i], adjMatrix[i][node]);
					if (e < minEdge[i]) minEdge[i] = e;
				}
			}
			
		} // end of while
		
		System.out.println(totalLan);
		
	} // end of main
} // end of class
