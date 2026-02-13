import java.util.*;
import java.io.*;


//구간 합 구하기 5
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		int[][] board = new int[N][N];
		int[][] boardSum = new int[N + 1][N + 1];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				boardSum[i + 1][j + 1] = board[i][j] + boardSum[i][j + 1] + boardSum[i + 1][j] - boardSum[i][j];
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 합 구하는 공식
			int sum = boardSum[x2][y2] - (boardSum[x2][y1 - 1] + boardSum[x1 - 1][y2]) + boardSum[x1 -1][y1 - 1];

			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}//main
}
