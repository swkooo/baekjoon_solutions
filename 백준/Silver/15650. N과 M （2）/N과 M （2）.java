import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M(2)
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numArr = new int[M];
		DFS(1, 0);
		
	}//main
	
	static int N;
	static int M;
	static int[] numArr;
	public static void DFS(int start, int cnt) {
		//종료부분
		if(cnt == M) {
			for(int i : numArr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		//재귀부분
		else {
			for (int i = start; i <= N; i++) {
				numArr[cnt] = i;
				DFS(i + 1, cnt + 1);
			}
		}
	}
}
