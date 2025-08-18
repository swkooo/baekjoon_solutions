import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//색종이
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		// 전체 좌표 배열
		int[][] coord = new int[1001][1001];
		
		// 색종이 배열 받기
		int[][] papers = new int[N][4];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				papers[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		// 맨 뒤에 것이 가장 위에 오기 때문에 거꾸로
		for (int i = N - 1; i >= 0; i--) {
			int x1 = papers[i][0];
			int y1 = papers[i][1];
			int width = papers[i][2];
			int height = papers[i][3];
			
			// 뒤에것부터 차치하는 칸수 체크
			int cnt = 0;
			// 좌표값 탐색하면서 coord값이 0이 아니면 cnt 증가
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					if (coord[y1 + y][x1 + x] == 0) {
						coord[y1 + y][x1 + x] = 1;
						cnt++;
					}
				}
			}
			//뒤에서부터 했으므로 거꾸로 출력
			sb.insert(0, cnt + "\n");
		}
		
		System.out.println(sb);
	}//main
}
