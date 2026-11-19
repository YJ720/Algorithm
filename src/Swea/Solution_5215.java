package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// #1 750

//1				//Test Case 갯수
//5 1000		//Test Case #1, N = 5, L = 1000
//100 200		//Test Case #1, 첫번째 재료 정보
//300 500
//250 300
//500 1000
//400 400	


public class Solution_5215 {
	static int N, L;
	static int[][] burger;
	static int maxTaste;
	
	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new FileReader("res/swea_5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < T+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			burger = new int[N][2];
			maxTaste = 0;
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				burger[j][0] = Integer.parseInt(st.nextToken());
				burger[j][1] = Integer.parseInt(st.nextToken());
			}
			subset(0, 0, 0);
			System.out.println("#" + i + " " + maxTaste);
		}		
	}
	
	public static void subset(int depth, int tasSum, int calSum) {
		if(calSum > L)	return;
		
		if(depth == N) {
			maxTaste = Math.max(tasSum, maxTaste);
			return;
		}
		
		subset(depth+1, tasSum+burger[depth][0], calSum + burger[depth][1]);
		subset(depth+1, tasSum, calSum);
	}
	
}
