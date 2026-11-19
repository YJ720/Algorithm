package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3249 {

	static String S;
	static int[][] map;
	static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		S = br.readLine();
		
		map = new int[N][N];
		
		fill(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		sb.append(N).append("\n");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
	
	static void fill(int r, int c, int size) {
		
		char ch = S.charAt(idx++);
		
		if( ch == 'X' ) {
			
			int nxt = size / 2;
			
			fill(r, c, nxt);
			fill(r, c + nxt, nxt);
			fill(r + nxt, c, nxt);
			fill(r + nxt, c + nxt, nxt);
			
		}else {
			
			int val = ch - '0';
			
			for (int i = r; i < r+size; i++) {
				for (int j = c; j < c+size; j++) {
					map[i][j] = val;
				}
			}
		}
	}
}
