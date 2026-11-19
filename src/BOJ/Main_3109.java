package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109 {
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 0, 1};	// 우상, 우, 우하 순서로 탐색
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 0~R까지의 행 순차 탐색
		for (int i = 0; i < R; i++) {
			if(dfs(i, 0)) {	// 탐색 성공하면
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static boolean dfs(int r, int c) {
		// 탐색 마킹
		map[r][c] = 'x';
		
		// 열의 끝에 도달
		if(c == C-1)	return true;
		
		// 3방향 탐색
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + 1;
			
			// 배열 범위 검사				탐색 가능한 길인지			여러 방향 탐색 방지
			if(nr>=0 && nr<R && map[nr][nc] == '.' && dfs(nr, nc)) {
				return true;
			}
		}
		
		// 3방향 모두 막힌 경우
		return false;
	}
}
