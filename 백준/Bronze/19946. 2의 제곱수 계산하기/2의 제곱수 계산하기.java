import java.math.BigInteger;
import java.util.Scanner;

//2의 제곱수 계산하기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger N = sc.nextBigInteger();	//biginteger로 받아서
		
		int cnt = 0;
		BigInteger two = BigInteger.valueOf(2);
		while(N.remainder(two).equals(BigInteger.ZERO)) {	// 2로 나눈 나머지가 0이면 반복
			N = N.divide(two); // 2로 나누고
			cnt++;	// cnt 증가
		}
		
		System.out.println(64 - cnt);
	}//main
}
