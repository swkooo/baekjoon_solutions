import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//백준 구구단
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 1; i < 10; i++) {
			System.out.println(N + " * " + i + " = " + (N * i));
//			System.out.printf("%d * %d = %d\n", N, i, N*i);
		}
	}
	
}
