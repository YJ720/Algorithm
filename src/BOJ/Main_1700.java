package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1700 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] uses = new int[K];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            uses[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> holes = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < K; i++) {
            int cur = uses[i];

            if (holes.contains(cur)) {
                // 이미 꽂혀있으면 아무것도 안 함
                continue;
            }

            if (holes.size() < N) {
                // 빈 자리가 있으면 그냥 꽂음
                holes.add(cur);
            } else {
                // 빈 자리가 없으면, 뺄 대상을 찾아야 함
                int remove = -1;
                int far = -1;

                for (int j = 0; j < holes.size(); j++) {
                    int plug = holes.get(j);
                    int next = Integer.MAX_VALUE;

                    for (int k = i + 1; k < K; k++) {
                        if (uses[k] == plug) {
                            next = k;
                            break;
                        }
                    }

                    if (next > far) {
                        far = next;
                        remove = j;
                    }
                }

                holes.remove(remove);
                holes.add(cur);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
