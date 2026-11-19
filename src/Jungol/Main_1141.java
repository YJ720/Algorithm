package Jungol;

import java.util.Scanner;

/*
 * boj 11727
 * 정올 1411
 */

public class Main_1141 {
	static int dp[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N+1];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for (int i = 3; i < N+1; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % 20100529;
		}
		
		System.out.println(dp[N]);
	}
}
