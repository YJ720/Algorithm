package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_prim {
	static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int no, int edge) {
			this.v = no;
			this.w = edge;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static int V, E;
	static ArrayList<Node>[] graph;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("swea_3124.txt"));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t < T+1; t++) {
			 st = new StringTokenizer(br.readLine());
			 V = Integer.parseInt(st.nextToken());			
			 E = Integer.parseInt(st.nextToken());	
			 graph = new ArrayList[V+1];
			 visited = new boolean[V+1];
			 
			 for (int i = 1; i < V+1; i++) {
				graph[i] = new ArrayList<>();
			}
			 
			 for (int i = 0; i < E; i++) {
				 st = new StringTokenizer(br.readLine());
				 int a = Integer.parseInt(st.nextToken());	
				 int b = Integer.parseInt(st.nextToken());	
				 int w = Integer.parseInt(st.nextToken());	
				 graph[a].add(new Node(b, w));
				 graph[b].add(new Node(a, w));				 
			}
			 
			 long ans = prim(1);
			 
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
			if(++cnt == V)	break;
			
			for (Node node : graph[cur.v]) {
				if(!visited[node.v]) {
					pq.offer(node);
				}
			}
		}
		return totalWeight;
	}
}
