import java.util.Scanner;

//자리배정
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();
		int R = sc.nextInt();
		int K = sc.nextInt();

		// x를 행에, y를 열에 배정하면 나중에 굳이 수정안해도 됨
		int[][] seat = new int[C + 2][R + 2]; // 상하좌우 패딩

		// 패딩값 -1로 설정
		for (int i = 0; i < C + 2; i++) {
			seat[i][0] = -1;
			seat[i][R + 1] = -1;
		}
		for (int j = 0; j < R + 2; j++) {
			seat[0][j] = -1;
			seat[C + 1][j] = -1;
		}

		// 델타이동(달팽이 이동)
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		int currRow = 1;	// 패딩했으므로 [1][0] 부터 시작
		int currCol = 0;

		int cnt = 0;
		int d = 0;
		while(C * R >= K) {	// 배정된 좌석이 예약인원수보다 많을 경우...
			int move = d % 4;	
			d++;	// 델타이동을 계속해서 반복하기 위한 설정
			while (seat[currRow + dr[move]][currCol + dc[move]] == 0) { // 다음칸이 비어있는 칸, 즉 0인 칸만
				cnt++;
				// 다음칸으로 넘어가기
				currRow += dr[move];
				currCol += dc[move];
				
				// 해당 좌석에 번호 배정
				seat[currRow][currCol] = cnt;
				// 목표한 번호에 도달하면 좌표 출력
				if (cnt == K) {
					System.out.println(currRow + " " + currCol);
					break;
				}
			}
			if (cnt == K) {
				break;
			}		
		}
		
		// 배정된 좌석보다 예약인원이 더 많다면 배정 불가!
		if (C * R < K) {
			System.out.println(0);
		}
		
		
	}// main
}
