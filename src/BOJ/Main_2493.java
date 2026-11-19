package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(in.readLine());
		
		Stack<int[]> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
				
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i < N+1; i++) {
			int H = Integer.parseInt(st.nextToken());
			
			/*
			 * stack 이 비어있으면 출력에 "0 " 추가
			 * 
			 * stack 이 비어있지 않으면
			 * top 의 높이와 현재 높이를 비교
			 * top 의 높이가 작다면 레이저에 맞지 않음 -> pop() 으로 빼줌
			 * top 의 높이가 크거나 같으면 레이저에 맞음 -> 출력에 top 의 인덱스 추가
			 */
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >= H) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			
			stack.push(new int[] {i, H});
		}
		System.out.println(sb.toString().trim());
	}
}
