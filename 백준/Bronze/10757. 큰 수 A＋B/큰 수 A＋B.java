import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 가변적인 크기를 갖는 참조자료형을 사용!
		BigInteger a = scanner.nextBigInteger();
		BigInteger b = scanner.nextBigInteger();
		
		// a + b를 합하여 출력
		System.out.println(a.add(b));
	}
	
}