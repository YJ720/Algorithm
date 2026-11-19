package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
#1 200
#2 304
#3 265
#4 307
#5 306
#6 366
#7 256
#8 399
#9 343
#10 391
 */

public class Solution_1247 {
	static int N;				// 고객 좌표 수
	static int cx, cy;			// 출발지(회사) 좌표
	static int hx, hy;			// 도착지(집) 좌표
	static int[][] custs;		// 고객 좌표 배열
	static int min_dist;
	
	
	static void swap(int i, int j) {
		int tmpX = custs[i][0];
		int tmpY = custs[i][1];
		
		custs[i][0] = custs[j][0];
		custs[i][1] = custs[j][1];
		
		custs[j][0] = tmpX;
		custs[j][1] = tmpY;
	}
	
	static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	static void permutation(int depth, int dist, int curX, int curY) {
		if(min_dist <= dist)	return;
		
		if(depth == N) {
			dist += getDist(curX, curY, hx, hy);
	        min_dist = Math.min(min_dist, dist);
			return;
		}
		
		for (int i = depth; i < N; i++) {
			swap(depth, i);
			
			int nextX = custs[depth][0];
			int nextY = custs[depth][1];
			int move = getDist(curX, curY, nextX, nextY);
			
			permutation(depth+1, dist + move, nextX, nextY);
			swap(depth, i);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("res/swea_1247.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());		
		for (int i = 1; i < T+1; i++) {
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());		
			
			custs = new int[N][2];
			for (int j = 0; j < N; j++) {
				custs[j][0] = Integer.parseInt(st.nextToken());
				custs[j][1] = Integer.parseInt(st.nextToken());
			}
			
			min_dist = Integer.MAX_VALUE;
			
			permutation(0, 0, cx, cy);
			
			System.out.println("#" + i + " " + min_dist);
		}		
	}
}
