import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;

//1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 테스트케이스의 길이가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
		 * 
		 * 총 10개의 테스트케이스가 주어진다.
		 * 
		 * [출력]
		 * 
		 * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 유효성 여부를 1 또는 0으로 표시한다 (1 - 유효함, 0 - 유효하지
		 * 않음).
		 */
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			String trash = sc.nextLine();
			String line = sc.nextLine();

			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				arr[i] = line.charAt(i);
			}
			// 괄호 종류별로 stack생성 하면 안되겠구나.. 일단 하나의 stack 생성
			ArrayDeque<Character> arrDeq = new ArrayDeque<>(); // ()

			// 이후 스택 안의 값 비교를 위해 map으로 key value 만들기
			Map<Character, Character> map = new HashMap<>();
			map.put(')', '(');
			map.put('}', '{');
			map.put(']', '[');
			map.put('>', '<');
			// 기본값 1: true
			int isOk = 1;
			// 여는 괄호 넣기
			for (char c : arr) {
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					arrDeq.push(c);
					// 여는 괄호가 아니라면?
				} else {
					// 닫는 괄호가 나왔는데 짝지을게 없네? false
					if (arrDeq.isEmpty()) {
						isOk = 0;
						break;
						// 일단 짝지을 건 있어
					} else {
						// 근데 그 짝이 서로 다르네? false
						if (map.get(c) != arrDeq.peek()) {
							isOk = 0;
							break;
						}
						// 짝 지었으니깐 pop으로 날리기
						arrDeq.pop();

					}
				}
			}
			System.out.println("#" + test_case + " " + isOk);
		} // ct
	}// main
}