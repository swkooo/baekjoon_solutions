import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//숨바꼭질 3
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100001];
		
		for (int i = 0; i <= N; i++) {
			dp[i] = N - i;
		}
		
		for (int i = N + 1; i <= K; i++) {
			if(i % 2 != 0) {
				int temp = Math.min(dp[i / 2] + 1, dp[i / 2 + 1] + 1);
				dp[i] = Math.min(dp[i - 1] + 1, temp);
			}
			else {
				dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2]);
			}
		}
		
		System.out.println(dp[K]);
		
	}//main
}
