import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Main_백준_1922_네트워크연결_골드4_이진오_612ms_KRUSKAL
 */
public class Main_백준_1922_네트워크연결_골드4_이진오_612ms_KRUSKAL {
	
	static int N;
	static int[] parents;
	
	public static void makeSet() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	public static int findSet(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents[a]); // path compression
	}
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());     // N <= 1,000(정점)
		int M = Integer.parseInt(br.readLine()); // M <= 100,000(간선)
		int[][] edgeList = new int[M][3]; // 간선 리스트 [from, to, weight]
		makeSet();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			edgeList[i][0] = Integer.parseInt(st.nextToken()); // from 
			edgeList[i][1] = Integer.parseInt(st.nextToken()); // to
			edgeList[i][2] = Integer.parseInt(st.nextToken()); // weight <= 10,000
		}
		Arrays.sort(edgeList, (e1, e2) -> e1[2] - e2[2]);
		
		int sum = 0;     // 현재까지 가중치의 합
		int edgeCnt = 0; // 현재까지 연결된 간선의 개수
		for (int i = 0; i < M; i++) {
			int from   = edgeList[i][0];
			int to     = edgeList[i][1];
			int weight = edgeList[i][2];
			
			if (from == to) continue; // from과 to가 동일할 경우 건너뜀
			
			if (union(from, to)) {    // 서로소 집합 union이 성공했다면, 간선을 연결한다
				sum += weight;
				if(++edgeCnt == N-1) break;
			}
		}
		
		System.out.println(sum);
		
	} // end of main
	
} // end of class
