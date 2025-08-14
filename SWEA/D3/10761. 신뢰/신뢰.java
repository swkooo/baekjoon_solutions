import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//10761. 신뢰

class Solution {
	public static void main(String args[]) throws IOException {
		/*
		 * [입력]
		 * 
		 * 첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.
		 * 
		 * 각 테스트 케이스는 다음과 같이 구성되었다.
		 * 
		 * 1. 첫 번째 정수는 테스트에서 눌러야 하는 버튼의 개수 N 이다. (1 <= N <= 100)
		 * 
		 * 2. 이후 버튼 N개가 공백으로 구분되어 한 줄에 주어진다. 버튼이 “O x” 의 형태이면 오렌지가 버튼 x를 눌러야 하며, “B x”의
		 * 형태이면 블루가 버튼 x를 눌러야 한다. (1 <= x <= 100)
		 * 
		 * 
		 * [출력]
		 * 
		 * 각 테스트 케이스마다 최소 시간을 출력하라
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] line = br.readLine().split(" ");

			int N = Integer.parseInt(line[0]);
			
			//눌러야 하는 버튼, 각각의 버튼의 위치 나눠서 queue에 저장
			ArrayDeque<String> button = new ArrayDeque<>();
			ArrayDeque<Integer> BmoveList = new ArrayDeque<>();
			ArrayDeque<Integer> OmoveList = new ArrayDeque<>();

			for (int i = 1; i < line.length; i += 2) {
				if (line[i].equals("B")) {
					button.offer(line[i]);
					BmoveList.add(Integer.parseInt(line[i + 1]));
				} else {
					button.offer(line[i]);
					OmoveList.add(Integer.parseInt(line[i + 1]));
				}
			}
			
			//B와 O로봇의 현재위치는 1
			int BNow = 1;
			int ONow = 1;

			int totalTime = 0;
			int size = button.size();
			//button queue에 들어있는 만큼 반복
			while (size > 0) {
				int time = 1; // 기본적으로 버튼 누르는 시간
				String currButton = button.poll();
				size--;
				// 꺼냈는데 B버튼이면
				if (currButton.equals("B")) {
					int targetB = BmoveList.poll();	//B가 이동해야 할 버튼위치 꺼내기
					while (targetB != BNow) { // target에 도착하기까지 B 이동
						if (targetB > BNow) {
							BNow++;
							time++;
						} else if (targetB < BNow) {
							BNow--;
							time++;
						}
						if (!OmoveList.isEmpty()) {	// O의 다음 타겟이 있다면
							int targetO = OmoveList.peek();	// O가 이동해야 할 버튼위치 확인
							if (targetO > ONow) {	// B가 이동하는동안 O도 이동
								ONow++;
							} else if (targetO < ONow) {
								ONow--;
							}
						}
					}
					//B가 버튼을 누르는 1초동안 O가 이동할 수 있으면 이동
					if (!OmoveList.isEmpty()) {
						int targetO = OmoveList.peek();
						if (targetO > ONow) {
							ONow++;
						} else if (targetO < ONow) {
							ONow--;
						}
					}
					
				}
				// 꺼냈는데 O버튼이면... B버튼 로직 반대로 똑같이 적용
				if (currButton.equals("O")) {
					int targetO = OmoveList.poll();

					while (targetO != ONow) {
						if (targetO > ONow) {
							ONow++;
							time++;
						} else if (targetO < ONow) {
							ONow--;
							time++;
						}
						if (!BmoveList.isEmpty()) {
							int targetB = BmoveList.peek();
							if (targetB > BNow) {
								BNow++;
							} else if (targetB < BNow) {
								BNow--;
							}
						}
					}
					
					if (!BmoveList.isEmpty()) {
						int targetB = BmoveList.peek();
						if (targetB > BNow) {
							BNow++;
						} else if (targetB < BNow) {
							BNow--;
						}
					}
				}
				//총 시간에 버튼을 누르러 움직인 시간을 더한다.
				totalTime += time;
			}
			
			// 걸린 총 시간 출력
			System.out.println("#" + test_case + " " + totalTime);
		} // tc
	}// main
}