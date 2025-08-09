import java.util.Scanner;

//최댓값
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < 9; i++) {
			int num = sc.nextInt();
			if (max < num) {
				max = num;
				maxIdx = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(maxIdx);
	}// main
}
