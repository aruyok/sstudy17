import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1. k-5개 새로 읽기 (a n t i c)
 * 2. k=26이면 알파벳 전체
 * 3. 알파벳 전체 확인하는 boolean 배열 */
public class Solution_BOJ_1062_가르침_고유라_320ms {
	static int N;
	static int K;
	static boolean check[] = new boolean[26];
	static String[] vocab;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        vocab = new String[N];
        
        if (K<5) {
        	System.out.println(0);
        	return;
        } else if (K==26){
        	System.out.println(N);
        	return;
        } else {
        	for (int i=0; i<N; i++) {
        		String s = br.readLine();
        		vocab[i] = s.substring(4, s.length()-4); //anta tica 제외하고
        	}
        	
        	K-=5; //a n t i c 빼고
        	check['a'-'a'] = true; //a n t i c는 이미 알고 있는 알파벳
        	check['n'-'a'] = true;
        	check['t'-'a'] = true;
        	check['i'-'a'] = true;
        	check['c'-'a'] = true;
        	
        	findMax(0,0);
        	System.out.println(result);
        	
        }//end of if-else
	}//end of main
	public static void findMax(int index, int cnt) {
		if (cnt==K) { //K가 되면 
			int max = 0;
			for (int i=0; i<N; i++) {
				boolean b = true;
				for (int j=0; j<vocab[i].length(); j++) {
					if (!check[vocab[i].charAt(j)-'a']) { //배우지 않은 알파벳 있는 단어 빼고
						b = false;
						break;
					}
				}
				if (b) { //전부 더해주기
					max++;
				}
			}//end of for i
			result = Math.max(max, result);
		}//end of if K
		
		for (int i=index; i<26; i++) {
			if (!check[i]) {
				check[i] = true;
				findMax(i, cnt+1);
				check[i] = false;
			}
		}//end of for
	}//end of dfs

}//end of class
