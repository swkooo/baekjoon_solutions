import java.util.Scanner;
import java.io.FileInputStream;

//24094. [IL lv2 기본기 다지기] 문제 2: 산의 봉우리
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * 문제 설명 N×N 크기의 지도에서 각 셀은 산의 높이를 나타낸다. 한 셀이 상하좌우로 인접한 모든 셀(존재하는 경우)보다 높다면 그 셀을
		 * “봉우리”라 한다. 지도에 있는 봉우리의 개수를 구하는 프로그램을 작성하라.
		 * 
		 * 
		 * 입력
		 * 
		 * 첫 줄에 테스트 케이스 T가 주어진다. 각 테스트 케이스의 첫 줄에 자연수 N (1 ≤ N ≤ 100)이 주어진다. 이후 N개의 줄에
		 * N개의 정수가 공백으로 구분되어 주어진다. (높이: 1 이상 1000 이하)
		 * 
		 * 출력 각 테스트 케이스마다 “#테스트케이스번호 봉우리개수” 형식으로 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N+2][N+2];
			
			//배열 입력 받기
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//델타 탐색(상하좌우)
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			int cnt = 0;	// 봉우리 개수
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					// 디폴트 값 true로 설정
					boolean isHighest = true;
					
					//확인하고자 하는 좌표값에 대해서
					for (int d = 0; d < 4; d++) {
						
						//좌표의 상하좌우보다 작을 경우 false로 변경
						if(arr[i][j] <= arr[i+dr[d]][j+dc[d]]) {
							isHighest = false;
						}
					}
					//false로 변경되지 않았다면 봉우리 개수 증가
					if (isHighest) {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}//tc
	}//main
}