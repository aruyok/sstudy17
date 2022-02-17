package study;
import java.util.*;
import java.io.*;

public class Study_Baekjoon_2841_외계인의기타연주_실버1_648ms {
	/**
	 * 
	 * 6개의 줄이 있으므로, 6개 스택 생성
	 * peek : 스택의 가장 위의 값 , prat : 입력값 
	 * peek > prat : prat 보다 작거나 같은 값이 나올때 까지 pop 반복 , count ++ 하면서 
	 * peek < prat : prat 값 쌓고, count ++
	 * peek = prat : 아무런 일을 할 필요 x 
	 * 스택이 비어있으면 prat 값 쌓고  , count ++ 
	 * 	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		Stack<Integer>[] stack = new Stack[7]; 
		for(int i=0; i<7; i++) {
			stack[i]=new Stack<>();
		}
		
		
		st= new StringTokenizer(br.readLine(), " ");
		int N=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		int count=0;
		
		while(N-->0) {

			st= new StringTokenizer(br.readLine(), " ");
			int number=Integer.parseInt(st.nextToken());
			int prat= Integer.parseInt(st.nextToken());
			
//			while(!stack[number].isEmpty() & stack[number].peek()>prat  ) { //  스택이 비어있더라도, '&'이거이기 때문에 검사를 둘다 해야하므로, peek()에서 예외발생
			while(!stack[number].isEmpty() && stack[number].peek()>prat  ) {
				
				stack[number].pop();
				count++;
			}
			if(stack[number].isEmpty() || (!stack[number].isEmpty()&&stack[number].peek() <prat)) {
				stack[number].push(prat);
				count++;
			}
			
			
			
		}// end of while
		
		System.out.println(count);
		
		
		
	}
}
