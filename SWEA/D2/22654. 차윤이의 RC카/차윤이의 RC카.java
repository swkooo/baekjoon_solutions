import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//22654. 차윤이의 RC카
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);
			int N = Integer.parseInt(br.readLine());
			
			char[][] field = new char[N][N];
			int[] start = new int[2];	// 시작지점
			int[] end = new int[2];		// 도착지점
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if (line[j] == 'X') 
						start = new int[] {i, j};
					if (line[j] == 'Y')
						end = new int[] {i, j};
					field[i][j] = line[j];
				}
			}// field, 시작, 도착 입력받기
			
			int Q = Integer.parseInt(br.readLine());
			for (int i = 0; i < Q; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				
				char[] commands = st.nextToken().toCharArray();
				
				int[] curr = new int[] {start[0], start[1]};	// 시작지점을 현재지점으로 가져오기
				
				dir = 0;	// 방향 위로 초기화
				
				for (char command : commands) {
					if (command == 'A') {	// A 커맨드면
						// 보고 있는 방향에 따라 이동칸 체크
						int moveRow = curr[0] + dr[dir];
						int moveCol = curr[1] + dc[dir];
						
						if (moveRow >= 0 && moveRow < N && moveCol >= 0 && moveCol < N ) {	// 바운더리 설정
							if (field[moveRow][moveCol] != 'T') {	// 이동칸이 tree가 아니면
								// 현재칸 이동칸으로 갱신
								curr[0] = moveRow;
								curr[1] = moveCol;
							}
						}
					}
					//방향 변경 커맨드면 방향변경 함수 실행
					else
						turnCommand(command);
				}//커맨드 수행
				// 커맨드가 끝났을 때 도착지점에 도착했는지 확인
				if (curr[0] == end[0] && curr[1] == end[1])
					sb.append(" ").append(1);
				else
					sb.append(" ").append(0);
			}
			sb.append("\n");
		}//tc
		System.out.println(sb);
	}//main
	
	// 델타이동(상우하좌.. 시계방향)
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int dir;
	
	static void turnCommand(char turn) {
		if (turn == 'L') {	// 왼쪽커맨드면
			if (dir == 0)	// dir이 0 일때 끝으로 옮기고 나머지는 -1
				dir = 3;
			else
				dir--;
		}
		if (turn == 'R') {	// 오른쪽커맨드면
			if (dir == 3)	// dir이 3 일때 처음으로 옮기고 나머지는 +1
				dir = 0;
			else
				dir++;
		}		
	}
}
