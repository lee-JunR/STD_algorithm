import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(countCoin(coin, k));
    }

    public static int countCoin(int[] coin, int money){
        int count = 0;

        for(int i=coin.length-1; i>=0; i--){
            if(money>=coin[i]){
                count += money/coin[i];
                money %= coin[i];
            }
        }

        return count;
    }
}
