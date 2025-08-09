import java.util.Scanner;

//baekjoon1008 A/B
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//오차 줄이기 위해 int 대신 double로 받기
		double A = sc.nextInt();
		double B = sc.nextInt();
		
		System.out.println(A / B);
	}
}
