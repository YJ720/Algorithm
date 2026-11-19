package Programmers;

public class Solution_46062 {

	class Solution {
	    public int solution(int[] stones, int k) {
	        int left = 1;
	        int right = 200_000_000;
	        int answer = 0;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            if (canCross(stones, k, mid)) {
	                answer = mid;      // 건널 수 있다면 갱신
	                left = mid + 1;    // 최솟값 상향
	            } else {
	                right = mid - 1;   // 건널 수 없다면 최댓값 하향
	            }
	        }

	        return answer;
	    }

	    private boolean canCross(int[] stones, int k, int mid) {
	        int skipCount = 0;

	        for (int stone : stones) {
	            if (stone - mid < 0) {
	                skipCount++; 
	                
	                if (skipCount >= k) {
	                    return false;
	                }
	            } else {
	                skipCount = 0; 
	            }
	        }

	        return true;
	    }
	}
}
