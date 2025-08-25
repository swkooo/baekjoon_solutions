import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 토마토
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MN = br.readLine().split(" ");
		int M = Integer.parseInt(MN[0]);
		int N = Integer.parseInt(MN[1]);

		int[][] farm = new int[N][M];
		
		// 농장 숫자 입력받기
		List<int[]> ripeTomato = new ArrayList<>();	// 익은 토마토 위치 저장할 list
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int tomato = Integer.parseInt(line[j]);
				if (tomato == 1) {
					int[] temp = { i, j };	// int[] 로 위치좌표 저장
					ripeTomato.add(temp);
				}
				farm[i][j] = tomato;
			}
		}

		// 델타 탐색
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		int daySize = 0;	// 익은 토마토 리스트 크기 저장할 변수
		int dayCnt = 0;		// 지난 날짜 셀 변수
		while (true) {
			int tempSize = daySize;		 // 리스트가 늘어나기 전 크기를 tempSize에 임시 저장
			daySize = ripeTomato.size(); // 리스트크기 다시 측정
			boolean isLeft = false;	// 주위에 안익은 토마토가 있는지 확인할 boolean
			for (int i = tempSize; i < daySize; i++) {	// 전에 확인한 리스트는 제외하고 추가된 요소들만 체크
				int row = ripeTomato.get(i)[0];
				int col = ripeTomato.get(i)[1];
				
				// 익은 토마토 기준으로 델타탐색하여 안 익은 토마토 익은 토마토로 만들기
				for (int d = 0; d < 4; d++) {
					int movedR = row + dr[d];
					int movedC = col + dc[d];
					
					if (movedR >= 0 & movedR < N && movedC >= 0 && movedC < M) {	// 바운더리 설정
						if (farm[movedR][movedC] == 0) {		// 주위에 안익은 토마토가 있다면
							farm[movedR][movedC] = 1;			// 익은 토마토로 만들고
							int[] temp = { movedR, movedC };	// 익은 토마토 리스트에 추가
							ripeTomato.add(temp);
							isLeft = true;						// 바꾸는 활동 진행했으므로 true로 변경
						}
					}
				}
			}
			if (!isLeft) {	// 바꾸는 활동을 못했다면.. 즉 주위에 더 이상 바꿀 토마토가 없다면
				break;
			}
			// while문이 계속 돈다면 dayCnt 증가
			dayCnt++;
		}// 반복문
		
		// 토마토 전부 익었는지 확인
		boolean isOK = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (farm[i][j] == 0) {	// 안 익은 토마토가 남아 있다면
					System.out.println(-1);
					isOK = false;
					break;
				}
			}
			if (!isOK) {
				break;
			}
		}
		// 안익은 토마토가 없다면
		if (isOK) {
			System.out.println(dayCnt);	// 바꿀 필요가 없었다면 0 출력 됨
		}
		
	}// main
}
