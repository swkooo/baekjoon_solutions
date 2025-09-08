import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//미로2
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());

			int[][] maze = new int[100][100];	// 미로 입력받기

			int[] start = new int[2];	// 미로 출발 지점
			for (int i = 0; i < 100; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					maze[i][j] = line[j] - '0';
					if (line[j] == '2') {	// 출발지점이면 start 에 넣기
						start = new int[] { i, j };
					}
				}
			}

			ArrayDeque<int[]> dq = new ArrayDeque<>();	// bfs 탐색할 queue
			dq.add(start);	// queue에 시작지점 넣기

			// 델타 탐색.. 상하좌우
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int[] temp = new int[2];	// 델타탐색한 좌표 받을 임시 int[];

			boolean isFound = false;	// 도착점을 찾았는지 확인
			while (!dq.isEmpty() && !isFound) {	// dq에 탐색할 부분이 남아있거나 도착점을 찾지 못했으면 계속 반복
				int size = dq.size();
				// dq 사이즈만큼 반복
				for (int i = 0; i < size; i++) {
					int[] curr = dq.poll();	// 일단 좌표 하나 꺼내서

					for (int d = 0; d < 4; d++) {	// 델타탐색
						int moveRow = curr[0] + dr[d];
						int moveCol = curr[1] + dc[d];

						if (maze[moveRow][moveCol] == 3) {	// 델타탐색 좌표 값이 3이면 
							isFound = true;	// 도착점 찾았으니 break;
							break;
						}

						if (maze[moveRow][moveCol] == 0) {	// 미로 길이 상하좌우에 있으면
							temp = new int[] { moveRow, moveCol };
							dq.add(temp);	// dq에 넣고
							maze[moveRow][moveCol] = 1;	// 갔던 길 벽으로 만들기
						}
					}
				}
			} // bfs 반복문
			if (isFound) {
				sb.append("#" + T + " 1\n");
			}
			else {
				sb.append("#" + T + " 0\n");
			}
		} // tc
		System.out.println(sb);
	}// main
}
