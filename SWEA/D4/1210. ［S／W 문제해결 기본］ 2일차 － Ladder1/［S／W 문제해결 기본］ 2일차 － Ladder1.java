import java.util.Scanner;

//1210. [S/W 문제해결 기본] 2일차 - Ladder1
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		[제약 사항]

		한 막대에서 출발한 가로선이 다른 막대를 가로질러서 연속하여 이어지는 경우는 없다.
		
		[입력]
		
		입력 파일의 첫 번째 줄에는 테스트 케이스의 번호가 주어지며, 바로 다음 줄에 테스트 케이스가 주어진다.
		
		총 10개의 테스트 케이스가 주어진다.
		
		[출력]
		
		#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 도착하게 되는 출발점의 x좌표를 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[100][102];	// 양옆에 0값 주어서 패딩하기
		for(int test_case = 1; test_case <= 10; test_case++) {
			int T;			
			T=sc.nextInt();
			
			int dx = 0;
			int dy = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 1; j <= 100; j++) {	// 패딩했기 때문에 열인덱스 1~100 지정
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 2) { //도착지점 좌표 체크
						dx = j;
						dy = i;
					}
				}
			} // 2차원배열 받기

			//밑에서부터 올라가기
			while(dy != 0) {	
				while (arr[dy][dx-1] == 1) {
					arr[dy][dx-1] = 0;
					dx--;
				}
				
				while (arr[dy][dx+1] == 1) {
					arr[dy][dx+1] = 0;
					dx++;
				}
				dy--;
			}
			
			System.out.println("#" + T + " " + (dx - 1));
		}//tc
	}//main
}