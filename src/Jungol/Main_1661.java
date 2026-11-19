package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

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

public class Main_1661 {
	static boolean map[][];
	static boolean visited[][];
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	static int x2, y2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int y1 = Integer.parseInt(st.nextToken()) - 1;
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		y2 = Integer.parseInt(st.nextToken()) - 1;
		x2 = Integer.parseInt(st.nextToken()) - 1;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				if(line.charAt(j) == '0') {
					map[i][j] = true;
				}
			}
		}		
		bfs(x1, y1);
	}
	
	public static void bfs(int sr, int sc) {
		ArrayDeque<int[]> q = new ArrayDeque<>();

		
		q.offer(new int[] {sr, sc, 0});
		visited[sr][sc] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int r = current[0];
			int c = current[1];
			int dist = current[2];
						
			if(r == x2 && c == y2) {
				System.out.println(dist);
				return;
			}
			
			for (int i = 0; i < 4; i++) {	// 4방 탐색 for 문
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) { // 배열 범위 검사
					if(map[nr][nc] && !visited[nr][nc]) {	// 아직 방문하지 않은 길인지
						q.offer(new int[] {nr, nc, dist + 1});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
