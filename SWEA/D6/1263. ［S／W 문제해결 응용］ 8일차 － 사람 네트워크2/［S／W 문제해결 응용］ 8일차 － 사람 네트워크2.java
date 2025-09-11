import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1263. [S/W 문제해결 응용] 8일차 - 사람 네트워크2
public class Solution {
	static int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			
			int[][] network = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					network[i][j] = INF;
					if(line[1 + i * N + j].equals("1")) {
						network[i][j] = 1;
					}
				}
			}
			
			// 시작점에 대해서 dist 는 0으로 초기화 start -> start : 0
			for (int i = 0; i < N; i++) {
				network[i][i] = 0;
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 정점 i -----------> 정점 j 경로와
						// 정점 i --> 정점 k -> 정점 j 경로 비교...!
						if (network[i][j] > network[i][k] + network[k][j]) {
							network[i][j] = network[i][k] + network[k][j];
						}
					}
				}
			}
			
			int minSum = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += network[i][j];
				}
				minSum = Math.min(minSum, sum);
			}
			
			System.out.println("#" + tc + " " + minSum);
		}//tc
		
	}//main
}
