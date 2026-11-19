package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SWEA 1251. 하나로 - Prim PQ
public class Solution_D4_1251_하나로_프림PQ {

    static class Node implements Comparable<Node> {
        int v;
        double w;

        public Node(int v, double w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.w, o.w);
        }
    }

    static int N;
    static int[] ArrX;
    static int[] ArrY;
    static double E;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader("res/swea_1251.txt"));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(in.readLine());

            ArrX = new int[N];
            ArrY = new int[N];
            visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                ArrX[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                ArrY[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(in.readLine());

            double answer = prim(0);

            sb.append("#").append(tc).append(" ")
              .append(Math.round(answer)).append("\n");
        }

        System.out.print(sb);
    }

    static double prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        double totalWeight = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.v]) continue;

            visited[cur.v] = true;
            totalWeight += cur.w;

            if (++count == N) break;

            //모든 섬이 연결이 가능하기 때문에.... 
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    pq.offer(new Node(i, getCost(cur.v, i)));
                }
            }
        }

        return totalWeight;
    }

    static double getCost(int a, int b) {
        long dx = ArrX[a] - ArrX[b];
        long dy = ArrY[a] - ArrY[b];

        return (dx * dx + dy * dy) * E;
    }
}