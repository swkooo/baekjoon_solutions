import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 단지번호붙이기... 너무 쓰레기같이 푼 것 같음
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		List<int[]> houseList = new ArrayList<>();
		int[][] map = new int[N + 2][N + 2]; // 상하좌우 패딩

		for (int i = 1; i <= N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				int check = line[j - 1] - '0';
				if (check == 1) {
					map[i][j] = check;
					int[] temp = { i, j };
					houseList.add(temp);
				}
			}
		}

		// 델타 탐색 ... 상하좌우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int houseCnt = 0;
		List<Integer> cntList = new ArrayList<>();
		for (int[] arr : houseList) {
			if (map[arr[0]][arr[1]] == 1) {
				houseCnt++;
				map[arr[0]][arr[1]] = 0;
				ArrayDeque<int[]> dq = new ArrayDeque<>();
				dq.add(arr);
				
				while (!dq.isEmpty()) {
					int[] curr = dq.poll();
					for (int d = 0; d < 4; d++) {
						
						int checkRow = curr[0] + dr[d];
						int checkCol = curr[1] + dc[d];
						
						if (map[checkRow][checkCol] == 1) {
							houseCnt++;
							map[checkRow][checkCol] = 0;
							int[] temp = { checkRow, checkCol };
//							System.out.println(Arrays.toString(temp));
							dq.add(temp);
						}
					}			
				}//bfs 탐색
			}

			if(houseCnt != 0) {
				cntList.add(houseCnt);
				houseCnt = 0;
			}
		}
		Collections.sort(cntList);
		System.out.println(cntList.size());
		
		for (int cnt : cntList) {
			System.out.println(cnt);
		}
	}// main
}
