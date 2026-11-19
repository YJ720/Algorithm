package Programmers;

import java.util.Arrays;

public class Main_389480 {
	
	
	/*
	 *  
	 */
	

	class Solution {
		public int solution(int[][] info, int n, int m) {
		    int totalB = 0;
		    for (int[] it : info) totalB += it[1];

		    int R = Math.max(0, totalB - (m - 1)); // B를 A로 최소 이만큼 옮겨야 함
		    
		    if (R == 0) return 0;

		    int INF = Integer.MAX_VALUE;
		    int[] dp = new int[totalB + 1]; // dp[k] = b합을 k 이상 만들 때 최소 a합
		    Arrays.fill(dp, INF);
		    dp[0] = 0;

		    for (int[] it : info) {
		        
		    	int a = it[0], b = it[1];
		        int[] ndp = dp.clone();
		        
		        for (int i = 0; i <= totalB; i++) {
		            
		        	if (dp[i] == INF) continue;
		            
		        	int ni = Math.min(totalB, i + b);
		            
		        	if (dp[i] + a < ndp[ni]) {
		        		ndp[ni] = dp[i] + a;
		        	}
		        }
		        dp = ndp;
		    }

		    int ans = INF;
		    
		    for (int i = R; i <= totalB; i++) {
		    	ans = Math.min(ans, dp[i]);
		    }

		    return (ans < n) ? ans : -1;
		}
	}
}
