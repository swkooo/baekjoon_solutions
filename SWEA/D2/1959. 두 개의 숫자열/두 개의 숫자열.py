import java.io.BufferedReader;
import java.io.InputStreamReader;


//1959. 두 개의 숫자열
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약 사항]
		 * 
		 * N 과 M은 3 이상 20 이하이다.
		 * 
		 * 
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,
		 * 
		 * 두 번째 줄에는 Ai,
		 * 
		 * 세 번째 줄에는 Bj 가 주어진다.
		 * 
		 * [출력]
		 * 
		 * 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] NM = br.readLine().split(" ");
			int N = Integer.parseInt(NM[0]);
			int M = Integer.parseInt(NM[1]);
			
			String[] Ai = br.readLine().split(" ");
			String[] Bj = br.readLine().split(" ");
			
			//확인할 최댓값
			int max = Integer.MIN_VALUE;
			
			// N <= M 인 케이스
			if (N <= M) {
				// M크기에 따라 한칸 씩 이동해가면서 곱한 값 저장하기
				for (int i = 0; i < M - N + 1; i++) {
					int sum = 0;	// 합계 저장
					for (int j = 0; j < N; j++) {
						sum += Integer.parseInt(Ai[j]) * Integer.parseInt(Bj[j + i]);
					}
					//합계랑 max랑 비교해서 갱신
					max = Math.max(max, sum);
				}
			}
			//N > M 인 케이스... 위에거랑 i j만 반대로
			else {
				for (int i = 0; i < N - M + 1; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += Integer.parseInt(Ai[j + i]) * Integer.parseInt(Bj[j]);
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}//tc
	}//main
}