import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_1966_프린터큐_실버3_88ms
 */
public class Main_백준_1966_프린터큐_실버3_88ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < TC; testCase++) {
			// first line
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// second line
			st = new StringTokenizer(br.readLine(), " ");
			
			// 자료구조 - 프린트물 저장할 큐, 최대 우선순위를 저장할 우선 순위 큐
//			PriorityQueue<Integer> pqueue = new PriorityQueue<>(N, (i1, i2) -> i2 - i1);
			
			int maxP = 0;
			int[] counter = new int[10]; // 1 ~ 9
			Queue<int[]> queue = new LinkedList<int[]>(); // [우선순위, 문서 인덱스]
			
			for (int i = 0; i < N; i++) {  // 입력 처리
				int priority = Integer.parseInt(st.nextToken());
//				pqueue.offer(priority);
				
				counter[priority]++;
				if (priority > maxP) maxP = priority;
				queue.offer(new int[] {priority, i});
			}

			
			// 프린트 처리 알고리즘
			int[] print = {-1, -1};
			int order = 0;
			while (print[1] != M) {
				// 현존 최대 우선순위
//				int maxP = pqueue.poll();
				
				// 출력 처리 알고리즘
				print = queue.poll();
				while (print[0] != maxP) {
					// 최대가 아니라면, 다시 enQueue
					queue.offer(print);
					// 다시 첫 원소를 deQueue
					print = queue.poll();
				}
				order++;
				
				// 최대 우선순위 처리 알고리즘
				counter[maxP]--;
				if (counter[maxP] == 0) {
					while (maxP >= 0 && counter[maxP] == 0) {
						maxP--;
					}
				}
			}
			sb.append(order).append("\n");
		} // end of for testcase
		
		
		// 전체 출력 처리
		System.out.print(sb.toString());
		
	} // end of main
} // end of class
