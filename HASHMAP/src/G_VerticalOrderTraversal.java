import java.util.*;

class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class VerticalOrderTraversal {

    /// leftmost and rightmost index track krenge
    static int l = 0;
    static int r = 0;

    /// // Vertical order traversal
    ///
    public static void findNode(Node root, int pos) {

        if (root == null) {
            return;
        }

        l = Math.min(l, pos);
        r = Math.max(r, pos);

        findNode(root.left, pos - 1); /// leftt jayyenge aur index mein se 1 subtract krenge
        findNode(root.right, pos + 1);//// right jayenge auur index mein mein 1 add krenge
    }

    public static ArrayList<Integer> Verticalorder(Node root) {

        /// edge case
        if (root == null) {
            return new ArrayList<>();
        }

        /// min and max index find krenge
        findNode(root, 0);

        /// we create the 2d ARRAYLIST to hold the elements
        ArrayList<ArrayList<Integer>> positive = new ArrayList<>();
        /// store the positive index element

        ArrayList<ArrayList<Integer>> negative = new ArrayList<>();
        //// stores the negative index element

        /// initialize positive arraylist
        for (int i = 0; i <= r; i++) {
            positive.add(new ArrayList<>());
        }

        /// initialize negative arraylist
        for (int i = 0; i <= Math.abs(l); i++) {
            negative.add(new ArrayList<>());
        }

        Queue<Node> q = new LinkedList<>();
        ///// queue implement using the LL

        Queue<Integer> index = new LinkedList<>();

        q.add(root);
        index.add(0);

        while (!q.isEmpty()) {

            Node temp = q.poll();
            int pos = index.poll();

            if (pos >= 0)
                positive.get(pos).add(temp.val);

            else
                negative.get(Math.abs(pos)).add(temp.val);

            //// left node jo hain unko queue mein daalenge

            if (temp.left != null) {

                q.offer(temp.left);
                index.offer(pos - 1);
            }

            //// right node jo hain unko queue mein daalenge

            if (temp.right != null) {

                q.offer(temp.right);
                index.offer(pos + 1);
            }
        }

        /// negative ko add krenge then positive

        ArrayList<Integer> ans = new ArrayList<>();

        /// reverse order mein negative add krenge

        for (int i = negative.size() - 1; i > 0; i--) {

            for (int j = 0; j < negative.get(i).size(); j++) {

                ans.add(negative.get(i).get(j));
            }
        }

        /// positive side add krenge

        for (int i = 0; i < positive.size(); i++) {

            for (int j = 0; j < positive.get(i).size(); j++) {

                ans.add(positive.get(i).get(j));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);
        Node g = new Node(8);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        System.out.println(Verticalorder(a));
        /// result will not ignore when it returns the value
    }
}