package Programmers;

import java.util.Arrays;

public class Solution_131129 {

	class Solution {
	    public int[] solution(int target) {
	    	// 각 점수마다 얻을 수 있는 싱글/불 횟수
	        int[] sb = new int[61];
	        Arrays.fill(sb, -1);
	        
	        for (int i = 1; i <= 20; i++) {
	            sb[i] = Math.max(sb[i], 1);         // 싱글
	            sb[i * 2] = Math.max(sb[i * 2], 0); // 더블
	            sb[i * 3] = Math.max(sb[i * 3], 0); // 트리플
	        }
	        sb[50] = Math.max(sb[50], 1);           // 불
	        
	        // dp[i][0]: 최소 다트 수, dp[i][1]: 최대 싱글/불 횟수
	        int[][] dp = new int[target + 1][2];
	        for (int i = 1; i <= target; i++) {
	            dp[i][0] = 1000000; 
	            dp[i][1] = -1;
	        }
	        
	        dp[0][0] = 0;
	        dp[0][1] = 0;
	        
	        for (int i = 1; i <= target; i++) {
	            for (int j = 1; j <= Math.min(60, i); j++) {
	                
	            	if (sb[j] != -1) {
	                    int prevDarts = dp[i - j][0];
	                    int prevSb = dp[i - j][1];
	                    
	                    // 다트 던진 횟수가 더 적은 경우
	                    if (prevDarts + 1 < dp[i][0]) {
	                        dp[i][0] = prevDarts + 1;
	                        dp[i][1] = prevSb + sb[j];
	                    } 
	                    // 다트 던진 횟수가 같다면 싱글/불 횟수가 더 많은 경우로
	                    else if (prevDarts + 1 == dp[i][0]) {
	                        dp[i][1] = Math.max(dp[i][1], prevSb + sb[j]);
	                    }
	                }
	            	
	            }
	        }
	        
	        return new int[]{dp[target][0], dp[target][1]};
	    }
	}
}
