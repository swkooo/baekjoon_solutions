import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//파도반 수열
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		Long[] numArr = new Long[101];
		numArr[1] = 1L;
		numArr[2] = 1L;
		numArr[3] = 1L;
		
		for (int i = 4; i <= 100; i++) {
			numArr[i] = numArr[i - 3] + numArr[i - 2];
		}
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(numArr[N] + "\n");
			
		}//tc
		System.out.println(sb);
		
	}//main
}
