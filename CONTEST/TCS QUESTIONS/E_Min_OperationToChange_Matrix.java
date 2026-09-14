import java.util.*;

/// // you have given the row ( make the opreation of the adding the 1 and then 1 to the othher then subtrating the 1 from the third )
public class E_Min_OperationToChange_Matrix {


    public static int minoperations(int p, int q, int r) {
        if (p == q && q == r) return 0;
        List<Integer> arr = new ArrayList<>(Arrays.asList(p, q, r));
        Collections.sort(arr);
        int step = 0;
        while (true) {
            arr.set(0, arr.get(0) + 1);
            arr.set(1, arr.get(1) + 1);
            arr.set(2, arr.get(2) - 1);
            step++;
            if (arr.get(0).equals(arr.get(1)) && arr.get(1).equals(arr.get(2))) return step;
            Collections.sort(arr);
            if ((arr.get(0).equals(arr.get(1)) && arr.get(1) + 1 == arr.get(2)) || ((arr.get(1).equals(arr.get(2)) && arr.get(0) + 1 == arr.get(1))))
                return -1; ///// it Can't be the same after number of the operations dso that print the (-1);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            int ans = minoperations(p, q, r);

            System.out.println(ans + " "); /// harr ek line ka c0de ka run kreke usdka answer dega

        }


        sc.close();

    }
}



