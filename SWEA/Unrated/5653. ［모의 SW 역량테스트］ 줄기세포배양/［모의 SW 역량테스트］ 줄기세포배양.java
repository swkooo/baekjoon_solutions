import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//5653. [모의 SW 역량테스트] 줄기세포배양
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			//BFS용 pq... 생명력 수치가 높은 줄기 세포가 먼저 차지하도록
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
			
			int[][] grid = new int[N + 1000][M + 1000];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int temp = Integer.parseInt(st.nextToken());
					grid[500 + i][500 + j] = temp;
					if(temp != 0)
						// row, col, 원래값, 활성화 전 x시간 지난 후, 활성화되고 x시간 지난 후 
						pq.offer(new int[] {(500 + i), (500 + j), temp, temp, temp});
					}
			}
			
			// BFS
			while(!pq.isEmpty() && K > 0) {
				int size = pq.size();
				
				// 임시 저장 리스트
				List<int[]> tempList = new ArrayList<>();
				
				for (int i = 0; i < size; i++) {
					int[] curr = pq.poll();
					
					if(curr[3] > 0) {
						curr[3]--;
						tempList.add(curr);
					}
					
					else {						
						for (int d = 0; d < 4; d++) {
							int moveRow = curr[0] + dr[d];
							int moveCol = curr[1] + dc[d];
							
							if(grid[moveRow][moveCol] == 0) {
								grid[moveRow][moveCol] = curr[2];
								tempList.add(new int[] {moveRow, moveCol, curr[2], curr[2], curr[2]});
							}
						}
						if(curr[4] > 1) {
							curr[4]--;
							tempList.add(curr);
						}
					}
				}//size만큼 반복
				
				// 임시 저장 리스트 값을 다시 pq에 추가
				for(int[] temp : tempList) {
					pq.add(temp);
				}
				
				K--;
			}//BFS
			
			sb.append("#").append(tc).append(" ").append(pq.size()).append("\n");
		}//tc
		System.out.println(sb);
		
		
	}//main
	
	// 델타 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

}
