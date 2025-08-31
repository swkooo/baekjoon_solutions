import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

// 숨바꼭질
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] NK = br.readLine().split(" ");

		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);

		ArrayDeque<Integer> dq = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<Integer>();
		dq.add(N);
		visited.add(N);	// 처음값 방문기록 추가

		int cnt = 0;

		if (N >= K) {	// 동생이 수빈이보다 뒤에 있으면 무조건 1칸씩 뒤로 이동밖에 없음
			System.out.println(N - K);
		}
		
		// 동생이 앞에 있을 경우..
		else {
			boolean isFound = false;	
			while (!isFound) {			// 동생을 찾을때까지 반복
				int size = dq.size();	
				// 큐 사이즈(cnt 단계에서 갈 수 있는 경우의 수) 만큼 반복
				for (int i = 0; i < size; i++) {
					int check = dq.poll();	// dq에서 1개씩 꺼내서
					// 꺼낸 값이 동생위치일 경우
					if (check == K) {
						isFound = true;	// 반복문 중단하고
						System.out.println(cnt);	// 이동시간 출력
						break;
					}
					
					// 이동 값이 바운더리를 벗어나지 않는다면, 방문기록에 없으면 추가
					if (check - 1 >= 0 && !visited.contains(check - 1)) {
						dq.add(check - 1);	// 다음 이동큐에 추가
						visited.add(check - 1);	// 방문했다고 기록
					}
					if (check + 1 <= 100000 && !visited.contains(check + 1)) {
						dq.add(check + 1);
						visited.add(check + 1);
					}
					if (check * 2 <= 100000 && !visited.contains(check * 2)) {
						dq.add(check * 2);
						visited.add(check * 2);
					}
				}
				// 이동시간 증가
				cnt++;
			} // while 반복문
		}
	}// main
}
