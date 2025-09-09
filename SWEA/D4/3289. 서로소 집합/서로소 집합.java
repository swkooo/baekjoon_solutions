import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	// 서로소 집합을 표현할 대표자를 가리키는 parent 배열 선언
	static protected int[] parent;

	// 초기화 make-set : 나 자신을 부모로 가리키도록 초기화 메서드 선언
	static public void init(int N) { // 요소의 갯수가 N개 일때 초기화!
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	// find-set : x가 속해있는 대표자를 반환하는 메서드
	static public int findSet(int x) {
		if (parent[x] == x) {
			return x;
		}

		// 재귀호출로 부모를 통해 다시 대표자 탐색 진행 (루트 업데이트)
		return parent[x] = findSet(parent[x]);
	}

	// union : x와 y가 속해있는 그룹을 통합하는 메서드
	static public void union(int x, int y) {
		int root_x = findSet(x);
		int root_y = findSet(y);

		if (root_x != root_y)
			parent[root_x] = root_y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);

			int[][] commands = new int[m][];
			for (int i = 0; i < m; i++) {
				String[] temp = br.readLine().split(" ");

				int command = Integer.parseInt(temp[0]);
				int x = Integer.parseInt(temp[1]);
				int y = Integer.parseInt(temp[2]);

				commands[i] = new int[] { command, x, y };

			}

			// 서로소 집합을 생성한 후에, 연산에 따라서 처리 후 결과 생성!
			sb.append("#" + tc + " ");
			
			// 서로소 집합을 원소 N개로 초기화
			init(n);

			// 명령어 M개를 읽고, 명령들을 수행하는 과정!
			for (int i = 0; i < m; i++) {
				int command = commands[i][0];
				int x = commands[i][1];
				int y = commands[i][2];

				if (command == 0) { // x, y를 union
					union(x, y);
				} else if (command == 1) { // x, y가 같은 그룹인가 확인
					if (findSet(x) == findSet(y)) {
						sb.append("1");
					}
					else {
						sb.append("0");
					}
				}

			}
			sb.append("\n");
		} // tc
		// 출력
		System.out.println(sb);

	}// main
}
