import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//괄호
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			char[] line = br.readLine().toCharArray();

			// 스택생성
			ArrayDeque<Character> arrDeq = new ArrayDeque<>();

			// VPS 체크.. 디폴트값 true
			boolean isOK = true;
			for (char ch : line) {
				if (ch == ')') {
					// 스택이 비어 있을때 닫힌 괄호는 무조건 틀림!
					if (arrDeq.isEmpty()) {
						isOK = false;
						break;
					}
					// 그렇지 않다면 안에 있는 것은 열린 괄호일테니깐 둘다 나가!
					else {
						arrDeq.pop();
					}
				}
				// 받은 값이 열린 괄호라면... 넣기
				else {
					arrDeq.push('(');
				}
			}
			//반복문이 끝나고 나서 arrDeqㅇㅇ에 남은 값이 있는지 확인... 있다면 잘못된 것
			if (!arrDeq.isEmpty()) {
				isOK = false;
			}
			
			//출력
			if (isOK) {
				sb.append("YES\n");
			}
			else {
				sb.append("NO\n");
			}
		} // tc
		System.out.println(sb);
	}// main
}
