import java.util.Scanner;

// 찬반투표
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		int giveUp = 0;
		for (int i = 0; i < N; i++) {
			int vote = sc.nextInt();
			if (vote == 0) {
				giveUp++;
			}
			result += vote;
		}
		if (giveUp >= (N / 2 + N % 2)) 
			System.out.println("INVALID");
		else if(result > 0)
			System.out.println("APPROVED");
		else
			System.out.println("REJECTED");
		
	}//main
}
