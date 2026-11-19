package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] iptCnt = new int[4];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			iptCnt[arr[i]]++;
		}
		
		int[][] cnt = new int[4][4];
		
		// 있어야 할 값,실제 값 
		for (int i = 0; i < N; i++) {
			int loc;
			
			if(i < iptCnt[1]) {
				loc = 1;
			}else if(i < iptCnt[1] + iptCnt[2]) {
				loc = 2;
			}else {
				loc = 3;
			}
			
			cnt[loc][arr[i]]++;
		}
		
		int swaps = 0;
        
        int swap12 = Math.min(cnt[1][2], cnt[2][1]);
        swaps += swap12;
        cnt[1][2] -= swap12;
        cnt[2][1] -= swap12;
        
        int swap13 = Math.min(cnt[1][3], cnt[3][1]);
        swaps += swap13;
        cnt[1][3] -= swap13;
        cnt[3][1] -= swap13;
        
        int swap23 = Math.min(cnt[2][3], cnt[3][2]);
        swaps += swap23;
        cnt[2][3] -= swap23;
        cnt[3][2] -= swap23;
        
        int remain = cnt[1][2] + cnt[1][3];
        swaps += (remain * 2);
    	
    	System.out.println(swaps);
	}
}
