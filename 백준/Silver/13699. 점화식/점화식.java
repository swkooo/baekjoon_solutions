import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger[] numArr = new BigInteger[n + 2];
		numArr[0] = BigInteger.ONE;
		numArr[1] = BigInteger.ONE;
		
		for (int i = 2; i <= n; i++) {
			numArr[i] = BigInteger.ZERO;
			for (int j = 0; j < i; j++) {
				BigInteger temp = numArr[j].multiply(numArr[i - 1 - j]);
				numArr[i] = numArr[i].add(temp);
			}
		}
		
		System.out.println(numArr[n]);
	}//main
}
