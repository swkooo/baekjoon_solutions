import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//참외밭
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		// 같은 방향으로 2개가 들어가면 그 부분이 오목하게 들어가는 부분이다...
		// 즉 1방향만 나오면 그 2개의 곱이 전체 사각형의 넓이고 2방향 나온 길이 중 빼는 사각형 넓이가 있다...
		// 전체 사각형 방향에 이어서 나오지 않는 방향이 작은 사각형 변이긴 한데..

		// 동서남북 리스트 생성
		List<int[]> eList = new ArrayList<>();
		List<int[]> wList = new ArrayList<>();
		List<int[]> sList = new ArrayList<>();
		List<int[]> nList = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			String[] line = br.readLine().split(" ");
			int direction = Integer.parseInt(line[0]);
			int[] data = { i, Integer.parseInt(line[1])};

			switch (direction) {
			case 1:
				eList.add(data);
				break;
			case 2:
				wList.add(data);
				break;
			case 3:
				sList.add(data);
				break;
			case 4:
				nList.add(data);
				break;
			}
		}
		
		
		// 동, 서 중 긴거 체크, 짧은거는 긴거의 인덱스 + 3 하고 인덱스 범위를 넘어갈 경우 % 6으로 나머지 값임.
		int idxWidth = 0;
		int longWidth = 0;
		int shortHeight = 0;
		if (eList.size() == 1) {
			idxWidth = eList.get(0)[0];
			longWidth = eList.get(0)[1];

			int idx = (idxWidth + 3) % 6;
			for (int[] arr : sList) {
				if (arr[0] == idx)
					shortHeight = arr[1];
			}
			for (int[] arr : nList) {
				if (arr[0] == idx)
					shortHeight = arr[1];
			}
		}
		if (wList.size() == 1) {
			idxWidth = wList.get(0)[0];
			longWidth = wList.get(0)[1];

			int idx = (idxWidth + 3) % 6;
			for (int[] arr : sList) {
				if (arr[0] == idx)
					shortHeight = arr[1];
			}
			for (int[] arr : nList) {
				if (arr[0] == idx)
					shortHeight = arr[1];
			}
		}


		// 남, 북 중 긴거 체크, 짧은거는 긴거의 인덱스 + 3 하고 인덱스 범위를 넘어갈 경우 % 6으로 나머지 값임.
		int idxHeight = 0;
		int longHeight = 0;
		int shortWidth = 0;
		if (sList.size() == 1) {
			idxHeight = sList.get(0)[0];
			longHeight = sList.get(0)[1];
			
			int idx = (idxHeight + 3) % 6;

			for (int[] arr : eList) {
				if (arr[0] == idx)
					shortWidth = arr[1];
			}
			for (int[] arr : wList) {
				if (arr[0] == idx)
					shortWidth = arr[1];
			}
		}
		if (nList.size() == 1) {
			idxHeight = nList.get(0)[0];
			longHeight = nList.get(0)[1];

			int idx = (idxHeight + 3) % 6;

			for (int[] arr : eList) {
				if (arr[0] == idx)
					shortWidth = arr[1];
			}
			for (int[] arr : wList) {
				if (arr[0] == idx)
					shortWidth = arr[1];
			}
		}		

		// 출력
		System.out.println((longWidth * longHeight - shortWidth * shortHeight) * K);

	}// main
}
