package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_26793 {
    static class Task implements Comparable<Task> {
        long d, t;
        
        public Task(long d, long t) {
            this.d = d;
            this.t = t;
        }
        
        @Override
        public int compareTo(Task o) {
            return Long.compare(this.t, o.t);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int Te = Integer.parseInt(br.readLine());
        for (int t = 1; t <= Te; t++) {
            int N = Integer.parseInt(br.readLine());
            
            Task[] task = new Task[N];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                long D = Long.parseLong(st.nextToken());
                long T = Long.parseLong(st.nextToken());
                task[i] = new Task(D, T);
            }
            
            Arrays.sort(task);
            
            long min = Long.MAX_VALUE;
            long Dsum = 0;
            
            for (int i = 0; i < N; i++) {
                Dsum += task[i].d;
                
                long dist = task[i].t - Dsum;
                
                if (min > dist) {
                    min = dist;
                }
            }
            System.out.println(min);
        }
    }
}