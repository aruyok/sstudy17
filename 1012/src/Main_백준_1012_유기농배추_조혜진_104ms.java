import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1012_유기농배추_조혜진_104ms {
	private static int m;
	private static int n;
	private static int cnt;
	private static int[][] maps;
	private static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken()); // 열
            n = Integer.parseInt(st.nextToken()); // 행
            int K = Integer.parseInt(st.nextToken());
            
            cnt = 0;
            maps = new int[n][m];
            visit = new boolean[n][m];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken()); 
            	maps[x][y] = 1;
			}     // 입력처리 끝
            
            for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (maps[i][j] == 1 && !visit[i][j])	{
//						System.out.println("cnt : " + cnt + "[x, y] : " + i + ", " + j);
						dfs(i, j);	// 재귀
						cnt++;
					}					
				}
			}
            sb.append(cnt).append('\n');
		}
        System.out.println(sb);        
	}
	
	// map[n][m]
	public static void dfs(int x, int y)	{
		visit[x][y] = true;
		if (maps[x][y] == 0)
			return;
		
		if (x < (n-1) 	&& !visit[x+1][y])
			dfs(x+1, y);
		if (x > 0 		&& !visit[x-1][y])
			dfs(x-1, y);
		if (y < (m-1) 	&& !visit[x][y+1])
			dfs(x, y+1);
		if (y > 0 		&& !visit[x][y-1])
			dfs(x, y-1);		
	}
}
