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

public class Ox13_Q3_3 {
  static int n;
  static long maxNum[];
  // 백준 1932 S1
  public static void main(String [] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ;

    n = Integer.parseInt(br.readLine());
    int checknum = checknum(n);
    List<Integer> arrList = new ArrayList<>();
    maxNum = new long[checknum];

    int dept = 2;
    // 값 받기
    for(int i = 0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j<=i; j++) {
        arrList.add(Integer.parseInt(st.nextToken()));
      }
    }

    calc(dept,checknum,arrList);
  }

  // 총 공간 체크
  public static int checknum(int n) {
    int sum = 0;
    for(int i=1 ; i<=n; i++) {
      sum+= i;
    }
    return sum;
  }
  public static void calc(int dept, int checknum, List<Integer> arrList) {
    maxNum[0] = (long) arrList.get(0);	// 첫 번째 값 세팅
    int cnt = 1;
    for(int i = 1; i<n; i++) { // n개의 층
      for(int j = 0; j<dept; j++) {
        // 계속 작은 삼각형을 그리면서 비교하는 방식으로 이해하면 편하다.
        if(j == 0) { // 삼각형의 왼쪽이 해당 행에서 첫 번째인 경우, 가운데 값 + 현재값
          maxNum[cnt] = maxNum[cnt-dept+1] + arrList.get(cnt);
        }else if(j == dept-1) {// 삼각형의 오른쪽이 해당 행에서 마지막인 경우, 가운데 값 + 현재값
          maxNum[cnt] = maxNum[cnt-dept] + arrList.get(cnt);
        }
        else {// 현재값 기준 11시방향, 1시방향 값 서로 비교
          maxNum[cnt]
              = Math.max( maxNum[cnt-dept] + arrList.get(cnt),  maxNum[cnt-dept+1] + arrList.get(cnt));
        }
        cnt++;
      }
      dept++;
    }// for fin
    // 경우에 따라 int의 한계치를 넘을 수도 있으므로 long으로 세팅
    long max = Arrays.stream(maxNum).max().getAsLong();
    System.out.println(max);
  }// calc fin
}
