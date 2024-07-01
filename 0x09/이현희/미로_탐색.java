import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m];
        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                distance[i][j] = 0;
            }
        }
        System.out.println(bfs(0, 0, distance));
        br.close();
    }

    private static int bfs(int x, int y, int[][] distance) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        distance[x][y] = 1;

        int[] dxs = {-1, 1, 0, 0};
        int[] dys = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0], cy = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dxs[i];
                int ny = cy + dys[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && distance[nx][ny] == 0 && graph[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[cx][cy] + 1;
                }
            }
        }
        return distance[n - 1][m - 1];
    }
}
