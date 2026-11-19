package Programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main_42584 {

	class Solution {
	    public int[] solution(int[] prices) {
	        int n = prices.length;
	        int[] stock = new int[n];
	        Deque<Integer> stack = new ArrayDeque<>();

	        for (int i = 0; i < n; i++) {
	            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
	                int idx = stack.pop();
	                stock[idx] = i - idx;
	            }
	            stack.push(i);
	        }

	        while (!stack.isEmpty()) {
	            int idx = stack.pop();
	            stock[idx] = (n - 1) - idx;
	        }

	        return stock;
	    }
	}
}
