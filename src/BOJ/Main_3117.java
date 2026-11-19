package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3117 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] start = new int[N];
		int[][] next = new int[31][K+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			start[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < K+1; i++) {
			next[0][i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < 31; i++) {
			for (int j = 1; j < K+1; j++) {
				next[i][j] = next[i - 1][next[i - 1][j]];
			}
		}
		
		
		
		int t = M - 1;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int v = start[i];
			
			for (int j = 30; j >= 0; j--) {
				if((t & (1 << j)) != 0) {
					v = next[j][v];
				}
			}
			sb.append(v).append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}