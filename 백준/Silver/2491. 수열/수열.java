import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수열
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] line = br.readLine().split(" ");

		int maxCnt = 0; // 가장 긴 수열길이 담을 변수

		int cnt = 1; // 수열 길이 세기
		for (int i = 0; i < N - 1; i++) {
			// 현재숫자보다 다음숫자가 더 크다면 cnt 증가
			int currNum = Integer.parseInt(line[i]);
			int nextNum = Integer.parseInt(line[i + 1]);

			if (nextNum >= currNum) {
				cnt++;
			}
			// 아니라면 maxCnt 갱신 후 수열길이 초기화
			else {
				maxCnt = Math.max(maxCnt, cnt);
				cnt = 1;
			}
		}
		// 마지막값 포함되게 한번 더
		maxCnt = Math.max(maxCnt, cnt);

		// 거꾸로 돌면서 똑같이 해주면 작아지는 숫자임
		cnt = 1;
		for (int i = N - 1; i > 0; i--) {
			int currNum = Integer.parseInt(line[i]);
			int nextNum = Integer.parseInt(line[i - 1]);

			if (nextNum >= currNum) {
				cnt++;
			} else {
				maxCnt = Math.max(maxCnt, cnt);
				cnt = 1;
			}
		}
		maxCnt = Math.max(maxCnt, cnt);

		// 출력
		System.out.println(maxCnt);
	}// main
}
