package Jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main_8944 {	// 시간초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] dp = new int[m + 1];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            
            for (int w = m; w >= 1; w--) {
                
                for (int k = 1; k <= count; k++) {
                    int totalWeight = weight * k;
                    int totalValue = value * k;
                    
                    if (w - totalWeight < 0) {
                        break; 
                    }
                    
                    dp[w] = Math.max(dp[w], dp[w - totalWeight] + totalValue);
                }
            }
        }

        System.out.println(dp[m]);
    }
}