package BOJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

// https://jungol.co.kr/problem/1141

public class Main_1141 {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("res/1141.txt"));
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();	
		int N = Integer.parseInt(in.readLine());
		long answer = 0;
		
		for (int i = 0; i < N; i++) {
			int cow = Integer.parseInt(in.readLine());		
			/*
			 * 스택이 비어있으면 -> 바로 현재 소의 키를 스택에 추가
			 * 스택이 비어있지 않음 && 스택의 top 이 현재 소의 키보다 작거나 같음
			 * -> pop() 으로 제거 후 현재 소의 키를 스택에 추가
			 * 스택의 top 이 현재 소의 키보다 작거나 같으면 더 이상 앞의 소의 머리를 볼 수 없음
			 */
			while(!stack.isEmpty() && stack.peek() <= cow) {
				stack.pop();
			}
			
			// 앞의 소의 머리를 볼 수 있는 소의 수를 누적 합
			answer += stack.size();
			
			// 현재 소의 키를 stack 에 push()
			stack.push(cow);
		}
		System.out.println(answer);
	}
}
