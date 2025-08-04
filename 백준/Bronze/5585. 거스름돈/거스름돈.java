import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 입력: 지불해야할 금액
		/* 로직: 가장 적게 거스름돈을 주는 법: 가장 큰단위 액수부터~
		 * 1. 거스름돈 액수 계산 change = 1000 - charge
		 * 2. 500엔 먼저 거슬러주기
		 *		거스름돈의 갯수: count += change / 500
		 *		거스름돈의 액수: change = change % 500 ...
		 * 3. 100엔일때, 50엔일 때, 10, 5, 1엔 일때... 동일
		*/
		// 출력: 계산된 거스름돈의 개수
		
		// 입력
		Scanner sc = new Scanner(System.in);
        int charge = sc.nextInt();
        int change = 1000 - charge;
        int count = 0;
        
        // 로직
        count += change / 500;
        change = change % 500;

        count += change / 100;
        change = change % 100;
        
        count += change / 50;
        change = change % 50;
        
        count += change / 10;
        change = change % 10;
        
        count += change / 5;
        change = change % 5;
        
        count += change / 1;
        
        // 출력
        System.out.println(count);
	}
}
