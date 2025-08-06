import java.util.Scanner;
import java.io.FileInputStream;

//12712. 파리퇴치3
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약 사항]
		 * 
		 * 1. N 은 5 이상 15 이하이다. 2. M은 2 이상 N 이하이다. 3. 각 영역의 파리 갯수는 30 이하 이다.
		 * 
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다. 각 테스트 케이스의 첫 번째 줄에 N 과 M
		 * 이 주어지고, 다음 N 줄에 걸쳐 N x N 배열이 주어진다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N + M * 2][N + M * 2]; // 상하좌우 패딩

			// 배열 입력받기
			for (int i = M; i < N + M; i++) {
				for (int j = M; j < N + M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 델타검색 상하좌우 설정
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			// x자 설정
			int[] drX = { -1, -1, 1, 1 };
			int[] dcX = { -1, 1, 1, -1 };
			int max = 0;

			// 입력받은 배열 요소마다 확인하기
			for (int i = M; i < N + M; i++) {
				for (int j = M; j < N + M; j++) {
					// sum에 일단 체크하고자 하는 숫자 집어넣고
					int sumCross = arr[i][j];
					int sumX = arr[i][j];

					// 체크하려는 숫자기준 M-1범위 만큼
					for (int num = 1; num < M; num++) {
						// 상하좌우, x범위 확인
						for (int d = 0; d < 4; d++) {
							sumCross += arr[i + (dc[d] * num)][j + (dr[d] * num)];
							sumX += arr[i + (dcX[d] * num)][j + (drX[d] * num)];
						}
					}
					// 마지막으로 max값과 합 비교해서 더 크면 갱신
					if (max < sumCross) {
						max = sumCross;
					}
					if (max < sumX) {
						max = sumX;
					}
				}
			}
			System.out.println("#" + test_case + " " + max);

		} // tc
	}// main
}