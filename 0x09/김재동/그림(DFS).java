package test10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ox10_Q1_1 {

    // 위부터 시계방향
    static int [] dx = {0,1,0,-1};
    static int [] dy = {-1,0,1,0};


    // 백준 1926 S1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // 그림의 세로 가로
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 기본 그림판, 방문한 곳
        int [][] painting = new int[n][m];
        boolean [][] visited = new boolean[n][m];
        // 기본 그림 입력받기
        for(int i =0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++) {
                painting[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 그림 넓이들 리스트 저장
        List<Integer> paintingArea = new ArrayList<>();

        // 전체 도화지 탐색하면서 그림 찾기
        for(int i = 0; i<n; i++) {
            for(int j =0; j<m; j++) {
                if(painting[i][j]==1&&!visited[i][j]) {
                    // 새로운 그림 발견
                    int size = dfs(i, j, painting, visited, n, m);
                    paintingArea.add(size);
                }
            }
        }
        System.out.println(paintingArea.size());
        if(!paintingArea.isEmpty()) {
            System.out.println(Collections.max(paintingArea));
        }else {
            System.out.println(0);
        }
    }

    // 너비 우선 탐색 (DFS)
    public static int dfs(int x, int y, int[][] painting, boolean[][]visited, int n, int m ) {
        Stack<Location> paintStk = new Stack<Location>();
        paintStk.push(new Location(x, y));
        visited[x][y] = true;
        int size = 0;

        while(!paintStk.isEmpty()) {
            Location nowLoc = paintStk.pop();
            size++;
            for(int i = 0; i<4; i++) {
                int tempX = nowLoc.x + dx[i];
                int tempY = nowLoc.y + dy[i];
                // 이동한 위치가 그림판 내에 있는 경우 방문 여부 및 그림 여부 체크
                if(tempX >=0 && tempY >=0 && tempX <n && tempY<m) {
                    if(painting[tempX][tempY]==1&&!visited[tempX][tempY]) {
                        paintStk.push(new Location(tempX, tempY));
                        visited[tempX][tempY] = true;
                    }
                }// 그림여부 체크 fin
            }// for fin
        }// while fin
        return size;
    }
}
class Location{
    int x;
    int y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}
