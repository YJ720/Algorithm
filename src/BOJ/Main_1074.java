package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
	static int r, c;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		zSearch(0, 0, 1<<N);
	}
	
	public static void zSearch(int rKey, int cKey, int size) {		
		if(size == 1) {
			System.out.println(cnt);
			return;
		}
		
		size = size>>1;
		
		if(r < rKey + size) { 
		    if(c < cKey + size) { // 좌상
		        zSearch(rKey, cKey, size);
		    } else { // 우상
		        cnt += size * size;
		        zSearch(rKey, cKey + size, size);
		    }
		} else { 
		    if(c < cKey + size) { // 좌하
		        cnt += 2 * size * size;
		        zSearch(rKey + size, cKey, size);
		    } else { // 우하
		        cnt += 3 * size * size;
		        zSearch(rKey + size, cKey + size, size);
		    }
		}
	}
}
