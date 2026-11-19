package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_서로소 {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int w;
		public Edge(int start, int end, int weight) {
			super();
			this.from = start;
			this.to = end;
			this.w = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void make() {
		for (int i = 1; i < V+1; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int v) {
		if(parents[v] == v)		return v;
		return parents[v] = find(parents[v]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)		return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("swea_3124.txt"));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t < T+1; t++) {
			 st = new StringTokenizer(br.readLine());
			 V = Integer.parseInt(st.nextToken());			
			 E = Integer.parseInt(st.nextToken());	
			 parents = new int[V+1];
			 edgeList = new Edge[E];
			 
			 for (int i = 0; i < E; i++) {
				 st = new StringTokenizer(br.readLine());
				 int from = Integer.parseInt(st.nextToken());	
				 int to = Integer.parseInt(st.nextToken());	
				 int weight = Integer.parseInt(st.nextToken());	
				 edgeList[i] = new Edge(from, to, weight);
			}
			 
			 make();
			 
			 Arrays.sort(edgeList);
			 long result = 0;
			 int count = 0;
			 
			 for (Edge edge : edgeList) {
				if(union(edge.from, edge.to)) {
					result += edge.w;
					
					if(++count == V-1) {
						break;
					}
				}
			}
			 
			 System.out.println("#" + t + " " + result);
		}
	}
}
