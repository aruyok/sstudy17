import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1. 박스를 2^n X 2^n X 2^n으로 나눠서 큐브 넣기*/ 
public class Solution_BOJ_1493_박스채우기_고유라 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int length = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine()); //큐브 종류
		int[] cube = new int[N];
		int result = 0; //큐브 갯수 최소값
		
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
 
            cube[t] = f; //종류마다 개수 입력
        }
        
        int cnt = 0; //사용한 큐브 갯수
        
        for (int i = N - 1; i >= 0; i--) { // 큰 큐브로 먼저 나누기
            int bAdd = (length>>i) * (width>>i) * (height>>i);
            int add = Math.min(cube[i], bAdd); // 채울 수 있는거랑 있는 개수랑 비교
            result += add; //최종 개수
        }
        
        System.out.println(result);
 
		
		
		
		
	}//end of main

}//end of class
