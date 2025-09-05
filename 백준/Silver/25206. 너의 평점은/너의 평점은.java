import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 너의 평점은
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 20;

		double scoreSum = 0;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			String[] score = br.readLine().split(" ");

			double gradeScore = 0;
			switch (score[2]) {
			case "A+":
				gradeScore = 4.5;

				break;
			case "A0":
				gradeScore = 4.0;

				break;
			case "B+":
				gradeScore = 3.5;

				break;
			case "B0":
				gradeScore = 3.0;

				break;
			case "C+":
				gradeScore = 2.5;

				break;
			case "C0":
				gradeScore = 2.0;

				break;
			case "D+":
				gradeScore = 1.5;

				break;
			case "D0":
				gradeScore = 1.0;

				break;
			case "F":
				gradeScore = 0.0;

				break;
			default:
				break;
			}
			if (!score[2].equals("P")) {				
				scoreSum += gradeScore * Double.parseDouble(score[1]);
				sum += Double.parseDouble(score[1]);
			}
		}
		
		System.out.println(scoreSum / sum);
	}// main
}
