import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_13335_트럭_실버1_조혜진_96ms {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int n = Integer.parseInt(st.nextToken()); // n (1 ≤ n ≤ 1,000)  : 다리를 건너는 트럭의 수
	    int w = Integer.parseInt(st.nextToken()); // w (1 ≤ w ≤ 100)    : 다리의 길이
	    int L = Integer.parseInt(st.nextToken()); // L (10 ≤ L ≤ 1,000) : 다리의 최대하중
	    
	    int[] truck = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
	    for (int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}	// 입력 끝
	    
	    Queue<Integer> b = new LinkedList<Integer>();
	    int time = 1;
	    int truckCnt = 0;	// 다 넘어간 트럭
	    int temp;
	    int index = 1;
	    int weight = truck[0];
	    
	    // 처음 트럭은 올라와있으니까
	    b.offer(truck[0]);
	    while (truckCnt < n) {
	    	if (b.size() >= w)	{
	    		temp = b.poll();
	    		if (temp != 0) {
	    			truckCnt++;
	    			weight -= temp;
	    		}    		
	    	}
	    	
	    	if (index < n && truck[index] + weight <= L)	{
	    		weight += truck[index];
		    	b.offer(truck[index++]);
	    	}
	    	else {
	    		b.offer(0);
	    	}	    	
	    	time++;
	    }
	    
	    System.out.println(time);
	}
}
