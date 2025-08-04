import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String trash = sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			String line = sc.nextLine();
			String[] arr = line.split(",");
			int sum = 0;
			for (String num : arr) {
				sum += Integer.parseInt(num);
			}
			System.out.println(sum);
	
		}//tc
	}//main
}