import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] line = br.readLine().split(" ");

			int changeCnt = Integer.parseInt(line[1]);
			
			ArrayDeque<String> dq = new ArrayDeque<>();	// 만들 숫자를 담을 queue
			dq.add(line[0]);	// 일단 기본 숫자 넣기
			
			for (int cnt = 0; cnt < changeCnt; cnt++) {	// 교환가능 횟수만큼 반복
				int size = dq.size();
				for (int i = 0; i < size; i++) { // queue에 있는 값들에 대해
					char[] arr = dq.poll().toCharArray();	// 일단 꺼내고
					
					for (int j = 0; j < arr.length - 1; j++) {
						// 탐색하려는 숫자 다음 인덱스만 교환
						for (int k = j + 1; k < arr.length; k++) {
							// 교환 실행
							char temp = arr[j];
							arr[j] = arr[k];
							arr[k] = temp;
							
							// 교환한 결과 string으로 변환하고 queue에 없으면 넣기
							String num = new String(arr);
							if (!dq.contains(num)) {
								dq.add(num);
							}
							// 교환한거 되돌리기
							arr[k] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
			
			int max = 0;
			// 교환한 결과값들에 대해 모두 비교하여 max값 찾기
			while(!dq.isEmpty()) {
				max = Math.max(max, Integer.parseInt(dq.poll()));
			}
			
			sb.append("#" + tc + " " + max + "\n");

		} // tc
		System.out.println(sb);
	}// main

}
