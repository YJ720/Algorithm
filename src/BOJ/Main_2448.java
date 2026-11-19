package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2448 {
	static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // N X (2N - 1)
        map = new char[n][2 * n - 1];
        
        // 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                map[i][j] = ' ';
            }
        }
        
        // 가장 위쪽에서 시작
        drawStar(0, n - 1, n);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void drawStar(int r, int c, int n) {
        // N=3인 경우 별 찍기
        if (n == 3) {
            map[r][c] = '*';                  // 1
            map[r + 1][c - 1] = '*';          // 2
            map[r + 1][c + 1] = '*';
            map[r + 2][c - 2] = '*';          // 3
            map[r + 2][c - 1] = '*';
            map[r + 2][c] = '*';
            map[r + 2][c + 1] = '*';
            map[r + 2][c + 2] = '*';
            return;
        }

        int nextSize = n / 2;
        
        // 상단
        drawStar(r, c, nextSize);
        // 좌하단
        drawStar(r + nextSize, c - nextSize, nextSize);
        // 우하단
        drawStar(r + nextSize, c + nextSize, nextSize);
    }
}
