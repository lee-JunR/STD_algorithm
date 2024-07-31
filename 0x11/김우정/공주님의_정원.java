import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

class Flower{
    int id;
    LocalDate bloomDate;
    LocalDate fallDate;

    public Flower(){}

    public Flower(int id, LocalDate bloomDate, LocalDate fallDate){
        this.id = id;
        this.bloomDate = bloomDate;
        this.fallDate = fallDate;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int bloomM = Integer.parseInt(st.nextToken());
            int bloomD = Integer.parseInt(st.nextToken());
            int fallM = Integer.parseInt(st.nextToken());
            int fallD = Integer.parseInt(st.nextToken());

            flowers.add(new Flower(i, LocalDate.of(2024, bloomM, bloomD),LocalDate.of(2024, fallM, fallD)))
        }

        flowers.sort(Comparator.comparing((Flower f)->f.bloomDate).thenComparing((Flower f)->f.fallDate));

        LocalDate baseDate = LocalDate.of(2024, 3, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 30);

        while(baseDate.isBefore(endDate)){

        }
        //시작일이 basedate보다 앞이고, 종료일이 가장 큰 flower선택하고 count++
        //basedate를 선택한 flower의 종료일로 설정.
        //basedate가 11월 30일 이상이 될 때 까지 반복

    }
}
