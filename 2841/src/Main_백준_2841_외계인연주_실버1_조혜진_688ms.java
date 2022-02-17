import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_백준_2841_외계인연주_실버1_조혜진_688ms {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken()); // <= 500,000
	    int P = Integer.parseInt(st.nextToken()); // <= 300,000
	    
	    int result = 0;
	    Stack<Integer>[] g = new Stack[6];	// 6개의 줄
		for (int i = 0; i < 6; i++)
			g[i] = new Stack<Integer>();
		 
	    for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine(), " ");
		    int a = Integer.parseInt(st.nextToken()) - 1; // 줄의 번호 -> 입력을 1~6 으로 받아서 하나빼줌
		    int b = Integer.parseInt(st.nextToken()); // 프렛의 번호
			
		    while (!g[a].isEmpty() && b < g[a].peek())	{
		    	g[a].pop();
		    	result++;
		    }
		    	
		    if (g[a].isEmpty() || b > g[a].peek())	{
		    	g[a].push(b);
		    	result++;
		    }		    
		}
	    System.out.println(result);
	}
}
