package Programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main_159993 {
	
	
	class Solution {
		
		static int n, m;
		static char[][] grid;
		static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
		
	    public int solution(String[] maps) {
	    	
	    	n = maps.length;
	    	m = maps[0].length();
	    	grid = new char[n][m]; 
	    	
	    	int sr = -1, sc = -1, lr = -1, lc = -1, er = -1, ec = -1;
	    	
	    	for (int i = 0; i < n; i++) {
				grid[i] = maps[i].toCharArray();
				
				for (int j = 0; j < m; j++) {
					if(grid[i][j] == 'S') {
						sr = i;
						sc = j;
					}else if(grid[i][j] == 'L') {
						lr = i;
						lc = j;
					}else if(grid[i][j] == 'E') {
						er = i;
						ec = j;
					}
				}
			}
	    	
	    	int d1 = bfs(sr, sc, lr, lc);
	    	if (d1 == -1) return -1;
	    	
	    	int d2 = bfs(lr, lc, er, ec);
	    	if (d2 == -1) return -1;
	    	
	        return d1 + d2;
	    }
	    
	    private int bfs(int sr, int sc, int er, int ec) {
	    	boolean[][] visited = new boolean[n][m];;
	    	Queue<int[]> q = new ArrayDeque<>();
	    	
	    	q.offer(new int[] {sr, sc, 0});
	    	visited[sr][sc] = true;
	    	
	    	while(!q.isEmpty()) {
	    		int[] cur = q.poll();
	    		int r = cur[0], c = cur[1], dist = cur[2];
	    		
	    		if(r == er && c == ec) return dist;
	    		
	    		for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					
					if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
					if(visited[nr][nc]) continue;
					if(grid[nr][nc] == 'X') continue;
					
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc, dist+1});
				}
	    	}
	    	
	    	return -1;
	    }
	}
}
