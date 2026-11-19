package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251 {
	static class Node implements Comparable<Node>{
		int v;
		long w;
		public Node(int no, long weight) {
			super();
			this.v = no;
			this.w = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	static long[] X, Y;
	static int N;
	static boolean[] visited;
	static double E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("res/swea_1251.txt"));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			X = new long[N];
			Y = new long[N];
			visited = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());				
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());				
			}
			
			E = Double.parseDouble(br.readLine());
			
			long ans = Math.round(E * prim(0));
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	public static long prim(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(st, 0));
		
		long totalWeight = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.v])		continue;
			visited[cur.v] = true;
			totalWeight += cur.w;
			if(++cnt == N)		break;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i]) {
					long distSq = getDistSq(cur.v, i);
					pq.offer(new Node(i, distSq));
				}
			}
		}
		
		return totalWeight;
	}
	
	public static long getDistSq(int a, int b) {
		
		return (X[a] - X[b]) * (X[a] - X[b]) + (Y[a] - Y[b]) * (Y[a] - Y[b]);
	}
}
	
