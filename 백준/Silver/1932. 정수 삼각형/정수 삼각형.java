import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//정수 삼각형
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][]	numArr = new int[N][N];
		
		for (int i = N - 1; i >= 0; i--) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				 numArr[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				numArr[i][j] += Math.max(numArr[i - 1][j], numArr[i - 1][j + 1]);
			}
		}
		
		System.out.println(numArr[N - 1][0]);
	}//main
}
