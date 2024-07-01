import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
        int boardSize = Integer.parseInt(br.readLine());

        char[][] board = new char[boardSize][boardSize];
        char[][] boardBlindness = new char[boardSize][boardSize];

        for(int i=0; i<boardSize; i++){
            String str = br.readLine();
            board[i] = str.toCharArray();

            String str2 = str.replaceAll("R","G");
            boardBlindness[i] = str2.toCharArray();
        }

        int countArea = countArea_DFS(board, boardSize);
        int countAreaB = countArea_DFS(boardBlindness, boardSize);

        System.out.println(countArea);
        System.out.println(countAreaB);

        br.close();
    }

    public static int countArea_DFS(char[][] board, int boardSize){
        Deque<Pair> stack = new LinkedList<>();
        boolean[][] isVisited = new boolean[boardSize][boardSize];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int countArea = 0;

        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                if(!isVisited[i][j]){
                    stack.add(new Pair(i, j));
                    isVisited[i][j]=true;
                    countArea++;
                }

                while(!stack.isEmpty()){
                    Pair node = stack.pop();

                    for(int direction=0; direction<4; direction++){
                        int curX = node.getX()+dx[direction];
                        int curY = node.getY()+dy[direction];

                        if(curX<0 || curY<0 || curX>=boardSize || curY>=boardSize){
                            continue;
                        }

                        if(board[curX][curY]!=board[node.getX()][node.getY()] || isVisited[curX][curY]){
                            continue;
                        }

                        stack.add(new Pair(curX, curY));
                        isVisited[curX][curY] = true;
                    }
                }
            }
        }
        return countArea;
    }
}
