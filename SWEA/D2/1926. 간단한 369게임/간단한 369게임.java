import java.util.Scanner;

//1926. 간단한 369게임
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약사항]
		 * 
		 * N은 10이상 1,000이하의 정수이다. (10 ≤ N ≤ 1,000)
		 * 
		 * 
		 * 
		 * [입력]
		 * 
		 * 입력으로 정수 N 이 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 1 ~ N까지의 숫자를 게임 규칙에 맞게 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			//숫자를 문자열로 변환
			String num = String.valueOf(i);
			
			String clap = "";	//박수 저장
			boolean isThree = false;	//3,6,9 인지 확인
			for(char ch : num.toCharArray()) {
				//단어 하나씩 확인해서 3, 6, 9라면 박수 저장, isThree true로 바꾸기
				if (ch == '3' || ch == '6' || ch == '9') {
					clap += '-';
					isThree = true;
				}
			}
			//isThree면 박수
			if (isThree) {
				System.out.print(clap + " ");
			}
			//아니면 숫자 출력
			else {
				System.out.print(num + " ");
			}
		}//tc
	}//main
}