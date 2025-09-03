import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//미로 탐색
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		char[][] miro = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			miro[i] = br.readLine().toCharArray();
		}
		
		//델타 탐색 상하좌우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		int[] coord = {0, 0};
		dq.add(coord);
		miro[0][0] = 0;
		
		int cnt = 1;
		boolean isFound = false;
		while(!isFound) {
			int size = dq.size();
			for (int i = 0; i < size; i++) {
				int[] curr = dq.poll();
				for (int d = 0; d < 4; d++) {
					int moveRow = curr[0] + dr[d];
					int moveCol = curr[1] + dc[d];
					if (moveRow >= 0 && moveRow < N && moveCol >= 0 && moveCol < M) {	//바운더리
						if (miro[moveRow][moveCol] == '1') {
							int[] temp = {moveRow, moveCol};
							dq.add(temp);
							if (moveRow == N - 1 && moveCol == M - 1) {
								isFound = true;
							}
							miro[moveRow][moveCol] = 0;
						}
					}
				}
			}			
			cnt++;
		} //bfs
		System.out.println(cnt);
	}//main
}
