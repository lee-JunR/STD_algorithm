package test13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ox13_Q4_2 {
  // 백준 1699 S2
  public static void main(String [] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = maxRoot(n);

    System.out.println(count);

  }

  // 계산하기
  public static int maxRoot(int n) {
    int dp [] = new int [n+1]; // 0부터 n까지 사용하기 위함
    Arrays.fill(dp, Integer.MAX_VALUE); // 초기에 제일 큰 값 세팅해서 최소 값 비교에 용이하게함
    dp[0] = 0;

    for(int i = 1; i<=n; i++) {
      for(int j = 1; j*j<=i; j++ ) {
        dp[i] = Math.min(dp[i], dp[i - j*j] +1 );
      }
    }// for fin

    return dp[n];
  }// maxRoot fin
}
