package Programmers;

public class Solution_86053 {
	
}


class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long low = 0;
        long high = 400_000_000_000_000L; 
        long ans = high;

        while (low <= high) {
            long mid = (low + high) / 2;

            long gTotal = 0;
            long sTotal = 0;
            long gsTotal = 0;

            for (int i = 0; i < g.length; i++) {
                long cnt = mid / (2L * t[i]);
                
                if (mid % (2L * t[i]) >= t[i]) { 
                    cnt++;
                }

                long maxW = cnt * w[i];

                gTotal += Math.min(g[i], maxW);
                sTotal += Math.min(s[i], maxW);
                gsTotal += Math.min(g[i] + s[i], maxW);
            }

            if (gTotal >= a && sTotal >= b && gsTotal >= a + b) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}