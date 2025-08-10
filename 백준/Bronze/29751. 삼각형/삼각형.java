import java.util.Scanner;

//삼각형
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Double W = sc.nextDouble();
		Double H = sc.nextDouble();

		System.out.printf("%.1f", (W * H / 2));
	}
}
