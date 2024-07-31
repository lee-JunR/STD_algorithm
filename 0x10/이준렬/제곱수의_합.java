import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 제곱수의 합 1699

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      int j = 1;
      while (j * j <= i) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        j++;
      }
    }
    System.out.println(dp[n]);
    br.close();
  }
}
