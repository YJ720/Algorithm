package BOJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799 {
	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new FileReader("res/10799.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		String line = in.readLine();
		int size = line.length();
		int answer = 0;
		
		// ')' 나오면 pop()으로 빼고
        // 이전 입력이 '('이면 레이저 이므로
        // stack 에 남은 '(' 개수를 세면 잘린 막대기 수
		for (int i = 0; i < size; i++) {
			char ch = line.charAt(i);			
			if(ch == '(') {
				stack.push(ch);
			}else if(ch == ')') {
				stack.pop();
				if (line.charAt(i-1) == '(') {
                    answer += stack.size();
                } else { // 꼬다리
                    answer++;
                }
			}
		}
		
		System.out.println(answer);
	}
}
