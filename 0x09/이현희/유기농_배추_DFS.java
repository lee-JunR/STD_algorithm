import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int cnt = 0;
            String[] input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]); // 가로길이(열)
            n = Integer.parseInt(input[1]); // 세로길이(행)
            int k = Integer.parseInt(input[2]);
            int[][] graph = new int[n][m];
            int[][] visited = new int[n][m];

            // 그래프 초기화
            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]); // 열
                int y = Integer.parseInt(input[1]); // 행
                graph[y][x] = 1;
            }

            // 그래프 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1 && visited[i][j] == 0) {
                        dfs(i, j, visited, graph);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
        br.close();
    }

    private static void dfs(int x, int y, int[][] visited, int[][] graph) {
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
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
        }
    }
}