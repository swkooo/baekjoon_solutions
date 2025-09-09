import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// 7465. 창용 마을 무리의 개수
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			// 인접리스트 생성
			List<List<Integer>> adjList = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adjList.add(new ArrayList<>());
			}
			
			// 인접리스트 입력받기
			for (int i = 0; i < M; i++) {
				String[] line = br.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				
				adjList.get(a).add(b);	// 방향성이 없으므로 둘다에 추가
				adjList.get(b).add(a);
			}
			
			boolean[] visited = new boolean[N + 1];	// 방문확인 배열
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			
			int cnt = 0;	// 무리 개수
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {	// 방문하지 않은 정점이라면
					cnt++;			// 무리 개수 증가시키고
					dq.offer(i);	// dq에 넣은 뒤
					while(!dq.isEmpty()) {	// dq가 빌때까지 반복
						int curr = dq.poll();	// 일단 꺼내고
						visited[curr] = true;	// 방문처리 후
						
						// 연결된 정점 탐색
						for(int check : adjList.get(curr)) {
							if (!visited[check]) {	// 연결된 정점이 방문하지 않은 정점이라면
								dq.add(check);		// dq에 넣기
							}
						}
					}//연결확인 반복문
				}//if
			}//전체정점 순회for문
			sb.append("#" + tc + " " + cnt + "\n");
		}//tc
		System.out.println(sb);
	}//main
}
