import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//평범한 배낭
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] prod = new int[N + 1][2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			prod[i][0] = Integer.parseInt(st.nextToken());
			prod[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] bag = new int[N + 1][K + 1];
		
		//dp
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(prod[i][0] > j) {
					bag[i][j] = bag[i - 1][j];
				}
				else {
					int temp = bag[i - 1][j - prod[i][0]] + prod[i][1];
					bag[i][j] = Math.max(bag[i - 1][j], temp);
				}
			}
//			System.out.println(Arrays.toString(bag[i]));
		}
		
		System.out.println(bag[N][K]);
		
	}//main
}
