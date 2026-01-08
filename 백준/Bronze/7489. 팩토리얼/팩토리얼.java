import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int rightNum = 1;
			for (int i = 2; i <= n; i++) {
				rightNum *= i;
				while(rightNum % 10 == 0) {
					rightNum /= 10;					
				}
				if(rightNum >= 10000) {
					rightNum %= 1000;
				}
			}
			rightNum %= 10;
			sb.append(rightNum).append("\n");
		}//tc
		System.out.println(sb);
	}//main
}
