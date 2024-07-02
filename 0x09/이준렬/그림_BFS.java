// 그림 1926 BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1926 {

  static int n;
  static int m;
  static int[][] board;
  static boolean[][] vis;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1}; // 상하좌우 네 방향을 의미

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    m = Integer.parseInt(input[1]);
    int biggestArea = 0;
    int countOfArea = 0;

    // board, vis 초기화
    board = new int[n][m];
    vis = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      String[] inputArr = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(inputArr[j]);
      }
    }

    // 각 노드를 순회하면서 진행.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 1 && vis[i][j] != true) { // 이미 방문한 노드 체크
          biggestArea = Math.max(biggestArea, BFS(i, j));
          countOfArea++;
        }
      }
    }

    System.out.println(countOfArea);
    System.out.println(biggestArea);

    br.close();
  }

  private static int BFS(int x, int y) {
    // bfs 시작
    Queue<int[]> Q = new LinkedList<>(); // 행렬을 그대로 넣어야 하므로 int[] 로 초기화
    vis[x][y] = true;
    Q.offer(new int[]{x, y}); // 큐에 시작점인 (x, y)을 삽입.
    int count = 1;

    while (!Q.isEmpty()) {
      int[] cur = Q.poll(); // 현재 값 큐에서 꺼내서
      int curX = cur[0];
      int curY = cur[1];

      for (int dir = 0; dir < 4; dir++) { // 상하좌우 칸을 살펴보기.
        int nx = curX + dx[dir];
        int ny = curY + dy[dir]; // nx, ny에 dir에서 정한 방향의 인접한 칸의 좌표가 들어감

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue; // 범위 밖일 경우 넘어감
        }
        if (vis[nx][ny] || board[nx][ny] != 1) {
          continue; // 이미 방문한 칸이거나 파란 칸이 아닐 경우
        }
        count++;
        vis[nx][ny] = true; // (nx, ny)를 방문했다고 명시
        Q.offer(new int[]{nx, ny});
      }
    }
    return count;
  }
}
