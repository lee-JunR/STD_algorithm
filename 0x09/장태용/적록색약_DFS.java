package week8DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] RGY = new int [N][N];
        int[][] RGYV = new int [N][N];
        int[][] RGN = new int [N][N];
        int[][] RGNV = new int [N][N];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i = 0; i<N; i++){
            String temp = br.readLine();
            for(int j = 0; j<N; j++){
                char c = temp.charAt(j);
                switch (c){
                    case 'R':
                        RGY[i][j] = 1;
                        RGN[i][j] = 1;
                        break;
                    case 'G':
                        RGY[i][j] = 1;
                        RGN[i][j] = 2;
                        break;
                    case 'B':
                        RGY[i][j] = 2;
                        RGN[i][j] = 3;
                }
            }
        }
        br.close();
        int answer1 = 0;
        int answer2 = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j < N; j++){
                if (RGYV[i][j] == 1){ //방문했으면 스킵
                    continue;
                }
                int currentColor = RGY[i][j];
                deque.addLast(new int[]{i, j});
                while(!deque.isEmpty()){
                    int[] now = deque.pollLast();
                    int nowX = now[0];
                    int nowY = now[1];
                    if(RGYV[nowX][nowY] == 1){
                        continue;
                    }
                    RGYV[nowX][nowY] = 1;
                    for(int k = 0; k<4; k++){
                        try{
                            if(RGYV[nowX+dx[k]][nowY+dy[k]] == 0 && RGY[nowX+dx[k]][nowY+dy[k]]==currentColor){
                                deque.addLast(new int[] {nowX+dx[k], nowY+dy[k]});
                            }
                        }catch (Exception e){
                            continue;
                        }
                    }
                }
                answer1 += 1;
            }
        }
        deque = new ArrayDeque<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j < N; j++){
                if (RGNV[i][j] == 1){ //방문했으면 스킵
                    continue;
                }
                int currentColor = RGN[i][j];
                deque.addLast(new int[]{i, j});
                while(!deque.isEmpty()){
                    int[] now = deque.pollLast();
                    int nowX = now[0];
                    int nowY = now[1];
                    if(RGNV[nowX][nowY] == 1){
                        continue;
                    }
                    RGNV[nowX][nowY] = 1;
                    for(int k = 0; k<4; k++){
                        try{
                            if(RGNV[nowX+dx[k]][nowY+dy[k]] == 0 && RGN[nowX+dx[k]][nowY+dy[k]]==currentColor){
                                deque.addLast(new int[] {nowX+dx[k], nowY+dy[k]});
                            }
                        }catch (Exception e){
                            continue;
                        }
                    }
                }
                answer2 += 1;
            }
        }
        System.out.println(answer2 +" " + answer1);
    }
}
