import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Main_백준_2109_순회강연_골드3_396ms
 * 
 *  - 그리디
 *    1. pay를 기준으로 오름차순 정렬하여 저장 
 *    2. 높은 pay서부터, 스케쥴을 잡아준다.
 */
public class Main_백준_2109_순회강연_골드3_이진오_396ms {
	
	static class Lecture {
		int pay;
		int day;
		
		public Lecture(int pay, int day) {
			super();
			this.pay = pay;
			this.day = day;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 우선 순위 큐 - pay 기준 내림차순 정렬, 
		PriorityQueue<Lecture> pqueue = new PriorityQueue<>(
				(l1, l2) -> (l1.pay < l2.pay) ? 1: (l1.pay == l2.pay)? 0: -1);
		int day = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (d > day) day = d;
			
			pqueue.offer(new Lecture(p, d));
		}
		
		// d일에 가능한 pay들의 집합
		int[] pays = new int[day+1];
		int sum = 0;
		
		while(!pqueue.isEmpty()) {
			Lecture l = pqueue.poll();
			
			for (int i = l.day; i > 0 ;i--) {
				if (pays[i] == 0) {
					sum += l.pay;
					pays[i] = l.pay;
					break;
				}
			}
		}
		System.out.println(sum);
		
	} // end of main
	
} // end of class
