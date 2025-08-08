import java.util.Scanner;
import java.io.FileInputStream;

//9386. 연속한 1의 개수
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * N개의 0과 1로 이루어진 수열에서 연속한 1의 개수 중 최대값을 출력하는 프로그램을 만드시오.
		 * 
		 * 입력 첫 줄에 테스트케이스 개수 T, 다음 줄부터 테스트케이스별로 첫 줄에 수열의 길이 N, 다음 줄에 N개의 0과1로 구성된 수열이
		 * 공백없이 제공된다. 1<=T<=10, 10<=N<=1000
		 * 
		 * 출력 #과 테스트케이스 번호, 빈칸에 이어 답을 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			String trash = sc.nextLine();
			String line = sc.nextLine();
			
			int max = 0;
			int cnt = 0;
			for(char num : line.toCharArray()) {
				// 배열에서 차례대로 숫자 1인지 체크, 맞으면 갯수 증가 cnt와 max값 비교 후 갱신
				if ((num - '0') == 1) {
					cnt++;
					if (max < cnt) {
						max = cnt;
					}
				}
				//cnt 초기화
				else {
					cnt = 0;
				}
			}
			System.out.println("#" + test_case + " " + max);
			
		}//tc	
	}//main
}