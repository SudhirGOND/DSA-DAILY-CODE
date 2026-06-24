import java.util.HashMap;

public class A_BasicsHashMap {

    public static void main(String[] args) {

//        HashMap<Integer, Integer> hash = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Ramukaka", 22);
        map.put("kaju", 19);
        map.put("devang", 25);
        map.put("Suraj", 35);


        System.out.println(map);/// same as the dictionary in the PYTHON
//        System.out.println(map.remove("kaju"));
        /// we can only travel using the for--each loop
        for (String key : map.keySet()) { ///  keyset means pairs of the map
            System.out.println(key + " " + map.get(key));

        }
    }

}
