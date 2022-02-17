import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_백준_3190_뱀_골드5_조혜진_80ms {
	private static int[] dx = {0, 1,  0, -1};
	private static int[] dy = {1, 0, -1,  0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N+2][N+2];
        
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = true;
		}

        int L = Integer.parseInt(br.readLine());
        int[][] dir = new int[L][2];
        for (int i = 0; i < L; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		dir[i][0] = Integer.parseInt(st.nextToken());
    		dir[i][1] = ((st.nextToken().equals("L")) ? -1 : 1); 	// 왼쪽('L' ==> -1) 오른쪽('D' ==> 1) 
		}
        
        int time = 0;
        int x = 1, y = 1;
        int curDir = 0, dirIndex = 0, nxtRotTime = dir[0][0];
        boolean[][] body = new boolean[N+2][N+2];	// 뱀의 몸통이 놓여있는위치
        for (int i = 0, len = N+2; i < len; i++) {
			body[0][i] 	   = true;
			body[i][0] 	   = true;
			body[len-1][i] = true;
			body[i][len-1] = true;	// 맵 바깥을 true 로 만들어 방문체크를 쉽게하기 위해서~~
		}
        
        Queue<Point> snake = new LinkedList<Point>();
        snake.offer(new Point(x, y));   // 초기위치
        body[x][y] = true;
        
        while(true)	{
        	x = x + dx[curDir];
        	y = y + dy[curDir];
        	if ((body[x][y]))	{
//            	System.out.println("time : " + time + ", curDir : " + curDir
//            			+ ", x : " + x + ", y : " + y + ", 큐길이 : " + snake.size());
        		break;
        	}
        	if (!map[x][y])	{	// 사과없으면
        		Point p = snake.poll();
        		body[p.x][p.y] = false;
//        		System.out.println("remove >> x : " + p.x + ", y : " + p.y);
        	}
        	else	{	// 이부분을 생각못해서.. 엄청 고민하다가 검색해서 찾았따 항상 문제 여러번 읽고 발생할 경우의수 다 생각하기!!!!
        		map[x][y] = false;
        	}
            snake.offer(new Point(x, y));  
            body[x][y] = true;
            time++;
        	if(nxtRotTime == time)	{
        		curDir += dir[dirIndex++][1];
        		if (curDir == 4)
        			curDir = 0;
        		else if (curDir == -1)
        			curDir = 3;
        		if (dirIndex < L)
        			nxtRotTime = dir[dirIndex][0];
        	} 
        	System.out.println("time : " + time + ", curDir : " + curDir
        			+ ", x : " + x + ", y : " + y + ", 큐길이 : " + snake.size());
    		for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					int a = (body[i][j] == true ? 1:0);
					System.out.print(a + "  ");
				}
				System.out.println();
			}
        }
        System.out.println((time+1));
	}
}
