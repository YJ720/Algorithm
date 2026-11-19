package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {
	static class Node implements Comparable<Node>{
		int v, w;
		public Node(int v, int weight) {
			this.v = v;
			this.w = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	private static final int INF = Integer.MAX_VALUE;
	static int V, E, K;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[V+1];
		dist = new int[V+1];
		
		for (int i = 1; i < V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		
		
	}
	
	public static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		dist[K] = 0;
		pq.offer(new Node(st, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dist[now.v] < now.w)		continue;
			
		}
	}
}
