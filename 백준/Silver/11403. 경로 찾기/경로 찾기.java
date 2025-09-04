import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 경로 찾기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		// 인풋받을 배열
		lineArr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				lineArr[i][j] = Integer.parseInt(line[j]);
			}
		}

		// 배열 돌면서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				hasRoad = false;
				visited = new boolean[N];
				// dfs 실행
				dfs(i, j);
				// 실행한 결과 길이 있으면 1, 없으면 0 출력
				if (hasRoad) {
					sb.append("1 ");
				} else {
					sb.append("0 ");
				}
			}
			sb.append("\n"); // 개행
		}
		// 출력
		System.out.println(sb);

	}// main

	static int N;
	static int[][] lineArr;
	static boolean hasRoad; // [i, j]가 길이 있는지 없는지 체크
	static boolean[] visited; // 방문체크

	static void dfs(int row, int col) { // i, j를 입력받아
		// 종료부분
		if (visited[col]) { // 목표인 j를 방문했다면
			hasRoad = true; // 길있다고 하고 stop
			return;
		}
		// 재귀부분
		for (int j = 0; j < N; j++) {
			if (!visited[j] && lineArr[row][j] == 1) { // 방문하지 않았고 다른 노드로 향하는 길이 있으면
				visited[j] = true; // 방문체크하고
				dfs(j, col); // 그길로 가보기
			}
		}
	}
}
