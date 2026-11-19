package Programmers;

public class Main_181851 {

	class Solution {
	    public int solution(int[] rank, boolean[] attendance) {
	    	int a = 0;
	    	int b = 0;
	    	int c = 0;
	    	
	    	int cnt = 0;
	    	
	    	for (int i = 1; i <= rank.length; i++) {
				for (int j = 0; j < rank.length; j++) {
					
					if( rank[j] == i && attendance[j] ) {
						if(cnt == 0) {
							a = j;
						}else if(cnt == 1) {
							b = j;
						}else if(cnt == 2) {
							c = j;
						}
						
						cnt++;
						
						if(cnt == 3) {
							return 10000 * a + 100 * b + c;
						}
					}
				}
			}

	        return 0;
	    }
	}
}
