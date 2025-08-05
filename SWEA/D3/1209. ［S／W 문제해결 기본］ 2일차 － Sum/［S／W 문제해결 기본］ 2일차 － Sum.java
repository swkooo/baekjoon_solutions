import java.util.Scanner;

//1209. [S/W 문제해결 기본] 2일차 - Sum
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		[제약 사항]

		총 10개의 테스트 케이스가 주어진다.
		
		배열의 크기는 100X100으로 동일하다.
		
		각 행의 합은 integer 범위를 넘어가지 않는다.
		
		동일한 최댓값이 있을 경우, 하나의 값만 출력한다.
		 
		[입력]
		
		각 테스트 케이스의 첫 줄에는 테스트 케이스 번호가 주어지고 그 다음 줄부터는 2차원 배열의 각 행 값이 주어진다.
		
		[출력]
		
		#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		

		for(int test_case = 1; test_case <= 10; test_case++) {
			int T;
			T=sc.nextInt();
			
			int max = 0;
			int sumX = 0;
			int sumX2 = 0;
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					sum += arr[i][j];
				}
				if (max < sum) {
					max = sum;
				}//배열 받으면서 행값들의 합 더하기
			}//2차원배열 받기
			for (int j = 0; j < 100; j++) {
				int sum = 0;
				for (int i = 0; i < 100; i++) {
					sum += arr[i][j];
					if (i == j) {
						sumX += arr[i][j];
					}
					if ((i + j) == 99) {
						sumX2 += arr[i][j];
					}
				}
				if (max < sum) {
					max = sum;
				}
			}//열검색하면서 열값들의 합 더하기, 대각선 합 구하기
			if (max < sumX) {
				max = sumX;
			}
			if (max < sumX2) {
				max = sumX2;
			}
			
			//정답 출력
			System.out.println("#" + T + " " + max);
		}//tc
	}//main
}