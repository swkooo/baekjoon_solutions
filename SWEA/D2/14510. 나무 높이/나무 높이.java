import java.util.Arrays;
import java.util.Scanner;

//14510. 나무 높이... A형 1번
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int maxHeight = 0;
			int[] trees = new int[N];
			for (int i = 0; i < N; i++) {
				int height = sc.nextInt();
				trees[i] = height;
				maxHeight = Math.max(maxHeight, height);
			}

			for (int i = 0; i < N; i++) {
				trees[i] = maxHeight - trees[i];
			}

			Arrays.sort(trees);

			int days = 0;

			while (trees[N - 1] > 1 && trees[N - 2] != 0) {	// 1만 남았을 경우에는 계산이 다르다...
//				System.out.println(Arrays.toString(trees));
				days++;
				if (days % 2 == 1) { // 날짜에 따라 주는 물이 다르다.. 홀수 날이면
					boolean isWater = true;
					for (int i = N - 1; i >= 0; i--) {
						if (trees[i] % 2 == 1) {
							trees[i]--;
							isWater = false;
							break;
						}
					}
					if (isWater) { // 전부다 짝수라 물을 못줬다면..
						trees[N - 1]--;
					}
				} else {
					boolean isWater = true;
					for (int i = N - 1; i >= 0; i--) { // 짝수 날이면
						if (trees[i] % 2 == 0 && trees[i] >= 2) { // 짝수 날에 물주려면 일단 2보단 커야한다.
							trees[i] -= 2;
							isWater = false;
							break;
						}
					}
					if (isWater) { // 전부다 홀수라 물을 못줬다면..
						trees[N - 1] -= 2;
					}
				}
				Arrays.sort(trees);	// 다시 정렬... 물주기 남은 나무를 확인하기 위해서
			}
			
			if (trees[N - 1] == 2) {	// 2만 남았을 때 특별 케이스... 2가 여러개면 위에서 처리됨
				days++;
				if (days % 2 == 1) {	// 홀수날이면 하루 뒤에 다시
					days++;
				}
				trees[N - 1] = 0;	// 아래에 걸리지 않도록 값 바꿔주기
			}
			
			while(trees[N - 1] != 0) {	// 남은 나무 모두 물 줄때까지 다시 반복
//				System.out.println(Arrays.toString(trees));
				days++;
				if (days % 2 == 1) {	// 홀수 날일때만 물 주기
					trees[N - 1]--;
				}
				Arrays.sort(trees);
			}
			
			// 출력
			System.out.println("#" + tc + " " + days);		

		} // tc
	}// main
}
