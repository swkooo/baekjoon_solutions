import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//가장 긴 증가하는 부분 수열
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] line = br.readLine().split(" ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}

		// 배열길이 카운트할 cnt
		int[] cnt = new int[N];
		cnt[N - 1] = 1; // 가장 마지막 숫자는 무조건 1

		int max = 1; // 최대값 저장할 변수
		for (int i = N - 2; i >= 0; i--) { // 뒤에서부터 돌면서
			cnt[i] = 1;				// 일단 1 저장
			for (int j = i + 1; j < N; j++) {	// 확인하는 인덱스 뒤에 더 큰 값이 있는지 체크
				if (arr[i] < arr[j]) {	// 더 큰 값이 있다면
					cnt[i] = Math.max(cnt[i], cnt[j] + 1);	// 그 값보다 1큰 배열 길이 저장하고 max갱신
				}
			}
//			System.out.println(Arrays.toString(cnt));
			max = Math.max(max, cnt[i]);	// 최대값 갱신
		}
		System.out.println(max);
	}// main
}
