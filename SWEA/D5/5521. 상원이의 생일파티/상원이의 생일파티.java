import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 상원이의 생일파티
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			//친구관계 배열 생성
			int[][] friendArr = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				// 친구관계면 서로 1표시
				friendArr[a][b]  = 1;
				friendArr[b][a]  = 1;
			}
			
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			// 중복제거를 위한 set
			Set<Integer> check = new HashSet<>();
			// 상원이의 친구관계 추가
			for (int i = 1; i <= N; i++) {
				if (friendArr[1][i] == 1) {
					dq.add(i);
					check.add(i);
				}
			}
			// 친구가 없으면...
			if (dq.isEmpty()) {
				System.out.println("#" + tc + " 0");
			}
			
			else {
				int size = dq.size();
				// 친구 있으면 친구만큼 반복문돌리기
				for (int i = 0; i < size; i++) {
					int idx = dq.poll();	// 친구 꺼내서
					// 친구의 친구 체크.. 상원이는 제외
					for (int j = 2; j <= N; j++) {
						if(friendArr[idx][j] == 1) {
							check.add(j);
						}
					}
				}
				//출력
				System.out.println("#" + tc + " " + check.size());
			}
			
		}//tc
	}//main
}
