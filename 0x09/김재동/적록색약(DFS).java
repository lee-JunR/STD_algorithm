package test10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ox10_Q3_1 {
    // 위부터 시계방향
    static int [] dx = {0,1,0,-1};
    static int [] dy = {-1,0,1,0};
    // 백준 10026 G5
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        // 그리드
        String [][] grid = new String[n][n];
        for(int i =0; i<n; i++) {
            String temp = br.readLine();
            grid[i] = temp.split("");
        }
        // 그리드 체크해서 리스트 저장, 방문기록 세팅
        boolean [][] visited = new boolean[n][n];
        List<Integer> gridArea = new ArrayList<>();
        // 그리드 크기 만큼 반복하여 계산
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int size = dfs(i, j, grid, visited, n);
                    gridArea.add(size);
                }
            }
        }
        sb.append(gridArea.size()+" ");
        // 방문 기록 초기화, 그리드 크기 초기화
        visited = new boolean[n][n];
        gridArea = new ArrayList<>();
        // 적녹색약 계산 대비 모든 R을 G로 변경 ( R,G 구분 못하므로 통일 )
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                grid[i][j] = grid[i][j].replace("R","G");
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int size = dfs(i, j, grid, visited, n);
                    gridArea.add(size);
                }
            }
        }
        sb.append(gridArea.size());
        System.out.println(sb.toString());
        br.close();
    }
    //깊이 우선 탐색 (DFS)
    public static int dfs(int x, int y, String [][] grid, boolean[][]visited, int n) {
        Stack<LocationQ3> gridStk = new Stack<LocationQ3>();
        gridStk.push(new LocationQ3(x, y));
        visited[x][y] = true;
        int size = 0;
        String temp = grid[x][y];
        //  스택이 비었다 -> 더이상 연결 되지 않는 다는 의미.
        while(!gridStk.isEmpty()) {
            LocationQ3 nowLoc = gridStk.pop();
            size++;
            for(int i = 0; i<4; i++) {
                int tempX = nowLoc.x + dx[i];
                int tempY = nowLoc.y + dy[i];
                // 이동한 위치가 그리드 내에 있는 경우
                if(tempX >=0 && tempY >=0 && tempX <n && tempY<n) {
                    // 적록색약이 아닌사람이 봤을 경우
                    if(grid[tempX][tempY].equals(temp)&&!visited[tempX][tempY]) {
                        gridStk.push(new LocationQ3(tempX, tempY));
                        visited[tempX][tempY] = true;
                    }
                }//
            }// for fin (상하좌우)
        }// while fin
        // R인경우 사이즈
        return size;
    }
}
class LocationQ3{
    int x;
    int y;
    LocationQ3(int x, int y){
        this.x = x;
        this.y = y;
    }
}