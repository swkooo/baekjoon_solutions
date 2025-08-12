import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//수 찾기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String [] lineA = br.readLine().split(" ");
		
		Set<String> set = new HashSet<>(); // 순서 보장이 필요 없으므로 HashSet 사용
		for (int i = 0; i < N; i++) {
			set.add(lineA[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		String [] lineB = br.readLine().split(" ");
		
		// B배열의 각 요소가 A배열에 존재하는지 확인
		for (int i = 0; i < M; i++) {
			if (set.contains(lineB[i])) { // set.contains()로 존재 여부 확인
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		//출력
		System.out.println(sb);
	}//main
}