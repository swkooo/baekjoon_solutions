import java.util.*;
import java.io.*;

//트리의 부모 찾기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		int[] parrent = new int[N + 1];
		
		//BFS
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		
		dq.add(1);
		visited[1] = true;
		
		while (!dq.isEmpty()) {
			int curr = dq.poll();
			
			for (int j : tree.get(curr)) {
				if(!visited[j]) {
					parrent[j] = curr;
					dq.add(j);
					visited[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 2; i <= N; i++) {
			sb.append(parrent[i]).append("\n");
		}
		System.out.println(sb);
		
	}//main
}
