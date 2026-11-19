package Programmers;

public class Main_133499 {

   class Solution {
       public int solution(String[] babbling) {
          String[] can = {"aya", "ye", "woo", "ma"};
          String[] cant = {"ayaaya", "yeye", "woowoo", "mama"};
          
           int ans = 0;
          
          for (String element : babbling) {
             
             int cnt = 1;
            
             for (String str : cant) {
               element = element.replace(str, "X");
            }
             
             for (String str : can) {
                element = element.replace(str, "O");
            }
             
             for (int i = 0; i < element.length(); i++) {
               if(element.charAt(i) != 'O') {
                  cnt = 0;
               }
            }
            ans += cnt;
         }

           return ans;
       }
   }
}
