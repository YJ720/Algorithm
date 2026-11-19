package Programmers;

/*
0인 경우에는 자동차가 자유롭게 지나갈 수 있다.
1인 경우에는 자동차 통행이 금지되어 지나갈 수 없다.
2인 경우는 보행자 안전을 위해 좌회전이나 우회전이 금지된다. (왼쪽에서 오던 차는 오른쪽으로만, 위에서 오던 차는 아래쪽으로만 진행 가능하다)

0 2 0 0 0 2
0 0 2 0 1 0
1 0 0 2 2 0
 */

public class Main_1832 {

   class Solution {
       int MOD = 20170805;
       public int solution(int m, int n, int[][] cityMap) {
           int[][][] memo = new int[2][m+1][n+1];
           
           // [방향][x][y], 0: 오른쪽, 1: 아래
           memo[0][0][0] = 1;
           
           for (int i = 0; i < m; i++) {
              for (int j = 0; j < n; j++) {
               
                 if(cityMap[i][j] == 0) {
                    memo[0][i+1][j] = (memo[0][i+1][j] + memo[0][i][j] + memo[1][i][j]) % MOD;
                    memo[1][i][j+1] = (memo[1][i][j+1] + memo[0][i][j] + memo[1][i][j]) % MOD;
                 }else if(cityMap[i][j] == 2) {
                    memo[0][i+1][j] = (memo[0][i+1][j] + memo[0][i][j]) % MOD;
                    memo[1][i][j+1] = (memo[1][i][j+1] + memo[1][i][j]) % MOD;
                 }
            }
         }
           
           return (memo[0][m-1][n-1] + memo[1][m-1][n-1]) % MOD;
       }
   }
}
