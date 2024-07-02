package week8DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0 ; t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =1 ; i<=N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] visited = new int[N+1];
            int[] finished = new int[N+1];
            Deque<Integer> queue = new ArrayDeque<>();
            int count = 0;
            for(int i = 1; i<=N; i++){
                if(visited[i]!=0){
                    finished[i]= 1;
                    continue;
                }
                queue.addLast(i);
                while(!queue.isEmpty()){
                    int now = queue.pollLast();
                    if(finished[now] == 1){
                        continue;
                    }
                    if(visited[now] == 0){
                        visited[now] = i;
                    }else if(visited[now]==i){
                        finished[now] = 1;
                        count ++;
                    }else{
                        finished[now] = 1;
                    }
                    queue.addLast(arr[now]);
                }
            }
            System.out.println(N-count);
        }

    }
}