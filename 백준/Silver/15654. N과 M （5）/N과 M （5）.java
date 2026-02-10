import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (5)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		answer = new int[M];
		visited= new boolean[N];
		
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
		// 종료부분
		if(depth == M) {
			for(int i : answer) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 재귀부분
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				answer[depth] = arr[i];
				visited[i] = true;
				DFS(depth + 1);
				visited[i] = false;
			}
		}
		
	}
}
