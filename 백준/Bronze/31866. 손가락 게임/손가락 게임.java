import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//손가락 게임
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		Map<Integer, Integer> rsp = new HashMap<>();

		rsp.put(0, 2); // 바위 > 가위
		rsp.put(2, 5); // 가위 > 보
		rsp.put(5, 0); // 보 > 바위

		if (!rsp.containsKey(A) && !rsp.containsKey(B)) { // 둘다 가위바위보에 해당하지 않는걸 냈을 때
			System.out.println("=");
		} 
		else if (A == B) {
			System.out.println("=");
		}
		// A가 이기는 경우
		else if (rsp.containsKey(A) && (!rsp.containsKey(B) || B == rsp.get(A))) {
			System.out.println(">");
		}
		// B가 이기는 경우
		else if (rsp.containsKey(B) && (!rsp.containsKey(A) || A == rsp.get(B))) {
			System.out.println("<");
		}

	}// main
}
