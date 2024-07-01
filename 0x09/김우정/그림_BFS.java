import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
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

    public int getY(){
        return y;
    }
}

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] board = new int[row][col];
        boolean[][] isVisited = new boolean[row][col];

        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
                isVisited[i][j] = false;
            }
        }

        int countPicture = 0;
        int maxArea = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        Deque<Pair> queue = new LinkedList<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]==0 || isVisited[i][j])
                    continue;

                queue.add(new Pair(i, j));
                countPicture++;
                isVisited[i][j]=true;
                int area = 0;

                while(!queue.isEmpty()){
                    Pair node = queue.pop();
                    area++;
                    for(int k=0; k<4; k++){
                        int curX = node.getX()+dx[k];
                        int curY = node.getY()+dy[k];

                        if(curX<0 || curY<0 || curX>=row || curY>=col)
                            continue;

                        if(board[curX][curY]==0 || isVisited[curX][curY])
                            continue;

                        queue.add(new Pair(curX, curY));
                        isVisited[curX][curY] = true;
                    }
                }

                if(maxArea<area) {
                    maxArea = area;
                }
            }
        }

        System.out.println(countPicture);
        System.out.println(maxArea);

        br.close();
    }
}
