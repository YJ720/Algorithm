package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1726 {

	static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new int[n * 4];
        init(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            sb.append(query(1, 1, n, left, right)).append("\n");
        }
        
        System.out.print(sb);
    }

    static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = Math.max(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
    }

    static int query(int node, int start, int end, int left, int right) {

    	if (left > end || right < start) {
            return 0;
        }
    	
        if (left <= start && end <= right) {
            return tree[node];
        }
        
        int mid = (start + end) / 2;
        return Math.max(query(node * 2, start, mid, left, right), query(node * 2 + 1, mid + 1, end, left, right));
    }
}
