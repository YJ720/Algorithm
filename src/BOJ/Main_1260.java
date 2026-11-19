package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1260 {
	public static boolean map[][];
	public static boolean visited[];
	public static int N;
	public static int V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int j =  Integer.parseInt(st.nextToken()) - 1;
			int k =  Integer.parseInt(st.nextToken()) - 1;
			map[j][k] = true;
			map[k][j] = true;
		}
		
		dfs(V);
//		bfs(V);
	}
	
	public static void dfs(int cur) {
		visited[cur] = true;
		for (int ad = 0; ad < N; ad++) {
			if(map[cur][ad] && !visited[ad]) {
				dfs(ad);
			}
		}
	}
}
