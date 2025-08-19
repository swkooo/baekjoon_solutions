import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//방 배정
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		// 여자 남자로 나눠서 학년별로 담기
		int[] girls = new int[6];
		int[] boys = new int[6];
		
		
		for (int i = 0; i < N; i++) {
			String[] student = br.readLine().split(" ");
			int grade = Integer.parseInt(student[1]);
			if (student[0].equals("0")) {	// 여자면 grade - 1 인덱스에 담기
				girls[grade - 1]++;
			}
			else {							// 남자도 똑같이
				boys[grade - 1]++;				
			}
		}
		
		// 필요한 방의 개수
		int roomCnt = 0;
		for (int i = 0; i < 6; i++) {
			roomCnt += girls[i] / K;	// 일단 K로 나눈 몫을 담고
			if (girls[i] % K != 0) {	// 나머지가 있으면 +1
				roomCnt++;
			}
			roomCnt += boys[i] / K;		// 남자도 똑같이
			if (boys[i] % K != 0) {
				roomCnt++;
			}
		}
		
		System.out.println(roomCnt);
	}//main
}
