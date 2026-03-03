import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		tree = new char[N + 1][3];
		
		for(int i = 1; i < N + 1; i++) {
			char[] line = br.readLine().toCharArray();
				
			int idx = line[0] - 64;
			tree[idx][0] = line[0];
			tree[idx][1] = line[2];
			tree[idx][2] = line[4];
		}
		
		DFS('A', 'F');
		sb.append("\n");

		DFS('A', 'M');
		sb.append("\n");
		
		DFS('A', 'B');
		
		System.out.println(sb);
		
	}//main
	static char[][] tree;
	static StringBuilder sb;
	
	public static void DFS(char curr, char method) {
		//종료파트
		if(curr == '.') {
			return;
		}
		
		//재귀파트
		int idx = curr - 64;
//		System.out.println(idx);
		if(method == 'F') {
			sb.append(tree[idx][0]);
			DFS(tree[idx][1], method);
			DFS(tree[idx][2], method);
		}
		if(method == 'M') {
			DFS(tree[idx][1], method);
			sb.append(tree[idx][0]);
			DFS(tree[idx][2], method);
		}
		if(method == 'B') {
			DFS(tree[idx][1], method);
			DFS(tree[idx][2], method);
			sb.append(tree[idx][0]);
		}
	}
	
}
