import java.util.*;
import java.io.*;

// N과 M (9)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] line = br.readLine().split(" ");
		
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());			
		}
		Arrays.sort(arr);
		
		answer = new int[M];
		visited = new boolean[N];
		
		DFS(0);
		
		System.out.println(sb);
	}//main
	
	static int N;
	static int M;
	static int[] arr;
	static int[] answer;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void DFS(int depth) {
		// 종료조건
		if(depth == M) {
			for(int i : answer) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀조건
		int prev = 0;
		
		for (int i = 0; i < N; i++) {
			if(!visited[i] & prev != arr[i]) {				
				answer[depth] = arr[i];
				visited[i] = true;
				prev = arr[i];
				
				DFS(depth + 1);
				
				visited[i] = false;				
			}
		}
		
	}//DFS
}
