package July;

public class B_seventhjuly2026 {
    public static void main(String[] args) {
        sumAndMultiply(204500050);
    }

    public static long sumAndMultiply(int n) {

        long x = 0;
        long sum = 0;
        int placevalue = 1; ///  trick
        while (n > 0) {
            int last = n % 10;
            if (last != 0) {
                sum += last; // calculate the sum
                x = x + last * placevalue; //  making of the x
                placevalue *= 10;
            }
            n /= 10;

        }
        return (long) sum * x;
    }
}


