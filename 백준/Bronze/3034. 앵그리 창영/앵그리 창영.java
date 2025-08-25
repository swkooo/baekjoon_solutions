import java.util.Scanner;

//앵그리 창영
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int cross = W * W + H * H;
		for (int i = 0; i < N; i++) {
			int check = sc.nextInt();
			if (check * check <= cross)
				sb.append("DA\n");
			else
				sb.append("NE\n");
		}
		
		System.out.println(sb);
		
	}//main
}
