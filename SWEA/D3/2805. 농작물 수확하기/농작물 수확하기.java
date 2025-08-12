import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2805. 농작물 수확하기
class Solution {
	public static void main(String args[]) throws IOException {
		/*
		 * [제약 사항]
		 * 
		 * 농장의 크기 N은 1 이상 49 이하의 홀수이다. (1 ≤ N ≤ 49)
		 * 
		 * 농작물의 가치는 0~5이다.
		 * 
		 * 
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스에는 농장의 크기 N과 농장 내 농작물의 가치가 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 각 줄은 '#t'로 시작하고, 공백으로 농장의 규칙에 따라 얻을 수 있는 수익을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];

			// 농장 입력받기
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					farm[i][j] = line[j] - '0';
				}
			}

			// 기준값, 즉 마름모 중앙 인덱스
			int standardNum = N / 2;

			int sum = 0; // 합계 저장

			// 농장 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 마름모중 증가하는 윗부분에 대해서
					if (i < standardNum) {
						// 수확할 농장 범위 지정.. 기준 값 기준으로 i값 가지고 좌우 바운더리
						if (j >= standardNum - i && j <= standardNum + i) {
							sum += farm[i][j];
						}
					}
					// 감소하는 아랫부분도 마찬가지로 바운더리
					else {
						if (j >= standardNum - (N - 1 - i) && j <= (standardNum + (N - 1 - i))) {
							sum += farm[i][j];
						}
					}

				}

			}
			
			//출력
			System.out.println("#" + test_case + " " + sum);

		} // tc
	}// main
}