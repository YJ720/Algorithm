package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수빈
        int k = sc.nextInt(); // 동생
        
        if (n == k) {
            System.out.println(0);
            return;
        }
        
        int[] time = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(n);
        time[n] = 1;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            // 이동할 수 있는 3가지 경우의 수
            int[] nextPos = {cur - 1, cur + 1, cur * 2};
            
            for (int next : nextPos) {
                // 찾은 경우
                if (next == k) {
                    System.out.println(time[cur]); // 누적된 걸린 시간
                    return;
                }
                
                // 이동할 위치가 범위 내에 있고, 아직 방문하지 않은 경우
                if (next >= 0 && next <= 100000 && time[next] == 0) {
                    time[next] = time[cur] + 1; // 시간 누적
                    queue.add(next);
                }
            }
        }
    }
}