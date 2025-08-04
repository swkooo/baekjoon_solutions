import java.util.Scanner;

public class Main {
	//백준 시험 성적
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력으로 시험성적을 받는다...! score
		int score = sc.nextInt();
		
		// 시험성적이 A, B, C, D, F인지 구분하여 출력
		// A 성적은 90이상 100점 이하.
		if(score >= 90 && score <= 100) {
			System.out.println("A");
		}
		// B 성적은 80이상 90미만.
		else if(score >= 80) {
			System.out.println("B");
		}
		// C 성적은 70이상 80미만.
		else if(score >= 70) {
			System.out.println("C");
		}
		// D 성적은 60이상 70미만.
		else if(score >= 60) {
			System.out.println("D");
		}
		// F는 나머지 (60미만)
		else {
			System.out.println("F");
		}
	}
}
