import java.util.Scanner;

//문자열 반복
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int R = sc.nextInt();
			String S = sc.nextLine();
			
			for (int i = 1; i < S.length(); i++) {
				for (int j = 0; j < R; j++) {
					System.out.print(S.charAt(i));
				}
			}
			System.out.println();
		}//tc
	}//main
}
