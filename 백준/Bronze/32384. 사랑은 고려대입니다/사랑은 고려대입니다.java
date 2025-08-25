import java.util.Scanner;

// 사랑은 고려대입니다
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			sb.append("LoveisKoreaUniversity ");
		}
		System.out.println(sb);
	}
}
