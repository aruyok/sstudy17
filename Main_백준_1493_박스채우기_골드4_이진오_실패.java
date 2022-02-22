import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_1493_박스채우기_골드4_이진오_실패
 * 
 * 
 *  - 분할 정복
 *    : 예시는 다 맞았는데, 통과를 못함..
 * 
 */
public class Main_백준_1493_박스채우기_골드4_이진오_실패 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int l = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cubeSizes = new int[N];
		int[] cubeCount = new int[N];
		
		for (int i = N-1; i >= 0; i--) { // 큰 사이즈부터 처리
			st = new StringTokenizer(br.readLine(), " ");
			cubeSizes[i] = 1<<Integer.parseInt(st.nextToken());
			cubeCount[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dq(0, l, w, h, cubeSizes, cubeCount));
		
		
	} // end of main
	
	public static int dq(int index, int l, int w, int h, int[] cubeSizes, int[] cubeCount) {
		// 기저 조건 - index가 끝이며, l, w, h가 남아있다. 
		if (index == cubeSizes.length) {
			if (l > 0 && w > 0 && h > 0) return -1;
			return 0;
		}
		
		// index 큐브의 사이즈
		int size = cubeSizes[index];
		
		// 가능한 분할 수(l, w, h 기준)
		int dl = l / size; // 10^6, size = 1
		int dw = w / size;
		int dh = h / size;
		
		// 0. 사용 불가능 (dl*dw*dh == 0) -> 다음 index로 넘긴다. 
		if (dl == 0 || dw == 0 || dh == 0) {
			return dq(index+1, l, w, h, cubeSizes, cubeCount);
		}
		
		// 1. 전체 크기 사용 가능 (dl*dw*dh 만큼)
		long count = (long)dl*dw*dh;
		if (cubeCount[index] >= count) {
			cubeCount[index] -= count;
			
			int temp1 = dq(index+1, l-dl*size, w, h, cubeSizes, cubeCount);
			int temp2 = dq(index+1, dl*size, w-dw*size, h, cubeSizes, cubeCount);
			int temp3 = dq(index+1, dl*size, dw*size, h-dh*size, cubeSizes, cubeCount);
			
			if (temp1 < 0 || temp2 < 0 || temp3 < 0) return -1;
			
			// 전체 크기가 사용 가능하다면, count는 10^6보다 작거나 같다. 
			return (int) count + temp1 + temp2 + temp3;
		}
		
		// 2-1. 일부 사용 가능 (가능한 층수 = cubeCount[index] / (dw*dh))
		int result = 0;
		long lcount = dw*dh;
		int nl = (int) (cubeCount[index] / lcount);
		int modl = (int) (cubeCount[index] - nl*lcount);
		if (cubeCount[index] >= lcount) {
			cubeCount[index] -= nl*lcount;
			
			int temp1 = dq(index+1, nl*size, w-dw*size, h, cubeSizes, cubeCount);
			int temp2 = dq(index+1, nl*size, dw*size, h-dh*size, cubeSizes, cubeCount);
			if (temp1 < 0 || temp2 < 0) return -1;
			
			// 층이 사용 가능하다면, lcount는 10^6보다 작거나 같다. 
			result = (int) (nl*lcount) + temp1 + temp2;
		}
		
		// 2-2. 하나의 층 내 일부만 사용 가능 (가능한 줄 수 = cubeCount[index] / dh)
		int wcount = dh;
		int nw = cubeCount[index] / wcount;
		int modw = cubeCount[index] - nw*wcount; 
		if (cubeCount[index] >= wcount) {
			cubeCount[index] -= nw*wcount;
			
			int temp1 = dq(index+1, size, nw*size, h-dh*size, cubeSizes, cubeCount);
			if (temp1 < 0) return -1;
			
			result += nw*wcount + temp1;
		}
		
		// 2-3. 하나의 줄 내 일부만 사용 가능 (가능한 개수 = cubeCount[index])
		int nh = cubeCount[index];
		if (cubeCount[index] > 0) {
			cubeCount[index] = 0;
			
			int temp = dq(index+1, size, size, h-nh*size, cubeSizes, cubeCount);
			if (temp < 0) return -1;
			
			result += nh + temp;
		}
		
		// 처리하고 남은 공간
		if (modw != 0) nw++;
		if (modl != 0) nl++;
		int temp1 = dq(index+1, size, w-nw*size, h, cubeSizes, cubeCount);
		int temp2 = dq(index+1, l-nl*size, w, h, cubeSizes, cubeCount);
		if (temp1 < 0 || temp2 < 0) return -1;
		return result + temp1 + temp2;
	} // end of dq
	
} // end of class
