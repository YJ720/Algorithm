package BOJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1966 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("res/1966.txt"));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Deque<int[]> deque = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				deque.add(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			
			
		}
	}
}
