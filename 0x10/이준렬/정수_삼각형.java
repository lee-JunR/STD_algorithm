package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 정수 삼각형 1932

public class boj_1932 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Integer.parseInt(line[j]);
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j != 0 && j != i) {
          dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
        } else if (j == 0) {
          dp[i][j] += dp[i - 1][j];
        } else if (j == i) {
          dp[i][j] += dp[i - 1][j - 1];
        }
      }
    }

    int maxSum = 0;
    for (int j = 0; j < n; j++) {
      if (dp[n - 1][j] > maxSum) {
        maxSum = dp[n - 1][j];
      }
    }
    System.out.println(maxSum);
    br.close();
  }
}
