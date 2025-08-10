import java.util.ArrayDeque;
import java.util.Scanner;

//1234. [S/W 문제해결 기본] 10일차 - 비밀번호
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]
		 * 
		 * 10개의 테스트 케이스가 10줄에 걸쳐, 한 줄에 테스트 케이스 하나씩 제공된다.
		 * 
		 * 각 테스트 케이스는 우선 문자열이 포함하는 문자의 총 수가 주어지고, 공백을 둔 다음 번호 문자열이 공백 없이 제공된다.
		 * 
		 * 문자열은 0~9로 구성되며 문자열의 길이 N은 10≤N≤100이다. 비밀번호의 길이는 문자열의 길이보다 작다.
		 * 
		 * [출력]
		 * 
		 * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답(비밀번호)을 출력한다.
		 */
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			// 문자열 통째로 받아서 공백 기준으로 나누기
			String[] line = sc.nextLine().split(" ");
			int N = Integer.parseInt(line[0]);
			char[] arr = line[1].toCharArray();

			// 스택 생성
			ArrayDeque<Character> arrDeq = new ArrayDeque<Character>();

			// 뒤에서 부터 확인, 스택에 있는 거랑 같으면 둘다 제거 아니면 push
			// arrDeq.reversed가 안된다고 해서 넣는걸 그냥 뒤에서 부터 하면 될듯?
			for (int i = N - 1; i >= 0; i--) {
				boolean isDiff = true;

				if (!arrDeq.isEmpty()) {
					if (arrDeq.peek() == arr[i]) {
						arrDeq.pop();
						isDiff = false;

					}
				}
				if (isDiff) {
					arrDeq.push(arr[i]);
				}
			}

			// 출력
			System.out.print("#" + test_case + " ");
			for (char ch : arrDeq) {
				System.out.print(ch);
			}
			System.out.println();
		} // tc
	}// main
}