package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1106 {
    static int[][] map;
    static int[] dr = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dc = {2, -2, 2, -2, 1, -1, 1, -1};
    static int N, M, R, C, S, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        S = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken()) - 1;

        map[R][C] = 1;

        dfs(R, C);
        System.out.println(map[S][K] - 1);
    }

    public static void dfs(int sr, int sc){
        if(sr == S && sc == K) return;

        int dist = map[sr][sc];

        for (int i = 0; i < 8; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                if(map[nr][nc] == 0 || map[nr][nc] > dist + 1){
                    map[nr][nc] = dist + 1;
                    dfs(nr, nc);
                }
            }
        }


    }
}
