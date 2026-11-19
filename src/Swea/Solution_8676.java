package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_8676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String target = "SAMSUNG";
		long mod = 1000000007;
		
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			String s = br.readLine();
			
			long[] dp = new long[8];
			dp[0] = 1;
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				for (int j = 0; j < 7; j++) {
					if(c == target.charAt(j)) {
						dp[j+1] = (dp[j+1] + dp[j]) % mod;
					}
				}
			}
			System.out.println("#" + t + " " + dp[7]);
		}
		
	}
}
