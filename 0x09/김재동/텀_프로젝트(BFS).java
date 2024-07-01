package test09;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class OxO9_Q5_2 {
    static int[] student; // 학생
    static boolean[] visited; // 방문한 곳
    static boolean[] finished; // 싸이클 마지막
    static int count; // 개수
    // 백준 9466 G3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            student = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            for (int j = 1; j <= n; j++) {
                student[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    bfs(j);
                }
            }
            sb.append((n - count) + "\n");
        }
        br.close();
        System.out.println(sb.toString().trim());
    }
    //너비 우선 탐색 (BFS)
    public static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>(); // queue - visited
        Deque<Integer> path = new ArrayDeque<>();  // path - finished 묶이는 느낌

        // queue - visited 얘넨 단순 체크용도
        // path - finished 얘네가 실제 계산 느낌

        queue.add(start);
        path.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int next = student[current];

            if (!visited[next]) { // -> 방문 안했으므로 싸이클 누적
                visited[next] = true;
                queue.add(next);
                path.add(next);
            }
            else { // 방문 한 경우 -> 싸이클이 되거나, 오류이거나
                if (!finished[next]) {
                    boolean cycle = false;
                    while (!path.isEmpty()) {
                        int node = path.poll();
                        if(node == next) {
                            cycle = true;
                        }
                        if(cycle ==true) {
                            count++;
                        }
                    }// while fin
                    return;
                }
            }
        }// while fin

        // 남은 경로 처리
        while (!path.isEmpty()) {
            finished[path.poll()] = true;
        }
    }
}
