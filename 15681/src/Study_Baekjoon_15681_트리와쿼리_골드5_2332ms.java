package study;
import java.io.*;
import java.util.*;


public class Study_Baekjoon_15681_Ʈ��������_���5_2332ms {
	
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

		// ���� ���� 
		adjList = new LinkedList[N+1];
		
		//�ڽĳ��
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

			adjList[a].add(b);  // ���� ������� ���� 
			adjList[b].add(a);
		}
		
		makeTree(R, -1); // ��Ʈ��� ( �θ���� ) 
		countSubTree(R);

		for(int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());

			System.out.println(size[q]);
		}

	}

	public static void makeTree(int cur, int p) { // ������, �θ��� -> Ʈ������� 
		for(int next : adjList[cur]) {// ������� ����� ���� 
			if(next != p) { //�ڽĳ���̸� 
				subList[cur].add(next);
				parent[next] = cur; 
				makeTree(next, cur);
			}
		}
	}

	public static void countSubTree(int cur) { // ����Ʈ���� ��� �� ����
		size[cur] = 1; // �ڱ��ڽŵ� ����Ʈ���� ���� 

		for(int next : subList[cur]) {
			countSubTree(next);
			size[cur] += size[next];	
		}
	}
} // end of class 
