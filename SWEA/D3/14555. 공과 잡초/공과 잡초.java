import java.util.ArrayDeque;
import java.util.Scanner;

//14555. 공과 잡초
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]
		 * 
		 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		 * 
		 * 각 테스트 케이스는 한 개의 줄로 이루어지며, 각 줄에는 길이가 1이상 50 이하인 문자열 S가 주어진다. 이 문자열은 위의 과정을 통해
		 * 만들어졌음이 보장된다.
		 * 
		 * [출력]
		 * 
		 * 각 테스트 케이스마다, 초원에 놓였을 수 있는 공의 개수의 최솟값을 구하는 프로그램을 작성하라.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = Integer.parseInt(sc.nextLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			char[] arr = sc.nextLine().toCharArray();

			// 스택생성
			ArrayDeque<Character> arrDeq = new ArrayDeque<>();

			int cnt = 0;
			for (char ch : arr) {
				//스택이 비어 있지 않다면
				if (!arrDeq.isEmpty()) {
					//스택안 확인해서 열린괄호라면 꺼내고 갯수 증가하고 뒤에거 받지 않고 넘어가기
					if (arrDeq.peek() == '(') {
						arrDeq.pop();
						cnt++;
						continue;
					}
				}
				//닫힌 괄호라면 갯수 증가(앞이 열린괄호일 continue로 넘어가기 때문에 카운트 x)
				if (ch == ')') {
					cnt++;
				}
				//일단 집어 넣어
				arrDeq.push(ch);
			}
			
			//출력
			System.out.println("#" + test_case + " " + cnt);

		} // tc
	}// main
}