import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// 좌표 압축
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] line = br.readLine().split(" ");
		
		int[] arr = new int[N];
		Set<Integer> noDup = new HashSet<>();	// rank를 매기기 위해 입력값 중복 제거
		// set과 arr에 동시에 입력받기
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(line[i]);
			arr[i] = num;
			noDup.add(num);
		}
		
		PriorityQueue<Integer> rank = new PriorityQueue<>();	// 최소 힙
		
		// 중복제거된 값들 최소 힙에 넣기
		for(int num : noDup) {
			rank.add(num);
		}
		
		Map<Integer, Integer> numRank = new HashMap<>(); // 숫자와 순위 맵핑
		
		int size = rank.size();
		for (int i = 0; i < size; i++) {
			numRank.put(rank.poll(), i);	// 최소힙에서 꺼내서 순위 매기기
		}

		// 배열돌면서 맵에 매겨진 순위에 따라 sb에 추가
		for (int i = 0; i < N; i++) {
			sb.append(numRank.get(arr[i]) + " ");
		}
		
		// 출력
		System.out.println(sb);
	}//main
}
