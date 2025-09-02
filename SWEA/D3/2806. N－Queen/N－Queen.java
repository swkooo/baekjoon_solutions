import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				cantPut.clear();	// 체크set초기화
				putQueen(0, i);		// 첫줄에 퀸 1개씩 놓아보기
			}
			sb.append("#" + tc + " " + cnt + "\n");
		}//tc
		System.out.println(sb);
		
	}//main
	static int N;
	static int cnt;	// 퀸배치가능한 경우의 수
	static Set<String> cantPut = new HashSet<>();	// 퀸 놓을 수 없은 자리 체크를 위한 set
	
	// 델타 탐색	\|/ 3방향 탐색
	static int[] dr = {-1, -1, -1};
	static int[] dc = {-1, 0, 1};	
	
	// 재귀 함수
	static void putQueen(int row, int col) {
		String check = row + " " + col;
		//종료조건
		for (int i = row; i >= 0; i--) {	//놓고자 하는 말의 위의 3방향 탐색
			for (int d = 0; d < 3; d++) {
				String temp = (row + dr[d] * i) + " " + (col + dc[d] * i);
				if (cantPut.contains(temp)) {	// 탐색방향에 말이 있다면 stop
					return;
				}
			}
		}
		if (row >= N - 1) {					// N-1 인덱스까지 놓았다면 cnt증가
			cnt++;
			return;
		}
		
		//재귀조건		
		for (int i = 0; i < N; i++) {
			cantPut.add(check);
			putQueen(row + 1, i);	// 다음 행으로 넘어가기
			cantPut.remove(check);	// 백트래킹
		}
	}
}
