import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//요세푸스 문제 0
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = sc.nextInt();
		int K = sc.nextInt();

		List<Integer> list = new LinkedList<>();

		// 1~N까지 숫자 리스트 만들기
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int size = list.size();
		int removeIdx = K - 1;
		while (size > 1) {
			removeIdx = removeIdx % size;
			sb.append(list.remove(removeIdx) +", ");
			
			//내가 뺀 값의 인덱스가 줄었으므로 추가로 -1 해줌
			removeIdx += K - 1;
			size--;
		}
		//마지막 값은 >와 함께 출력
		sb.append(list.get(0) + ">");
		// 출력
		System.out.println(sb);
	}// main
}
