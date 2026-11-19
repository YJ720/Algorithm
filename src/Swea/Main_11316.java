package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main_11316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[m];
            Arrays.fill(arr, -1);

            int last = s;
            arr[s] = 0;

            int ans = 0;

            for (int i = 1; i <= m; i++) {
                last = math(p, last, q, m);

                if (arr[last] != -1) {
                    ans = i - arr[last];
                    break;
                }

                arr[last] = i;
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    static int math(int p, int A, int q, int m) {
        return (int) (((long) p * A + q) % m);
    }
}
