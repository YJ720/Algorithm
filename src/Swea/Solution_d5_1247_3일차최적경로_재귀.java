package Swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * 고객사와 집은 순열 구하고 마지막에 처리하면 되기때문에 10P10이다. 
 * 
 * 시간이 20초로 충분
 * 
 * 212ms
 */
public class Solution_d5_1247_3일차최적경로_재귀 {
	static int N;
	static int[][] map;
	static boolean[] visit;
	static int min ;
	static int homex;
	static int homey;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/1247_3일차최적경로.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer tokens;
		for (int testcase = 1; testcase <=T; testcase++) {
			N = Integer.parseInt(in.readLine());
			min = Integer.MAX_VALUE;
			map = new int[N][2];
			visit = new boolean[N];
			tokens = new StringTokenizer(in.readLine(), " ");
			int comx = Integer.parseInt(tokens.nextToken());
			int comy = Integer.parseInt(tokens.nextToken());
			homex = Integer.parseInt(tokens.nextToken());
			homey = Integer.parseInt(tokens.nextToken());
			for (int i = 0; i < N; i++) {
				map[i][0] = Integer.parseInt(tokens.nextToken());
				map[i][1] = Integer.parseInt(tokens.nextToken());
			}
			permutation(0,0,comx, comy);
			System.out.println("#" + testcase + " " + min);
		}
	}
	private static void permutation(int cnt,int dist, int startx, int starty) {
		if(cnt == N) {
			dist+= Math.abs(startx - homex)+Math.abs(starty - homey);
			min = Math.min(min, dist);
			return;
		}
		if(dist >=min) {
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				int ndist =  Math.abs(startx - map[i][0])+Math.abs(starty - map[i][1]);
				permutation(cnt+1, dist+ndist, map[i][0], map[i][1]);
				visit[i] = false;
			}
		}
	}
}








