package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		int notYet = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.offer(new int[] {i, j});	// 큐에 모든 출발점 저장
				}else if(map[i][j] == 0) {
					notYet++;	// 아직 안 익은 토마토
				}
			}
		}		
		
		if(notYet == 0) {	// 안 익은 토마토 없음 == 이미 다 익었음
			System.out.println(0);
			return;
		}
		
		while(!q.isEmpty()) {		// 큐에 저장된 모든 출발점에서 BFS 탐색
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < N && nx >= 0 && ny < M && ny >=0) {	// 배열 범위 검사
					if(map[nx][ny] == 0) {	// 탐색 여부 검사
						map[nx][ny] = map[x][y] + 1;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
		
		int max_days = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {	// BFS 후에도 안 익은 토마토 존재 == 토마토가 모두 익지 못함
					System.out.println(-1);
					return;
				}
				max_days = Math.max(max_days, map[i][j]);	// 모든 토마토가 익는 시간
			}
		}
		System.out.println(max_days-1);
	}

}
