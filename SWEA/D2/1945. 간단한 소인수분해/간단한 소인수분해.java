import java.util.Scanner;
import java.io.FileInputStream;

//1945. 간단한 소인수분해
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		[제약 사항]

		N은 2 이상 10,000,000 이하이다.
		
		
		[입력]
		
		가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		
		각 테스트 케이스의 첫 번째 줄에 N 이 주어진다.
		
		
		[출력]
		
		출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		
		(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = {2, 3, 5, 7, 11};
			for (int i = 0; i < arr.length; i++) {
				int cnt = 0;
				while(N % arr[i] == 0) {
					N = N / arr[i];
					cnt++;
				}
				arr[i] = cnt;
			}
			System.out.print("#" + test_case + " ");
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}//tc
	}//main
}