import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 연결 요소의 개수
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		// 그래프와 방문 배열 초기화
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {

			String[] line = br.readLine().split(" ");

			int u = Integer.parseInt(line[0]);
			int v = Integer.parseInt(line[1]);

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}// main

	// 그래프를 표현할 인접 리스트
	static ArrayList<Integer>[] graph;
	// 정점 방문 여부를 체크할 배열
	static boolean[] visited;
	static int cnt = 0;

	public static void dfs(int node) {
		// 1. 현재 노드 방문 처리
	    visited[node] = true;

	    // 2. 현재 노드와 연결된 다른 노드들을 순회
	    for (int nextNode : graph[node]) {
	        // 3. 만약 연결된 노드를 아직 방문하지 않았다면
	        if (!visited[nextNode]) {
//	        	System.out.println(node + " -> " + nextNode); // 방문 순서 출력
	            // 4. 그 노드로 다시 dfs 함수를 호출 (재귀)
	            dfs(nextNode);
	        }
	    }
	}// 재귀함수
}
