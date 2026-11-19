package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int cnt = 0;
	
	static class Virus {
	    int r, c;
	    Virus(int r, int c) {
	        this.r = r;
	        this.c = c;
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int sr, int sc, int wall) {
		if(wall == 3) {
			bfs();
			return;
		}
		
		for (int i = sr; i < N; i++) {
			int nsc = (i == sr) ? sc : 0;
            for (int j = nsc; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					
					dfs(i, j, wall + 1);
					
					map[i][j] = 0;
				}
			}
		}		
	}
	
	public static void bfs() {
		Queue<Virus> q = new LinkedList<>();		 		
        int[][] copy = new int[N][M];
		
		for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++) {
	        	copy[i][j] = map[i][j];
	            if (map[i][j] == 2) {
	                q.add(new Virus(i, j));
	            }
	        }
	    }
		
		while(!q.isEmpty()) {
			Virus cur = q.poll();
	        
	        for (int d = 0; d < 4; d++) {
	            int nr = cur.r + dr[d];
	            int nc = cur.c + dc[d];
	            
	            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
	                if (copy[nr][nc] == 0) {
	                    copy[nr][nc] = 2;
	                    q.add(new Virus(nr, nc));
	                }
	            }
	        }
		}
		
		int tmp = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j] == 0) {
					tmp++;
				}
			}
		}
		
		if(tmp > cnt)	cnt = tmp;
	}
}












