package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_8898 {
	static int N, M;	
	static int[] cows, horses;	
	static int minz, count;
	static int c1, c2;
	static int distx;
	static int p1, p2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			cows = new int[N];
			horses = new int[M];
			
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			
			distx =  Math.abs(c1 - c2);
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cows[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				horses[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(cows);
			Arrays.sort(horses);
			
			minz = Integer.MAX_VALUE;
			count = 0;			
			
			p1 = 0;
			p2 = 0;
			
			while(p1<N && p2<M) {
				int distz = Math.abs(cows[p1] - horses[p2]);
				
				if(minz > distz) {
					minz = distz;
					count = 1;
				}else if(minz == distz) {
					count++;
				}
				
				if(cows[p1] < horses[p2]) {
					p1++;
				}else {
					p2++;
				}
			}
			System.out.println("#" + t + " " + (distx + minz) + " " + count);
		}
	}
}
