package Swea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206 {
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/swea_1206.txt"));
		StringTokenizer st;
		
		for (int t = 1; t < 11; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 2; i < N-2; i++) {
				if(arr[i] > arr[i-1] && arr[i] > arr[i-2] && arr[i] > arr[i+1] && arr[i] > arr[i+2]) {
					int left = Math.max(arr[i-2], arr[i-1]);
					int right = Math.max(arr[i+2], arr[i+1]);
					int lr = Math.max(left, right);
					
					ans += (arr[i] - lr);
					
					i+=2;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		
	}
}
