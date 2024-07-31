package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 선긋기랑 비슷한 메커니즘
public class boj_2457 {
  static List<Flower> flowers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    flowers = new ArrayList<>(); // 몇 개가 들어올지 모르기 때문에 ArrayList로 초기화함

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int startMonth = Integer.parseInt(st.nextToken());
      int startDay = Integer.parseInt(st.nextToken());
      int endMonth = Integer.parseInt(st.nextToken());
      int endDay = Integer.parseInt(st.nextToken());
      flowers.add(new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay));
    }

    // 리스트 정렬
    Collections.sort(flowers, new Comparator<Flower>() {
      @Override
      public int compare(Flower f1, Flower f2) {
        if (f1.start == f2.start) {
          return f2.end - f1.end;
        }
        return f1.start - f2.start;
      }
    });

    int count = 0;
    int currentEnd = 301; // 3월 1일을 301로 표현
    int targetEnd = 1130; // 11월 30일을 1130로 표현
    int idx = 0;

    while (currentEnd <= targetEnd) {
      int nextEnd = currentEnd;
      while (idx < flowers.size() && flowers.get(idx).start <= currentEnd) {
        nextEnd = Math.max(nextEnd, flowers.get(idx).end);
        idx++;
      }

      if (nextEnd == currentEnd) { // 더 이상 연장할 수 없는 경우
        System.out.println(0);
        return;
      }

      count++;
      currentEnd = nextEnd;
    }

    System.out.println(count);
    br.close();
  }

  private static class Flower {
    int start;
    int end;

    public Flower(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
