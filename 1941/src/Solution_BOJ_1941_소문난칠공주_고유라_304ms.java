import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 1. 7개 뽑는 조합 만들고
 * 2. 노드 이어져있는지 확인하고
 * 3. s 개수 세기
 * 4. 조합에서 Y>3이면 리턴*/
public class Solution_BOJ_1941_소문난칠공주_고유라_304ms {
	static char[][] cls = new char[5][5];
	static int result;
	static int[] comb = new int[7];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<5; i++) {
			cls[i] = br.readLine().toCharArray();
		}
		
		comb(0,0,0);
		
		System.out.println(result);	
		
	}//end of main

	public static void comb(int index, int cnt, int y) {
		// TODO Auto-generated method stub
		if (y>3) return;
		
		if (cnt==7) {
			if (connect()) {
				result++;
			}
			return;
		}
		
		if (index==25) return;
		
		comb[cnt] = index;
		int Y = cls[index/5][index%5] == 'Y'? 1:0;
		comb(index+1, cnt+1, y+Y);
		comb(index+1, cnt, y);
	}//end of comb

	public static boolean connect() { // 연결되어있는지 확인
		boolean[] check = new boolean[7];
		check[0] = true;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		
		int count = 1;
		while (!q.isEmpty()) {
			int p = q.poll();
			for(int i = 0 ; i < 7 ; i++) {
				if(p==i || check[i])
					continue;
				if(comb[p] % 5 == 0) // 제일 왼쪽 벽
					if(comb[p] - 1 == comb[i])
						continue;
				if(comb[p] % 5 == 4) // 제일 오른쪽 벽
					if(comb[p] + 1 == comb[i])
						continue;
				if(comb[p] - 1 == comb[i] || comb[p] + 1 == comb[i] || comb[p]+5 == comb[i] || comb[p] - 5 == comb[i]) {
					q.offer(i);
					check[i] = true;
					count++;
				}
			}
		}//end of while
		
		if (count!=7) return false; //연결 아무것도 안되어있으면
		return true;
		
	} //end of connect

}//end of class
