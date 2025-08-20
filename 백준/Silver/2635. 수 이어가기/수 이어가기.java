import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//수 이어가기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		int maxCnt = 0;
		int maxIdx = 0;
		for (int i = N / 2; i <= N; i++) {
			cnt = 1;
			int check = FuncCnt(N, i);
			if (maxCnt < check) {
				maxCnt = check;
				maxIdx = i;
			}
		}
		sb.append(maxCnt + "\n" + N);
		
		FuncPrint(N, maxIdx);
		
		System.out.println(sb);
	}// main
	
	
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	
	public static int FuncCnt(int N, int i) {
		if (N - i < 0) {
			cnt++;
			return cnt;
		} else {
			cnt++;
			return FuncCnt(i, N - i);
		}
	}
	public static void FuncPrint(int N, int i) {
		if (N - i < 0) {
			sb.append(" " + i);
			
		} else {
			sb.append(" " + i);
			FuncPrint(i, N - i);
		}
	}
}
