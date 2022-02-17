package study;
import java.io.*;
import java.util.*;


public class Study_Baekjoon_15681_트리와쿼리_골드5_2332ms {
	
	public static LinkedList<Integer>[] adjList;
	public static LinkedList<Integer>[] subList;
	public static int[] parent;
	public static int[] size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		// 정점 정보 
		adjList = new LinkedList[N+1];
		
		//자식노드
		subList = new LinkedList[N+1];
		
		parent = new int[N+1];
		size = new int[N+1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
			subList[i] = new LinkedList<Integer>();
		}

		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);  // 각각 연결관계 저장 
			adjList[b].add(a);
		}
		
		makeTree(R, -1); // 루트노드 ( 부모없음 ) 
		countSubTree(R);

		for(int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());

			System.out.println(size[q]);
		}

	}

	public static void makeTree(int cur, int p) { // 현재노드, 부모노드 -> 트리만들기 
		for(int next : adjList[cur]) {// 현재노드와 연결된 노드들 
			if(next != p) { //자식노드이면 
				subList[cur].add(next);
				parent[next] = cur; 
				makeTree(next, cur);
			}
		}
	}

	public static void countSubTree(int cur) { // 서브트리의 노드 수 세기
		size[cur] = 1; // 자기자신도 서브트리에 포함 

		for(int next : subList[cur]) {
			countSubTree(next);
			size[cur] += size[next];	
		}
	}
} // end of class 
