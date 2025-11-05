import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//3074. 입국심사
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			long[] timeArr = new long[N];
			
			long min = Long.MAX_VALUE;
			long max = 0;
			for (int i = 0; i < N; i++) {
				long t = Integer.parseInt(br.readLine());
				min = Math.min(min, t);
				max = Math.max(max, t);
				timeArr[i] = t;
			}
			
			long minTime = min * M / N;
			long maxTime = max * M / N;
			long totalTime = (minTime + maxTime) / 2;
			
			while(totalTime != maxTime) {
				long possible = 0;
				for (long time : timeArr) {
					possible += totalTime / time;
				}
				if(possible < M) {
					minTime = totalTime;
					totalTime = (totalTime + maxTime + 1) / 2;
				}
				else {
					maxTime = totalTime;
					totalTime = (totalTime + minTime + 1) / 2;
				}				
			}// 반복문
			
			sb.append("#").append(tc).append(" ").append(totalTime).append("\n");
		}//tc
		//출력
		System.out.println(sb);
	}//main
}
