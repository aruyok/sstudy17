import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 1. 7개 뽑는 조합 만들고
 * 2. 노드 이어져있는지 확인하고
 * 3. s 개수 세기
 * 4. 조합에서 Y>3이면 리턴*/
public class Solution_BOJ_1941_소문난칠공주_고유라_240ms {
    static int N = 5;
    static int ressult = 0;
    static int[] select;
    static char[][] cls;
    static boolean[] check;
    static boolean[] adjacent;
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static Queue<Integer> q;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cls = new char[N][N];
        
        for (int i = 0; i < N; i++) {
        	cls[i] = br.readLine().toCharArray();
        }
        check = new boolean[N*N];
        select = new int[7]; //선택된 7명
        
        comb(0, 0, 0);
        
        System.out.println(ressult);
    }
 
    public static void comb(int idx, int cnt, int cntS) {
        if (cnt == 7) {
            if (cntS >= 4) { // 솜 4명 이상
                if(connect()) // 연결되어있는지 확인
                    ressult++;
                return;
            }
            return; //4명 아니면
        }
        
        for (int i = idx; i < N*N; i++) {
            check[i] = true;
            select[cnt] = i;
            
            if(cls[i/N][i%N] == 'S') { // 솜이면
            	comb(i + 1, cnt + 1, cntS + 1);
            } else {
            	comb(i + 1, cnt + 1, cntS);
            }
            
            check[i] = false;
        }
    } //end of comb
    
    public static boolean connect() {
        int cnt = 1;
        adjacent = new boolean[N*N];
        q = new LinkedList<>();
        q.add(select[0]); // 한 명 넣고
       
        while(!q.isEmpty()) { //7명 다 연결되어있는지 
            int p = q.poll();
            adjacent[p] = true;
            
            for (int d = 0; d < 4; d++) {
                int nX = (p/N) + dx[d];
                int nY = (p%N) + dy[d];

                if(nX < 0 || nY < 0 || nX >= N || nY >= N) { // 범위 벗어나면
                	continue;
                }

                if(adjacent[nX*N+nY]) { //확인 다 하면
                	continue;
                }

                if(!check[nX*N+nY]) { // 연결 o 공주 x
                	continue;
                }
 
                cnt++;
                adjacent[nX*N+nY] = true;
                q.add(nX*N+nY);
            }
        }
 
        if(cnt == 7) {
        	return true; // 연결 7명 다 되어있으면 
        } else {
        	return false;
        }
    } //end of connect
    
} //end of class