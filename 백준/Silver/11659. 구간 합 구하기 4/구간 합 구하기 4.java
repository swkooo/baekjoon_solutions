import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//구간 합 구하기4
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		// 사실상 누적합 구해서 끝 범위 - 처음 범위 하면 됨
		int[] arrN = new int[N + 1];
		String[] line = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			arrN[i] = Integer.parseInt(line[i - 1]) + arrN[i - 1];	// 0번 인덱스 비워놓고 누적합 구하기
		}
		

		for (int m = 0; m < M; m++) {
			String[] section = br.readLine().split(" ");
			int start = Integer.parseInt(section[0]);
			int end = Integer.parseInt(section[1]);

			// 출력
			sb.append((arrN[end] - arrN[start - 1]) + "\n"); 
		} // 사실상 tc
		System.out.println(sb);
	}// main
}
