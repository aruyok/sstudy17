import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main_백준_15681_트리와쿼리_골드5_조혜진_1576ms {
	private static int[] parent, size;
	private static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

		parent = new int[N+1];
		size = new int[N+1];
        tree = new ArrayList[N+1];
        for (int i = 0, len = tree.length; i < len; i++) {
			tree[i] = new ArrayList<Integer>();
		}
        
        for (int i = 1; i < N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}
        
        MakeTree(R, -1);

        for (int i = 0; i < Q; i++) {
            sb.append(size[Integer.parseInt(br.readLine())]).append("\n");
		}
        System.out.println(sb);
	}

	public static void MakeTree(int currentNode, int p)	{
		int index = 0;
		size[currentNode] = 1;
		
//	    for(int node : tree[currentNode]) {	// java.util.ConcurrentModificationException 에러때문에.. 리스트를 두개쓰면 되지만 그냥..
		while(index < tree[currentNode].size()) {
			int node = tree[currentNode].get(index);
	        if (node != p)	{
				parent[node] = currentNode;
	            MakeTree(node, currentNode);
				tree[currentNode].remove(new Integer(node));
				size[currentNode] += size[node];
	        }
	        else	{
	        	index++;
	        }
	    }
	}
}
