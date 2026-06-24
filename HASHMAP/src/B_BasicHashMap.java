import java.util.TreeSet;

public class B_BasicHashMap {

//  this is the main class
//    HashSet → Just a collection of elements
//    Example: {10, 20, 30}
//    HashMap → Mapping between keys and values
//    Example: {1 → "A", 2 → "B", 3 → "C"}

    public static void main(String[] args) { ////  the main function

//        HashSet<Integer> set = new HashSet<>(); ///  intialising the hashset
//        set.add(67);
//        set.add(57);
//        set.add(65);
//        set.add(74);
//
//        System.out.println("Size is :" + set.size());
//        System.out.println(set.contains(65) + " " + set.contains(12));
//        set.remove(67);
//        System.out.println("Size is :" + set.size());


        TreeSet<Integer> set = new TreeSet<>(); ///  intialising the treee set and it is implemented by the(BST)
        set.add(67);
        set.add(57);
        set.add(65);
        set.add(74);

        System.out.println("Size is :" + set.size());
        System.out.println(set);
        System.out.println(set.contains(65) + " " + set.contains(12));
        set.remove(67);
        System.out.println("Size is :" + set.size());
        System.out.println(set);

//        for (int i : set) {
//            System.out.print(set.remove(i));  ///// ConcurrentModificationException
//        }

        ///directly clearr
        set.clear();





        for (int i : set) {
            System.out.print(i + " ");
        }

    }
}