import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

// 1961. 숫자 배열 회전
public class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		[제약 사항]

		N은 3 이상 7 이하이다.
		
		[입력]
		
		가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		
		각 테스트 케이스의 첫 번째 줄에 N이 주어지고,
		
		다음 N 줄에는 N x N 행렬이 주어진다.
		
		[출력]
		
		출력의 첫 줄은 '#t'로 시작하고,
		
		다음 N줄에 걸쳐서 90도, 180도, 270도 회전한 모양을 출력한다.
		
		입력과는 달리 출력에서는 회전한 모양 사이에만 공백이 존재함에 유의하라.
		
		(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}	
			}//배열입력
			int[] turn90 = new int[N];
			int[] turn180 = new int[N];
			int[] turn270 = new int[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					turn90[j] = arr[N-1-j][i];
					turn180[j] = arr[N-1-i][N-1-j];
					turn270[j] = arr[j][N-1-i];
				}
				for(int k : turn90) {
					System.out.print(k);
				}
				System.out.print(" ");
				for(int k : turn180) {
					System.out.print(k);
				}
				System.out.print(" ");
				for(int k : turn270) {
					System.out.print(k);
				}
				System.out.println();
			}
			
		}//tc 반복문
	}//main
}