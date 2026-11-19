package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234 {
	static int N;
	static int[] input;
	static int ans;
	static boolean[] visited;
	static int totalSum;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("res/swea_3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N];
			ans = 0;
			visited = new boolean[N];
			totalSum = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				totalSum += input[i];
			}
						
			dfs(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	// 남은 경우의 수 계산
	public static int pre(int m) {
		int fact = 1;
		int pow2 = 1;
		for (int i = 1; i < m+1; i++) {
			fact *= i;
			pow2 *= 2;
		}
		return fact * pow2;
	}
	
	public static void dfs(int depth, int lSum, int rSum) {
		if(depth == N) {
			ans++;
			return;
		}
		
		// 왼쪽의 무게가 전체 무게의 절반 이상이면 남은 경우의 수 더하고 끝
		if(lSum * 2 >= totalSum) {
			int M = N - depth;
			ans += pre(M);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				// 왼쪽 추가
				dfs(depth+1, lSum+input[i], rSum);
				
				// 오른쪽 추가
				if(lSum >= rSum + input[i]) {
					dfs(depth+1, lSum, rSum+input[i]);
				}
				visited[i] = false;
			}
		}
	}
}
			
		
