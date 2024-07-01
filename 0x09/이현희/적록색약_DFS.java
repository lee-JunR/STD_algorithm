import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j);
            }
        }

        int[][] canDivideVisited = new int[n][n]; // 적록색약이 아닌 사람
        int canDivideCnt = 0;
        int[][] cannotDivideVisited = new int[n][n]; // 적록색약인 사람
        int canNotDivideCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (canDivideVisited[i][j] == 0) {
                    canDivide(i, j, canDivideVisited, graph[i][j]);
                    canDivideCnt++;
                }
                if (cannotDivideVisited[i][j] == 0) {
                    canNotDivide(i, j, cannotDivideVisited, graph[i][j]);
                    canNotDivideCnt++;
                }
            }
        }
        System.out.printf("%d %d\n", canDivideCnt, canNotDivideCnt);
        br.close();
    }

    private static void canDivide(int x, int y, int[][] visited, char color) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = 1;

        int[] dxs = {-1, 1, 0, 0};
        int[] dys = {0, 0, -1, 1};

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0], cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dxs[i];
                int ny = cy + dys[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == 0 && graph[nx][ny] == color) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    private static void canNotDivide(int x, int y, int[][] visited, char color) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = 1;

        int[] dxs = {-1, 1, 0, 0};
        int[] dys = {0, 0, -1, 1};

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0], cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dxs[i];
                int ny = cy + dys[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && visited[nx][ny] == 0) {
                    if (color == graph[nx][ny] || color == 'R' && graph[nx][ny] == 'G' || color == 'G' && graph[nx][ny] == 'R') {
                        stack.push(new int[]{nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
            }
        }
    }
}