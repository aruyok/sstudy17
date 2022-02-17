import java.util.Scanner;

/* 1. 기본적으로 1/4 > 전체 0이나 1 아니면 또 1/4 ... 
 * 2. 1/4할 때마다 괄호 표시*/
public class Solution_BOJ_1992_쿼드트리_실버1_고유라_332ms {
	static int[][] arr;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		for (int i=0; i<N; i++) {
			String s = sc.next();
			for (int j=0; j<N; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		twoByTwo(0, 0, N); //2X2로 나누기
		
	}//end of main

	private static void twoByTwo(int i, int j, int n) {
		if (n==1) {
			System.out.print(arr[i][j]);
			return;
		}
		boolean b0 = true, b1 = true; //0만 있음, 1만 있음
		
		for (int a=i; a<i+n; a++) {
			for (int b=j; b<j+n; b++) {
				if (arr[a][b]==0) b1 = false;
				if (arr[a][b]==1) b0 = false;
			}
		}
		
		if (b0) { //0만 있을 때
			System.out.print(0);
			return;
		}
		if (b1) { //1만 있을 때
			System.out.print(1);
			return;
		}
		
		System.out.print("(");
		twoByTwo(i,j,n/2);
		twoByTwo(i,j+n/2,n/2);
		twoByTwo(i+n/2,j,n/2);
		twoByTwo(i+n/2,j+n/2,n/2);
		System.out.print(")");
	}//end of twoByTwo

}//end of class