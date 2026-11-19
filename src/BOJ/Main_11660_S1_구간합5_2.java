package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_11660_S1_구간합5_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] sum = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				sum[i][j] = Integer.parseInt(st.nextToken());
				//이전 행과 이전 열에 대한 누적값 더하기             두번 더해진 부분 빼기 
				sum[i][j] += sum[i - 1][j] + sum[i][j -1] - sum[i - 1][j - 1];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
//					  누적된 부분에서       초기 좌표의 값 빼기                두번 빼진곳 더해주기 
			int res = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

}
