package Jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main_1824 {
    
    static int[][] board = new int[9][9];
    static boolean isSolved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
    }

    static void dfs(int row, int col) {
    	if (isSolved) {
            return;
        }
    	
    	// 해당 행을 다 채움 -> 다음 행의 첫 번째 열로 이동
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        // 마지막 행까지 다 채움 -> 정답 출력
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
            
            isSolved = true; 
            return;
        }

        // 빈 칸인 경우
        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                // 규칙에 맞는 숫자 탐색
                if (isValid(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1); // 다음 열로 이동
                }
            }
            // 맞는 숫자가 없다면 백트래킹
            board[row][col] = 0;
            return;
        }

        // 빈 칸이 아니라면 다음 열로 바로 이동
        dfs(row, col + 1);
    }

    static boolean isValid(int row, int col, int value) {
        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // 3x3 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}