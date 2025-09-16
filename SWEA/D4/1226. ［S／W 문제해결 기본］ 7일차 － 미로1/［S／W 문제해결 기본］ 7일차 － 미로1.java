import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//1226. [S/W 문제해결 기본] 7일차 - 미로1
public class Solution {
	// 델타 탐색
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, 1, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			sb.append("#" + T);
			
			char[][] maze = new char[16][16];
			int[] start = new int[2];
			int[] end = new int[2];
			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					char num = line.charAt(j);
					maze[i][j] = num;
					if (num == '2')
						start = new int[] { i, j };					
					if (num == '3')
						end = new int[] { i, j };
				}
			}
			
			// bfs용 queue
			ArrayDeque<int[]> queue = new ArrayDeque<>();
			queue.offer(start);
			
			boolean isFound = false;
			while (!queue.isEmpty() && !isFound) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int[] curr = queue.poll();
					maze[curr[0]][curr[1]] = '1';

					for (int d = 0; d < 4; d++) {
						int moveRow = curr[0] + dr[d];
						int moveCol = curr[1] + dc[d];
						if (moveRow == end[0] && moveCol == end[1]) {
							isFound = true;
							break;
						}

						if (maze[moveRow][moveCol] == '0')
							queue.add(new int[] { moveRow, moveCol });						
					}
					if (isFound)
						break;
				}//queue반복문
			}//while반복문
			if (isFound)
				sb.append(" 1\n");			
			else 
				sb.append(" 0\n");			
		} // tc
		System.out.println(sb);
	}// main
}
