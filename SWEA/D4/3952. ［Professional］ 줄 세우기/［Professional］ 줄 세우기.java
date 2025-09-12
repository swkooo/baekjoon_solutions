import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//3952. [Professional] 줄 세우기
public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc);
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			int[] inDegree = new int[N + 1];	// 진입차수 배열
			List<List<Integer>> adjList = new ArrayList<>(N + 1);	//인접리스트
			for (int i = 0; i < N + 1; i++) {	// 인접리스트 초기화
				adjList.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M; i++) {
				String[] line = br.readLine().split(" ");
				int from = Integer.parseInt(line[0]);
				int to = Integer.parseInt(line[1]);
				// 인접리스트에 연결정보 받으면서 진입차수 증가
				adjList.get(from).add(to);
				inDegree[to]++;
			}

			ArrayDeque<Integer> queue = new ArrayDeque<>(); // 위상정렬을 위한 queue생성
			for (int i = 1; i < N + 1; i++) {
				if (inDegree[i] == 0)	// 진입차수가 0이면 queue에 일단 넣어놓기 
					queue.offer(i);
			}
			
			// queue가 빌때까지
			while(!queue.isEmpty()) {
				int curr = queue.poll();	// 꺼내서
				sb.append(" " + curr);		// 출력에 넣고
				
				for (int next : adjList.get(curr)) {	// 인접한 노드 찾아서
					inDegree[next]--;					// 진입차수 줄이고
					if (inDegree[next] == 0) {			// 줄어든 진입차수가 0이면
						queue.offer(next);				// 큐에 넣기
					}
				}
			}// 위상정렬반복문
			sb.append("\n");	// 개행
		}//tc
		//출력
		System.out.println(sb);
	}//main
}
