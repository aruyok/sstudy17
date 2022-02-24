import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_BOJ_1414_불우이웃돕기_고유라 {
	public static class Computer implements Comparable<Computer> {
		public int len;
		public int computer;
		
		public Computer(int len, int computer) {
			this.len = len;
			this.computer = computer;
		}
		
		public int compareTo(Computer com){
            if(this.len > com.len) {
            	return 1;
            }
            
            if(this.len < com.len) {
            	return -1;
            }
            
            return 0;
        }

	}//end of class computer

	static int n;
	static int[][] lan;
	static int total;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		lan = new int[n][n];
		total = 0;
		int result = -1;
		
		for (int i=0; i<n; i++) {
			String s = sc.next();
			for (int j=0; j<n; j++) {
				char c = s.charAt(j);
				int num = 0;
				
				if ((int)c>=(int)'a' && (int)c<=(int)'z') {
					num = (int)c - (int)'a' + 1;
				} else {
					num = (int)c - (int)'A' + 27;
				}//if else
				
				lan[i][j] = num;
				total += num;
				
			}//end of for j
		}//end of for i
		
		for (int i=0; i<n; i++) {
			result = Math.max(prim(i), result);
		}
		
		System.out.println(result);
		
		
	}//end of main

	public static int prim(int a) {
		int result2 = 0;
		int count = 0;
        boolean[] check = new boolean[n];
        
        PriorityQueue<Computer> q = new PriorityQueue<Computer>();
        q.add(new Computer(0, a));
        
        while(!q.isEmpty()){
            int l = q.peek().len;
            int c = q.peek().computer;
            q.poll();
            
            if(check[c]) {
            	continue;
            }
            
            check[c] = true;
            result2 += l;
            count++;
            
            for(int i = 0; i < n; i++){
                if(lan[c][i] == '0' && lan[i][c] == '0') {
                	continue;
                }
                q.add(new Computer(Math.min(lan[c][i],lan[i][c]), i));
            }
        } //end of wile
        
        if(count < n) {
        	return -1;
        }
        return total - result2;
	}

}//end of class
