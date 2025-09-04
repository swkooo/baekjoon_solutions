import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] fee = br.readLine().split(" ");

			int dayFee = Integer.parseInt(fee[0]);
			int monthFee = Integer.parseInt(fee[1]);
			threeFee = Integer.parseInt(fee[2]);
			int yearFee = Integer.parseInt(fee[3]);

			String[] line = br.readLine().split(" ");
			int[] plan = new int[12];

			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(line[i]);
			}
			// ------------입력----------------

			planFee = new int[14]; // 3개월 계산을 위해 내년 2월까지 받기
			minFee = 0; // 최소비용 초기화
			for (int i = 0; i < 12; i++) {
				// 일단 1일권과 1달권비교해서 작은걸로 비용설정
				planFee[i] = Math.min(dayFee * plan[i], monthFee);
				minFee += planFee[i];
			}
			// 3달권 계산을 위한 재귀 실행
			dfs(0);

			// 3달권 최소랑 1년권 비교
			minFee = Math.min(minFee, yearFee);
			sb.append("#" + tc + " " + minFee + "\n");
		} // tc
			// 출력
		System.out.println(sb);

	}// main

	static int threeFee;
	static int[] planFee;
	static int minFee;
	static int sum;

	// 3달권 비교를 위한 함수
	static void dfs(int idx) {
		// 종료.. 인덱스가 12를 넘어가면(2월까지 설정해놔서 괜춘)
		if (idx >= 12) {
			minFee = Math.min(minFee, sum); // 최소비용 갱신
			return;
		}

		// 재귀
		// 3달권과 비교를 위한 3개 단위로 달 묶기
		int before = planFee[idx] + planFee[idx + 1] + planFee[idx + 2];
		if (threeFee < before) { // 비교해서 3달권이 더 작으면
			sum += threeFee; // 3달권 비용 더하고
			dfs(idx + 3); // 3달 점프
			sum -= threeFee; // 백트래킹
		}
		sum += planFee[idx]; // 그냥 다음달로 넘어가는 것도 체크
		dfs(idx + 1); // 1달 점프
		sum -= planFee[idx]; // 백트래킹
	}
}
