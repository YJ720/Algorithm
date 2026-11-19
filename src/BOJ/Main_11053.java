package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053 {
	private static int n;
    private static int[] nums, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        nums = new int[n + 1];
        memo = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        memo[1] = 1;
        for (int i = 2; i < n+1; i++) {
            memo[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[i] && memo[i] <= memo[j]) {
                    memo[i] = memo[j] + 1;
                }
            }
        }

        int max = memo[1];
        for (int i = 2; i <= n; i++) {
            max = Math.max(memo[i], max);
        }
        System.out.println(max);
    }
}
