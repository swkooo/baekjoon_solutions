import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<int[]> list1 = new ArrayList<>();
		List<int[]> list2 = new ArrayList<>();
		
		for (int i = 1; i <= n + 2; i++) {
			if (n % i == 0) {
				list1.add(new int[] {i, n / i});
			}
			if ((n + 2) % i == 0) {
				list2.add(new int[] {i, (n + 2) / i});
			}
		}
		
		boolean isOK = false;
		for (int i = 0; i < list1.size(); i++) {
			int a = list1.get(i)[0];
			int c = list1.get(i)[1];
			for (int j = 0; j < list2.size(); j++) {
				int d = -list2.get(j)[0];
				int b = list2.get(j)[1];
				if((a * d + b * c) == n + 1) {
					isOK = true;
					System.out.println(a + " " + b + " " + c + " " + d);
					break;
				}
			}
		}
		if (!isOK) {
			System.out.println(-1);
		}
		
	}//main
}
