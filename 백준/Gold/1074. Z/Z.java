import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Z
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] Nrc = br.readLine().split(" ");
		int N = Integer.parseInt(Nrc[0]);
		int r = Integer.parseInt(Nrc[1]);
		int c = Integer.parseInt(Nrc[2]);
		
		// 함수 실행
		zSearch(N, r, c);
		// 출력
		System.out.println(cnt);
	}//main
	
	static int cnt = 0;	// 좌표 방문 횟수 체크
	public static void zSearch(int N, int curRow, int curCol) {
		// 종료부분
		if (N == 1) {	// 가장 작은 2 X 2 배열이 된다면
			cnt += curRow * 2 + curCol;	// 0,1 ~ 1,1 까지 숫자 더하기
			return;
		}
		
		// 재귀부분
		int divine = (int) Math.pow(2, N - 1);	// 4등분을 위한 숫자계산
		if (curRow / divine == 0 && curCol / divine == 0) { 	 // 4등분 했을 때 2사분면이라면..
			zSearch(N - 1, curRow % divine, curCol % divine);	 // 바로 다음 재귀(4등분) 실행
		}
		else if (curRow / divine == 0 && curCol / divine == 1) { // 1사분면
			cnt += divine * divine;								 // divine * diviine 만큼 방문횟수 더하고 
			zSearch(N - 1, curRow % divine, curCol % divine);	 // 다음재귀 실행
		}
		else if (curRow / divine == 1 && curCol / divine == 0) { // 3사분면
			cnt += divine * divine * 2;
			zSearch(N - 1, curRow % divine, curCol % divine);
		}
		else if (curRow / divine == 1 && curCol / divine == 1) { // 4사분면
			cnt += divine * divine * 3;
			zSearch(N - 1, curRow % divine, curCol % divine);
		}		
	}
}
