import java.util.HashMap;

public class ArraySubset {

    public boolean isSubset(int a[], int b[]) {

        ///putting the freq int  the a
        HashMap<Integer, Integer> aMap = new HashMap<>();
        for (int ele : a) {
            if (aMap.containsKey(ele)) {
                int freq = aMap.get(ele);
                aMap.put(ele, freq + 1);
            } else
                aMap.put(ele, 1);
        }


        ///putting the values in the  b
        HashMap<Integer, Integer> bMap = new HashMap<>();
        for (int ele : b) {
            if (!aMap.containsKey(ele)) return false;
            if (bMap.containsKey(ele)) {
                int freq = bMap.get(ele);
                bMap.put(ele, freq + 1);
            } else
                bMap.put(ele, 1);
        }

        /// checking the frequency of the b in a
        for (int ele : bMap.keySet()) {
            int freq = bMap.get(ele);
            int afreq = aMap.get(ele);
            if (afreq < freq) return false;
        }

        return true;


    }

}
