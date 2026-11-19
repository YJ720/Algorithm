package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
123 ~ 987 숫자 완탐
 */

public class Main_2503 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      int ans = 0;
      
      int[] arr = new int[988];
      
      for (int i = 123; i < 988; i++) {
         String str = Integer.toString(i);
         if(str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2) || 
               str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
            arr[i] = -1;
         }
      }
      
      int N = Integer.parseInt(br.readLine());
      String num;
      int s, b;
      
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         num = st.nextToken();
         s = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());
         
         for (int j = 123; j < 988; j++) {
            if(arr[j] == -1) {
               continue;
            }
            
            String str = Integer.toString(j);
            
            int sCnt = 0;
            int bCnt = 0;
            
            for (int k = 0; k < 3; k++) {
               if(num.charAt(k) == str.charAt(k)) {
                  sCnt++;
               }
            }
            
            for (int k = 0; k < 3; k++) {
               for (int k2 = 0; k2 < 3; k2++) {
                  if((num.charAt(k) == str.charAt(k2)) && (k != k2)) {
                     bCnt++;
                  }
               }
            }

            if(s != sCnt || b != bCnt) {
               arr[j] = -1;
               continue;
            }
            
            if(s == sCnt && b == bCnt) {
               arr[j]++;
            }
         }
      }
      
      for (int i = 123; i < 988; i++) {
         if(arr[i] != -1 && arr[i] == N) {
            ans++;
         }
      }
      
      System.out.println(ans);
   }
}
