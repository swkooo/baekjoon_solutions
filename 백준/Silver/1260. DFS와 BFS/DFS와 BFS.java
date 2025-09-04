import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//DFS와 BFS
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NMV = br.readLine().split(" ");
		N = Integer.parseInt(NMV[0]);
		M = Integer.parseInt(NMV[1]);
		V = Integer.parseInt(NMV[2]);

		// 인접리스트생성
		adjList = new ArrayList[N + 1];	// 번호 편하게 넣기 위해 N+1개 만큼 생성
		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 간선 인접리스트에 넣기
		for (int i = 0; i < M; i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			if (!adjList[a].contains(b))
				adjList[a].add(b);
			if (!adjList[b].contains(a))
				adjList[b].add(a);
		}
		
		// 방문체크
		visited = new HashSet<>();
		DFS(V);	// DFS 실행

		sb.append("\n");	//개행
		
		// BFS를 위한 dq 생성
		dq = new ArrayDeque<>();
		visited.clear();	// 방문체크 초기화
		// 첫번째 값 넣어놓기
		dq.add(V);
		visited.add(V);
		BFS();	// BFS 실행
		
		//출력
		System.out.println(sb);

	}// main

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int V;
	static List<Integer>[] adjList;
	static ArrayDeque<Integer> dq;
	static Set<Integer> visited;

	//DFS 재귀함수로 만들기
	static void DFS(int V) {
		//종료
		if (visited.contains(V) || visited.size() == N) {	// 방문했거나 방문체크가 꽉 차면(다돌았으면)
			return;
		}
		
		//재귀
		else {
			sb.append(V + " ");
			visited.add(V);
			Collections.sort(adjList[V]);
			for (int i = 0; i < adjList[V].size(); i++) {
				DFS(adjList[V].get(i));
			}
		}
	}
	
	//BFS queue이용해 만들기
	static void BFS() {
		while (!dq.isEmpty()) {
			int currNode = dq.poll();
			sb.append(currNode + " ");

			for (int i = 0; i < adjList[currNode].size(); i++) {
				Collections.sort(adjList[currNode]);
				int check = adjList[currNode].get(i);
				if (!visited.contains(check)) {
					dq.add(check);
					visited.add(check);
				}
			}
		}
	}
}
