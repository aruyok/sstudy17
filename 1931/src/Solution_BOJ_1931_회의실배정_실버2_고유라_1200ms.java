import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_BOJ_1931_회의실배정_실버2_고유라_1200ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] time = new int[n][2];
		int cnt = 0; //회의 개수
		
		for (int i=0; i<n; i++) {
			time[i][0] = sc.nextInt(); //시작
			time[i][1] = sc.nextInt(); //종료
		}
		
		Arrays.sort(time, new Comparator<int[]>() { //종료 시간 정렬
			public int compare(int[] t1, int[] t2) {
				int resultT = 0;
				if (t1[1] == t2[1]) { //종료시간 같으면 시작 시간 순서 오름차순
					resultT = t1[0] - t2[0];
					return resultT;
				}
				return t1[1] - t2[1];
			}
		});
		
		int bt = 0; //직전 종료 시간
		for (int i=0; i<n; i++) {
			if (bt <= time[i][0]) {
				bt = time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}//end of main

}//end of class
