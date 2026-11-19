package Jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Log implements Comparable<Log> {
    int id;
    int x1;
    int x2;
    int y;

    public Log(int id, int x1, int x2, int y) {
        this.id = id;
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
    }

    // x1 기준으로 오름차순 정렬 -> x1이 같으면 x2 기준으로
    @Override
    public int compareTo(Log o) {
        if (this.x1 == o.x1) {
            return Integer.compare(this.x2, o.x2);
        }
        return Integer.compare(this.x1, o.x1);
    }
}

public class Main_3431 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Log[] logs = new Log[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            logs[i] = new Log(i + 1, x1, x2, y);
        }

        Arrays.sort(logs);

        int[] group = new int[N + 1];
        
        int currentGroup = 1;
        int maxX2 = logs[0].x2;
        group[logs[0].id] = currentGroup;

        // 그룹화
        for (int i = 1; i < N; i++) {
            if (logs[i].x1 <= maxX2) {
                group[logs[i].id] = currentGroup;
                maxX2 = Math.max(maxX2, logs[i].x2);
                
            } else {
                currentGroup++;
                group[logs[i].id] = currentGroup;
                maxX2 = logs[i].x2;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        // Q 처리
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 두 통나무가 같은 그룹인가?
            if (group[u] == group[v]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}
