import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] lw = br.readLine().split(" ");
		int leng = Integer.parseInt(lw[0]);	//가로
		int width = Integer.parseInt(lw[1]);		//세로
		
		int toCut = Integer.parseInt(br.readLine());
		
		List<Integer> widthList = new ArrayList<Integer>();
		widthList.add(0);
		widthList.add(width);
		
		List<Integer> lengList = new ArrayList<Integer>();
		lengList.add(0);
		lengList.add(leng);
		
		for (int i = 0; i < toCut; i++) {
			String[] line = br.readLine().split(" ");
			
			if (line[0].equals("0")) {
				widthList.add(Integer.parseInt(line[1]));
			}
			else {
				lengList.add(Integer.parseInt(line[1]));
			}
		}
		
		Collections.sort(widthList);
		
		int maxWidth = 0;
		for (int i = 0; i < widthList.size() - 1; i++) {
			int diff = widthList.get(i + 1) - widthList.get(i);
			maxWidth = Math.max(maxWidth, diff);
		}
		
		
		Collections.sort(lengList);
		
		
		int maxleng = 0;
		for(int i = 0; i < lengList.size() - 1; i++) {
			int diff = lengList.get(i + 1) - lengList.get(i);
			maxleng = Math.max(maxleng, diff);
		}
		
		System.out.println(maxWidth * maxleng);
		
	}//main
}
