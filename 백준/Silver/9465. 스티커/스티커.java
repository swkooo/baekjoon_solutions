import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//스티커
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			// 스티커 배열 입력받기
			int[][] sticker = new int[2][n + 2];
			for (int i = 0; i < 2; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(line[j]);
				}
			}
			int[][] score = new int[2][n + 2]; // 최대값 저장
			
			// 첫번째 행은 스티커 값 그대로
			score[0][0] = sticker[0][0];
			score[1][0] = sticker[1][0];
			
			// 두번째 행은 이전 스티커행과 교차해서 더하기
			score[0][1] = sticker[0][1] + sticker[1][0];
			score[1][1] = sticker[1][1] + sticker[0][0];

			// 이후 아래 규칙에 따라 max값을 가짐
			// 일단 본인 스티커값 더하고, 교차되는 이전행 스티커값 더하거나 or 이전이전 같은 행 스티커값 더하거나
			score[0][2] = sticker[0][2] + Math.max(score[1][0], score[1][1]);
			score[1][2] = sticker[1][2] + Math.max(score[0][0], score[0][1]);

			for (int i = 2; i < n; i++) {
				score[0][i] = sticker[0][i] + Math.max(score[1][i - 2], score[1][i - 1]);
				score[1][i] = sticker[1][i] + Math.max(score[0][i - 2], score[0][i - 1]);
			}

			sb.append(Math.max(score[0][n - 1], score[1][n - 1]) + "\n");	// 마지막에 저장된 두 수 비교해서 최대값 출력
		} // tc
		System.out.println(sb);
	}// main
}
