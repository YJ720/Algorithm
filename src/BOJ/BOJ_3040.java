package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040 {
	static int N;
	static int R;
	static int[] numbers;
	static int[] input;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 9;
		R = 7;
		input = new int[N];
		numbers = new int[R];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		combi(0, 0, 0);
	}
	
	static void combi(int depth, int start, int sum) {
		if(depth == R) {
			if(sum == 100) {
				for (int i = 0; i < R; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[depth] = input[i];
			combi(depth+1, i+1, sum + input[i]);
		}
	}
}
