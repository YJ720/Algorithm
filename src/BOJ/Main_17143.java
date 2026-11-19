package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143 {	
	static class Shark{
		int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
	}
	
	static int R, C, M;
    static Shark[][] grid;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new Shark[R + 1][C + 1];
        
        // 상어 정보 입력
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            // 이동 횟수 최적화
            if (d == 1 || d == 2) s %= (R - 1) * 2;
            else s %= (C - 1) * 2;

            grid[r][c] = new Shark(r, c, s, d, z);
		}
        
        int total = 0;
        
        for (int col = 1; col < C+1; col++) {	// 낚시왕 이동
			for (int row = 1; row < R+1; row++) {	// 상어 탐색
				if(grid[row][col] != null) {
					total += grid[row][col].z;
					grid[row][col] = null;
					break;	// 한 열당 한 마리만 잡고 끝
				}
			}
			
			// 상어의 이동을 기록할 배열 선언
			Shark[][] nextGrid = new Shark[R + 1][C + 1];
			
			for (int r = 1; r < R+1; r++) {
				for (int c = 1; c < C+1; c++) {
					if(grid[r][c] != null) {
						Shark shark = grid[r][c];
                        move(shark);
                        
                        if (nextGrid[shark.r][shark.c] != null) {	// 이동한 곳에 다른 상어가 있다면
                            if (nextGrid[shark.r][shark.c].z < shark.z) {		// 무게 비교
                                nextGrid[shark.r][shark.c] = shark;
                            }
                        } else {
                            nextGrid[shark.r][shark.c] = shark;
                        }
					}
				}
			}			
			grid = nextGrid;
		}       
        System.out.println(total);
	}
	
	public static void move(Shark shark) {
		int s = shark.s;
        int d = shark.d;
        int r = shark.r;
        int c = shark.c;
        
        for (int i = 0; i < s; i++) {
			if(d==1) {		// 위
				r--;
				if(r==0) {
					r = 2;
					d = 2;
				}
			}else if(d==2) {		// 아래
				r++;
				if(r==R+1) {
					r = R-1;
					d = 1;
				}
			}else if(d==3) {		// 오른쪽
				c++;
				if(c==C+1) {
					c=C-1;
					d=4;
				}
			}else if(d==4) {		// 왼쪽
				c--;
				if(c==0) {
					c=2;
					d=3;
				}
			}
		}
        
        shark.r = r;
        shark.c = c;
        shark.d = d;
	}
}
