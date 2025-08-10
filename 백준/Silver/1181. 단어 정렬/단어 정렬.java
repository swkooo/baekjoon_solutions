import java.io.*;
import java.util.*;

//단어정렬... 못풀어서 지피티 도움 받음ㅜ
public class Main {
	public static void main(String[] args) throws IOException {
		// 버퍼드리더로 가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// hashset으로 일단 먼저 중복제거 입력
		Set<String> uniq = new HashSet<>(N * 2);
		for (int i = 0; i < N; i++)
			uniq.add(br.readLine());

		// arraylist로 변환 후 Comparator 사용해서 길이와 알파벳순으로 정렬
		List<String> list = new ArrayList<>(uniq);
		list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));

		// 형식에 맞춰서 출력
		StringBuilder sb = new StringBuilder();
		for (String s : list)
			sb.append(s).append('\n');
		System.out.print(sb);
	}
}
