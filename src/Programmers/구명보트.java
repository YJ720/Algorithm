package Programmers;

import java.util.Arrays;

public class 구명보트 {
	public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
       int l = 0;
       int r = people.length;
       
       while(l<=r) {
    	   		if(people[l] + people[r] <= limit) {
    	   			l++;
    	   			r--;
        	   		answer++;
    	   		}else {
        	   		r--;
        	   		answer++;
    	   		}
       }
        
        return answer;
    }
}
