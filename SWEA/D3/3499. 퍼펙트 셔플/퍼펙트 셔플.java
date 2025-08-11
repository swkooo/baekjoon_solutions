import java.util.ArrayDeque;
import java.util.Scanner;

//3499. 퍼펙트 셔플
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]
		 * 
		 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 자연수 N(1 ≤ N ≤ 1,000)이 주어진다.
		 * 
		 * 두 번째 줄에는 덱에 카드가 놓인 순서대로 N개의 카드 이름이 공백으로 구분되어 주어진다.
		 * 
		 * 카드의 이름은 알파벳 대문자와 ‘-’만으로 이루어져 있으며, 길이는 80이하이다.
		 * 
		 * [출력]
		 * 
		 * 각 테스트 케이스마다 주어진 덱을 퍼펙트 셔플한 결과를 한 줄에 카드 이름을 공백으로 구분하여 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			//큐 2개 만들기
			ArrayDeque<String> arrDeq1 = new ArrayDeque<>();
			ArrayDeque<String> arrDeq2 = new ArrayDeque<>();
			
			for (int i = 0; i < N; i++) {
				//N이 짝수인 경우
				if (N % 2 == 0) {
					if (i < N / 2) {
						arrDeq1.add(sc.next());
					}
					else {
						arrDeq2.add(sc.next());
					}
				}
				//N이 홀수인 경우
				else {
					if (i < N / 2 + 1) {
						arrDeq1.add(sc.next());
					}
					else {
						arrDeq2.add(sc.next());
					}
				}
			}
			
			//출력
			System.out.print("#" + test_case);
			//어차피 최대 N / 2 + 1 있으니깐..
			for (int i = 0; i < N / 2 + 1; i++) {
				//그냥 큐가 비어있지 않으면 출력하는 방식
				if (!arrDeq1.isEmpty()) {
					System.out.print(" " + arrDeq1.poll());
				}
				if (!arrDeq2.isEmpty()) {
					System.out.print(" " + arrDeq2.poll());
				}
			}
			System.out.println();
		}//tc
	}//main
}