import java.util.Scanner;

//1217. [S/W 문제해결 기본] 4일차 - 거듭 제곱
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약 사항] java: import java.util.Scanner; c/c++: #include 를 제외한 나머지 라이브러리 사용을
		 * 금한다.
		 * 
		 * 총 10개의 테스트 케이스가 주어진다.
		 * 
		 * 결과 값은 Integer 범위를 넘어가지 않는다.
		 * 
		 * [입력]
		 * 
		 * 각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고 그 다음 줄에는 두 개의 숫자가 주어진다.
		 * 
		 * [출력]
		 * 
		 * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T= sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + test_case + " " + Power(N, M));
			
			
			
		}//tc
	}//main
	
	//거듭제곱 함수 만들기
	public static int Power(int N, int M) {
		
		//기본부분
		if (M <= 1) {
			return N;
		}
		
		//재귀부분
		return N * Power(N , M - 1);
	}
}