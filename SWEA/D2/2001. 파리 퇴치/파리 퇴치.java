import java.util.Iterator;
import java.util.Scanner;
import java.io.FileInputStream;

//2001. 파리 퇴치
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약 사항]
		 * 
		 * 1. N 은 5 이상 15 이하이다.
		 * 
		 * 2. M은 2 이상 N 이하이다.
		 * 
		 * 3. 각 영역의 파리 갯수는 30 이하 이다.
		 * 
		 * 
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,
		 * 
		 * 다음 N 줄에 걸쳐 N x N 배열이 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N + M][N + M]; //오른쪽, 아래패딩
			
			//배열 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			
			// arr[i][j] 기준으로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = 0;
					// M길이만큼 오른쪽 아래로 확장해서 더하기!... 시원하게 4중포문ㅋㅋ
					for (int x = 0; x < M; x++) {
						for (int y = 0; y < M; y++) {
							sum += arr[i+x][j+y];
						}
					}
					// max값이랑 비교해서 sum이 더 크면 갱신
					if (max < sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		} // tc
	}// main
}