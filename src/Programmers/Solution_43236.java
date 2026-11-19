package Programmers;

import java.util.Arrays;

public class Solution_43236 {
	
	
	class Solution {
	    public int solution(int distance, int[] rocks, int n) {
	    	int ans = 0;
	        
	        Arrays.sort(rocks);
	        
	        int left = 1; 
	        int right = distance; 
	        
	        while (left <= right) {
	            int mid = (left + right) / 2;
	            int removed = 0;
	            int prev = 0;
	            
	            for (int i = 0; i < rocks.length; i++) {
	                if (rocks[i] - prev < mid) {
	                    removed++;
	                } else {
	                    prev = rocks[i];
	                }
	            }
	            
	            if (distance - prev < mid) {
	                removed++;
	            }
	            
	            if (removed > n) {
	                right = mid - 1;
	            } else {
	                ans = mid;
	                left = mid + 1;
	            }
	        }
	        
	        return ans;
	    }
	}
	
}
