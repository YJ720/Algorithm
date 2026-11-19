package Programmers;

import java.util.Stack;

public class Soluton_12909 {
	public static void main(String[] args) {
		
	}
	
	boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
        	if(c == ')') {
				if(stack.isEmpty()) {
					answer = false;
					return answer;
				}else {
					stack.pop();
				}
			}else {
				stack.push(c);
			}
		}
        
        if(!stack.isEmpty())		answer = false;
        
        return answer;
    }
	
}
