package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15649 {
	static int M;
	static int N;
	static int[] input;
	static int[] numbers;
	static boolean[] visited;
	
	public static void permutation(int depth) {
		if(depth == M) {
			for (int i = 0; i < numbers.length; i++) {
			    System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			
			numbers[depth] = input[i];
			permutation(depth+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		numbers = new int[M];
		visited = new boolean[N];
		permutation(0);
	}
}
