import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//5215. 햄버거 다이어트
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String[] NL = br.readLine().split(" ");
			
			N = Integer.parseInt(NL[0]);
			L = Integer.parseInt(NL[1]);
			
			scores = new int[N];
			caLs = new int[N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				scores[i] = Integer.parseInt(line[0]);
				caLs[i] = Integer.parseInt(line[1]);
			}
			
			makeBuger(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
		}//tc
		
	}//main
	
	static int N;
	static int L;
	
	//재료의 점수와 칼로리를 관리
	//1. 재료 클래스를 만들어서 배열로 관리
	//2. 2차원 배열을 이용하여 [0] 점수, [1] 칼로리
	//3. 각각 1 차원 배열로 관리한다.(V)
	
	static int[] scores;
	static int[] caLs;
	static int ans;
	
	//정석 부분집합
	//1. 비트마스킹 이용
	//2. 재귀함수
	//3. 백트래킹 -> 유망성 검사
	
	static void makeBuger(int idx, int sumCal, int sumScore) {
		//종료부분
		if (sumCal > L) {	// 제한칼로리를 벗어나버렸으면 의미 X
			return;
		}
		
		//재료 판단 끝
		if(idx == N) {
			ans = Math.max(ans, sumScore);
			return;
		}
			
		
		//재귀부분
		
		//재료를 사용한 경우
		makeBuger(idx+1, sumCal + caLs[idx], sumScore + scores[idx]);
		
		//재료를 사용하지 않은경우
		makeBuger(idx+1, sumCal, sumScore);
		
	}
}
