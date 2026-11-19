package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int[] inDegree = new int[N+1];
		
		ArrayList<Integer> result = new ArrayList<>();
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			inDegree[to]++;
		}
		
		for (int i = 1; i < N+1; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			result.add(cur);
			
			for (Integer ad : list[cur]) {
				if(--inDegree[ad] == 0) {
					q.offer(ad);
				}
			}
		}
		
		int size = result.size();
		
		for (int i = 0; i < size; i++) {
			System.out.print(result.get(i));
			if (i != size - 1)	System.out.print(" ");
		}
	}
}
