import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

//8931. 제로
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]

		 * 첫 번째 줄에 테스트 케이스의 수 TC가 주어진다.
		 * 
		 * 각 테스트 케이스는 다음과 같이 구성되었다.

		 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)

		 * 이후 K개의 줄에 정수가 하나씩 주어진다. 정수는 0 이상 100000 이하의 값이다.

		 * 만약 정수가 0일 경우에는 최근에 쓰고 지우지 않았던 수를 지워야 하며, 그렇지 않을 경우 해당 수를 써야 한다.

		 * 정수가 0일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.

		 * [출력]
		 * 
		 * 각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
		 * 
		 * 각 테스트 케이스마다 한 줄씩 재민이가 받아 적은 수의 합을 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
			ArrayDeque<Integer> arrDec = new ArrayDeque<>();
			
			int sum = 0;
			//입력받으면서 합계 같이 구하기!
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if (num != 0) {
					arrDec.push(num);
					sum += num;		// 입력 받은 값이 0이 아니면 스택에 일단 넣어! + sum에 더해!
				}
				else {
					if (! arrDec.isEmpty()) {
						sum -= arrDec.pop();	// 0이면 스택에서 1개 빼면서 sum에서 빼!
					}
				}	
			}
			
			System.out.println("#" + test_case + " " + sum);
		}//tc
	}//main
}