import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int count = devide(x);
        System.out.print(count);
    }

    public static int devide(int x) {
        if(x==1) return 0;

        int[] dp = new int[x + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= x; i++) {

            if (i % 6 == 0) {
                dp[i] = dp[i / 3] < dp[i / 2] ? dp[i / 3] + 1 : dp[i / 2] + 1;
            } else if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i / 3] + 1;
            }

            if(dp[i]==0 || dp[i-1]+1<dp[i]){
                dp[i]=dp[i-1]+1;
            }
        }

        return dp[x];
    }
}
