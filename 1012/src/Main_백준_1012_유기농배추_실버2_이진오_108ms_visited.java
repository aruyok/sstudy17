import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_1012_유기농배추_실버2_108ms_visited
 */
public class Main_백준_1012_유기농배추_실버2_이진오_108ms_visited {
	private static boolean[][] field;   // 배추 배열
	private static boolean[][] visited; // 방문 배열
	
	private static int M;
	private static int N;

	public static int search(int row, int col) {
		if (visited[row][col]) return 0;
		
		// 방문 처리
		visited[row][col] = true;
		
//		// 만약, 필드에 배추가 없다면
//		if (!field[row][col]) return 0; // 현재 row, col
//		
		// 상
		if (row-1 >= 0 && field[row-1][col] && !visited[row-1][col]) {
			search(row-1, col);
		}
		// 하
		if (row+1 < N && field[row+1][col] && !visited[row+1][col]) {
			search(row+1, col);
		}
		// 좌
		if (col-1 >= 0 && field[row][col-1] && !visited[row][col-1]) {
			search(row, col-1);
		}
		// 우
		if (col+1 < M && field[row][col+1] && !visited[row][col+1]) {
			search(row, col+1);
		}
		
		return 1; // row, col에서 시작해서 가능한 모든 위치 탐색 후 1 리턴
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new boolean[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				field[r][c] = true; // 배추 심음
			}
			
			// 전체 좌표 탐색
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					cnt += search(r, c);
				}
			}
			
			sb.append(cnt).append("\n");
		} // end of for testCase
		
		System.out.print(sb.toString());
		
	} // end of main
	
} // end of class
