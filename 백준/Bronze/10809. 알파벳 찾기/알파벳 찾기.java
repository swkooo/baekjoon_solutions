import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//알파벳 찾기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		char[] line = sc.nextLine().toCharArray();

		List<Integer> alphList = new ArrayList<>();
		
		// Character 숫자 값: (a = 97) ~ (z = 122)... alphabet - 97 => 0 ~ 25 값
		for (char ch : line) {
			alphList.add(ch - 97);
		}
		
		// 알파벳 번호 a~z까지 탐방하면서
		for (int i = 0; i <= 25; i++) {
			//list에 있으면 인덱스 출력
			if (alphList.contains(i)) {
				sb.append(alphList.indexOf(i) + " ");
			}
			//없으면 -1 출력
			else {
				sb.append(-1 + " ");
			}
		}
		//출력
		System.out.println(sb);
	}// main
}
