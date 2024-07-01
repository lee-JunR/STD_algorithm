package test10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ox10_Q5_2 {
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
                    dfs(j);
                }
            }
            sb.append((n - count) + "\n");
        }
        br.close();
        System.out.println(sb.toString().trim());
    }

    public static void dfs(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.peek();

            if (!visited[current]) {
                visited[current] = true;
            }

            int next = student[current];

            if (!visited[next]) {
                stack.push(next);
            } else {
                if (!finished[next]) {
                    boolean cycle = false;
                    int cycleCount = 0;

                    while (!stack.isEmpty()) {
                        int node = stack.pop();
                        cycleCount++;
                        if (node == next) {
                            cycle = true;
                        }
                        finished[node] = true;
                        if (cycle && node == next) break;
                    }
                    if (cycle) {
                        count += cycleCount;
                    }
                } else {
                    while (!stack.isEmpty()) {
                        finished[stack.pop()] = true;
                    }
                }
                return;
            }
        }
    }
}