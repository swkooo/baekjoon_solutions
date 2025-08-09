import java.util.Scanner;

//이항 계수 1
// n! 나누기 r!(n-r)!
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		System.out.println(Factorial(N) / (Factorial(K) * Factorial(N - K)));
	}// main

	public static int Factorial(int num) {
		// 기본부분
		if (num <= 1) {
			return 1;
		}
		return num * Factorial(num - 1);
	}
}
