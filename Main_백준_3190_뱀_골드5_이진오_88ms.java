import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * Main_백준_3190_뱀_골드5_ms
 */
public class Main_백준_3190_뱀_골드5_88ms {
	
	static final int APPLE = 1;
	static final int SNAKE = 2;
	// 뱀의 방향 전환 정보 (오른쪽 변환 시 인덱스+1, 왼쪽 변환 시 인덱스-1)
	static final int[] dr = { 0, 1, 0,-1};
	static final int[] dc = { 1, 0,-1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 보드의 크기, 사과의 개수
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N+1][N+1];
		
		// 뱀, [r, c] 배열을 통해 관리
		ArrayDeque<Integer> snakeR = new ArrayDeque<Integer>();
		ArrayDeque<Integer> snakeC = new ArrayDeque<Integer>();
		
		// 뱀의 초기 상태
		snakeR.addFirst(1);
		snakeC.addFirst(1);
		board[1][1] = SNAKE;
		
		// 사과 입력
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 사과의 위치
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			board[r][c] = APPLE;
		}
		
		// 방향 전환 개수
		int L = Integer.parseInt(br.readLine());
		
		// 방향 변환 정보(처음)
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		char cmd = st.nextToken().charAt(0);
		L--;
		
		// 게임 시간, 방향 정보
		int playTime = 0;
		int headToward = 0;
		
		// 게임 시작
		while(true) {
			// 시간++
			playTime++;
			
			// 몸 길이를 늘려, 머리를 다음칸에 위치시킨다. 머리 - 꼬리
			int nextR = snakeR.peekFirst() + dr[headToward];
			int nextC = snakeC.peekFirst() + dc[headToward];
			snakeR.addFirst(nextR);
			snakeC.addFirst(nextC);
			// 이동이 불가능하다면, break
			if (nextR < 1 || nextR > N || nextC < 1 || nextC > N) break;
			if (board[nextR][nextC] == SNAKE) break;
			// 이동한 칸에 사과가 있다면, 사과가 없어지고 꼬리는 없어지지 않는다.
			if (board[nextR][nextC] == APPLE) {
				board[nextR][nextC] = SNAKE;
			}
			// 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 
			else {
				board[nextR][nextC] = SNAKE;
				board[snakeR.pollLast()][snakeC.pollLast()] = 0;
			}
			
			// 현재 시간이 X라면, 뱀 머리의 방향을 변환한다. 
			if (playTime == X) {
				if (cmd == 'D') headToward += 1;
				else 			headToward -= 1;
				if (headToward >= 4) headToward -= 4;
				if (headToward <  0) headToward += 4;
				// 방향 변환 횟수가 남아있다면
				if (L > 0) {
					st = new StringTokenizer(br.readLine(), " ");
					X = Integer.parseInt(st.nextToken());
					cmd = st.nextToken().charAt(0);
					L--;
				}
			}
			
		} // end of while playTime
		
		// 잔여 입력 처리
		while(L > 0) {
			br.readLine();
			L--;
		}
		
		System.out.println(playTime);
		
	} // end of main
} // end of class

