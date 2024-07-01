import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    private int x;
    private int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());
            int cabbageNum = Integer.parseInt(st.nextToken());

            int[][] board = new int[rowSize][colSize];
            boolean[][] isVisited = new boolean[rowSize][colSize];

            for(int j=0; j<cabbageNum; j++){
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());

                board[col][row] = 1;
            }

            Queue<Pair> queue = new LinkedList<>();
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};
            int result = 0;

            for(int j=0; j<rowSize; j++){
                for(int k=0; k<colSize; k++){
                    if(board[j][k]==0||isVisited[j][k])
                        continue;

                    queue.add(new Pair(j, k));
                    isVisited[j][k] = true;
                    result++;

                    while(!queue.isEmpty()){
                        Pair node = queue.poll();
                        for(int direction=0; direction<4; direction++){
                            int curX = node.getX() + dx[direction];
                            int curY = node.getY() + dy[direction];

                            if(curX<0 || curY<0 || curX>=rowSize || curY>=colSize)
                                continue;

                            if(board[curX][curY]==0 || isVisited[curX][curY])
                                continue;

                            queue.add(new Pair(curX, curY));
                            isVisited[curX][curY]=true;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
