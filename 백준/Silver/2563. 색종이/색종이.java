import java.util.Scanner;

//색종이
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] paper = new int[101][101];	// 전체 도화지 넓이
		
		int cnt = 0;	// 넓이 확인을 위한 카운트
		for (int n = 0; n < N; n++) {
			int colNum = sc.nextInt();
			int rowNum = sc.nextInt();
			
			// 입력받은 좌표로부터 10 X 10 범위 돌면서 0인부분, 즉 기존 색종이가 없는 부분 1로 바꾸면서 넓이 측정
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(paper[rowNum + i][colNum + j] == 0)	{
						paper[rowNum + i][colNum + j] = 1;
						cnt++;
					}
				}
			}			
		}
		
		//출력		
		System.out.println(cnt);
	}//main
}
