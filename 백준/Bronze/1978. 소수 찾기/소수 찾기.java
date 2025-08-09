import java.util.Scanner;

//소수 찾기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0; // 소수 카운트

		for (int i = 0; i < N; i++) {
			int target = sc.nextInt();

			// 입력받은 숫자가 1이 아니라면
			if (target != 1) {

				int num = target; // 시행횟수 줄이기 위해 num 설정
				boolean isPrime = true; // 소수확인용
				// 나눈 몫만큼 체크범위 줄여가기
				for (int j = 2; j < num; j++) {
					// 나눴을때 나머지가 0이면 소수가 아님
					if (target % j == 0) {
						isPrime = false; // false로 바꾸고 중단
						break;
					}
					num = target / j; // 나눈 몫까지로 범위 줄임
				}

				// 반복문이 끝났을 때 isPrime이 그대로 true라면 cnt 증가
				if (isPrime) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}// main
}
