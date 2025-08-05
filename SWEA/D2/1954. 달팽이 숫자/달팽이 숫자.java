
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		/*
		[제약사항]

		달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)
		
		
		[입력]
		
		가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		
		각 테스트 케이스에는 N이 주어진다.
		
		
		[출력]
		
		각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.
		
		(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        //델타탐색
		int[] dr = {0, 1, 0, -1}; //행 움직이기
		int[] dc = {1, 0, -1, 0}; //열 움직이기
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int [][] arr = new int[N][N];
            //x, y 좌표 첫 시작값... 이동후 값입력하므로 [0][-1]에서부터 시작
			int dx = -1;
			int dy = -0;
			int nNum = 1;	//넣을 숫자
            //3-> 5번, 4 -> 7번, 5-> 9번, 6-> 11번 =>  (배열길이 * 2 - 1)번 시행
			for (int i = 1; i <= arr.length * 2 - 1; i++) {
				int d = (i - 1) % 4;	//델타탐색 반복
				if (d % 2 == 1) {
					N--;					// 세로방향으로 움직일경우 이동길이 - 1
				}
                //델타탐색값에 따라 한칸씩 이동
				for(int n = 1; n <= N; n++) {
					dx += dc[d];
					dy += dr[d];
					arr[dy][dx] = nNum++;				
				}	
			}
			
			
			// 정답 배열 출력
            System.out.println("#" + test_case);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}//tc
	}//main
}