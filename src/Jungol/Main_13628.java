package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_13628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3]; int H = 0;

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        H = Integer.parseInt(br.readLine());

        /*
        0 a + b + c
        1 a + b
        2 a + c
        3 b + c
        4 a
        5 b
        6 c
         */

        int min = 0;

        for(int i : arr){
            min += i;
        }

        for (int bm = 0; bm < (1 << 3); bm++){
            int health = 0; int time = 0;

            for (int i = 0; i < 3; i++){
                if ((bm & (1 << i)) != 0){ // 걸어서
                    health += arr[i] / 2;
                    time += arr[i] / 2;
                }else{ // 서서
                    time += arr[i];
                }
            }

            if((health < H) && (time < min)){
                min = time;
            }
        }

        System.out.println(min);
    }
}
