package study;
import java.io.*;
import java.util.*;
public class Study_Baekjoon_3190_��_���5_100ms {

	/**
	 * ���� 1,1���� ���� - > �׳� 0,0 ���� �ϰ�, �ε������� -1 
	 * ���� ��質 ���� �ε����� �� 
	 * �������� �̵��ϸ鼭 ��� (1) �ְų� ���ų��� ���� �ൿ 
	 * ���� �ٲٱ�, ���������� �� �� �������� 
	 */
	private static int[] dx = {0, 1, 0, -1}; 
	private static int[] dy = {1, 0, -1, 0}; // �� �� �� �� ( ��  : �⺻������ ) 
	private static int N,L,K;
	private static int[][] map;
	private static List<int[]> snake = new LinkedList<>(); // ���� �����̴� ��ġ 
	private static int time; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine()); // ������ ũ�� 
		map= new int [N][N];
		K= Integer.parseInt(br.readLine()); // ����� ���� 
		for(int i=0; i<K; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		
				int r = Integer.parseInt(st.nextToken()); 
				int c = Integer.parseInt(st.nextToken()); // ��� ��ġ 
				map[r-1][c-1] = 1; // ��� �ִ� �� = 1 �� ���� 
				
			
		}
		
		L= Integer.parseInt(br.readLine()); // ���� ���� ��ȯ Ƚ�� 
		int dir[][]= new int[L][2] ;
		for(int i=0; i<L; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine(), " ");
			dir[i][0]= Integer.parseInt(st.nextToken()); // �� �� �� �̵� ? 
			char leftright = st.nextToken().charAt(0);
			dir[i][1]= leftright=='D' ? 1 : -1 ;// D : ��(+1) , L : ��(-1) 
		}
		snake.add(new int[] {0,0}); 
		count(0,0,0, dir); // x , y, ���� ����, ���� 
		
		System.out.println(time);
	}// end of main 
	
	public static void count(int x, int y,int direct, int[][] dir) {
	
		time = 0; 
		int count =0 ; // ���� ��ȯ 
		

		while(true) {
			time++;
			int nx = x + dx [direct];
			int ny=  y + dy [direct]; // �Ӹ��̵� 
			
			if(out(nx, ny)) break; // ���� �� 
			
			if(map[nx][ny]==1) { // ��� �� 
				map[nx][ny]=0; // ��� ���ְ� 
				snake.add(new int[] {nx,ny});  // ��ġ �߰�
			}
			else { // ��� x 
				snake.add(new int[] {nx, ny});
				snake.remove(0); // ���� �ڸ��� 
			}
			
			x = nx ; y= ny; 
			
			if(count < L && time == dir[count][0]) {
				// ����ٲٱ� ���� �ҷ� ? 
				direct = (dir[count][1]+direct)%4 ; 
				if(direct == -1 ) direct = 3; // �·� ���ٰ� �������� ������ �� ������ �������� 
				count++;
			}
		}
	}
	public static boolean out(int x, int y) {
		
		// ��� ���� 
		if(x<0 | x >= N | y<0 | y >=N) return true;
		// �����̶� ��Ҵ��� 
		for(int i=0; i<snake.size(); i++) {
			if(snake.get(i)[0]==x && snake.get(i)[1]==y) return true;
		}
		return false;
	}
	
}
