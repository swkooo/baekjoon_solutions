import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//5658. [모의 SW 역량테스트] 보물상자 비밀번호
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * [입력]
		 * 
		 * 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		 * 
		 * 각 테스트 케이스의 첫 번째 줄에는 숫자의 개수 N과 크기 순서 K가 주어 진다.
		 * 
		 * 그 다음 줄에는 16진수 0~F 숫자가 공백 없이 N개 주어진다.
		 * 
		 * 
		 * 
		 * [출력]
		 * 
		 * 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
		 * 
		 * (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] NK = br.readLine().split(" ");
			int N = Integer.parseInt(NK[0]);
			int K = Integer.parseInt(NK[1]);

			char[] line = br.readLine().toCharArray();
			
			//numList에 16진수 10진수로 변환해서 집어넣기
			List<Integer> numList = new LinkedList<>();
			for (char ch : line) {
				numList.add(Character.digit(ch, 16));
			}
			
			//중복제거를 위한 set만들기
			Set<Integer> set = new HashSet<>();
			
			//한변에 들어가는 숫자 수 = 회전하는 횟수 = N / 4
			int tryNum = N / 4;
			int sum = 0;	//  한변의 숫자들의 합
			
			// 회전하는 횟수만큼 numList 돌리기
			for (int i = 0; i < N / 4; i++) {
				int lastNum = numList.remove(N - 1);
				numList.add(0, lastNum);
				
				//
				for (int j = 0; j < N; j++) {
					//각 자리수마다 곱할 16진수 자리 수 곱해서 sum에 더하기
					int power16 = (int) Math.pow(16, (tryNum - (j % tryNum) - 1));
					sum += numList.get(j) * power16;
					//각변에서 몇번째 자리인지 확인하고 마지막이면 set에 집어넣고 sum 초기화
					if (j % tryNum == tryNum - 1) {
						set.add(sum);
						sum = 0;
					}
				}
			}
			
			//set에서 다시 list에 넣기
			List<Integer> num10List = new LinkedList<>();
			for (int i : set) {
				num10List.add(i);
			}
			
			//collections로 정렬하고 뒤집기
			Collections.sort(num10List);
			Collections.reverse(num10List);
			
			//출력 
			System.out.println("#" + test_case + " " + num10List.get(K-1));

		} // tc
	}// main
}