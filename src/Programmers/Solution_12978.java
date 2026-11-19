package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_12978 {
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
	
	public int solution(int N, int[][] road, int K) {
		List<Node>[] graph = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int[] r : road) {
			int u = r[0];
			int v = r[1];
			int w = r[2];
			
			graph[u].add(new Node(v, w));
			graph[v].add(new Node(u, w));
		}
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.w>dist[cur.v]) {
				continue;
			}
			
			for (Node nxt : graph[cur.v]) {
				int nCost = dist[cur.v] + nxt.w;
				
				if(nCost<dist[nxt.v]) {
					dist[nxt.v] = nCost;
					pq.offer(new Node(nxt.v, nCost));
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i < N+1; i++) {
			if(dist[i]<=K) {
				answer++;
			}
		}
        return answer;
    }
}
