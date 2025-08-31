import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1216. [S/W 문제해결 기본] 3일차 - 회문2
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			char[][] board = new char[100][100];

			int max = 1; // 최대 회문 길이 저장
			for (int i = 0; i < 100; i++) {
				board[i] = br.readLine().toCharArray();
			}
			// 가로 회문 체크
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (j + 1 < 100 && board[i][j] == board[i][j + 1]) { // 2글자가 연속해 같은 케이스
						int move = 1;
						while (j - move >= 0 && j + 1 + move < 100) { // 좌우 바운더리가 벗어나지 않는다면
							if (board[i][j - move] == board[i][j + 1 + move]) { // 좌우가 같으면
								move++;
							} else {
								break;
							}
						} // 회문체크
						max = Math.max(max, move * 2);
					} // 2글자

					// 1글자 케이스
					int move = 1;
					while (j - move >= 0 && j + move < 100) { // 좌우 바운더리가 벗어나지 않는다면
						if (board[i][j - move] == board[i][j + move]) { // 좌우가 같으면
							move++;
						} else {
							break;
						}
					} // 회문체크
					max = Math.max(max, move * 2 - 1);

				}
			}

			// 세로 회문에 대해서 똑같이 하면 됨(i, j만 바꾸기)
			for (int j = 0; j < 100; j++) {
				for (int i = 0; i < 100; i++) {
					if (i + 1 < 100 && board[i][j] == board[i + 1][j]) { // 2글자가 연속해 같은 케이스
						int move = 1;
						while (i - move >= 0 && i + 1 + move < 100) { // 상하 바운더리가 벗어나지 않는다면
							if (board[i - move][j] == board[i + 1 + move][j]) { // 상하가 같으면
								move++;
							} else {
								break;
							}
						} // 회문체크
						max = Math.max(max, move * 2);
					} // 2글자
					
					// 1글자 케이스
					int move = 1;
					while (i - move >= 0 && i + move < 100) {
						if (board[i - move][j] == board[i + move][j]) {
							move++;
						} else {
							break;
						}
					} // 회문체크
					max = Math.max(max, move * 2 - 1);
				}
			}
			// 출력
			System.out.println("#" + T + " " + max);
		} // tc
	}// main
}
