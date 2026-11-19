package Swea;

/*
10761. 신뢰 D3

 
Master
 나는돌멩이
2,559
참여자
1,523
제출
879
정답
57.72
정답률
100
Point
Problem제출이력정답
시간 : 100개 테스트케이스를 합쳐서 C의 경우 1초 / C++의 경우 1초 / Java의 경우 2초 / Python의 경우 2초
메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
※ SW expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.
 

오렌지와 블루는 순진하고 귀여운 로봇 친구들이다.

하지만 정체불명의 인공지능 악마가 두 로봇을 서로 다른 복도에 가둬놓고, 실험을 진행하고 있다.

한 복도에는 1 이상 100 이하의 정수로 구분되는 100개의 버튼이 존재한다.

버튼 K는 복도의 시작점에서 K미터 떨어져 있다. 두 로봇은 버튼 1에서 시작한다.

매 1초마다, 로봇은 복도의 양 방향 중 하나로 1미터 걷거나, 자기 위치에 있는 버튼을 누르거나, 아무 것도 하지 않는다.
 

오렌지와 블루는 서로 다른 복도에 있음에 유의하라.
 

하나의 테스트는 여러 개의 버튼 수열로 표시되는데, 이는 로봇들이 수열에 표시된 순서대로 버튼을 눌러야 함을 뜻한다.

버튼은 O x, B x와 같은 형태로 주어지는데, O x는 오렌지가 해당 버튼을 눌러야 함을 뜻하고, B x는 블루가 해당 버튼을 눌러야 함을 뜻한다.

순서대로 버튼을 눌러야 하기 때문에, 두 로봇이 동시에 버튼을 누를 수는 없다. 두 로봇 모두 수열을 정확히 알고 있다.

악마는 테스트가 끝나면 두 로봇에게 케이크를 주기로 약속했다.

테스트를 끝낼 수 있는 가장 빠른 시간은 언제인가?

[입력]

첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.

각 테스트 케이스는 다음과 같이 구성되었다.

1. 첫 번째 정수는 테스트에서 눌러야 하는 버튼의 개수 N 이다. (1 <= N <= 100)

2. 이후 버튼 N개가 공백으로 구분되어 한 줄에 주어진다. 버튼이 “O x” 의 형태이면 오렌지가 버튼 x를 눌러야 하며, “B x”의 형태이면 블루가 버튼 x를 눌러야 한다. (1 <= x <= 100)


[출력]

각 테스트 케이스마다 최소 시간을 출력하라.

입력
3
4 B 2 O 1 O 2 B 4
3 B 5 B 8 O 100
2 O 2 O 1
 
출력
#1 6
#2 100
#3 4	

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10761 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			String robot[] = new String[N];
			int pos[] = new int[N];
			
			for (int i = 0; i < N; i++) {
				robot[i] = st.nextToken();
				pos[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] lastPos = {1, 1};
            int[] lastTime = {0, 0};

            int time = 0;

            for (int i = 0; i < N; i++) {

                int r;

                if (robot[i].equals("O")) {
                    r = 0;
                } else {
                    r = 1;
                }

                int distance = Math.abs(pos[i] - lastPos[r]);

                int freeTime = time - lastTime[r];

                int remain = Math.max(0, distance - freeTime);

                time += remain + 1;

                lastPos[r] = pos[i];
                lastTime[r] = time;
            }
			
			System.out.println("#" + t + " " + time);
		}
	}
}


























