import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());

        int[][] list = new int[size+1][size+1];
        for(int i=1; i<=size; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=i; j++){
                if(!st.hasMoreTokens()) break;
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(findMax(list));
    }

    public static int findMax(int[][] list){
        int[][] dp = new int[list.length][list.length];

        for(int i=1; i<list.length; i++){
            dp[list.length-1][i] = list[list.length-1][i];
        }

        for(int i=list.length-2; i>=1; i--){
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1])+list[i][j];
            }
        }

        return dp[1][1];
    }
}
