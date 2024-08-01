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

public class Ox13_Q5_1 {

  static char [] char1;
  static char [] char2;

  // 백준 9251 G5
  public static void main(String [] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 받은 문자열들 각각 단어배열로 변경
    char1 = br.readLine().toCharArray();
    char2 = br.readLine().toCharArray();

    // 공집합 생각해서 비교하는 판 1씩 크기 증가
    int [][] dp = new int[char1.length +1 ][char2.length+1];


    // 0은 공집합이니 넘기고 1부터 진행
    for(int i = 1; i<=char1.length; i++) {
      for(int j = 1; j<=char2.length; j++) {
        // 같은 경우 +1
        if(char1[i-1]==char2[j-1]) {
          dp[i][j] = dp[i-1][j-1] + 1;
        }
        // 다른경우 (이전 행 or 이전 열) + 1
        else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }// for fin
    }// for fin

    // 제일 마지막 값 출력
    System.out.println(dp[char1.length][char2.length]);
  }
}
