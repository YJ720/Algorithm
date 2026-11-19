package BOJ;

import java.util.Scanner;

public class Main_1562 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // memo[길이][마지막 숫자][사용된 숫자의 비트마스크]
        long[][][] memo = new long[n + 1][10][1024];

        // 길이가 1일 때의 초기화
        for (int i = 1; i <= 9; i++) {
            memo[1][i][1 << i] = 1;
        }

        // 길이 2 ~ N DP 탐색
        for (int len = 2; len <= n; len++) {
            for (int last = 0; last <= 9; last++) {
                for (int mask = 0; mask < 1024; mask++) {
                    
                    // 새로운 숫자 추가
                    int newMask = mask | (1 << last);

                    // 이전 자리가 last - 1 이었던 경우
                    if (last > 0) {
                        memo[len][last][newMask] = (memo[len][last][newMask] + memo[len - 1][last - 1][mask]) % MOD;
                    }
                    
                    // 이전 자리가 last + 1 이었던 경우
                    if (last < 9) {
                        memo[len][last][newMask] = (memo[len][last][newMask] + memo[len - 1][last + 1][mask]) % MOD;
                    }
                }
            }
        }

        long sum = 0;
        // 길이가 N이고, 0~9 모든 숫자가 사용된 경우의 합 계산
        for (int i = 0; i <= 9; i++) {
            sum = (sum + memo[n][i][1023]) % MOD;
        }

        System.out.println(sum);
    }
}