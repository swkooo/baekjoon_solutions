import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2×n 타일링 2
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] cnt = new int[n + 4];

		// 1과 2를 가지고 n 의 수를 채우는 경우의 수랑 같다.(단 2는 X2)
		cnt[1] = 1; // 1
		cnt[2] = 3; // 1+1, 2
		cnt[3] = 5; // 1+2, 1+1+1, 2+1 -> cnt[1]에 cnt[1]*2를 더하거나, cnt[2]에 1을 더하거나!
		cnt[4] = 11; // 1+1+2, 2+2, 1+2+1, 1+1+1+1, 2+1+1 -> 같은방식으로 cnt[2]*2를 더하거나, cnt[3]에 1을 더하거나!

		for (int i = 3; i <= n; i++) {
			cnt[i] = (cnt[i - 2] * 2 + cnt[i - 1]) % 10007;
		}
		
		System.out.println(cnt[n]);
	}// main
}
