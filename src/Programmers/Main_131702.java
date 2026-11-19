package Programmers;

import java.util.Arrays;

/*
	퍼즐은 시계들이 행렬을 이루는 구조물인데 하나의 시계에 시곗바늘은 하나씩만 있습니다.
	각 시곗바늘은 시계방향으로만 돌릴 수 있고 한 번의 조작으로 90도씩 돌릴 수 있습니다. 
	시계들은 기계장치에 의해 연결되어 있어 어떤 시계의 시곗바늘을 돌리면 
		그 시계의 상하좌우로 인접한 시계들의 시곗바늘도 함께 돌아갑니다. 
	행렬의 모서리에 위치한 시계의 시곗바늘을 돌리는 경우에는 
		인접한 세 시계의 시곗바늘들이 함께 돌아가며, 
		꼭짓점에 위치한 시계의 시곗바늘을 돌리는 경우에는 
		인접한 두 시계의 시곗바늘들이 함께 돌아갑니다.
		
	0 3 3 0
	3 2 2 3
	0 3 2 0
	0 3 3 3
	
	0 0 3 0
	0 3 3 3
	0 0 2 0
	0 3 3 3
	
	0 0 0 0
	0 0 0 0
	0 0 3 0
	0 3 3 3
	
	i<N i>0
	{ 1, -1, 0, 0 }
	{ 0, 0, 1, -1 }
		   j<N j>0
		   
		   
	0 3 0 0
	0 3 0 0
	0 3 0 0
	0 0 0 0
		
 */




public class Main_131702 {

	class Solution {
		static int[] dx = {0, -1, 1, 0, 0};
	    static int[] dy = {0, 0, 0, -1, 1};

	    public int solution(int[][] clockHands) {
	        int min = 200;
	        int N = clockHands.length;
	        int[][] spinMap = new int[N][N];

	        Outter : for (int spins = 0; spins < (1 << (2 * N)); spins++) {
	            Arrays.stream(spinMap).forEach(row -> Arrays.fill(row, 0));
	            int sum = 0;
	            
	            // 00 01 10 11
	            // 00 00 00 11

	            for (int row = 0; row < N; row++) {
	                for (int col = 0; col < N; col++) {
	                    int spin = row == 0 ?
	                        (spins >> (col * 2)) & 3 // 1행일 경우
	                        : (4 - ((clockHands[row - 1][col] + spinMap[row - 1][col]) & 3)) & 3; // 2행부터

	                    for (int i = 0; i < 5; i++) {
	                        int nx = row + dx[i];
	                        int ny = col + dy[i];
	                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
	                            spinMap[nx][ny] = (spinMap[nx][ny] + spin) & 3;
	                        }
	                    }

	                    sum += spin;
	                    if (sum >= min) continue Outter;
	                }
	            }

	            for (int col = 0; col < N; col++) {
	                if (((clockHands[N - 1][col] + spinMap[N - 1][col]) & 3) != 0) continue Outter;
	            }

	            min = Math.min(min, sum);
	        }

	        return min;
	    }
	}
}
