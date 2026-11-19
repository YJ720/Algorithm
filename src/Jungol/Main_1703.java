package Jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1703 {
    static class Pair implements Comparable<Pair> {
        int u, v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.u, o.u);
        }
    }

    static final int INF = 1000000000;
    static int[][][] memo;
    static int[][][] traceType; // 1: 직접 연결(Match), 2: 분할(Split)
    static int[][][] traceK;
    static int[][][] traceH1;
    static int[][][] traceH2;
    static List<Pair> pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int totalDots = Integer.parseInt(br.readLine().trim());
        int n = totalDots / 2;
        String s = br.readLine().trim();
        
        char[] color = new char[totalDots + 1];
        for (int i = 0; i < totalDots; i++) {
            color[i + 1] = s.charAt(i);
        }

        // dp[i][j][h]: i번부터 j번까지의 점들을 최대 높이 h로 연결할 때의 최소 비용
        memo = new int[totalDots + 1][totalDots + 1][n + 2];
        traceType = new int[totalDots + 1][totalDots + 1][n + 2];
        traceK = new int[totalDots + 1][totalDots + 1][n + 2];
        traceH1 = new int[totalDots + 1][totalDots + 1][n + 2];
        traceH2 = new int[totalDots + 1][totalDots + 1][n + 2];

        for (int i = 0; i <= totalDots; i++) {
            for (int j = 0; j <= totalDots; j++) {
                for (int h = 0; h <= n + 1; h++) {
                    memo[i][j][h] = INF;
                }
            }
        }

        // L은 구간의 길이 (항상 짝수여야 온전한 쌍을 이룹니다)
        for (int L = 2; L <= totalDots; L += 2) {
            for (int i = 1; i <= totalDots - L + 1; i++) {
                int j = i + L - 1;

                // 1. i와 j를 직접 연결하는 경우
                if (color[i] != color[j]) {
                    if (L == 2) {
                        memo[i][j][1] = 3; // 가로 1 + 세로 2
                        traceType[i][j][1] = 1;
                    } else {
                        for (int hInner = 1; hInner <= n; hInner++) {
                            if (memo[i + 1][j - 1][hInner] != INF) {
                                int h = hInner + 1;
                                int cost = memo[i + 1][j - 1][hInner] + (j - i) + 2 * h;
                                if (cost < memo[i][j][h]) {
                                    memo[i][j][h] = cost;
                                    traceType[i][j][h] = 1;
                                    traceH1[i][j][h] = hInner; 
                                }
                            }
                        }
                    }
                }

                // 2. 구간을 i~k, k+1~j 두 부분으로 나누는 경우
                for (int k = i + 1; k < j; k += 2) {
                    for (int h1 = 1; h1 <= n; h1++) {
                        if (memo[i][k][h1] == INF) continue;
                        
                        for (int h2 = 1; h2 <= n; h2++) {
                            if (memo[k + 1][j][h2] == INF) continue;

                            int h = Math.max(h1, h2);
                            int cost = memo[i][k][h1] + memo[k + 1][j][h2];
                            
                            if (cost < memo[i][j][h]) {
                                memo[i][j][h] = cost;
                                traceType[i][j][h] = 2;
                                traceK[i][j][h] = k;
                                traceH1[i][j][h] = h1;
                                traceH2[i][j][h] = h2;
                            }
                        }
                    }
                }
            }
        }

        // 전체 구간(1 ~ 2n)에서 최소 비용과 그때의 높이 찾기
        int minCost = INF;
        int bestH = -1;
        for (int h = 1; h <= n; h++) {
            if (memo[1][totalDots][h] < minCost) {
                minCost = memo[1][totalDots][h];
                bestH = h;
            }
        }

        System.out.println(minCost);

        // 최적해 역추적
        pairs = new ArrayList<>();
        reconstruct(1, totalDots, bestH);
        Collections.sort(pairs);

        for (Pair p : pairs) {
            System.out.println(p.u + " " + p.v);
        }
    }

    // 경로 역추적 메서드
    static void reconstruct(int i, int j, int h) {
        if (i >= j) return;
        
        int type = traceType[i][j][h];
        if (type == 1) { // i와 j가 직접 연결된 경우
            pairs.add(new Pair(i, j));
            int hInner = traceH1[i][j][h];
            if (hInner > 0) {
                reconstruct(i + 1, j - 1, hInner);
            }
        } else if (type == 2) { // k를 기준으로 분할된 경우
            int k = traceK[i][j][h];
            int h1 = traceH1[i][j][h];
            int h2 = traceH2[i][j][h];
            reconstruct(i, k, h1);
            reconstruct(k + 1, j, h2);
        }
    }
}