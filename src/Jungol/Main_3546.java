package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3546 {
    static int R, C;
    static char[][] Map;
    static boolean[][] isTarget;
    static int pr, pc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Map = new char[R][C];
        isTarget = new boolean[R][C]; // 목표점 위치를 기억할 배열

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = line.charAt(j);
                Map[i][j] = ch;
                
                if (ch == '+' || ch == 'B' || ch == 'W') {
                    isTarget[i][j] = true;
                }
                
                if (ch == 'w' || ch == 'W') {
                    pr = i;
                    pc = j;
                }
            }
        }

        // 이동 명령어 입력
        String commands = br.readLine();
        if (commands != null) {
            commands = commands.trim();
        } else {
            commands = "";
        }

        boolean isFinished = false;

        // 시뮬
        for (int i = 0; i < commands.length(); i++) {
            char cmd = commands.charAt(i);
            int dr = 0, dc = 0;
            
            // 방향
            if (cmd == 'U') dr = -1;
            else if (cmd == 'D') dr = 1;
            else if (cmd == 'L') dc = -1;
            else if (cmd == 'R') dc = 1;

            int nr = pr + dr;
            int nc = pc + dc;

            char nextCell = Map[nr][nc];

            // 이동할 칸이 빈 공간이거나 목표점인 경우 - 캐릭터만 이동
            if (nextCell == '.' || nextCell == '+') {
                move(pr, pc, nr, nc);
            } 
            // 이동할 칸에 박스가 있는 경우 - 박스를 밀 수 있는지 확인
            else if (nextCell == 'b' || nextCell == 'B') {
                int nnr = nr + dr;
                int nnc = nc + dc;
                char nextNextCell = Map[nnr][nnc];
                
                // 박스가 밀려날 칸이 빈 공간이거나 목표점이면 이동
                if (nextNextCell == '.' || nextNextCell == '+') {
                    pushAndMove(pr, pc, nr, nc, nnr, nnc);
                }
            }

            // 게임 종료 조건 확인
            if (check()) {
                isFinished = true;
                break;
            }
        }


        if (isFinished) {
            System.out.println("complete");
        } else {
            System.out.println("incomplete");
        }

        for (int i = 0; i < R; i++) {
            System.out.println(new String(Map[i]));
        }
    }

    // 캐릭터만 이동
    static void move(int r, int c, int nr, int nc) {
        // 기존 위치 복구
        Map[r][c] = isTarget[r][c] ? '+' : '.';
        // 새 위치 갱신
        Map[nr][nc] = isTarget[nr][nc] ? 'W' : 'w';
        pr = nr;
        pc = nc;
    }

    // 박스를 밀고 이동
    static void pushAndMove(int r, int c, int nr, int nc, int nnr, int nnc) {
        // 박스 새 위치 갱신
        Map[nnr][nnc] = isTarget[nnr][nnc] ? 'B' : 'b';
        // 캐릭터 새 위치 갱신
        Map[nr][nc] = isTarget[nr][nc] ? 'W' : 'w';
        // 캐릭터 기존 위치 복구
        Map[r][c] = isTarget[r][c] ? '+' : '.';
        pr = nr;
        pc = nc;
    }

    // 모든 박스가 목표점에 있는지 확인
    static boolean check() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (Map[i][j] == 'b') {
                    return false; // 목표점에 없는 박스가 하나라도 있으면 미완료
                }
            }
        }
        return true;
    }
}
