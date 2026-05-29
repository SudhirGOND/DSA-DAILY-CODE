public class Fraction {

    int num;
    int deno;


    //function of the gcd
    public static int gcd(int num, int deno) {
        int min = Math.min(num, deno);
        for (int i = min; i >= 1; i--) {
            if (num % i == 0 && deno % i == 0) {
                return i;//when it hits condition
            }
        }
        return min;//no hits condition

    }

    public Fraction() {
        //contructor
    }

    public Fraction(int num, int deno) {
        //@constructor
        this.deno = deno;
        this.num = num;

    }

    //
    public void simplify() {
        int hcf = gcd(num, deno);
        num /= hcf;
        deno /= hcf;
    }

    public static void add(Fraction f1, Fraction f2) {
        f1.num = ((f1.num * f2.deno) + (f1.deno * f2.num));
        f1.deno = (f1.deno * f2.deno);

    }


    public static void main(String[] args) {

        Fraction f1 = new Fraction(7, 21);
        System.out.println(f1.num + "/" + f1.deno);
        Fraction f2 = new Fraction(4, 21);
        System.out.println(f2.num + "/" + f2.deno);
        System.out.println("The simplification version of the fraction 2: " + f2.num + "/" + f2.deno);
//        Fraction f3 = new Fraction();

        f1.simplify();
        f2.simplify();
        add(f1, f2);
//        f3 = add(f1, f2);
// adding two fraction and simplifying
//        int A =  add(f1,f2);//cannot store fraction in th integer add
        System.out.println("Addition is the : " + f1.num + "/" + f1.deno);
    }
}

