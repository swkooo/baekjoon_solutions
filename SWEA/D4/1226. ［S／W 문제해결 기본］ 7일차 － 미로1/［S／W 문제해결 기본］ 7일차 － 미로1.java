import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//1226. [S/W 문제해결 기본] 7일차 - 미로1
public class Solution {

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

	// 델타 탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N = 16;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());

			char[][] maze = new char[N][N];

			Node start = new Node(-1, -1);

			// 미로 입력받기
			for (int i = 0; i < 16; i++) {
				maze[i] = br.readLine().toCharArray();
				if (start.row == -1) { // 시작점 못찾았을 때만
					for (int j = 0; j < 16; j++) {
						if (maze[i][j] == '2') {	// 시작지점
							start = new Node(i, j);
						}
					}
				}
			}
			// 미로탐색을 위한 queue생성
			ArrayDeque<Node> dq = new ArrayDeque<>();
			dq.offer(start);

			boolean isFound = false;	// 도착지점 찾았는지 여부체크
			while (!dq.isEmpty() && !isFound) {
				int size = dq.size();
				for (int i = 0; i < size; i++) {
					Node curr = dq.poll();
					maze[curr.row][curr.col] = '1';	// 방문한 좌표 1(벽)으로 변환

					for (int d = 0; d < 4; d++) {	// 델타탐색
						int moveRow = curr.row + dr[d];
						int moveCol = curr.col + dc[d];

						if (maze[moveRow][moveCol] == '3') {	// 도착지점 발견하면 break;
							isFound = true;
							break;
						}
						if (maze[moveRow][moveCol] == '0')		// 길이 있으면 queue에 추가하기
							dq.add(new Node(moveRow, moveCol));
					}
				}
			}//미로찾기while
			if (isFound) {	// 찾았으면 1출력
				sb.append("#" + T + " 1\n");
			}
			else			// 아니면 0
			sb.append("#" + T + " 0\n");
		} // tc
		//출력
		System.out.println(sb);
	}// main
}
