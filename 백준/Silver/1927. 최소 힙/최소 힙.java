import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 최소 힙 pq
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (pq.isEmpty() && x == 0) {
				sb.append("0\n");
			}
			else if(x == 0) {
				sb.append(pq.poll() + "\n");
			}
			else {
				pq.add(x);
			}
		}
		// 출력
		System.out.println(sb);
		
	}// main
}
