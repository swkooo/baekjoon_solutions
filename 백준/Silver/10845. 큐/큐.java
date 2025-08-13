import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//큐
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// 큐 만듬
		ArrayDeque<String> arrDeq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			String command = line[0];

			// 명령어 별로 명령 수행
			// push
			if (command.equals("push")) {
				arrDeq.offer(line[1]);
			}
			// pop
			else if (command.equals("pop")) {
				// 비어있으면 -1 출력
				if (arrDeq.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(arrDeq.pop() + "\n");
				}
			}
			//size
			else if (command.equals("size")) {
				sb.append(arrDeq.size() + "\n");
			}
			//empty
			else if (command.equals("empty")) {
				if (arrDeq.isEmpty()) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			//front
			else if (command.equals("front")) {
				if (arrDeq.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(arrDeq.peekFirst() + "\n");
				}
			}
			//back
			else if (command.equals("back")) {
				if (arrDeq.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(arrDeq.peekLast() + "\n");
				}
			}
		}
		//출력
		System.out.println(sb);

	}// main
}
