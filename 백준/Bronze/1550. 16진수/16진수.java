import java.util.Scanner;

//16진수
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.next(), 16);
		
		System.out.println(num);
		
	}
}