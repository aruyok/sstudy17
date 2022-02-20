import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_1062_가르침_골드4_이진오_256ms
 * 
 * 아이디어
 *  1. 학생들이 배우는 단어 K가 5보다 작다면, 항상 배울 수 없다. 
 *  2. a, n, t, i, c는 항상 배워야 한다. 
 *  3. a, n, t, i, c를 제외한 영어 소문자 中  K-5개를 선택하여 개수를 헤아린다. 
 *    - 개수를 헤아릴 때, 97+26 크기의 배열을 활용한다. 
 *    - 만약 'b'를 선택했을 때, selected['b'] = true;를 설정해준다. 
 */
public class Main_백준_1062_가르침_골드4_이진오_256ms {
	
	static String[] words;
	static int[] wordsCnt;
	static int result;
	static char[] characters = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // N <= 50 
		int K = Integer.parseInt(st.nextToken()); // K <= 26
		
		words = new String[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		// 단어를 배울 수 없는 경우
		if (K < 5) System.out.println(0);
		
		// 21 C K-5
		else {
			boolean[] selected = new boolean[26+'a'];
			selected['a'] = true;
			selected['n'] = true;
			selected['t'] = true;
			selected['i'] = true;
			selected['c'] = true;
			combination(0, 0, K-5, selected);
			System.out.println(result);
		}
		
	} // end of main

	public static void combination(int cnt, int start, int r, boolean[] selected) {
		if (cnt == r) {
			// words에서, selected 배열에 false인 단어들이 존재하는지 헤아린다. 
			int temp = 0;
			for (int i = 0; i < words.length; i++) {
				boolean flag = true;
				for (int j = 4, l = words[i].length()-4; j < l; j++) {
					// 선택되지 않은 단어가 존재한다면
					if (!selected[words[i].charAt(j)]) {
						flag = false;
						break;
					}
				}
				if (flag) temp++;
			}
			
			if (result < temp) result = temp;
			return;
		}
		
		for (int i = start; i < 21; i++) {
			selected[characters[i]] = true;
			combination(cnt+1, i+1, r, selected);
			selected[characters[i]] = false;
		}
	} // end of combination
	
} // end of class
