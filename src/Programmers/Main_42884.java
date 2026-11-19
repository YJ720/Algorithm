package Programmers;

import java.util.Arrays;

public class Main_42884 {

	class Solution {
	    public int solution(int[][] routes) {
	        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
	        
	        int camera = 0;
	        int prevCamera = -30001;
	        
	        for (int[] route : routes) {
				int in = route[0];
				int out = route[1];
				
				if(in > prevCamera) {
					prevCamera = out;
					camera++;
				}
			}
	        
	        return camera;
	    }
	}
}
