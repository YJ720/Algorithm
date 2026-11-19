package Programmers;

import java.util.Stack;

public class Solution_77886 {

	class Solution {
	    public String[] solution(String[] s) {
	    	String[] answer = new String[s.length];
	    	
	    	for (int i = 0; i < s.length; i++) {
				
				answer[i] = move110(s[i]);
			}
	        return answer;
	    }
	    
	    static String move110(String S) {
			Stack<Character> stack = new Stack<>();
			int cnt110 = 0;
			
			for (int i = 0; i < S.length(); i++) {
				char ch = S.charAt(i);
				
				if(ch == '0' && stack.size() >= 2) {
					char second = stack.pop();
					char first = stack.pop();
					
					if(first == '1' && second == '1') {
						cnt110++;
					}else {
						stack.push(first);
	                    stack.push(second);
	                    stack.push(ch);
					}
				}else {
					stack.push(ch);
				}
			}
			
			StringBuilder sb = new StringBuilder();
	        while (!stack.isEmpty()) {
	            sb.append(stack.pop());
	        }
	        sb.reverse();
	        
	        int insertIdx = sb.lastIndexOf("0");
	        if (insertIdx == -1) {
	            insertIdx = 0;
	        } else {
	            insertIdx += 1;
	        }
	        
	        StringBuilder toInsert = new StringBuilder();
	        for (int i = 0; i < cnt110; i++) {
	            toInsert.append("110");
	        }
	        
	        sb.insert(insertIdx, toInsert.toString());
	        
	        return sb.toString();
			
	    }
	}
}
