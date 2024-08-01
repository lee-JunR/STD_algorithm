package test14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Ox14_Q3_1 {
  // 백준 2457 G3
  public static void main(String[] args) throws IOException {
    // 값 입력 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;

    List<Day> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int strtMon = Integer.parseInt(st.nextToken());
      int strtDay = Integer.parseInt(st.nextToken());
      int endMon = Integer.parseInt(st.nextToken());
      int endDay = Integer.parseInt(st.nextToken());

      int startDate = strtMon * 100 + strtDay;
      int endDate = endMon * 100 + endDay;

      list.add(new Day(startDate, endDate));
    } // for fin

    // 변환 된 list 정해놓은 순서대로 정렬
    list.sort(new DayComparator());

    int firstDay = 301; // 3월 1일
    int endDay = 1201;  // 12월 1일
    int maxEnd = 0;	// 현재 꽃의 지는 날짜
    int result = 0;

    // 꽃이 피어있는 기간 체크
    while (firstDay < endDay) {
      boolean found = false; // 새로운 꽃 여부 체크
      for (int i = 0; i < list.size(); i++) {
        Day day = list.get(i);
        // firstDay = 꽃이 피어있는 시작 날짜.
        // 즉 현재 심을 꽃이 firstDay보다 크면 문제가 있는 것이므로 새 꽃 받음
        if (day.startDate > firstDay) {
          break;
        }
        // 현재 지정한 꽃이 피어있는 기간 체크, 다음 꽃 여부 지정
        if (day.endDate > maxEnd) {
          maxEnd = day.endDate;
          found = true;
        }
      }
      // 만약 새 꽃이 갱신이 안됐는데, false => 전체 기간 만족 되는 꽃 X
      if (!found) {
        result = 0;
        break;
      }
      // 현재 피어있는 꽃의 시작점 재 지정
      firstDay = maxEnd;
      result++;

      // 12월 1일 이후로 피는 꽃은 체크할 필요 없으므로 종료
      if (firstDay >= endDay) {
        break;
      }
    }
    // while문을 다 돌아도 종료일자 커버x -> 만족되는 꽃 X
    if (firstDay < endDay) {
      result = 0;
    }

    System.out.println(result);
  } // main fin
}

class Day {
  int startDate;
  int endDate;

  Day(int startDate, int endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }
}

// 클래스 객체의 우선순위를 위한 클래스
class DayComparator implements Comparator<Day> {
  @Override
  public int compare(Day d1, Day d2) {
    // 시작 날짜 같은 경우, 종료 날짜가 긴 것이 앞에 오게끔
    if (d1.startDate == d2.startDate) {
      return d2.endDate - d1.endDate;
    } else {
      // 시작 날짜 다른 경우 시작 날짜가 빠른 것부터 앞에 오게끔
      return d1.startDate - d2.startDate;
    }
  }
}
