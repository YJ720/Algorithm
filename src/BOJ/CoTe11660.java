package BOJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoTe11660 {
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("res/CoTe11660.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				A[i][j] += A[i-1][j] + A[i][j-1] - A[i-1][j-1];
			}
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		
		for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int ans = A[x2][y2] - A[x1-1][y2] - A[x2][y1-1] + A[x1-1][y1-1];
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}	
}