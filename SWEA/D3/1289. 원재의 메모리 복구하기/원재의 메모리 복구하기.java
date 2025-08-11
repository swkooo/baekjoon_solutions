import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1289. 원재의 메모리 복구하기
class Solution {
	public static void main(String args[]) throws IOException {
		/*
		 * [입력]
		 * 
		 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		 * 
		 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 메모리의 원래 값이 주어진다.
		 * 
		 * 메모리의 길이는 1이상 50이하이다.
		 * 
		 * [출력]
		 * 
		 * 각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고,
		 * 
		 * 초기값(모든bit가 0)에서 원래 값으로 복구하기 위한 최소 수정 횟수를 출력한다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			char[] line = br.readLine().toCharArray();
			// 바꾸는 횟수
			int cnt = 0;
			for (int i = 0; i < line.length; i++) {
				//000... 에서 주어진 상태로 돌아가는거나 반대로 가는거나 똑같음
				if (line[i] == '1') {
					for (int j = i + 1; j < line.length; j++) {
						//0일경우 1로 바꾸고 1이면 0으로
						if (line[j] == '0') {
							line[j] = '1';
						} else {
							line[j] = '0';
						}
					}
					//바꾸면 cnt 증가
					cnt++;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(cnt);
			
			System.out.println(sb);
			
		} // tc
	}// main
}