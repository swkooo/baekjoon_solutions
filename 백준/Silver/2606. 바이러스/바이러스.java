import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//바이러스
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int comN = Integer.parseInt(br.readLine());
		int netN = Integer.parseInt(br.readLine());

		int[][] netArr = new int[comN + 1][comN + 1];	// 네트워크 연결망 만들기
		for (int i = 0; i < netN; i++) {
			String[] line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			// 연결되어 있는 네트워크 1로 표시
			netArr[a][b] = 1;
			netArr[b][a] = 1;
		}
		
		// 바이러스걸린 컴퓨터 체크할 list
		List<Integer> virus = new ArrayList<>();
		virus.add(1);	// 1번 컴퓨터는 무조건 바이러스
		
		// 리스트를 계속 돌면서.. 이때 size가 계속 커져야함
		for (int i = 0; i < virus.size(); i++) {
			int check = virus.get(i);	// 체크할 컴퓨터 번호 가져오기
			for (int j = 1; j <= comN; j++) {	// 체크를 행으로 가지는 열 확인
				if (!virus.contains(j) && netArr[check][j] == 1) {	// list에 이미 존재하지 않고 바이러스 컴퓨터라면
					virus.add(j);	// 열 번호 리스트 추가
				}
			}
		}
		
		// 출력.. 첫번째 컴퓨터 제외
		System.out.println(virus.size() - 1);
	}// main
}
