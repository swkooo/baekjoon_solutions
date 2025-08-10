import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//좌표 정렬하기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();

		// 입력 받기
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			int[] coord = new int[2];
			for (int j = 0; j < 2; j++) {
				coord[j] = Integer.parseInt(line[j]);
			}
			list.add(coord);
		}

		list.sort(Comparator.comparing((int[] arr) -> arr[0]).thenComparing((int[] arr) -> arr[1]));
		
		//출력
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < list.size(); i++) {
					sb.append(list.get(i)[0]).append(' ').append(list.get(i)[1]).append('\n');
				}
				System.out.print(sb);	
	}// main
}
