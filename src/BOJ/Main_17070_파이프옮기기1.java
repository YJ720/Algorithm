package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int N;
	static int map[][];
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		
		dfs(0, 1, 0);
		
		System.out.println(cnt);
	}
	
	/**
	 * 
	 * @param r
	 * @param c
	 * @param dir		0 가로, 1 세로, 2 대각선
	 */
	public static void dfs(int r, int c, int dir) {
		if(r == N -1 && c == N - 1) {
			cnt++;
			return;
		}
		
		// 가로 이동
		if(dir == 0 || dir == 2) {
			if(c + 1 < N && map[r][c+1] == 0) {				
				dfs(r, c+1, 0);
			}
		}

		// 세로 이동
		if(dir == 1 || dir == 2) {
			if(r + 1 < N && map[r+1][c] == 0) {				
				dfs(r+1, c, 1);
			}
		}

		// 대각선 이동
		if (r + 1 < N && c + 1 < N) {
			if(map[r + 1][c + 1] == 0 && map[r][c + 1] == 0 && map[r + 1][c] == 0) {				
				dfs(r+1, c+1, 2);
			}
		}
		
	}
}
