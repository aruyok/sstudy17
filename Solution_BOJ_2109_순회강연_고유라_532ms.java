import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 1. 강연료 내림차순 정렬
 * 2. 강연료 같으면 날짜 내림차순
 * 3. 우선순위 큐로 같은 날짜에서 강의료 제일 많은거 빼기*/
public class Solution_BOJ_2109_순회강연_고유라_532ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] lecture = new int[n+1][2];
		
		for (int i=0; i<n; i++) {
			lecture[i][0] = sc.nextInt(); //강연료
			lecture[i][1] = sc.nextInt(); //날짜
		}
		
		Arrays.sort(lecture, new Comparator<int[]>() { //내림차순
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
		});
		
		int d = lecture[0][1]; //날짜
		int i = 0; //lecture 시작 인덱스
		PriorityQueue<Integer> pd = new PriorityQueue<Integer>(Collections.reverseOrder());
		int pay = 0; //강연료 총합
		
		while (d!=0) { //d>=1
			while(lecture.length>i && lecture[i][1]==d) { //날짜별로 우선순위 큐에 넣고
				pd.add(lecture[i][0]);
				i++;
			}
			d--;
			if (!pd.isEmpty()) {
				pay += pd.poll(); //강의료 많은거만 빼기
			}
		}//end of while
		System.out.println(pay);		
		
	}//end of main

}//end of class
