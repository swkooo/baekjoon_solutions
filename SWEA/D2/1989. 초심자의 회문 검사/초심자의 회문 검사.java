
import java.util.Scanner;
import java.io.FileInputStream;

//1989. 초심자의 회문 검사
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약 사항]
		 * 
		 * 각 단어의 길이는 3 이상 10 이하이다.
		 * 
		 * 
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에 하나의 단어가 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		String trash = sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {
			String line = sc.nextLine();
			int length = line.length();	// 한줄씩 받아오기
			int answer = 1;	//기본값
			for (int i = 0; i < length; i++) {
				char letter = line.charAt(i); //첫번째 글자

				if(letter != line.charAt(length - i - 1)) {
					answer = 0;
					break;	// 첫글자가 끝글자랑 다르다면 0으로 바꾸고 break
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}//tc
	}//main
}