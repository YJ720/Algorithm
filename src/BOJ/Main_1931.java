package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] time = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			time[i][0] = Integer.parseInt(st.nextToken()); // 시작
			time[i][1] = Integer.parseInt(st.nextToken()); // 종료
		}
		
		Arrays.sort(time, (a, b) -> {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		
		int cnt = 0, prevEnd = 0;
		
		for (int i = 0; i < N; i++) {
			
			if(prevEnd <= time[i][0]) {
				prevEnd = time[i][1];
                cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
