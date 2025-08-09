import java.util.Scanner;

//아스키코드
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char input = sc.next().charAt(0);

		System.out.println(input + '0' - '0');
	}// main
}
