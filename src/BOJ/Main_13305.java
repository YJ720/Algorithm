package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
예제 입력 1
5
2 3 1 1
5 2 4 4 1
예제 출력 1
20

최저가 갱신하면서
최저가 * 길이 추가
 */

public class Main_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long min = Long.MAX_VALUE;
        long cost = 0;
        for (int i = 0; i < N-1; i++) {
            min = Math.min(min, Integer.parseInt(st.nextToken()));
            cost += dist[i] * min;
        }

        System.out.println(cost);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[][] graph = new int[N-1][2]; // {거리, 가격}
//
//        for (int i = 0; i < 2; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N-1; j++) {
//                graph[j][i] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int min = graph[0][1];
//        long price = (long) min * graph[0][0];
//
//        for (int i = 1; i < N-1; i++) {
//            if(min >= graph[i][1]){
//                min = graph[i][1];
//            }
//            price += (long) min * graph[i][0];
//        }
//
//        System.out.println(price);
//    }
}
