import java.awt.event.PaintEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BurningTheTree {


    class Pair {

        Node node;
        int dist;

        Pair(Node node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static Node start;
    /// /  start should be the target
    static HashMap<Node, Node> parent;

    /// /Parent node <node ,parentnode>

    public int minTime(Node root, int target) {

        /// bfs lagyenge -> value store karenge..bahar nikalo left right --> parent
        /// burning wale se hum 3 direction mein ja rhe
        /// during bfs -> left / right /parent
        //// for prent we made the hashmap
        ///queue bnayenge for bfs -> same style of the BFS
        /// pair ke form mein root(start), level(dist)
        ///// Hashmap and the start Node

        start = null;
        parent = new HashMap<>();
        /// storing the value to the parent map
        dfs(root, target);
        ////Queue for thee bfs

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0)); /// start root and the dist = 0
        HashSet<Node> burned = new HashSet<>(); ///  made toi store the already burnedd or taken
        burned.add(start);
        int time = 0;
        while (!q.isEmpty()) {
            Pair front = q.remove();
            int dist = front.dist;
            time = Math.max(time, dist);
            Node node = front.node;
            if (node.left != null && !burned.contains(node.left)) {
                q.add(new Pair(node.left, dist + 1));//// ek dist badjakle
                burned.add(node.left);
            }
            if (node.right != null && !burned.contains(node.right)) {
                q.add(new Pair(node.right, dist + 1));//// ek dist badjakle
                burned.add(node.right);
            }
            if (parent.containsKey(node) && !burned.contains(parent.get(node))) {
                q.add(new Pair(parent.get(node), dist + 1));//// ek dist badjakle
                burned.add(parent.get(node));
            }
        }

        return time;

    }

    private void dfs(Node root, int target) {

        if (root == null) return;
        if (root.val == target) start = root;
        if (root.left != null) parent.put(root.left, root);
        if (root.right != null) parent.put(root.right, root);


        dfs(root.left, target);//// target khojenge kidhar left

        dfs(root.right, target);/////  target khojenge right mein


    }


}



