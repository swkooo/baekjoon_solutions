import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//추첨을 통해 커피를 받자
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		boolean isHacker = false;
		int sum = 0;
		for (int i = 0; i < line.length; i++) {
			int num = Integer.parseInt(line[i]);
			if (i <= 1) {
				if (num > 100) {
					isHacker = true;
					break;
				} else
					sum += num;
				continue;
			} else if (i <= 3) {
				if (num > 200) {
					isHacker = true;
					break;
				} else
					sum += num;
				continue;
			} else if (i <= 5) {
				if (num > 300) {
					isHacker = true;
					break;
				} else
					sum += num;
				continue;
			} else if (i <= 7) {
				if (num > 400) {
					isHacker = true;
					break;
				} else
					sum += num;
				continue;
			} else {
				if (num > 500) {
					isHacker = true;
					break;
				} else
					sum += num;
				continue;
			}
		}
		if (isHacker) {
			System.out.println("hacker");
		}

		if (sum >= 100) {
			System.out.println("draw");
		}
		if (!isHacker && sum < 100) {
			System.out.println("none");
		}

	}// main
}
