import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        int[][] visited = new int[n][m];
        int bigSize = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 그래프 초기화
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    int size = bfs(i, j, visited);
                    if (bigSize < size) {
                        bigSize = size;
                    }
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(bigSize);
        br.close();
    }

    private static int bfs(int x, int y, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int size = 1;
        visited[x][y] = 1;

        int[] dxs = {-1, 1, 0, 0};
        int[] dys = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0], cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dxs[i];
                int ny = cy + dys[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                    size++;
                }
            }
        }
        return size;
    }
}
