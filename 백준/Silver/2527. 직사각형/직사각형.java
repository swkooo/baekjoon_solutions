import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 직사각형
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 4; tc++) {

			String[] line = br.readLine().split(" ");
			// 첫번째 직사각형 꼭지점 좌표
			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int x2 = Integer.parseInt(line[2]);
			int y2 = Integer.parseInt(line[3]);

			// 직사각형의 가로 세로 변에 해당하는 좌표 list에 넣기
			List<Integer> width = new ArrayList<>();
			for (int i = x1; i <= x2; i++) {
				width.add(i);
			}
			List<Integer> height = new ArrayList<>();
			for (int i = y1; i <= y2; i++) {
				height.add(i);
			}

			// 두번째 직사각형 꼭지점 좌표 할당
			x1 = Integer.parseInt(line[4]);
			y1 = Integer.parseInt(line[5]);
			x2 = Integer.parseInt(line[6]);
			y2 = Integer.parseInt(line[7]);

			// list와 두번째 꼭지점 좌표간에 겹치는 부분 탐색
			List<Integer> wOverlap = new ArrayList<>();
			int cnt = 0;	// 겹치는 부분이 여러개라면 2개만 탐색하고 탈출 할 수 있도록 설계
			for (int i = x1; i <= x2; i++) {
				if (width.contains(i)) {
					wOverlap.add(i);
					cnt++;
				}
				if (cnt >= 2)
					break;
			}
			List<Integer> hOverlap = new ArrayList<>();
			cnt = 0;
			for (int i = y1; i <= y2; i++) {
				if (height.contains(i)) {
					hOverlap.add(i);
					cnt++;
				}
				if (cnt >= 2)
					break;
			}

			// 분류 로직
			if (wOverlap.isEmpty() || hOverlap.isEmpty()) // 겹치는 부분이 없으면 d
				sb.append("d\n");
			else if (wOverlap.size() == 1 && hOverlap.size() == 1) // 가로, 세로 겹치는 부분 1개만 있다면 c
				sb.append("c\n");
			else if (wOverlap.size() > 1 && hOverlap.size() > 1) // 가로, 세로 겹치는 부분이 둘다 2개 이상이면 a
				sb.append("a\n");
			else // 그 외의 경우는 b
				sb.append("b\n");

		} // tc
			// 출력
		System.out.println(sb);
	}// main
}
