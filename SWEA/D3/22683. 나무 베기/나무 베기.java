import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 22683. 나무 베기
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 이동횟수 카운트를 위해 델타이동 시 방향전환에 따라 매핑
		cntMap = new HashMap<>();
		cntMap.put(0, 1);	// 방향 그대로
		cntMap.put(1, 2);	// 좌회전or우회전 1번
		cntMap.put(2, 3);	// 2번
		cntMap.put(3, 2);	// 1번
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new char[N][N];
			start = new int[2];
			end = new int[2];
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					char field = line[j];
					map[i][j] = field;
					if (field == 'X') {
						start = new int[] { i, j };
					}
					if (field == 'Y') {
						end = new int[] { i, j };
					}
				}
			} // 입력받기
			
			// 방문배열 & 최솟값 초기화, 시작지점 방문체크
			visited = new boolean[N][N];
			visited[start[0]][start[1]] = true;
			minCnt = Integer.MAX_VALUE;
			// DFS 실행
			DFS(start, 0, 0, 0);
			
			// 이동할 수 가 없어 minCnt가 갱신되지 않았으면 -1로 설정
			if (minCnt == Integer.MAX_VALUE) {
				minCnt = -1;
			}
			sb.append("#").append(tc).append(" ").append(minCnt).append("\n");
		}//tc
		System.out.println(sb);
	}// main

	// 델타탐색
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	static Map<Integer, Integer> cntMap;
	
	static int N;
	static int K;
	static int[] start;
	static int[] end;
	static char[][] map;
	static boolean[][] visited;
	static int minCnt;
	
	// DFS 탐색 기본
	static void DFS(int[] curr, int cnt, int tree, int currD) {
		// 종료파트
		if (cnt > minCnt || tree > K) {	// cnt가 최소이동값을 넘었거나 벨 수 있는 tree 를 넘었다면 stop
			return;
		}
		if (curr[0] == end[0] && curr[1] == end[1]) {	// 도착지점에 도달했다면
			minCnt = Math.min(minCnt, cnt);	// 최소이동값 갱신하고 stop
			return;
		}
		// 재귀파트
		for (int d = 0; d < 4; d++) {
			int moveRow = curr[0] + dr[d];
			int moveCol = curr[1] + dc[d];
			if (moveRow >= 0 && moveRow < N && moveCol >= 0 && moveCol < N && !visited[moveRow][moveCol]) { // 바운더리 설정
				visited[moveRow][moveCol] = true; // 방문처리하고
				int temp = cntMap.get(Math.abs(currD - d));	// 델타이동 방향전환에 따른 보정값
				cnt += temp;	// 이동횟수 증가
				if(map[moveRow][moveCol] == 'T') {	// 이동지점이 나무일때만 tree 증가
					tree++;
					DFS(new int[] {moveRow, moveCol}, cnt, tree, d);	// 재귀
					tree--;	// 백트래킹
				}
				else {
					DFS(new int[] {moveRow, moveCol}, cnt, tree, d);
				}
				cnt -= temp;	// 백트래킹
				visited[moveRow][moveCol] = false;	// 백트래킹
			}
		}
	}
}
