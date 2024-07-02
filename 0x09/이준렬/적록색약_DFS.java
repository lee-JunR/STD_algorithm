//적록색약 DFS 10026

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class boj_10026 {

  static char[][] board;
  static boolean[][] visited;
  static int n;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    board = new char[n][n];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        board[i][j] = line.charAt(j);
      }
    }

    int normalCount = countAreas(false);
    int blindCount = countAreas(true);

    System.out.println(normalCount + " " + blindCount);
    br.close();
  }

  private static int countAreas(boolean isBlind) {
    int count = 0;
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          DFS(i, j, board[i][j], isBlind);
          count++;
        }
      }
    }
    return count;
  }

  private static void DFS(int x, int y, char color, boolean isBlind) {
    Deque<int[]> stack = new LinkedList<>();
    visited[x][y] = true;
    stack.push(new int[]{x, y});

    while (!stack.isEmpty()) {
      int[] current = stack.pop();
      int cx = current[0];
      int cy = current[1];

      for (int d = 0; d < 4; d++) {
        int nx = cx + dx[d];
        int ny = cy + dy[d];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
          continue;
        }

        if (!visited[nx][ny]) {
          if (isBlind) {
            if ((color == 'R' || color == 'G') && (board[nx][ny] == 'R' || board[nx][ny] == 'G')) {
              visited[nx][ny] = true;
              stack.push(new int[]{nx, ny});
            } else if (color == 'B' && board[nx][ny] == 'B') {
              visited[nx][ny] = true;
              stack.push(new int[]{nx, ny});
            }
          } else {
            if (board[nx][ny] == color) {
              visited[nx][ny] = true;
              stack.push(new int[]{nx, ny});
            }
          }
        }
      }
    }
  }
}
