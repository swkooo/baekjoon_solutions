import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//돌 게임
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] result = new int[N + 3];
		result[1] = 1;
		result[2] = 2;
		result[3] = 1;
		
		for (int i = 4; i <= N; i++) {
			result[i] = Math.min(result[i - 1], result[i - 3]) + 1;
		}
		
		if (result[N] % 2 == 1) {
			System.out.println("SK");
		}
		else {
			System.out.println("CY");
		}
		
	}//main
}
