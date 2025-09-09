import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 1251. [S/W 문제해결 응용] 4일차 - 하나로

public class Solution {
	
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;

		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}

	static class Edge {
		int from;
		int to;
		double leng;

		public Edge(int from, int to, double leng) {
			this.from = from;
			this.to = to;
			this.leng = leng;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", leng=" + leng + "]";
		}

	}
	//main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 입력받기
			int N = Integer.parseInt(br.readLine());

			Node[] nodes = new Node[N + 1];

			String[] temp1 = br.readLine().split(" ");
			String[] temp2 = br.readLine().split(" ");

			for (int j = 1; j <= N; j++) {
				nodes[j] = new Node(Integer.parseInt(temp1[j - 1]), Integer.parseInt(temp2[j - 1]));
			}

			double E = Double.parseDouble(br.readLine());
			
			// 좌표간 길이 계산해서 list에 넣기			
			List<Edge> edgeList = new ArrayList<>();
			
			for (int i = 1; i < N; i++) {
				double x1 = nodes[i].x;
				double y1 = nodes[i].y;
				for (int j = i + 1; j <= N; j++) {
					double x2 = nodes[j].x;
					double y2 = nodes[j].y;
					double leng = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
					
					edgeList.add(new Edge(i, j, leng));
				}
			}
			
			// 길이 가장 짧은 순으로 간선 정렬
			Collections.sort(edgeList, (o1, o2) -> Double.compare(o1.leng, o2.leng));
			
//			for(Edge edge : edgeList) {
//				System.out.println(edge.toString());
//			}
			
			// 부모 배열 생성 및 초기화
			p = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			double sumLeng = 0;	// 길이 합
			int pick = 0;	// 좌표 선택한 갯수
			for (int i = 0; i < edgeList.size() && pick < N; i++) {
				int px = findSet(edgeList.get(i).from);	// 가장 작은 길이의 간선의 점 인덱스 부모가져오기
				int py = findSet(edgeList.get(i).to);
				if (px != py) {	// 부모가 같지 않다면
					pick++;		// 간선 선택하고
					sumLeng += edgeList.get(i).leng; // 최소길이에 더한 후
					p[py] = px; // 부모 통일(union)
				}
			}
			
			// 출력
			sb.append("#" + tc + " " + Math.round(E * sumLeng) + "\n");
			
		} // tc
		System.out.println(sb);
	}// main	
	static int[] p; // 대표를 저장할 배열
	
	// 부모정점 찾기
	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}
}
