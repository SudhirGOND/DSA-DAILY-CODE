import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class I_TopView {

    class Pair {
        Node node;
        int dist;

        Pair(Node node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }


    public ArrayList<Integer> topview(Node root) {


        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); ///  < horizontal_dist , value >
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0)); /// q mein 1 element daale diye for the BFS
        int minDist = Integer.MAX_VALUE;
        int maxDist = Integer.MIN_VALUE;
        while (q.size() > 0) {
            /// phla node nikala ..uske node and dist
            Pair front = q.poll();
            Node node = front.node;
            int dist = front.dist;

            ///mindist and maxDist --> we stoores only the value of that min & max at that level
            minDist = Math.min(minDist, dist);
            maxDist = Math.max(maxDist, dist);

            if (!map.containsKey(dist))
                map.put(dist, node.val); ///  phli baar jo sbse uper aayega usko dalloge (dist == baraber ho)
//           map.put(dist, node.val); ///  jiska first occurrence hogha vo (top view mein daal denge )
///// last occurence hoga to bottom view mein daal denge
            if (node.left != null) q.add(new Pair(node.left, dist - 1));/// left ja rhe
            if (node.right != null) q.add(new Pair(node.right, dist + 1));/// right ja rrhee

        }

        for (int i = minDist; i <= maxDist; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }
}