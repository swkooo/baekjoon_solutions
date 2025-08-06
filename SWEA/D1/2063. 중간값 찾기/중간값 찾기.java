import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

//2063. 중간값 찾기
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약 사항]
		 * 
		 * 1. N은 항상 홀수로 주어진다.
		 * 
		 * 2. N은 9이상 199 이하의 정수이다. (9 ≤ N ≤ 199)
		 * 
		 * 
		 * [입력]
		 * 
		 * 입력은 첫 줄에 N 이 주어진다.
		 * 
		 * 둘째 줄에 N 개의 점수가 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * N 개의 점수들 중, 중간값에 해당하는 점수를 정답으로 출력한다.
		 */
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int mid = N / 2; // 중간 인덱스 찾기
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		} // 배열 입력받기
		Arrays.sort(arr); // 오름차순 정렬
		System.out.println(arr[mid]);
	}
}