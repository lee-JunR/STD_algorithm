package test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ox14_Q1_1 {
  static int count = 0;
  static int [] money;
  // 백준 11047 동전0 S4
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // n, k 받기
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    money = new int [n];
    // n개 오름차순 값 받기
    for(int i = 0; i<n; i++) {
      money[i] = Integer.parseInt(br.readLine());
    }

    for( int i = 0; i<n; i++) {
      boolean check = true;
      // 동전 받은 n개 중, 가장 큰 값부터 작은 값 순으로 비교
      while(check) {
        // 만약 현재 남은 잔액보다 money배열의 값이 작은경우 반복해서 해당 값 제거
        if(money[n-i-1] <= k) {
          k -= money[n-i-1];
          count++;
        }else {
          check = false;
        }
      }
    }// for fin
    System.out.println(count);
  }
}
