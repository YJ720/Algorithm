package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int arr[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// int 로 하면 fail
			long profit = 0;
			int max = 0;
			
			for (int i = N-1; i >= 0; i--) {
				if(arr[i] < max) {
					profit += (max - arr[i]);
				}else {
					max = arr[i];
				}
			}
			
			System.out.println("#" + t + " " + profit);
		}
	}
}
