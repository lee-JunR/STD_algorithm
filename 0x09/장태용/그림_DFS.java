package week8DFS;
//그림
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1926 {
    public static void main(String[] args) throws IOException {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[][] map = new int[N][M];
        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        int maxAnswer = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j< M; j++){
                if (map[i][j] == 0 || map[i][j] ==2){
                    continue;
                }
                deque.addLast(new int[]{i,j});
                int count = 0;
                while(!deque.isEmpty()){
                    int[] now = deque.pollLast();
                    int nowX = now[0];
                    int nowY = now[1];
                    if(map[nowX][nowY]==2){
                        continue;
                    }
                    map[nowX][nowY] = 2;
                    for(int k =0; k<4;k++){
                        try{
                            if (map[nowX+dx[k]][nowY+dy[k]]==1){
                                deque.addLast(new int[]{nowX+dx[k], nowY+dy[k]});
                            }
                        }catch(Exception e){
                            continue;
                        }
                    }
                    count ++;
                }
                maxAnswer = Math.max(maxAnswer, count);
                answer++;
            }
        }
        System.out.println(answer);
        System.out.println(maxAnswer);
    }
}
