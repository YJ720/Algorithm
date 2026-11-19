package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2007 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			sb.append('#').append(t).append(' ').append(find(s)).append('\n');
		}
		System.out.println(sb);
	}
	
	static int find(String s) {
		
		for (int i = 1; i <= 10; i++) {
			boolean ok = true;
			
			for (int j = i; j < s.length(); j++) {
				if(s.charAt(j) != s.charAt(j % i)) {
					ok = false;
					break;
				}
			}
			
			if(ok) return i;
			
		}
		return -1;
	}

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int T = Integer.parseInt(br.readLine());
//		
//		for (int t = 1; t <= T; t++) {			
//			int cnt = 1;
//			
//			String input = br.readLine();
//			
//			for (int i = 1; i < 30; i++) {
//				if( input.charAt(i) != input.charAt(0) ) {
//					cnt = i + 1;
//				}else {
//					for (int j = i+1; j < i+1+cnt; j++) {
//						if( input.charAt(j) != input.charAt(j % cnt) ) {
//							cnt = j + 1;
//						}
//					}
//					break;
//				}
//			}
//			
//			System.out.println("#" + t + " " + cnt);
//		}
//	}
}
