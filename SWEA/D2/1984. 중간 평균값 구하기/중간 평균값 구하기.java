import java.util.Iterator;
import java.util.Scanner;

//1984. 중간 평균값 구하기
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		[제약 사항]

		각 수는 0 이상 10000 이하의 정수이다.
		
		
		[입력]
		
		가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		
		각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.
		
		
		[출력]
		
		출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		
		(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}//입력받기
			int max = 0;
			int maxCnt = 0;
			int min = 10000;
			int minCnt = 0;
			for(int num : arr) {
				if (num > max) {
					max = num;
				}//최대값
				if (num < min) {
					min = num;
				}//최소값
			}//배열순회
			double sum = 0;
			for(int num : arr) {
				if (num == max) {
					maxCnt++;
					continue;
				}
				if (num == min) {
					minCnt++;
					continue;
				}
				sum += num;
			}//최대최소값이 아닐경우 합하기
			double ans = sum / (10 - maxCnt - minCnt);
			int result = (int) Math.round(ans);
			System.out.println("#" + test_case + " " + result);
		}//tc
	}//main
}