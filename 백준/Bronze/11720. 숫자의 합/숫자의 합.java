import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String num = sc.next();
		String[] numArr = num.split("");
		
		int sum = 0;
		for(String i : numArr) {
			sum += Integer.parseInt(i);
		}
		System.out.println(sum);
		
	}//main
}
