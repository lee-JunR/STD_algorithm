import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for(int i=0; i<testcase; i++) {
            int x = Integer.parseInt(br.readLine());
            int[] count = fibonacciCount(x);
            System.out.printf("%d %d\n", count[0], count[1]);
        }
    }

    public static int[] fibonacciCount(int n){

        int[] dp0 = new int[n+2];
        int[] dp1 = new int[n+2];

        dp0[0]=1;
        dp1[0]=0;

        dp0[1]=0;
        dp1[1]=1;

        for(int i=2; i<=n; i++){
            dp0[i] = dp0[i-1] + dp0[i-2];
            dp1[i] = dp1[i-1] + dp1[i-2];

//            System.out.printf("%d번째 - 0 : %d, 1 : %d\n", i, dp0[i], dp1[i]);
        }

        return new int[] {dp0[n], dp1[n]};
    }
}
