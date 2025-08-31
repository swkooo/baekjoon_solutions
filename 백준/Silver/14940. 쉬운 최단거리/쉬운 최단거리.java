import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

//쉬운 최단거리
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int[][] map = new int[n + 2][m + 2]; // 갈수 없는 땅이 0이므로 상하좌우로 패딩하자

		int[] target = new int[2];
		for (int i = 1; i < n + 1; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = Integer.parseInt(line[j - 1]);
				// 출발지점 찾기
				if (map[i][j] == 2) {
					target = new int[] { i, j }; // target에 저장하고 0으로 변경
					map[i][j] = 0;
				}
			}
		}

		// 탐색좌표 담을 dq와 방문기록할 visisted
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		Set<String> visited = new HashSet<>();
		dq.add(target);
		visited.add(target[0] + " " + target[1]); // String으로 변환해서 visited에 넣기

		// 델타 탐색 (상하좌우)
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int cnt = 0; // 목표지점까지 거리
		while (!dq.isEmpty()) { // 탐색가능한 부분 전부 탐색
			cnt++;

			int size = dq.size();
			// 이번 cnt에서 확인할 dq 사이즈만큼 반복 실행
			for (int i = 0; i < size; i++) {
				int[] check = dq.poll(); // 좌표 꺼내서
				for (int d = 0; d < 4; d++) {
					int moveRow = check[0] + dr[d];
					int moveCol = check[1] + dc[d];
					String visitCheck = moveRow + " " + moveCol;
					// 상하좌우가 0이 아니고 방문한적이 없다면 실행
					if (map[moveRow][moveCol] != 0 && !visited.contains(visitCheck)) {
						map[moveRow][moveCol] = cnt;
						int[] temp = { moveRow, moveCol };
						// dq와 visited에 각각 집어넣기
						dq.add(temp);
						visited.add(visitCheck);
					}
				} // 델타 탐색
			} // dq 반복문

		} // while 반복문

		// 좌표 출력 및 도달할 수 없는 부분 체크
		for (int i = 1; i < n + 1; i++) {	// 패딩한 부분임을 잊지말자
			for (int j = 1; j < m + 1; j++) {
				// 좌표값이 1일 경우
				if (map[i][j] == 1) {
					boolean unReachable = true;	// 도달할 수 있는지 없는지 체크
					// 1값 기준으로 상하좌우 델타 탐색
					for (int d = 0; d < 4; d++) {
						// 만약 상하좌우에 출발지점이 있다면
						if (target[0] == i + dr[d] && target[1] == j + dc[d]) {
							unReachable = false;	// 도달할 수 있는 좌표
						}
					}
					// 아니면 -1로 변경
					if (unReachable) {
						map[i][j] = -1;
					}
				}
				// sb에 추가
				sb.append(map[i][j] + " ");
			}
			// 개행
			sb.append("\n");
		}
		// 출력
		System.out.println(sb);
	}// main
}
