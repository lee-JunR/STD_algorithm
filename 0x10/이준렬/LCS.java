package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class boj_9251 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str1 = br.readLine();
    String str2 = br.readLine();
    List<int[]> pairs = new ArrayList<>();

    for (int i = 0; i < str1.length(); i++) {
      for (int j = 0; j < str2.length(); j++) {
        if (str1.charAt(i) == str2.charAt(j)) {
          pairs.add(new int[]{i, j});
        }
      }
    }

    int lisLength = findLIS(pairs);
    System.out.println(lisLength);
    br.close();
  }
  private static int findLIS(List<int[]> pairs) {
    int n = pairs.size();
    int[] dp = new int[n];
    int maxLength = 0;

    for (int i = 0; i < n; i++) {
      dp[i] = 1; // 각 쌍은 최소 길이 1의 부분 수열이 된다
      for (int j = 0; j < i; j++) {
        if (pairs.get(j)[0] < pairs.get(i)[0] && pairs.get(j)[1] < pairs.get(i)[1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }

    return maxLength;
  }
}
