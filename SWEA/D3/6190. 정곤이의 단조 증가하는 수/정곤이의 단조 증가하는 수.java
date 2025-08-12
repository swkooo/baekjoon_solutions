import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//6190. 정곤이의 단조 증가하는 수
class Solution {
	public static void main(String args[]) throws IOException {
		/*
		 * [입력]
		 * 
		 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(1 ≤N ≤ 1,000) 이 주어진다.
		 * 
		 * 두 번째 줄에는 N개의 정수 A1, …, AN(1 ≤ Ai ≤ 30,000) 이 공백 하나로 구분되어 주어진다.
		 * 
		 * 
		 * [출력]
		 * 
		 * 각 테스트 케이스마다 단조 증가하는 수인 Ai x Aj중에서 그 최댓값을 출력한다.
		 * 
		 * 만약 Ai x Aj중에서 단조 증가하는 수가 없다면 -1을 출력한다.
		 * 
		 * 
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}
			
			int max = -1;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					String check = "";
					check += arr[i] * arr [j];
					
					boolean isIncr = true;
					for(int k = 0; k < check.length() - 1; k++) {
						if (check.charAt(k) > check.charAt(k+1)) {
							isIncr = false;
							break;
						}
					}
					if (isIncr) {
						max = Math.max(max, Integer.parseInt(check));
					}
				}
			}
			System.out.println("#" + test_case + " " + max);
		}//tc
	}//main
}