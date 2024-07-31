package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//정수 삼각형

public class boj1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][N];
        for(int i =1 ; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<i;j++){
                int n = Integer.parseInt(st.nextToken());
                if(j!=0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+n;
                }else{
                    dp[i][j] = dp[i-1][j] + n;
                }
            }
        }
        br.close();
        System.out.println(Arrays.stream(dp[N]).max().getAsInt());
    }
}
