import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//RGB거리
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] house = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			house[i][0] = Integer.parseInt(line[0]);
			house[i][1] = Integer.parseInt(line[1]);
			house[i][2] = Integer.parseInt(line[2]);
		}
		// dp로 이전까지 최소합 기록하기
		int[][] minSum = new int[N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			minSum[i][0] = Math.min(house[i - 1][1] + minSum[i - 1][1], house[i - 1][2] + minSum[i - 1][2]);
			minSum[i][1] = Math.min(house[i - 1][0] + minSum[i - 1][0], house[i - 1][2] + minSum[i - 1][2]);
			minSum[i][2] = Math.min(house[i - 1][0] + minSum[i - 1][0], house[i - 1][1] + minSum[i - 1][1]);
		}
		
		int answer = Math.min(minSum[N][0], minSum[N][1]);
		answer = Math.min(answer, minSum[N][2]);
		
		System.out.println(answer);
		
	}//main
}
