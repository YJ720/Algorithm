package Swea;

/*
 * 2 1 1 1
 * 2 2 2 1
 * 1 2 1 1
 * 2 2 1 2
 * 
 *  a + b - c - d = K
 *  E - F = K
 *  2 <= E <= 2N
 *  a + b = E
 *  b = E - a
 *  
 */


/*
 *  2 ~ 4
 *  
 *  2 = 1 1
 *  3 = 1 2
 *  4 = 2 2
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_26011 {

    static long cnt(long E, long N) {
        long lo = Math.max(1, E - N);
        long hi = Math.min(N, E - 1);
        return Math.max(0, hi - lo + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            long ans = 0;
            for (long E = 2; E <= 2 * N; E++) {
                long F = E - K; // a+b - (c+d) = K  =>  c+d = E-K
                
                long c1 = cnt(E, N);
                if (c1 == 0) continue;
                
                long c2 = cnt(F, N);
                if (c2 == 0) continue;
                ans += c1 * c2;
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
