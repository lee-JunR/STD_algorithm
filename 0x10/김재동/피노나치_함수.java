package test13;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ox13_Q2_1 {
  static int [] zeroArr, oneArr ;
  // 백준 1003 S3
  public static void main(String [] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    zeroArr= new int [41]; // n의 최대가 40이므로 +1
    oneArr = new int [41];

    // n개의 테스트 케이스 실행
    for(int i =0; i<n; i++) {
      int temp = Integer.parseInt(br.readLine());
      fibonacci(); // 모든 경우의 수 미리 계산
      // 해당 경우의 수 출력
      sb.append(zeroArr[temp] + " " + oneArr[temp] + "\n");
    } // for fin

    System.out.println(sb.toString().trim());
  }
  // 모든 경우의 수 미리 구해두기
  public  static void fibonacci() {
    zeroArr[0] = 1;
    oneArr[0] = 0;
    zeroArr[1] = 0;
    oneArr[1] = 1;

    for(int i = 2; i<=40; i++) {
      zeroArr[i] = zeroArr[i-1] + zeroArr[i-2];
      oneArr[i] = oneArr[i-1] + oneArr[i-2];
    }
  }
}
