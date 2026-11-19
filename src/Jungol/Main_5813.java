package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5813 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      Queue<Integer> q = new ArrayDeque<>();
      
      int min = Integer.MAX_VALUE;
      
      st = new StringTokenizer(br.readLine());
      
      for (int i = 0; i < M; i++) {
         int value = Integer.parseInt(st.nextToken());
         q.add(value);
         min = Integer.min(value, min);
         sb.append(min).append(" ");
      }
      
      for (int i = M; i < N; i++) {
         int value = Integer.parseInt(st.nextToken());
         q.add(value);
         q.poll();
         
         int poll = q.poll();
         q.add(poll);
         if( poll == min ) {
            for (int j = 0; j < M; j++) {
               value = q.poll();
               min = Integer.min(value, min);
               q.add(poll);
            }
         }
         
         min = Integer.min(value, min);
         sb.append(min).append(" ");
      }
      
      System.out.println(sb);
   }
}
