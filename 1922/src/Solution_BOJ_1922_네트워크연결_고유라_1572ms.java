import java.util.Arrays;
import java.util.Scanner;

/* 1. 가중치 오름차순 정렬
 * 2. 가중치 최소 노드 두개 찾고
 * 3. 부모가 같으면 사이클 다르면 그 간선 선택 */

class computer implements Comparable<computer>{ //간선 클래스
	int x,y;
	int cost;
	
	public computer(int x, int y, int cost) {
		super();
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(computer o) {
		return this.cost-o.cost;
	}
	
}//end of com class

public class Solution_BOJ_1922_네트워크연결_고유라_1572ms {
	static int n;
	static int m;
	static int[] parent;
	static computer[] cList;
	static int cnt;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n = sc.nextInt(); // 컴퓨터 수
		m = sc.nextInt(); // 연결할 수 있는 선의 수
		parent = new int[n+1];
		
		for (int i = 1; i<=n; i++) {
			parent[i] = i;
		}
		
		cList = new computer[m];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(); // 컴퓨터 a
			int b = sc.nextInt(); // 컴퓨터 b
			int c = sc.nextInt(); // 연결 비용
			cList[i] = new computer(a,b,c);
		}
		
		Arrays.sort(cList);
		
		for(computer com: cList) {
			union(com.x, com.y, com.cost);
			if(cnt == n-1) {
				break;
			}
		}
		System.out.println(result);
		
	}//end of main
	
	public static void union(int x, int y, int cost) { //간선 선택
		x = search(x);
		y = search(y);
		
		if(x!= y) { //둘이 사이클 아니면
			result += cost;
			cnt++;
			
			if(x < y) { // 위에 있는 애를 부모로 
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}//end of if
		
	}//end of union

	public static int search(int x) {
		if(x == parent[x]) { //어디에도 이어지지 않았으면 바로 리턴
			return x;
		} else { //아니면 재귀로 최상위 노드 찾기
			return parent[x] = search(parent[x]);
		}
	}//end of search

}//end of class
