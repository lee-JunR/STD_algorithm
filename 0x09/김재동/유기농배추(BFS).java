package test09;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class OxO9_Q2_1 {

    // 위부터 시계방향
    static int [] dx = {0,1,0,-1};
    static int [] dy = {-1,0,1,0};

    // 백준 1012 S2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for(int i = 0 ; i< t; i++) {
            // 배추밭 가로, 세로, 배추의 위치
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 배추밭 배추 세팅 ( 배추 = 1 )
            int [][] field = new int [n][m];

            for(int j = 0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            boolean [][] visited = new boolean [n][m]; // 방문한 곳 확인
            // 배추 넓이들 리스트 저장
            List<Integer> fieldArea = new ArrayList<>();
            // 배추 밭 크기 만큼 반복하여 계산
            for(int sero = 0; sero <n; sero++) {
                for(int garo = 0; garo<m; garo++) {
                    if(field[sero][garo]==1 && !visited[sero][garo]) {
                        int size = bfs(sero,garo,field,visited,n,m);
                        fieldArea.add(size);
                    }
                }
            }// 배추밭 테스트 끝
            // 최종 출력을 위해 sb에 값 추가
            if(fieldArea.isEmpty()) {
                sb.append("0\n");
            }else {
                sb.append(fieldArea.size()+"\n");
            }
        }// for fin

        System.out.println(sb.toString().trim());
        br.close();
    }

    // 너비 우선 탐색 (BFS)
    public static int bfs(int x, int y, int[][] field, boolean[][]visited, int n, int m ) {
        // 새로운 배추흰지렁이가 필요한 위치 deq 생성
        Deque<LocationQ2> fieldDeq = new ArrayDeque<LocationQ2>();
        fieldDeq.add(new LocationQ2(x, y));
        // 방문 여부 체크, 지렁이 한마리로 관리 가능한 넓이 체크
        visited[x][y] = true;
        int size = 0;
        //  deq가 비었다 -> 더이상 연결 되지 않는 다는 의미.
        while(!fieldDeq.isEmpty()) {
            LocationQ2 nowLoc = fieldDeq.pollFirst();
            size++;
            for(int i = 0; i<4; i++) {
                int tempX = nowLoc.x + dx[i];
                int tempY = nowLoc.y + dy[i];
                // 이동한 위치가 밭 내에 있는 경우 방문 여부 및 배추 여부 체크
                if(tempX >=0 && tempY >=0 && tempX <n && tempY<m) {
                    // 현재위치가 1인 경우 + 방문한 적이 없는 경우
                    if(field[tempX][tempY]==1&&!visited[tempX][tempY]) {
                        fieldDeq.add(new LocationQ2(tempX, tempY));
                        visited[tempX][tempY] = true;
                    }
                }// 배추 여부 체크 fin
            }// for fin
        }// while fin
        // 지렁이 한마리가 관리 가능한 배추 밭 넓이 return
        return size;
    }
}
class LocationQ2{
    int x;
    int y;
    LocationQ2(int x, int y){
        this.x = x;
        this.y = y;
    }
}
