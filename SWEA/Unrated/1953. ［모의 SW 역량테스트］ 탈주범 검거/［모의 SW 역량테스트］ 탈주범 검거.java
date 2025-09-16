import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

//1953. [모의 SW 역량테스트] 탈주범 검거
public class Solution {
	public static void main(String[] args) throws IOException {
		tunnel = new ArrayList<>();
		for (int i = 0; i <= 7; i++) {
			tunnel.add(new ArrayList<>());
		}
		// 1번 터널
		tunnel.get(1).add(new HashSet<>(Arrays.asList(1, 2, 5, 6)));	// 상방향 연결
		tunnel.get(1).add(new HashSet<>(Arrays.asList(1, 2, 4, 7)));	// 하방향 연결
		tunnel.get(1).add(new HashSet<>(Arrays.asList(1, 3, 4, 5)));	// 좌방향 연결
		tunnel.get(1).add(new HashSet<>(Arrays.asList(1, 3, 6, 7)));	// 우방향 연결
		
		// 2번 터널
		tunnel.get(2).add(new HashSet<>(Arrays.asList(1, 2, 5, 6)));	// 상방향 연결
		tunnel.get(2).add(new HashSet<>(Arrays.asList(1, 2, 4, 7)));	// 하방향 연결
		tunnel.get(2).add(new HashSet<>());								// 좌방향 연결X
		tunnel.get(2).add(new HashSet<>());								// 우방향 연결X
			
		// 3번 터널
		tunnel.get(3).add(new HashSet<>());								// 상방향 연결X
		tunnel.get(3).add(new HashSet<>());								// 하방향 연결X
		tunnel.get(3).add(new HashSet<>(Arrays.asList(1, 3, 4, 5)));	// 좌방향 연결
		tunnel.get(3).add(new HashSet<>(Arrays.asList(1, 3, 6, 7)));	// 우방향 연결
		
		// 4번 터널
		tunnel.get(4).add(new HashSet<>(Arrays.asList(1, 2, 5, 6)));// 상방향 연결
		tunnel.get(4).add(new HashSet<>());							// 하방향 연결X
		tunnel.get(4).add(new HashSet<>());							// 좌방향 연결X
		tunnel.get(4).add(new HashSet<>(Arrays.asList(1, 3, 6, 7)));// 우방향 연결
		
		// 5번 터널
		tunnel.get(5).add(new HashSet<>());							// 상방향 연결X
		tunnel.get(5).add(new HashSet<>(Arrays.asList(1, 2, 4, 7)));// 하방향 연결
		tunnel.get(5).add(new HashSet<>());							// 좌방향 연결X
		tunnel.get(5).add(new HashSet<>(Arrays.asList(1, 3, 6, 7)));// 우방향 연결
		
		// 6번 터널
		tunnel.get(6).add(new HashSet<>());							// 상방향 연결X
		tunnel.get(6).add(new HashSet<>(Arrays.asList(1, 2, 4, 7)));// 하방향 연결
		tunnel.get(6).add(new HashSet<>(Arrays.asList(1, 3, 4, 5)));// 좌방향 연결
		tunnel.get(6).add(new HashSet<>());							// 우방향 연결X
		
		// 7번 터널
		tunnel.get(7).add(new HashSet<>(Arrays.asList(1, 2, 5, 6)));// 상방향 연결
		tunnel.get(7).add(new HashSet<>());							// 하방향 연결X
		tunnel.get(7).add(new HashSet<>(Arrays.asList(1, 3, 4, 5)));// 좌방향 연결
		tunnel.get(7).add(new HashSet<>());							// 우방향 연결X
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N + 2][M + 2];	// 상하좌우 패딩
			
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < M + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//지도입력받기
			
			//방문체크를 위한 visited 생성
			boolean[][] visited = new boolean[N + 2][M + 2];
			
			//bfs를 위한 queue
			ArrayDeque<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] {R + 1, C + 1});	// 시작지점 넣기
			visited[R + 1][C + 1] = true;	// 방문체크
			
			int cnt = 0;	// 있을 수 있는 터널 세기
			while(!queue.isEmpty() && L > 0) {	// 갈 곳과 시간이 남아있다면..
				L--;	// 시간 줄이고
				int size = queue.size();
				
				for (int i = 0; i < size; i++) {	// queue 사이즈만큼 반복
					int[] curr = queue.poll();		// 일단 하나 꺼내서
					cnt++;							// 갈 수 있는 곳이니깐 +1
//					System.out.print("curr: " + Arrays.toString(curr));
//					System.out.println(" value: " + map[curr[0]][curr[1]]);
					
					for (int d = 0; d < 4; d++) {	// 델타탐색
						int moveRow = curr[0] + dr[d];
						int moveCol = curr[1] + dc[d];
						
						if (map[moveRow][moveCol] != 0) {	// 일단 터널이 있는지 확인
//							System.out.print("check: " + moveRow + " " + moveCol);
//							System.out.println("/ value: " + map[moveRow][moveCol]);
							// 현재터널과 이동하려는 터널이 연결가능하고 방문하지 않았다면
							if (isValid(map[curr[0]][curr[1]], d, map[moveRow][moveCol]) && !visited[moveRow][moveCol]) {
								queue.add(new int[] {moveRow, moveCol});	// 큐에넣고
								visited[moveRow][moveCol] = true;			// 방문체크
							}
						}
					}			
				}//queue 반복문
			}//while반복문
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}//tc
		System.out.println(sb);
	}//main
	
	//델타탐색(상하좌우)
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static List<List<HashSet<Integer>>> tunnel;
	
	// 가려고 하는 방향의 파이프가 서로 연결되어 있는지 아닌지 확인 함수
	static boolean isValid(int curr, int dir, int next) {
		if (tunnel.get(curr).get(dir).contains(next))
			return true;
		
		else
			return false;
	}
	
}
