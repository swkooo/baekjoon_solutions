import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//ACM Craft
public class Main {
	static class Node {
		int num;
		int time;
		
		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] nodes = new int[N + 1];		// 각 건물의 건설시간 입력받기
			for (int i = 1; i < N + 1; i++) {
				nodes[i] = Integer.parseInt(st.nextToken());
			}
			// 인접리스트 생성 및 초기화
			adjList = new ArrayList<>();
			for (int i = 0; i < N + 1; i++) {
				adjList.add(new ArrayList<>());
			}
			// 인접리스트 생성 및 초기화
			List<List<Integer>> adjList2 = new ArrayList<>();
			for (int i = 0; i < N + 1; i++) {
				adjList2.add(new ArrayList<>());
			}
			// 진입차수 배열, 인접리스트 입력받기
			int[] inDegree = new int[N + 1];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList.get(from).add(to);
				adjList2.get(to).add(from);
				inDegree[to]++;
				}			
			W = Integer.parseInt(br.readLine());	// 지어야 할 건물
			
			boolean[] visited = new boolean[N + 1];
			List<Integer> linked = new ArrayList<>();
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			for (int num : adjList2.get(W)) {
				dq.offer(num);
				linked.add(num);
				visited[num] = true;
			}
			while(!dq.isEmpty()) {
				int curr = dq.poll();
				visited[curr] = true;
				for (int num : adjList2.get(curr)) {
					if (!visited[num]) {		
						visited[num] = true;
						dq.add(num);
						linked.add(num);
					}
				}
			}
//			System.out.println(linked.toString());
			
			// W와 연결되어 있는 노드 탐색
				for (int i = 1; i < N + 1; i++) {
					if (!linked.contains(i)) {	// w와 연결되어 있지 않다면 간선 지우기
						adjList.get(i).clear();
					}
				}
			// 위상정렬을 위한 queue생성
			ArrayDeque<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i < N + 1; i++) {
				// adjList에 연결된 노드가 있고 진입차수가 0이라면 큐에 넣기
				if (!adjList.get(i).isEmpty() && inDegree[i] == 0) {
					queue.offer(i);
				}
			}
			
			int maxTime = 0;
			int[] sumTimes = new int[N + 1];	// 순서대로 건물짓기위해 필요한 누적시간합 배열
			while(inDegree[W] != 0 && !queue.isEmpty()) {	// W의 진입차수가 0이 아니고 queue가 비어있지 않다면
				int size = queue.size();
				//queue 사이즈만큼 반복(depth)
				for (int i = 0; i < size; i++) {
					int curr = queue.poll();
					// 누적 시간합이 없으면 현재값 넣어주기
					if(sumTimes[curr] == 0)
					sumTimes[curr] += nodes[curr];	
//					System.out.println(curr + ": " + sumTimes[curr]);
					// curr와 연결된 노드들에 대해
					for(int next : adjList.get(curr)) {
						inDegree[next]--;	// 진입차수 줄이고
						// 누적 시간합을 먼저 지어야할 건물들의 시간합과 비교해서 큰값만 기록
						sumTimes[next] = Math.max(sumTimes[next], (nodes[next] + sumTimes[curr]));
						// 인접노드가 존재하고 진입차수가 0이면 큐에 넣기
						if (!adjList.get(next).isEmpty() && inDegree[next] == 0)
							queue.offer(next);						
					}
					// 현재 depth에서 최대시간과 비교해서 갱신
					maxTime = Math.max(maxTime, sumTimes[curr]);
				}
			}
			// 출력
			sb.append((maxTime + nodes[W]) + "\n");
		}//tc
		System.out.println(sb);
	}//main
	
	static List<List<Integer>> adjList;
	static int W;
	static boolean isFound;
}