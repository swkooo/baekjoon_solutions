import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//개미
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] wh = br.readLine().split(" ");
		int w = Integer.parseInt(wh[0]);
		int h = Integer.parseInt(wh[1]);
		
		String[] pq = br.readLine().split(" ");
		int p = Integer.parseInt(pq[0]);
		int q = Integer.parseInt(pq[1]);
		
		int t = Integer.parseInt(br.readLine());
		
		// 애초에 시뮬레이션을 하면 안됨... 4만이라는 좌표 넓이를 탐색하면서 1번 값을 찾는것도 시간초과임
		
		// 1. x좌표 계산
        // t초 동안 이동한 x좌표를 주기로 나눈다.
        // x축 이동의 주기는 2*w
        int finalX = (p + t) % (2 * w);
        if (finalX > w) {
            finalX = 2 * w - finalX;
        }

        // 2. y좌표 계산
        // t초 동안 이동한 y좌표를 주기로 나눈다.
        // y축 이동의 주기는 2*h
        int finalY = (q + t) % (2 * h);
        if (finalY > h) {
            finalY = 2 * h - finalY;
        }

        System.out.println(finalX + " " + finalY);
		
	}//main
}
