package Swea;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * swap 순열 버전
 * 163ms 
 */
public class Solution_d5_1247_3일차최적경로_swap {
    static int N;
    static int[][] customer;   // 고객 좌표
    static int min;
    static int homex;
    static int homey;
    static int comx;
    static int comy;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/swea_1247.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        StringTokenizer tokens;

        for (int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(in.readLine());
            min = Integer.MAX_VALUE;

            customer = new int[N][2];

            tokens = new StringTokenizer(in.readLine(), " ");
            comx = Integer.parseInt(tokens.nextToken());
            comy = Integer.parseInt(tokens.nextToken());
            homex = Integer.parseInt(tokens.nextToken());
            homey = Integer.parseInt(tokens.nextToken());

            for (int i = 0; i < N; i++) {
                customer[i][0] = Integer.parseInt(tokens.nextToken());
                customer[i][1] = Integer.parseInt(tokens.nextToken());
            }

            permutation(0, 0, comx, comy);

            System.out.println("#" + testcase + " " + min);
        }
    }

    private static void permutation(int cnt, int dist, int prevX, int prevY) {
        if (dist >= min) return;

        if (cnt == N-1) {
            dist += Math.abs(prevX - homex) + Math.abs(prevY - homey);
            min = Math.min(min, dist);
            return;
        }

        for (int i = cnt; i < N; i++) {
            swap(cnt, i);

            int nextX = customer[cnt][0];
            int nextY = customer[cnt][1];
            int move = Math.abs(prevX - nextX) + Math.abs(prevY - nextY);

            permutation(cnt + 1, dist + move, nextX, nextY);

            swap(cnt, i);
        }
    }

    private static void swap(int i, int j) {
        int tempX = customer[i][0];
        int tempY = customer[i][1];

        customer[i][0] = customer[j][0];
        customer[i][1] = customer[j][1];

        customer[j][0] = tempX;
        customer[j][1] = tempY;
    }
}








