import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

//1249. [S/W 문제해결 응용] 4일차 - 보급로
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = line[j] - '0';
				}
			}

			// 델타이동
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			// dist 배열 초기화 (맥스값으로)
			int[][] dist = new int[N][N];
			for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

			// 최소힙 생성
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

			// 시작점 설정 (비용, 행, 열)
			dist[0][0] = 0;
			pq.offer(new int[]{0, 0, 0});

			while (!pq.isEmpty()) {
			    int[] current = pq.poll();
			    int cost = current[0];
			    int curRow = current[1];
			    int curCol = current[2];

			    // 이미 더 짧은 경로가 발견된 경우 스킵
			    if (cost > dist[curRow][curCol]) {
			        continue;
			    }

			    // 도착 지점 도달 시 종료
			    if (curRow == N - 1 && curCol == N - 1) {
			        break;
			    }

			    // 4방향 탐색
			    for (int d = 0; d < 4; d++) {
			        int moveRow = curRow + dr[d];
			        int moveCol = curCol + dc[d];

			        // 유효성 검사 및 최단 경로 갱신
			        if (moveRow >= 0 && moveRow < N && moveCol >= 0 && moveCol < N) {
			            int newCost = dist[curRow][curCol] + map[moveRow][moveCol];
			            if (newCost < dist[moveRow][moveCol]) {
			                dist[moveRow][moveCol] = newCost;
			                pq.offer(new int[]{newCost, moveRow, moveCol});
			            }
			        }
			    }
			}

			// 결과 출력
			System.out.println("#" + tc + " " + dist[N - 1][N - 1]);
		} // tc

	}// main
}
