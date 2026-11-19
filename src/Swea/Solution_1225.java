package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        
        // 한 tc 동안
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] A = new int[8];
            int minVal = Integer.MAX_VALUE;

            // input 을 배열에 저장하고 최솟값 찾기
            for (int i = 0; i < 8; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                if (A[i] < minVal) {
                    minVal = A[i];
                }
            }

            // 최솟값을 기준으로 15씩 몇 번 뺄 수 있는지 계산
            int Count = (minVal / 15) - 1;
            
            Queue<Integer> queue = new ArrayDeque<>();

            // 일괄 감산 후 큐에 삽입
            for (int i = 0; i < 8; i++) {
                if (Count > 0) {
                    A[i] -= (15 * Count);
                }
                queue.offer(A[i]);
            }
           
            boolean isFinished = false;
            while (!isFinished) {
            	/*
                 * 15씩 빼고 남은 배열에 1부터 5까지 순차적으로 감산
                 * 맨 앞의 숫자를 꺼내서 i 만큼 감산
                 */
                for (int i = 1; i <= 5; i++) {
                    int current = queue.poll(); 
                    current -= i; 
                    
                    // 0보다 작아지면 맨 뒤로 보내고 종료
                    if (current <= 0) {
                        queue.offer(0); 
                        isFinished = true; 
                        break; 
                    }
                    
                    // 0보다 크면 맨 뒤로 보내고 반복
                    queue.offer(current); 
                }
            }

            System.out.print("#" + N + " ");
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
        br.close();
    }
}