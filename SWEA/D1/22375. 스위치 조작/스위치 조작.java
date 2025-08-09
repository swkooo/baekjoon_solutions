import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;

//22375. 스위치 조작
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * N개의 전등이 설치되어 있다. 각 전등은 1번부터 N번까지 번호가 붙어있고, i번 스위치를 조작하면 i번부터 N번까지의 전등의 켜짐/꺼짐
		 * 상태가 반대가 된다고 한다. 모든 전등의 현재 상태와 스위치 조작 후 상태가 주어지면 최소 몇 개의 스위치를 조작해야 하는지 알아내는
		 * 프로그램을 만드시오.
		 * 
		 * 전등이 켜진 상태는 1, 꺼진 상태는 0으로 주어진다. 예를 들어 현재 상태 A가 0 0 0이고, 조작 후 상태 B가 0 1 0인 경우,
		 * 
		 * 초기상태가 0 0 0 이므로, 2번 스위치를 조작해 0 1 1인 상태를 만들고, 3번 스위치를 조작해 0 1 0인 상태를 만들 수
		 * 있으므로, 최소 2번의 조작이 필요하다.
		 * 
		 * [입력] 첫 줄에 테스트케이스 개수 T, 다음 줄 부터 케이스 별로 스위치 개수 N, 다음 두 줄에 조작 전 스위치 상태 Ai와 조작 후
		 * 상태 Bi가 각각 N개씩 주어진다. (1<=T<=10, 1<=N<=100)
		 * 
		 * [출력] #과 케이스번호, 빈칸으로 구분된 답을 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] Ai = new int[N];
			int[] Bi = new int[N];
			
			// 입력값 각각 받기
			for (int i = 0; i < N; i++) {
				Ai[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				Bi[i] = sc.nextInt();
			}
			
			// 해쉬맵활용해서 1<->0 서로 변환하기
			Map<Integer, Integer> light = new HashMap<>();
			light.put(1, 0);
			light.put(0, 1);
			
			//시행 횟수 카운트
			int cnt = 0;
			
			// Ai와 Bi 배열 비교하기
			for (int i = 0; i < N; i++) {
				//만약 다르다면
				if (Bi[i] != Ai[i]) {
					//i 번째 이후 인덱스 값들 전부 변경
					for (int j = i; j < N; j++) {
						Bi[j] = light.get(Bi[j]);
					}
					//시행횟수 증가
					cnt++;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		} // tc
	}// main
}