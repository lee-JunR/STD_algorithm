package 그리디;

// ATM

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ATM 앞에 n명의 사람들이 줄을 섰음. 1~n 번까지 번호, i번째 사람이 돈을 인출하는데 Pi 분이 걸림.
// 뭔가 스케줄링 알고리즘 같당
// 시간의 합을 최소로 만드는 프로그램을 작성
public class boj_11399 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] personTime = new int[n];

    for (int i = 0; i < n; i++) {
      personTime[i] = Integer.parseInt(st.nextToken());
    }

    // 3, 1, 4, 3, 2
    // 0번사람 3분만에 3분
    // 1번사람 1분만에 3+1분
    // 2번사람 4분만에 3+1+4분
    // 3번사람 3분만에 3+1+4+3분
    // 4번사람 2분만에 3+1+4+3+2분
    // 총 39분

    // 뒤에 있을 수록 큰 수가 있는 것이 유리할듯? 왜냐하면 i번째 사람이 걸리는 시간은 n-i 번 더해지기 때문이다.
    // 한번 해보자

    // 1, 2, 3, 3, 4
    // 0번사람 1분만에 1분
    // 1번사람 2분만에 1+2분
    // 2번사람 3분만에 1+2+3분
    // 3번사람 3분만에 1+2+3+3분
    // 4번사람 4분만에 1+2+3+3+4분
    // 총 32분

    Arrays.sort(personTime);

    int result = 0;
    for (int i = 0; i < n; i++) {
      result += personTime[i] * (n-i);
    }
    System.out.println(result);

    br.close();
  }
}
