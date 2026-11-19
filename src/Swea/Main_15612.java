package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15612 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int[] rowCnt = new int[8];
            int[] colCnt = new int[8];

            for (int i = 0; i < 8; i++) {
                String line = br.readLine();
                for (int j = 0; j < 8; j++) {
                    if (line.charAt(j) == 'O') {
                        rowCnt[i]++;
                        colCnt[j]++;
                    }
                }
            }
            
            boolean ok = true;
            for (int k = 0; k < 8; k++) {
                if (rowCnt[k] != 1 || colCnt[k] != 1) {
                	ok = false;
                	break;
                }
            }
			
			System.out.println("#" + t + " " + (ok ? "yes" : "no"));
			
		}
	}
}
