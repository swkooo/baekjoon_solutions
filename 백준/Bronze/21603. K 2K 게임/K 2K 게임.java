import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//K 2K 게임
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		K = K % 10;
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if ((i % 10) != K && (i % 10) != K * 2) {
				list.add(i);
			}
		}
		sb.append(list.size() + "\n");
		for(int num : list) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
		
	}//main
}
