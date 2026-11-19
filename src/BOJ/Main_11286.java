package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            // 절댓값이 같은 경우 음수가 앞에 오도록 오름차순 정렬
            if (abs1 == abs2) {
                return Integer.compare(o1, o2);
            }
            // 절댓값이 다른 경우 절댓값을 기준으로 오름차순 정렬
            return Integer.compare(abs1, abs2);
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 배열이 비어있는데 0이 들어오면 0 출력
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    // 가장 우선순위가 높은 값을 출력하고 큐에서 제거
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                // x가 0이 아니라면 큐에 추가
                pq.add(x);
            }
        }

        System.out.print(sb.toString());
    }
}