import java.util.Arrays;
import java.util.Scanner;

//블랙잭
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 먼저 크기 순으로 정렬
		Arrays.sort(arr);

		int max = 0;
		boolean isBlackJack = false; // 블랙잭 여부 체크용
		int targetIdx = 0;
		// 블랙잭이 아닐경우, targetIdx가 N-2보다 작을경우 반복
		while (!isBlackJack && targetIdx < N - 2) {
			int j = targetIdx + 1;
			//target과 다음 더하는 카드가 M보다 작고 J가 N-1보다 작을경우 반복
			while (arr[targetIdx] + arr[j] < M && j < N - 1) {
				//세번째 카드 설정
				for (int k = j + 1; k < N; k++) {
					int sum = arr[targetIdx] + arr[j] + arr[k];
					//세카드의 합이 블랙잭이면 max값과 isBlackJack바꾸고 break
					if (sum == M) {
						isBlackJack = true;
						max = sum;
						break;
					// sum이 M을 넘어갈 경우엔 break
					} else if (sum > M) {
						break;
					// 마지막으로 max값과 비교해서 갱신
					} else {
						if (max < sum) {
							max = sum;
						}
					}
				}//3번째카드까지 더하는 for문
				j++;
			}//2번째카드까지 확인하는 반복문
			targetIdx++;
		}//전체 반복문
		
		//출력
		System.out.println(max);
	}// main
}
