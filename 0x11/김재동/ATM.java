package test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ox14_Q2_1 {
  // 백준 11399 ATM S4
  public static void main(String[] args) throws IOException{
    // 값 입력 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    List<Integer> nArr = new ArrayList<Integer>();
    while(st.hasMoreTokens()) {
      nArr.add(Integer.parseInt(st.nextToken()));
    }


    // 입력받은 배열 정렬
    Collections.sort(nArr);

    long sum = 0;  // 인덱스 별로 추가될 값
    long total = 0; // 전체 누적된 시간

    // 각 배열마다 걸리는 시간 체크
    for(int i = 0; i<nArr.size(); i++) {
      sum += nArr.get(i);
      total += sum;
    }
    System.out.println(total);
  }
}
