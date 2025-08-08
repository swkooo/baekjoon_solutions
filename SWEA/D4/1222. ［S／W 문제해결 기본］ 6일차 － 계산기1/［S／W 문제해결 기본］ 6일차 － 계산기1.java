import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 문자열 계산식의 길이가 주어진다. 그 다음 줄에 문자열 계산식이 주어진다.
		 * 
		 * 총 10개의 테스트 케이스가 주어진다.
		 * 
		 * [출력]
		 * 
		 * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 답을 출력한다.
		 * 
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			String trash = sc.nextLine();
			String line = sc.nextLine();

			// 일단 문제에서 요구하는 대로 후위연산식부터 만들어보자...
			String postFix = ""; // 후위연산식 담을 문자열
			ArrayDeque<Character> stack1 = new ArrayDeque<>(); // 연산자 담을 stack

			// 입력받은 문자열에 대해서 하나씩 체크
			for (char ch : line.toCharArray()) {

				// 만약 숫자라면
				if (Character.isDigit(ch)) {
					postFix += ch; // 후위연산식에 넣기
				}

				// 연산자라면 스택에 넣기(여기선 +만 띵킹)
				else {
					// 스택이 비어 있지 않다면! -> pop할 때 에러 안나게 하기 위해
					if (!stack1.isEmpty()) {
						postFix += stack1.pop(); // 스택에 저장된 연산자(+) 꺼내서 후위연산식에 넣기
					}
					stack1.push(ch);
				}
			}
			postFix += stack1.pop(); // 원래는 while이지만 이 문제에서는 어차피 + 한개만 남았을것이므로...

			// 후위연산식가지고 계산해보기!
			ArrayDeque<Integer> stack2 = new ArrayDeque<>(); // 이번엔 계산숫자를 담을 stack
			for (char ch : postFix.toCharArray()) {
				if (Character.isDigit(ch)) {
					stack2.push(ch - '0'); // ch에 '0'값 뺴주는걸로 int형으로 변환시키기
				} else {
					// stack 위에 쌓이 2개 꺼내기
					int sec = stack2.pop();
					int fst = stack2.pop();

					// 꺼낸거 더하기(+라 순서 상관없긴 함..)
					stack2.push(fst + sec);
				}
			}
			// stack 맨 밑에 있는게 정답!
			int answer = stack2.pop();

			System.out.println("#" + test_case + " " + answer);
		} // tc
	}// main
}