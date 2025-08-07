import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileInputStream;

// 5432. 쇠막대기 자르기
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]
		 * 
		 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대
		 * 100,000이다.
		 * 
		 * [출력]
		 * 
		 * 각 테스트 케이스마다 #T를 출력하고 한 칸을 띄운 후, 잘려진 조각의 총 개수를 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		String trash = sc.nextLine();

		
		for (int test_case = 1; test_case <= T; test_case++) {
			String line = sc.nextLine(); // 한줄 입력받기
			int stick = 0;
			int cnt = 0;
			ArrayDeque<Character> arrDec = new ArrayDeque<>();
			for (int i = 0; i < line.length(); i++) {
				// stick 확인
				if (line.charAt(i) == '(') {
					arrDec.push('(');
					stick++;
				}
				else {
					//레이저로 자르기(pop), 쌓인 stick 만큼 갯수증가
					if (line.charAt(i-1) == '(') {
						stick--;
						arrDec.pop();
						cnt += stick;
					}
					//괄호 닫기, stick 1개 차감, 갯수 1 증가
					else {
						stick--;
						cnt++;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}//tc
	}//main
}