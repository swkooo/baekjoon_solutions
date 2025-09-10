import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//The candy war
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] line = br.readLine().split(" ");
						
			int[] childs = new int[N];
			for (int i = 0; i < N; i++) {
				int candy = Integer.parseInt(line[i]);
				if (candy % 2 != 0) {
					candy++;
				}
				childs[i] = candy;
			}
			
			int cnt = 0;
			boolean isAllSame = false;
			while(!isAllSame) {
				isAllSame = true;
				for(int i = 0; i < N - 1; i++) {
					if (childs[i] != childs[i + 1]) {
						isAllSame = false;
						break;
					}
				} // dq안에 요소들이 전부 같은 값인 지 확인
				if (!isAllSame) {
					cnt++;
					for (int i = 0; i < N; i++) {
						childs[i] = childs[i] / 2;
					}
					int temp = childs[0];
					childs[0] += childs[N - 1];
					for (int i = 1; i < N; i++) {
						int temp2 = childs[i];
						childs[i] += temp;
						temp = temp2;
					}
					for (int i = 0; i < N; i++) {
						if (childs[i] % 2 != 0) {
							childs[i]++;
						}
					}// 1사이클 실행
				}// 모두 같지 않다면
			}//while반복문
			
			System.out.println(cnt);
		}//tc

	}// main
}
