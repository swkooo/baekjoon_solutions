import java.util.Arrays;
import java.util.Scanner;

//직각삼각형
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int[] arr = new int[3];
			
			// 제곱수 입력받기
			for (int i = 0; i < 3; i++) {
				int num = sc.nextInt();
				arr[i] = num * num;
			}
			//반복문 탈출
			if (arr[0] <= 0) {
				break;
			}
			//배열 오름차순 정렬
			Arrays.sort(arr);
			//직각삼각형인지 확인
			if (arr[2] == arr[0] + arr[1]) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}//반복문
	}// main
}
