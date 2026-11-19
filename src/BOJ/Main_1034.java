package BOJ;

/*
예제 입력 1 
3 2
01
10
10
1
예제 출력 1 
2

예제 입력 2 
1 6
101010
2
예제 출력 2 
0

예제 입력 3 
2 2
00
11
999
예제 출력 3 
0

예제 입력 4 
5 1
0
1
0
1
0
1000
예제 출력 4 
2

예제 입력 5 
14 3
001
101
001
000
111
001
101
111
110
000
111
010
110
001
6
예제 출력 5 
4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1034 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int[] zero = new int[N];
      String[] row = new String[N];
      
      for (int i = 0; i < N; i++) {
         String str = br.readLine();
         
         for (int j = 0; j < M; j++) {
            if(str.charAt(j) == '0') {
               zero[i]++;
            }
         }

         row[i] = str;
       }
      
      int K = Integer.parseInt(br.readLine());
      int max = 0;
      
      for (int i = 0; i < N; i++) {
         if( zero[i] <= K && (K - zero[i]) % 2 == 0 ) {
            
            int dupl = 1;
            
            for (int j = 0; j < N; j++) {
               if(i==j) continue;
               
               if( row[i].equals(row[j]) ) {
                  dupl++;
               }
            }
            max = Integer.max(max, dupl);
         }
      }
      
      System.out.println(max);
   }
}
