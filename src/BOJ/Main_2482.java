package BOJ;

import java.util.Scanner;

public class Main_2482 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 2K가 N보다 크다면 0 출력하고 return
		if(2*K > N) {
			System.out.println(0);
			return;
		}
		
		int[][] dp = new int[N+1][K+1];
		
		// K가 0인 경우 1로 초기화, K가 1인 경우 i로 초기화
		for (int i = 1; i < N+1; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
		}
		
		// 선형 배열인 경우로만 고려해서 i번째 색을 선택하는 경우와 선택하지 않는 경우의 합
		for (int i = 2; i < N+1; i++) {
			for (int j = 2; j < K+1; j++) {
				dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % 1000000003;
			}
		}
		
		// 원형인 경우까지 고려해서 1번째 색을 선택하는 경우와 선택하지 않는 경우의 합
		dp[N][K] = (dp[N-3][K-1] + dp[N-1][K]) % 1000000003;
		System.out.println(dp[N][K]);
	}
}