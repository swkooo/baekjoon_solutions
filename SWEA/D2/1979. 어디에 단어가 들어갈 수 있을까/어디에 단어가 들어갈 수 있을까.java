import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1979. 어디에 단어가 들어갈 수 있을까
class Solution {
	public static void main(String args[]) throws IOException {
		/*
		 * [제약 사항]
		 * 
		 * 1. N은 5 이상 15 이하의 정수이다. (5 ≤ N ≤ 15)
		 * 
		 * 2. K는 2 이상 N 이하의 정수이다. (2 ≤ K ≤ N)
		 * 
		 * 
		 * [입력]
		 * 
		 * 입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
		 * 
		 * 다음 줄부터 각 테스트 케이스가 주어진다.
		 * 
		 * 테스트 케이스의 첫 번째 줄에는 단어 퍼즐의 가로, 세로 길이 N 과, 단어의 길이 K 가 주어진다.
		 * 
		 * 테스트 케이스의 두 번째 줄부터 퍼즐의 모양이 2차원 정보로 주어진다.
		 * 
		 * 퍼즐의 각 셀 중, 흰색 부분은 1, 검은색 부분은 0 으로 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);

			int[][] numArr = new int[N + 2][N + 2]; // 상하좌우 패딩

			// 배열 입력 받기
			for (int i = 1; i < N + 1; i++) {
				String[] num = br.readLine().split(" ");
				for (int j = 1; j < N + 1; j++) {
					numArr[i][j] = Integer.parseInt(num[j - 1]);
				}
			}

			// 정답 배열... ex) 01110
			String answer = "0";
			for (int i = 0; i < K; i++) {
				answer += 1;
			}
			answer += 0;

			int cnt = 0; // 정답 개수 체크
			// 가로 체크
			for (int i = 0; i < numArr.length; i++) {
				for (int j = 0; j < numArr.length - K - 1; j++) {
					String check = "";
					for (int n = 0; n < K + 2; n++) {
						check += numArr[i][j + n]; // 배열 string으로 만들기
					}
					// string이 정답 배열이면 갯수 증가
					if (check.equals(answer)) {
						cnt++;
					}
				}
			}

			// 세로 체크... 행과 열만 바꾸면 됨
			for (int i = 0; i < numArr.length - K - 1; i++) {
				for (int j = 0; j < numArr.length; j++) {
					String check = "";
					for (int n = 0; n < K + 2; n++) {
						check += numArr[i + n][j]; // 배열 string으로 만들기
					}
					// string이 정답 배열이면 갯수 증가
					if (check.equals(answer)) {
						cnt++;
					}
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		} // tc
	}// main
}