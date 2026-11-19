package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1761 {
    static int N, M, K;
    static int[] depth;
    static int[] dist;
    static int[][] parent;
    static ArrayList<Node>[] adj;

    static class Node {
        int to, cost;
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        K = 0;
        for (int i = 1; i <= N; i *= 2) K++;
        
        depth = new int[N + 1];
        dist = new int[N + 1];
        parent = new int[K][N + 1];
        adj = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, cost));
            adj[v].add(new Node(u, cost));
        }
        
        // 1번 노드를 루트로 설정하여 탐색
        dfs(1, 1, 0, 0);
        
        // 부모 노드 정보 채우기
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
        
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            int lca = getLCA(u, v);

            int distance = dist[u] + dist[v] - 2 * dist[lca];
            sb.append(distance).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void dfs(int cur, int p, int d, int c) {
        depth[cur] = d;
        parent[0][cur] = p;
        dist[cur] = c;
        
        for (Node next : adj[cur]) {
            if (next.to != p) {
                dfs(next.to, cur, d + 1, c + next.cost);
            }
        }
    }
    
    static int getLCA(int a, int b) {
        // 깊이가 더 깊은 쪽을 a로 맞춤
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        // 깊이 맞추기
        for (int i = K - 1; i >= 0; i--) {
            if ((1 << i) <= depth[a] - depth[b]) {
                a = parent[i][a];
            }
        }
        
        if (a == b) return a;
        
        // 공통 조상 찾기
        for (int i = K - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        
        return parent[0][a];
    }
}