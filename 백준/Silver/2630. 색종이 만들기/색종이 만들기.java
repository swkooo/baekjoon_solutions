import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//색종이 만들기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(line[j]);
			}
		}

		// 출력
		paperCut(paper);
		System.out.println(cntW + "\n" + cntB);

	}// main

	static int cntW = 0; // 흰색 개수
	static int cntB = 0; // 파란색 개수

	// 재귀함수 만들기
	public static void paperCut(int[][] paper) {
		int size = paper.length;

		boolean isOK = true; // 디폴트값 true
		int first = paper[0][0]; // 검사할 첫번째 값 저장
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// 첫번째 값과 다른 값이 나오면 break;
				if (paper[i][j] != first) {
					isOK = false;
					break;
				}
			}
			if (!isOK) {
				break;
			}
		}

		// 검사결과 전부 같은 수일 경우
		if (isOK && first == 0) { // 0이면 흰색
			cntW++;
			return;
		}
		if (isOK && first == 1) { // 1이면 파란색
			cntB++;
			return;
		}

		// 그렇지 않으면 4등분 자르기
		else {
			size = size / 2;
			// 4등분한 배열 담을 4개 paper
			int[][] paper1 = new int[size][size];
			int[][] paper2 = new int[size][size];
			int[][] paper3 = new int[size][size];
			int[][] paper4 = new int[size][size];

			// i, j를 size/2 로 나눈 값의 몫을 가지고 어디 배열에 넣을지 결정
			for (int i = 0; i < size * 2; i++) {
				for (int j = 0; j < size * 2; j++) {
					if (i / size == 0 && j / size == 0) {
						paper1[i][j] = paper[i][j];
					}
					if (i / size == 1 && j / size == 0) {
						paper2[i % size][j] = paper[i][j];
					}
					if (i / size == 0 && j / size == 1) {
						paper3[i][j % size] = paper[i][j];
					}
					if (i / size == 1 && j / size == 1) {
						paper4[i % size][j % size] = paper[i][j];
					}
				}
			}
			// 재귀 실행
			paperCut(paper1);

			paperCut(paper2);

			paperCut(paper3);

			paperCut(paper4);
		}
	}
}
