package study;
import java.io.*;
import java.util.*;
/**
 * 회의 종료시간이 빠를 수록 다음 회의가능 시간 많아짐  
 * 회의 종료시간을 기준으로 오름차순 정렬 
 * 현재 종료시간 < 다음 시작시간이면 x 
 * 현재 종료시간 >= 다음 시작시간이면 ㅇ 가능 
 */
public class Study_Baekjoon_1931_회의실배정_실버1_576ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader (System.in));
		int N= Integer.parseInt(br.readLine()); // 회의 수 
		int room[][]= new int[N][2] ; // 시작 ,종료 
		for(int i=0; i<N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " "); 
			room[i][0] = Integer.parseInt(st.nextToken());
			room[i][1] = Integer.parseInt(st.nextToken()); 
			
		}
		// 종료시간 기준 오름차순 
		Arrays.sort(room , (s1,s2)-> {
			if(s1[1]==s2[1])
				return s1[0]- s2[0]; // 종료시간이 같으면 시작시간 오름차순
			return s1[1]-s2[1]; 
		});
		
	
		int index =0 ;
		int count=1; 
		for(int i=index+1; i<N ;i++) {
			if(room[i][0] >= room[index][1]) { // 다음 시작시간 > 현재 종료시간 
				count++;
				index = i ;
			}
		}
		System.out.println(count);
	} // end of main 
	
}
