import java.util.ArrayList;

public class A_MIN_rotation_toUnlock {
    public static void main(String[] args) {




        int random = 223;
        int password = 3394;
        int ans = 0;

        while (random > 0 || password > 0) {

            int first = random % 10;
            int second = password % 10;

            random /= 10;
            password /= 10;
            int abs = Math.abs(first - second);

            ans = Math.min(abs, 10 - abs);

        }

        System.out.println(ans);

    }
}