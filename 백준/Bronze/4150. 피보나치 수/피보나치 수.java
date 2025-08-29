import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 피보나치 수
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//dp로 해보기
		BigInteger[] fibo = new BigInteger[N + 2];	// 값 범위가 long 도 넘어가기때문에 biginteger로
		fibo[1] = BigInteger.ONE;
		fibo[2] = BigInteger.ONE;
		
		for (int i = 3; i < N + 1; i++) {
			fibo[i] = fibo[i - 2].add(fibo[i - 1]);
			
		}
		
		System.out.println(fibo[N]);
				
	}//main
	
}
