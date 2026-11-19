package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_practice {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};

		int[] backDr = {1, 0, -1, 0};
		int[] backDc = {0, -1, 0, 1};
		
		int cnt = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {			
			if(map[r][c] == 0) {
				map[r][c] = 2;
				cnt++;
			}
			
			boolean isMoved = false;
			
			for (int i = 0; i < 4; i++) {
				d = (d+3)%4;
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(map[nr][nc] == 0) {
					r = nr;
					c = nc;
					isMoved = true;
					break;
				}
			}
			
			if(!isMoved) {
				int br = r + backDr[d];
				int bc = c + backDc[d];
				if(map[br][bc] == 1) {
					break;
				}
				r = br;
				c = bc;
			}
		}
		
		System.out.println(cnt);
	}
}
