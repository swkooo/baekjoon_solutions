import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileInputStream;

//1215. [S/W 문제해결 기본] 3일차 - 회문1
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [제약 사항]
		 * 
		 * 각 칸의 들어가는 글자는 'A', 'B', 'C' 중 하나이다.
		 * 
		 * ABA도 회문이며, ABBA도 회문이다. A 또한 길이 1짜리 회문이다.
		 * 
		 * 가로 또는 세로로 이어진 회문의 개수만 센다.
		 * 
		 * 아래 그림에서 노란색 경로를 따라가면 길이 7짜리 회문이 되지만 직선이 아니기 때문에 인정되지 않는다.
		 * 
		 * [입력]
		 * 
		 * 총 10개의 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 찾아야 하는 회문의 길이가 주어지며, 다음 줄에 8x8 크기의 글자판이 주어진다.
		 * 
		 * [출력]
		 * 
		 * #부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 찾은 회문의 개수를 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			String trash = sc.nextLine(); 
			char[][] arr = new char[8][8];	// 배열생성
			
			int cnt = 0;
			char[] checkArr = new char[N];
			for (int i = 0; i < 8; i++) {
				// 행 배열 입력받기
				String line = sc.nextLine();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = line.charAt(j);
				}

				//행 배열 입력받으면서 회문 찾기
				for (int j = 0; j <= 8 - N; j++) {
					for (int n = 0; n < N; n++) {
						checkArr[n] = arr[i][n+j];
					}
					// 기본값 true로 설정
					boolean isOk = true;
					for (int n = 0; n < N; n++) {
						if (checkArr[n] != checkArr[N-n-1]) {
							//비교했을 때 같지 않으면 false로 바꾸로 break
							isOk = false;
							break;
						}
					}
					//같지 않는 경우가 없으면 cnt 증가
					if (isOk) {
						cnt++;
					}
					
				}
				
			}
			
			//열배열도 같은 원리로 적용
			for (int j = 0; j < 8; j++) {
				int checkCnt = 0;
				for (int i = 0; i <= 8 - N; i++) {
					for (int n = 0; n < N; n++) {
						checkArr[n] = arr[n+i][j];
					}
					boolean isOk = true;
					for (int n = 0; n < N; n++) {
						if (checkArr[n] != checkArr[N-n-1]) {
							isOk = false;
							break;
						}
					}
					if (isOk) {
						cnt++;
					}
					
				}
			}
			//정답 출력
			System.out.println("#" + test_case + " " + cnt);

		}
	}
}