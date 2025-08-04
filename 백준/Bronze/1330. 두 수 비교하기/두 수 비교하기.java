import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		
		// 정수 A, B
		int A = sc.nextInt(), B = sc.nextInt();
		
//		String output;
		
		// 로직
		if(A > B) {
			System.out.println(">");
		}
		else if(A < B) {
			System.out.println("<");
		}
		else {
			System.out.println("==");
		}
	}
}
