package Swea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
#1 112097 250783
#2 250783 112097
#3 336560 26320
#4 346656 16224
 */

// 1~18 까지의 합은 171로 홀수이므로, 무승부가 발생하는 경우는 없다.
// DFS로 모든 경우의 수를 탐색한다.

public class Solution_6808 {
    
    static int[] gyuCards;      // 규영이의 카드
    static int[] inCards;       // 인영이의 카드
    static int winCount, loseCount; // 규영이의 승리, 패배 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("res/swea_6808"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            gyuCards = new int[9];
            inCards = new int[9];
            winCount = 0;
            loseCount = 0;
            
            // 1~18 카드 중 규영이가 가진 카드를 체크하기 위한 배열
            boolean[] isGyuCard = new boolean[19]; 
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 9; i++) {
                gyuCards[i] = Integer.parseInt(st.nextToken());
                isGyuCard[gyuCards[i]] = true; // 규영이가 뽑은 카드 표시
            }
            
            // 규영이가 안 뽑은 카드를 인영이의 배열에 넣음
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!isGyuCard[i]) {
                    inCards[idx++] = i;
                }
            }
            
            dfs(0, 0, 0, 0);
            
            System.out.printf("#%d %d %d\n", tc, winCount, loseCount);
        }
    }

    
    public static void dfs(int depth, int gyuScore, int inScore, int flag) {
        // 기저 조건: 9라운드까지 모두 진행됨
        if (depth == 9) {
            if (gyuScore > inScore) {
                winCount++;
            } else if (gyuScore < inScore) {
                loseCount++;
            }
            return;
        }
        
        // 인영이의 카드 9장 중 하나를 선택
        for (int i = 0; i < 9; i++) {
            if ((flag & 1<<i) != 0) continue;
            
            int gyu = gyuCards[depth]; // 규영이가 이번 라운드에 내는 카드
            int in = inCards[i];       // 인영이가 이번 라운드에 내는 카드
            int sum = gyu + in;        // 두 카드의 합
            
            // 승패에 따라 점수 누적
            if (gyu > in) {
                dfs(depth + 1, gyuScore + sum, inScore, flag | 1<<i);
            } else {
                dfs(depth + 1, gyuScore, inScore + sum, flag | 1<<i);
            }
        }
    }
}