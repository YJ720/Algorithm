package BOJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("res/7785.txt"));
        
        int n = Integer.parseInt(br.readLine());
        HashSet<String> inOffice = new HashSet<>();
        
        // "enter" 는 저장하고 아니면 제거 
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String name = st.nextToken();
        	String action = st.nextToken();
        	
        	if(action.equals("enter")) {
        		inOffice.add(name);
        	}else {
        		inOffice.remove(name);
        	}
		}
        
        // 사전 역순 정렬
        ArrayList<String> result = new ArrayList<>(inOffice);
        Collections.sort(result, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder(n*5);
        for (String name : result) {
			sb.append(name).append("\n");
		}
        System.out.println(sb.toString());
    }
}