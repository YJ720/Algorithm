package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12712 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());

        int[][] plusDir = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] xDir    = {{-1,-1},{-1,1},{1,-1},{1,1}};

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    
                	int plusSum = arr[i][j];
                    for (int[] d : plusDir) {
                        for (int k = 1; k < M; k++) {
                            int ni = i + d[0] * k, nj = j + d[1] * k;
                            if (ni >= 0 && ni < N && nj >= 0 && nj < N)
                                plusSum += arr[ni][nj];
                        }
                    }

                    int xSum = arr[i][j];
                    for (int[] d : xDir) {
                        for (int k = 1; k < M; k++) {
                            int ni = i + d[0] * k, nj = j + d[1] * k;
                            if (ni >= 0 && ni < N && nj >= 0 && nj < N)
                                xSum += arr[ni][nj];
                        }
                    }

                    max = Math.max(max, Math.max(plusSum, xSum));
                }
            }

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
