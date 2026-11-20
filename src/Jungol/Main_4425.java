package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4425 {
    static int N, H, goal, num, max, min;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        goal = N*N*3/4;
        num = 1_000_001;
        visit = new boolean[N][N];
        max = 0; min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] > max) max = map[i][j];

                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int lo = 0; int hi = max - min;
        while(lo < hi){
            int mid = (lo + hi) / 2;

            if(check(mid)) hi = mid;
            else lo = mid + 1;
        }
        System.out.println(lo);
    }

    public static boolean check(int h){
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                if(bfs(i, j, h) >= goal) return true;
            }
        }
        return false;
    }

    public static int bfs(int sr, int sc, int h){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {sr, sc});

        visit[sr][sc] = true;

        int cnt = 0;

        while(!q.isEmpty()){

            int [] poll = q.poll();
            cnt++;
            if(cnt >= goal){
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nr = poll[0] + dr[i];
                int nc = poll[1] + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]){
                    if(Math.abs(map[poll[0]][poll[1]] - map[nr][nc]) <= h){
                        q.offer(new int[] {nr, nc});
                        visit[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}
