package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Main_42586 {

	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	    	
	    	int n = progresses.length;
	    	int[] days = new int[n];
	        
	    	for (int i = 0; i < n; i++) {
	    		days[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
	        }

	        List<Integer> result = new ArrayList<>();
	        int base = days[0];
	        int cnt = 1;

	        for (int i = 1; i < n; i++) {
	            if (days[i] <= base) {
	                cnt++;
	            } else {
	                result.add(cnt);
	                base = days[i];
	                cnt = 1;
	            }
	        }
	        result.add(cnt);

	        return result.stream().mapToInt(Integer::intValue).toArray();
	    }
	}
}
