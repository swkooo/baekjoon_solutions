import java.util.ArrayDeque;
import java.util.Scanner;

//1225. [S/W 문제해결 기본] 7일차 - 암호생성기
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약 사항]
		 * 
		 * 주어지는 각 수는 integer 범위를 넘지 않는다.
		 * 
		 * 마지막 암호 배열은 모두 한 자리 수로 구성되어 있다.
		 * 
		 * 
		 * [입력]
		 * 
		 * 총 10개의 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고, 그 다음 줄에는 8개의 데이터가 주어진다.
		 * 
		 * [출력]
		 * 
		 * #부호와 함께 테스트케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.
		 */
		Scanner sc = new Scanner(System.in);


		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			
			//큐 생성 및 입력받기
			ArrayDeque<Integer> arrDeq = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				arrDeq.offer(sc.nextInt());
			}
			
			// 반복문 종료조건을 위한 temp 생성
			int temp = 1;
			// 뺄 숫자
			int minusNum = 0;
			while(temp != 0) {
				// 5개 주기로 사이클 돌아가므로 5로 나눈 나머지 + 1
				temp = arrDeq.poll() - (minusNum % 5 + 1);
				// 뺀 값이 0보다 작아지면 스탑
				if (temp <= 0) {
					temp = 0;
				}
				// 뺀 값 뒤에다 넣어주기
				arrDeq.offer(temp);

				minusNum++;
			}
			
			//출력
			System.out.print("#" + test_case);
			for(int i : arrDeq) {
				System.out.print(" " + i);
			}
			System.out.println();	//개행
			
		}//tc
	}//main
}