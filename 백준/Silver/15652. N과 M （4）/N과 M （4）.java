import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N과 M (4)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		
		arr = new int[M];
		
		DFS(0, 1, arr);
		System.out.println(sb);
	}
	
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb;
	
	public static void DFS(int cnt, int curr, int[] answer) {
		// 종료부분
		if(cnt == M) {
			for(int i : answer) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		// 재귀부분
		for (int i = curr; i <= N; i++) {
			answer[cnt] = i;
			DFS(cnt + 1, i, answer);
		}
	}
}
