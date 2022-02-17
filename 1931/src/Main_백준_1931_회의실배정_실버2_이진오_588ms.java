import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Main_백준_1931_회의실배정_실버2_588ms
 * 
 *  - 그리디: 끝나는 시간을 우선적으로 고려하여 플랜 (증명..?)
 *  - 우선순위큐: 회의들을 정렬하며 append
 *  
 */
public class Main_백준_1931_회의실배정_실버2_588ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 회의실 정보 - 끝나는 시간 오름차순 => 시작 시간 오름차순
		PriorityQueue<int[]> meetings = new PriorityQueue<int[]>(N, 
				(m1, m2) -> (m1[1] != m2[1])? m1[1] - m2[1]: m1[0] - m2[0]);
		
		// 회의 추가 코드
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			
			meetings.offer(new int[] {start, end});
		}
		
		// 회의가 끝나는 시간
		int until = meetings.poll()[1];
		// 회의 하나 시작
		int cnt = 1;
		
		// 대기하는 회의들이 없을 때까지
		while(!meetings.isEmpty()) {
			
			int[] m = meetings.poll();
			
			// 다음 회의가 시작 가능하다면, 
			if (m[0] >= until) {
				until = m[1];
				cnt++;
			}
		}
		System.out.println(cnt);
	} // end of main
} // end of class
