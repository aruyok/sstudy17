package study;
import java.io.*;
import java.util.*;
public class Study_Baekjoon_3190_뱀_골드5_100ms {

	/**
	 * 뱀이 1,1에서 시작 - > 그냥 0,0 으로 하고, 인덱스값에 -1 
	 * 뱀이 경계나 몸에 부딪히면 끝 
	 * 그전에는 이동하면서 사과 (1) 있거나 없거나에 대한 행동 
	 * 방향 바꾸기, 음수나오면 젤 뒤 방향으로 
	 */
	private static int[] dx = {0, 1, 0, -1}; 
	private static int[] dy = {1, 0, -1, 0}; // 우 하 좌 상 ( 우  : 기본움직임 ) 
	private static int N,L,K;
	private static int[][] map;
	private static List<int[]> snake = new LinkedList<>(); // 뱀이 움직이는 위치 
	private static int time; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine()); // 보드의 크기 
		map= new int [N][N];
		K= Integer.parseInt(br.readLine()); // 사과의 개수 
		for(int i=0; i<K; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
				int r = Integer.parseInt(st.nextToken()); 
				int c = Integer.parseInt(st.nextToken()); // 사과 위치 
				map[r-1][c-1] = 1; // 사과 있는 곳 = 1 로 설정 
				
			
		}
		
		L= Integer.parseInt(br.readLine()); // 뱀의 방향 변환 횟수 
		int dir[][]= new int[L][2] ;
		for(int i=0; i<L; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			dir[i][0]= Integer.parseInt(st.nextToken()); // 몇 초 후 이동 ? 
			char leftright = st.nextToken().charAt(0);
			dir[i][1]= leftright=='D' ? 1 : -1 ;// D : 우(+1) , L : 좌(-1) 
		}
		snake.add(new int[] {0,0}); 
		count(0,0,0, dir); // x , y, 현재 방향, 방향 
		
		System.out.println(time);
	}// end of main 
	
	public static void count(int x, int y,int direct, int[][] dir) {
	
		time = 0; 
		int count =0 ; // 방향 변환 
		

		while(true) {
			time++;
			int nx = x + dx [direct];
			int ny=  y + dy [direct]; // 머리이동 
			
			if(out(nx, ny)) break; // 게임 끝 
			
			if(map[nx][ny]==1) { // 사과 ㅇ 
				map[nx][ny]=0; // 사과 없애고 
				snake.add(new int[] {nx,ny});  // 위치 추가
			}
			else { // 사과 x 
				snake.add(new int[] {nx, ny});
				snake.remove(0); // 꼬리 자르기 
			}
			
			x = nx ; y= ny; 
			
			if(count < L && time == dir[count][0]) {
				// 방향바꾸기 어케 할래 ? 
				direct = (dir[count][1]+direct)%4 ; 
				if(direct == -1 ) direct = 3; // 좌로 가다가 음수값이 나오면 젤 마지막 방향으로 
				count++;
			}
		}
	}
	public static boolean out(int x, int y) {
		
		// 경계 인지 
		if(x<0 | x >= N | y<0 | y >=N) return true;
		// 몸통이랑 닿았는지 
		for(int i=0; i<snake.size(); i++) {
			if(snake.get(i)[0]==x && snake.get(i)[1]==y) return true;
		}
		return false;
	}
	
}
