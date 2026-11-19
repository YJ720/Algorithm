package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int arr[] = new int[N+1];
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a] = b;
			}
			
			int min = arr[1];
			int cnt = 1;
			
			for (int i = 2; i <= N; i++) {
				
				if( arr[i] < min ) {
					min = arr[i];
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
