import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//문자열 1줄 읽기
		String line = sc.nextLine();
		//char단위로 끊기
		String[] lineArr = line.split("");
		//10개 단위로 출력
		for (int i = 0; i < lineArr.length; i++) {
			//index가 9, 19, 29..  일때 출력하고 개행
			if (i % 10 == 9) {
				System.out.println(lineArr[i]);
			}
			//그렇지 않으면 붙여서 출력
			else {
				System.out.print(lineArr[i]);
			}
		}
		
	}//main
}