import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Main_백준_2841_외계인의기타연주_실버1_648ms
 */
public class Main_백준_2841_외계인의기타연주_실버1_648ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		// 6개의 줄을 관리하는 스택
		List<Stack<Integer>> lines = new ArrayList<Stack<Integer>>(7);
		lines.add(null);
		for (int no = 1; no <= 6; no++) {
			lines.add(new Stack<Integer>());
		}
		
		int cnt = 0;
		Stack<Integer> temp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int no = Integer.parseInt(st.nextToken());
			int pret = Integer.parseInt(st.nextToken());
			temp = lines.get(no);
			
			while (true) { // 라인의 peek가 pret과 동일할 때까지
				// 공백 스택일 때
				if (temp.isEmpty()) { 
					temp.add(pret);
					cnt++;
					break;
				}
				// 공백이 아닐 때
				int peek = temp.peek();
				// 현재 스택의 peek와 pret이 동일할 때
				if (peek == pret) {
					break;
				} 
				// 현재 스택의 peek가 pret보다 작을 때
				if (peek < pret) {
					temp.add(pret);
					cnt++;
					break;
				} 
				// 현재 스택의 peek가 pret보다 클 때
				if (peek > pret) {
					temp.pop();
					cnt++;
				} 
			} // end of while
		} // end of for i
		
		// 출력 처리
		System.out.println(cnt);
		
	} // end of main
} // end of class
