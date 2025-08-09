import java.util.Scanner;

//웰컴 키트
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = sc.nextInt();
		}
		int T = sc.nextInt();
		int P = sc.nextInt();

		// 티셔츠 묶음
		int cntT = 0;
		for (int i : arr) {
			// 딱 안나눠 떨어지면 묶음 개수 증가
			if (i % T != 0) {
				cntT++;
			}
			cntT += i / T;
		}
		System.out.println(cntT);

		// 펜 묶음
		System.out.println(N / P + " " + N % P);

	}// main
}
