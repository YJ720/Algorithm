package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10
//4
//0 5 3 8
//4 0 4 1
//2 5 0 3
//7 2 3 0
//......

//#1 2
//#2 1
//#3 38
//#4 15
//#5 4
//#6 0
//#7 51
//#8 23
//#9 13
//#10 11


public class Solution_4012 {
	static int N;
	static int[][] food;
	static boolean[] selected;
	static int min_score;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("res/swea_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			food = new int [N][N];
			min_score = Integer.MAX_VALUE;
			selected = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			subset(0, 0);
			System.out.println("#" + t + " " + min_score);
		}
	}
	
	
	public static void subset(int depth, int count) {
		if(count > N/2)	return;
		
		if(depth == N) {
			if(count == N/2) {
				calScore();
			}
			return;
		}
		
		selected[depth] = true;
		subset(depth+1, count+1);
		
		selected[depth] = false;
		subset(depth+1, count);
	}
	
	public static void calScore() {
		int scoreA = 0, scoreB = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(selected[i] && selected[j]) {
					scoreA += food[i][j] + food[j][i];
				}
				else if(!selected[i] && !selected[j]) {
					scoreB += food[i][j] + food[j][i];
				}
			}
		}
		
		int score = Math.abs(scoreA - scoreB);
		min_score = Math.min(min_score, score);
	}
}
