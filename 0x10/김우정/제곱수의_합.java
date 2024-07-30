import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(squareSum(n));
    }

    public static int squareSum(int n){
        int[] dp = new int[n+1];

        dp[0] = 0;

        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1] + 1;

            for(int j=2; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

//        for(int i=1; i<=n; i++){
//            System.out.println(i + " : " + dp[i]);
//        }

        return dp[n];
    }
}
