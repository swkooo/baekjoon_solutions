import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//치즈도둑
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int maxDay = 0;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N + 2][N + 2];	// 상하좌우 패딩
			
			for (int i = 1; i <= N; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(line[j - 1]);
					maxDay = Math.max(maxDay, map[i][j]);	// 최대반복 day 일 구하기
				}
			}
			
			// 델타탐색
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			int[] temp = new int[2];
			
			int maxCnt = 1;	// 최대 치즈 덩어리 개수
			for (int day = 1; day <= maxDay; day++) {
												
				// madDay일 동안 해당되는 칸 갉아먹기
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (map[i][j] == day) {
							map[i][j] = 0;
						}
					}
				}
				
				// bfs
				ArrayDeque<int[]> dq = new ArrayDeque<>();
				boolean[][]	visited = new boolean[N+2][N+2];	// 방문배열 생성
				// 덩어리 개수 측정
				int cnt = 0;
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						// 치즈가 있고 방문하지 않았더라면
						if (map[i][j] != 0 && !visited[i][j]) {
							temp = new int[] {i, j};
							dq.add(temp);	// dq에 좌표 값 넣고
							visited[i][j] = true;	// 방문처리 후
							cnt++;	// 덩어리 개수 증가
							
							// 해당 치즈에 대해 bfs으로 이어진 치즈 탐색
							while(!dq.isEmpty()) {
								int size = dq.size();
								
								for (int k = 0; k < size; k++) {
									int[] curr = dq.poll();
									
									// 델타탐색
									for (int d = 0; d < 4; d++) {
										int moveRow = curr[0] + dr[d];
										int moveCol = curr[1] + dc[d];
										
										// 치즈가 있고 방문핮 ㅣ않았더라면
										if (map[moveRow][moveCol] != 0 && !visited[moveRow][moveCol]) {
											int[] move = new int[] {moveRow, moveCol};
											// dq에 넣고 방문처리
											dq.add(move);
											visited[moveRow][moveCol] = true;
										}
									}
								}								
							}//bfs 반복문
							
						}
					}
				}//map좌표 배열 탐색
				maxCnt = Math.max(maxCnt, cnt);	// max덩어리개수 갱신
				
			}//100일 반복문
			System.out.println("#" + tc + " " + maxCnt);
			
			
		}//tc
		
	}// main
}
