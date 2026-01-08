import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		long rightNum = 1;
		for (long i = 2; i <= n; i++) {
			rightNum *= i;
			if(rightNum >= Integer.MAX_VALUE) {
				rightNum %= 10000000;
			}
			while(rightNum % 10 == 0) {
				rightNum /= 10;					
			}
		}
		System.out.println(rightNum %= 10);
	}//main
}
