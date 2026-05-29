import java.util.ArrayList;

class SubsetByBits {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        int n = arr.length; ///  chota hi hoga less than 32

        int m = (1 << n); ///  2 raised to power n

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) { //  m  = number of subsets

            ArrayList<Integer> a = new ArrayList<>();

            for (int j = 0; j < n; j++) { ///  harr ek array k  element k set bits ko chek karega
                if ((i >> j) % 2 == 1) a.add(arr[j]);
            }
            ans.add(a); //  array a peice get added

        }


        return ans;

    }
}
