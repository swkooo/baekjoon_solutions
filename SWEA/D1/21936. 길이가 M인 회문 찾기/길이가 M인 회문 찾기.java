import java.util.Scanner;

//21936. 길이가 M인 회문 찾기
class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * 길이가 N인 문자열 안에 길이가 M인 회문이 있으면 그 회문을 출력하고, 회문이 없으면 NONE을 출력하는 프로그램을 만드시오.
		 * (2<=M<=N<100)
		 * 
		 * [입력] 첫 줄에 테스트케이스 개수 T, 다음 줄부터 각 케이스 별로 첫 줄에 N과 M, 다음 줄에 길이가 N인 문자열이 주어진다.
		 * 
		 * [출력] #과 테스트케이스번호, 빈칸에 이어 회문 또는 NONE을 출력한다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = Integer.parseInt(sc.nextLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] line = sc.nextLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			char[] arr = sc.nextLine().toCharArray();
			
			char[] check = new char[M];
			
			String answer = "";
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j < M; j++) {
					check[j] = arr[i + j];
				}
				boolean isOK = true;
				for (int j = 0; j < M; j++) {
					if (check[j] != check[M-j-1]) {
						isOK = false;
						break;
					}
				}
				if (isOK) {
					for(char ch : check) {
						answer += ch;
					}
					break;
				}
			}
			if (answer == "") {
				System.out.println("#" + test_case + " NONE");
			}
			else {
				System.out.println("#" + test_case + " " + answer);
			}
			
		}//tc
	}//main
}