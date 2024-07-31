import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] += Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int combo = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            combo += list[i];
            result += combo;

//            System.out.printf("combo : %d, result : %d\n", combo, result);
        }

        System.out.println(result);
    }
}
