package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11437 {

	static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 트리 간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        // 1번 노드를 루트로 트리의 깊이와 부모를 설정
        bfs(1);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    // 깊이 및 부모 노드 기록
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        depth[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : tree[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = cur; // 부모 노드 기록
                    depth[next] = depth[cur] + 1; // 깊이 1 증가
                    q.add(next);
                }
            }
        }
    }

    // 최소 공통 조상을 찾는 함수
    static int lca(int a, int b) {
        // 깊이가 다를 경우, 더 깊은 노드를 위로 올려 깊이를 맞춤
        while (depth[a] > depth[b]) {
            a = parent[a];
        }
        while (depth[b] > depth[a]) {
            b = parent[b];
        }

        // 깊이가 같아진 후, 공통 조상을 찾을 때까지 함께 위로 이동
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
