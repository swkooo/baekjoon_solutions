import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 회의실 배정... gpt 도움받음
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] timeArr = new int[N][2];	// 회의시간 저장할 배열
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			timeArr[i][0] = Integer.parseInt(line[0]);
			timeArr[i][1] = Integer.parseInt(line[1]);		
		}

		Arrays.sort(timeArr, (o1, o2) -> {
		    // 종료 시간이 같으면 시작 시간으로 정렬
		    if (o1[1] == o2[1]) {
		        return o1[0] - o2[0];
		    }
		    // 종료 시간이 다르면 종료 시간으로 정렬
		    return o1[1] - o2[1];
		});
		
		int cnt = 0;
		int endTime = 0;

		for (int i = 0; i < N; i++) {
		    // 현재 회의의 시작 시간이 이전 회의의 종료 시간보다 크거나 같으면
		    if (endTime <= timeArr[i][0]) {
		        // 해당 회의를 선택하고 카운트를 증가시킴
		    	endTime = timeArr[i][1];
		    	cnt++;
		    }
		}

		System.out.println(cnt);
	}// main

}
