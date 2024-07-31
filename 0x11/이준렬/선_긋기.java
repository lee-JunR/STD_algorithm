package 그리디;

// 선 긋기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 그냥 구하면 되는거 아닌가? 이게 왜 그리디지?
// x,y 좌표계가 아니라 한 1차원 좌표계에서 x부터 y 까지의 길이임. (x1, x2 라는 변수로 해주지.. 너무해)
// 그러면 겹쳐진 좌표를 체킹하는 알고리즘이 가장 중요한 알고리즘이 된다.
// 1,3 과 2,5의 겹쳐진 부분을 어떻게 체킹할 것인가?
// -> end = Math.max(end, current.y);
// + 정렬한 후 진행해야 될듯. 그러면 뒷쪽은 체크 안해도 되니깐

public class boj_2170 {
  static List<Point> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    list = new ArrayList<>(); // 몇개가 들어올지 모르기 때문에 ArrayList 로 초기화함

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      Point points = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      list.add(points);
    }

    // 리스트 정렬
    Collections.sort(list, new Comparator<Point>() {
      @Override
      public int compare(Point p1, Point p2) {
        if (p1.x == p2.x) {
          return p1.y - p2.y;
        }
        return p1.x - p2.x;
      }
    });

    int totalLength = 0;
    int start = list.get(0).x;
    int end = list.get(0).y;

    for (int i = 1; i < list.size(); i++) {
      Point current = list.get(i);

      if (current.x <= end) {
        end = Math.max(end, current.y);
      } else {
        totalLength += end - start;
        start = current.x;
        end = current.y;
      }
    }

    totalLength += end - start;
    System.out.println(totalLength);

    br.close();
  }

  private static class Point {
    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}