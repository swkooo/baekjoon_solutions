
// 16546. Baby-gin_실습

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			char[] line = br.readLine().toCharArray();
			boolean isBabygin = false;
			int run = 0;
			int tripple = 0;

			// 카운트 배열 0 ~ 9까지 수를 담을 수 있는 배열;
			int[] counts = new int[10];

			for (char ch : line) {
				counts[ch - '0']++;
			}


			// 1. 트리플 카운트
			for (int i = 0; i <= 9; i++) {
				if (counts[i] >= 3) {
					tripple += counts[i] / 3; // 몫
					counts[i] = counts[i] % 3; // 나머지
				}
			}
//			System.out.println("triple: " + tripple);

			// 2. 런 카운트
			// 123, 234, 345, ..., 789
			for (int i = 0; i <= 7; i++) {
				// counts[i], counts[i+1], counts[i+2] 확인할 예정
				if (counts[i] > 0 && counts[i + 1] > 0 && counts[i + 2] > 0) {
					// 세개의 카드 카운트 중에서 가장 작은 값 (갯수 가장 적은 것)
					int mn = Math.min(counts[i], Math.min(counts[i + 1], counts[i + 2]));
					run += mn;
					counts[i] -= mn;
					counts[i + 1] -= mn;
					counts[i + 2] -= mn;
				}
			}
//			System.out.println("run: " + run);
			
			// 3. 베이비진 여부 체크...
			if (run + tripple >= 2) {
				isBabygin = true;
			}
			// 출력
			if (isBabygin) {
				sb.append("#" + tc + " true\n");
			} else {
				sb.append("#" + tc + " false\n");
			}

		} // tc
		System.out.println(sb);
	}// main
}
