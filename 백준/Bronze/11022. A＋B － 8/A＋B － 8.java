import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int ans = A + B;
			System.out.printf("Case #%d: %d + %d = %d\n", tc, A, B, ans);
	
		}//tc
	}//main
}