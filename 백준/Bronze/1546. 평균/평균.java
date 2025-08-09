import java.util.Scanner;

//평균
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] arr = new double[N];
		double max = 0;

		// 배열 입력받으면서 max값 찾기
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		double avgSum = 0;
		// 문제에서 요구하는 방식대로 평균 구하기
		for (double i : arr) {
			avgSum += i / max * 100;
		}

		System.out.println(avgSum / N);

	}// main
}
