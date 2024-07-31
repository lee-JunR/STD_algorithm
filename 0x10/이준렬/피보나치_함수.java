package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 피보나치 함수
public class boj_1003 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    List<ST> dp = new ArrayList<ST>();

    dp.add(0, new ST(1, 0));
    dp.add(1, new ST(0, 1));

    for (int i = 2; i < 41; i++) {
      dp.add(i, ST.plus(dp.get(i - 1), dp.get(i - 2)));
    }

//    dp.stream().forEach(i -> System.out.println(i.toString())); // 테스트

    for (int t = 0; t < tc; t++) {
      int n = Integer.parseInt(br.readLine());
      sb.append(dp.get(n).toString()).append('\n');
    }
    System.out.println(sb.toString());
    br.close();
  }

  public static class ST {

    int zeroCount;
    int oneCount;

    public ST(int zeroCount, int oneCount) {
      this.zeroCount = zeroCount;
      this.oneCount = oneCount;
    }

    static ST plus(ST st0, ST st1) {
      return new ST(st0.zeroCount + st1.zeroCount, st0.oneCount + st1.oneCount);
    }

    @Override
    public String toString() {
      return String.format("%d %d", this.zeroCount, this.oneCount);
    }
  }

}
