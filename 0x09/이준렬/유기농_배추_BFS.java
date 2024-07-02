// 유기농 배추 1012 BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_1012 {

  static int n;
  static int m;
  static int[][] board;
  static boolean[][] vis;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    for (int t = 0; t < tc; t++) {
      String[] input = br.readLine().split(" ");
      m = Integer.parseInt(input[0]); // 가로 길이
      n = Integer.parseInt(input[1]); // 세로 길이
      int k = Integer.parseInt(input[2]); // 배추가 심어져 있는 위치의 개수
      int result = 0;

      //board 초기화
      board = new int[n][m];
      vis = new boolean[n][m];
      initializeBoard(k, br);

      //bfs 진행
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (vis[i][j] != true && board[i][j] == 1) {
            BFS(i, j);
            result++;
          }
        }
      }
      System.out.println(result);

    }

    br.close();
  }


  private static void initializeBoard(int k, BufferedReader br) throws IOException {
    String[] input;
    // board의 모든 위치 0으로 초기화
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        board[i][j] = 0;
      }
    }

    // board에 X,Y 위치 초기화
    for (int i = 0; i < k; i++) {
      input = br.readLine().split(" "); // 배추의 위치 X,Y 입력 초기화
      board[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
    }
  }

  private static void BFS(int i, int j) {
    Queue<int[]> que = new LinkedList<>();
    int[] dirX = {1, 0, -1, 0};
    int[] dirY = {0, 1, 0, -1};
    int count = 1;
    vis[i][j] = true;
    que.offer(new int[]{i, j});

    while (!que.isEmpty()) {
      int[] cur = que.poll();
      int curX = cur[0];
      int curY = cur[1];
      for (int dir = 0; dir < 4; dir++) {
        int nx = curX + dirX[dir];
        int ny = curY + dirY[dir];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }
        if (vis[nx][ny] || board[nx][ny] != 1) {
          continue;
        }
        count++;
        vis[nx][ny] = true;
        que.offer(new int[]{nx, ny});
      }
    }


  }

}
