package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1167 {
	
	static class Node {
		int to, dist;
		
		public Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
	
	static int N, maxDist = 0, farNode;
	static ArrayList<Node>[] tree;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			tree[i] = new ArrayList<>();			
		}
		
		for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                
                if (to == -1) {
                    break;
                }
                
                int weight = Integer.parseInt(st.nextToken());
                
                tree[from].add(new Node(to, weight));
            }
        }
		
		visited = new boolean[N+1];
		bfs(1);
		
		visited = new boolean[N + 1];
        maxDist = 0;
        bfs(farNode);
        
        System.out.println(maxDist);

	}
	
	// StackOverflowError
//	static void dfs(int from, int dist) {
//
//		visited[from] = true;
//		
//		if (dist > maxDist) {
//			maxDist = dist;
//			farNode = from;
//		}
//		
//		for (Node nextNode : tree[from]) {
//			
//			if (!visited[nextNode.to]) {
//				dfs(nextNode.to, dist + nextNode.dist);
//			}
//			
//		}
//	}
	
	static void bfs(int startNode) {
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(startNode, 0));
        visited[startNode] = true;
        
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNode = cur.to;
            int curDist = cur.dist;
            
            if (curDist > maxDist) {
                maxDist = curDist;
                farNode = curNode;
            }
            
            for (Node nextNode : tree[curNode]) {
                if (!visited[nextNode.to]) {
                    visited[nextNode.to] = true;
                    
                    queue.add(new Node(nextNode.to, curDist + nextNode.dist));
                }
            }
        }
	}
}









