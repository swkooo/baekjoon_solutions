import java.util.Scanner;

//연속인가??
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = sc.nextLong();
		
		if ((a * k + b) == (c * k + d)) {
			System.out.println("Yes " + (a * k + b));
		}
		else {
			System.out.println("No");
		}
		
	}//main
}
