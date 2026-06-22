

public class twenty22026 {

    public static int maxNumberOfBalloons(String text) {
/// first we store the frequency of the all letterof the "baloon" -> "balon"
/// it is the 5 letters b ,a,l ,o,n
/// then the min among all ( b,a,n ,  --> l/2 ,o/2)


        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for (char i : text.toCharArray()) {
            if (i == 'b') b++;
            else if (i == 'a') a++;
            else if (i == 'l') l++;
            else if (i == 'o') o++;
            else if (i == 'n') n++;

        }
        ///now made the freq equivalent
        l = l / 2;
        o = o / 2;

        return Math.min(a, Math.min(b, Math.min(l, Math.min(o, n))));
    }


    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
    }

}
