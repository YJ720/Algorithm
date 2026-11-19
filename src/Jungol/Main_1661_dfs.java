package Jungol;

import java.io.IOException;
import java.util.Scanner;

/*
8 7 
1 2 7 5 
11111111 
00000111 
10110011 
10111001 
10111101 
10000001 
11111111
 */

public class Main_1661_dfs {
	static int map[][];
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	static int x2, y2;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		
		int y1 = sc.nextInt() - 1;
		int x1 = sc.nextInt() - 1;
		y2 = sc.nextInt() - 1;
		x2 = sc.nextInt() - 1;
		
		String line;
		for (int i = 0; i < N; i++) {
			line = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		map[x1][y1] = 1;
		
		dfs(x1, y1);
		System.out.println(map[x2][y2] - 1);
	}
	
	public static void dfs(int sr, int sc) {
		if(sr == x2 && sc == y2) {
			return;
		}
		
		int dist = map[sr][sc];
		
		for (int i = 0; i < 4; i++) {	// 4방 탐색 for 문
			int nr = sr + dr[i];
			int nc = sc + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M) { // 배열 범위 검사
				// 아직 방문하지 않은 길인지 || 
				if(map[nr][nc] == 0 || map[nr][nc] > dist + 1) {	
					map[nr][nc] = dist + 1;
					dfs(nr, nc);
				}
			}
		}
	}
}
