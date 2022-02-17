import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_13335_트럭_실버1_100ms
 */
public class Main_백준_13335_트럭_실버1_100ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 1  <= N <= 1,000
		int W = Integer.parseInt(st.nextToken()); // 1  <= W <= 1,000
		int L = Integer.parseInt(st.nextToken()); // 10 <= L <= 1,000
		
		Queue<Integer> bridge = new LinkedList<Integer>();
		Queue<Integer> trucks = new LinkedList<Integer>();
		
		int totalLoad = 0; // 현재 다리의 총 하중
		int time = 0;
		
		// 입력 처리
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < W; i++) {
			bridge.offer(0);
		}
		
		while (!bridge.isEmpty()) {
			// 1. 다리에서 deQueue
			totalLoad -= bridge.poll();
			
			// 2. 잔여 트럭이 존재한다면
			if (!trucks.isEmpty()) {
				// 2-1. 다리에 올라갈 수 있다면
				if (totalLoad + trucks.peek() <= L) {
					int truck = trucks.poll();
					totalLoad += truck;
					bridge.offer(truck);
				}
				// 2-2. 다리에 올라갈 수 없다면
				else {
					bridge.offer(0);
				}
			}
			
			// 3. 1초 지남
			time++;
		}
		
		System.out.println(time);
	}
}
