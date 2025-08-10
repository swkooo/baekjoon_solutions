import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//하노이탑 이동 순서
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//시행횟수는 2의 n승 - 1 / math.pow로 구하는 방법이 느리다고 해서 비트 연산자로 변경
		System.out.println((1 << N) - 1);
		
		//시행 과정 출력
		Hanoi(N, "1", "3", "2");
		System.out.println(sb);

	}// main
	static StringBuilder sb = new StringBuilder();
	public static void Hanoi(int num, String from, String to, String via) {
		if (num <= 1) {
//			System.out.println(from + " " + to); // 최종적으로 목적지
			
			sb.append(from + " " + to + "\n");
		} else {
			Hanoi(num - 1, from, via, to); // 경유지로 일단 옮기고
			sb.append(from + " " + to + "\n");
			Hanoi(num - 1, via, to, from); // 경유지에서 목적지로
		}
	}
}
