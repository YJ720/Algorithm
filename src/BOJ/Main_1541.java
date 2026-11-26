package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541 {

    public static int sum(String part){
        int total = 0;
        for (String num : part.split("\\+")){
            total += Integer.parseInt(num);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split("-");

        int ans = sum(parts[0]);

        for (int i = 1; i < parts.length ; i++) {
            ans -= sum(parts[i]);
        }

        System.out.println(ans);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = br.readLine();
//
//        String[] subPart = s.split("-");
//
//        int ans = 0;
//
//        if(subPart.length == 1){
//            String[] plusPart = s.split("\\+");
//
//            for (int i = 0; i < plusPart.length; i++) {
//                ans += Integer.parseInt(plusPart[i]);
//            }
//
//            System.out.println(ans);
//            return;
//        }
//
//        int plusNum = 0;
//
//        String[] plusPart = subPart[0].split("\\+");
//        for (int i = 0; i < plusPart.length; i++) {
//            plusNum += Integer.parseInt(plusPart[i]);
//        }
//
//        int num = plusNum;
//
//        for (int i = 1; i < subPart.length; i++) {
//            plusNum = 0;
//
//            plusPart = subPart[i].split("\\+");
//
//            for (int j = 0; j < plusPart.length; j++) {
//                plusNum += Integer.parseInt(plusPart[j]);
//            }
//
//            num -= plusNum;
//        }
//
//        System.out.println(num);
//    }
}
