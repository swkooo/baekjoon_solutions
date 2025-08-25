import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//나무 자르기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");

		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);

		String[] line = br.readLine().split(" ");
		// 최대 힙 생성
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		pq.add(0);	// 마지막 나무 비교를 위해 0 
		
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(line[i]));	// 최대 힙에 나무들 넣기
		}
		
		// 일단 나무 중 최대 높이 찾아 놓기
		int maxHeight = pq.peek();

		long sum = 0;	// 합 구하면서 int 범위 넘을 수도 있음 long
		int cut = 0;	// 가장 높은 나무 기준 자를려고 하는 높이
		for (int i = 1; i <= N; i++) {
			int maxCheck = pq.poll();	// 현재 확인하는 가장 높은 나무 높이
			int maxNext = pq.peek();	// 다음 나무 높이

			long diff = maxCheck - maxNext;	// 두 나무의 차이
			
			if (sum + (diff * i) >= M) {	// 지금까지 자른 나무의 높이 합과 다음 자르려는 나무 차 * i 번째의 길이가 M의 값을 넘어간다면... -> 이때 int값 범위 넘어갈 수 있음
//				System.out.println(diff + " " + i);
				cut += (M - sum) / i;		// 일단 자를 수 있는 만큼 자르고
				if ((M - sum) % i != 0) {	// 나머지가 0이 아니라 잘라야 할 길이가 조금 남는다면...
					cut += 1;	// 1미터만 더 자르기
				}
				break;
			}
			cut += diff;		// 그게 아니라면 자르는 길이 더하고
			sum += diff * i;	// 여태까지 자른 나무들의 길이 합도 더하고

		}
		// 가장 큰 나무 높이에서 자르려는 높이 뺀 값 출력
		System.out.println(maxHeight - cut);
	}// main
}
