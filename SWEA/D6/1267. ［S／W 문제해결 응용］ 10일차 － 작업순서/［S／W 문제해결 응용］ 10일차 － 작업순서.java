import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//1267. [S/W 문제해결 응용] 10일차 - 작업순서
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			
			String[] VE = br.readLine().split(" ");
			int V = Integer.parseInt(VE[0]);
			int E = Integer.parseInt(VE[1]);
						
			int[] inDegree = new int[V + 1];
			List<List<Integer>> adjList = new ArrayList<>();
			for (int i = 0; i < V + 1; i++) {
				adjList.add(new ArrayList<>());
			}
			
			String[] line = br.readLine().split(" ");
			for (int i = 1; i < E + 1; i++) {
				int from = Integer.parseInt(line[(i - 1) * 2]);
				int to = Integer.parseInt(line[(i - 1) * 2 + 1]);
				adjList.get(from).add(to);
				inDegree[to]++;
			}
//			System.out.println(Arrays.toString(inDegree));
			
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			for (int i = 1; i < V + 1; i++) {	// 진입차수가 0인 것 dq에 넣기
				if (inDegree[i] == 0) {
					dq.add(i);
				}
			}
			
			while(!dq.isEmpty()) {
				int curr = dq.poll();
				sb.append(curr + " ");
				
				for (int next : adjList.get(curr)) {
					inDegree[next]--;
					if (inDegree[next] == 0) {
						dq.add(next);
					}
				}
			}
			sb.append("\n");
		}//tc
		System.out.println(sb);
	}//main
}
