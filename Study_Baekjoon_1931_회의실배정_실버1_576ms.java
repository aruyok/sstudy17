package study;
import java.io.*;
import java.util.*;
/**
 * ȸ�� ����ð��� ���� ���� ���� ȸ�ǰ��� �ð� ������  
 * ȸ�� ����ð��� �������� �������� ���� 
 * ���� ����ð� < ���� ���۽ð��̸� x 
 * ���� ����ð� >= ���� ���۽ð��̸� �� ���� 
 */
public class Study_Baekjoon_1931_ȸ�ǽǹ���_�ǹ�1_576ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader (System.in));
		int N= Integer.parseInt(br.readLine()); // ȸ�� �� 
		int room[][]= new int[N][2] ; // ���� ,���� 
		for(int i=0; i<N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " "); 
			room[i][0] = Integer.parseInt(st.nextToken());
			room[i][1] = Integer.parseInt(st.nextToken()); 
			
		}
		// ����ð� ���� �������� 
		Arrays.sort(room , (s1,s2)-> {
			if(s1[1]==s2[1])
				return s1[0]- s2[0]; // ����ð��� ������ ���۽ð� ��������
			return s1[1]-s2[1]; 
		});
		
	
		int index =0 ;
		int count=1; 
		for(int i=index+1; i<N ;i++) {
			if(room[i][0] >= room[index][1]) { // ���� ���۽ð� > ���� ����ð� 
				count++;
				index = i ;
			}
		}
		System.out.println(count);
	} // end of main 
	
}
