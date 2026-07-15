package July;

public class F_fifthteenthJULY2026 {

    class Solution {
        /// / this  is the style of the NOBADO  JO KI KUCH NHI KARTE BSS PADHA AUR KRNE LEGE
        /// UNDERSTAND WITH EXAMPLES AND THEN SOLVE
        public int gcdOfOddEvenSums(int n) {
            int oddsum = 0;
            int evensum = 0;
            for (int i = 1; i <= 2 * n; i++) {
                if (i % 2 == 0)
                    evensum += i;
                else
                    oddsum += i;
            }

            while (oddsum > 0 && evensum > 0) {
                if (oddsum > evensum) {
                    oddsum = oddsum % evensum;
                } else {
                    evensum = evensum % oddsum;
                }

            }
            if (oddsum == 0)
                return evensum;

            return oddsum;

        }
    }

    /// /// PRO BNADE JINKO PATA HI
    public int gcdOfOddEvenSums(int n) {
        // sum of the n even number = n(n+1)
        /// sum of the odd numbers = n(n)

        int evensum = n * (n + 1);
        int oddsum = n * n;
        return gcd(evensum, oddsum);
    }

    public int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while (a > 0 && b > 0) {

            if (a > b)
                a = a % b;
            else
                b = b % a;

        }
        if (a == 0)
            return b;

        return a;
    }

    ///////// if you observe And then you find the answer is the

    ///    return n ... only


}
