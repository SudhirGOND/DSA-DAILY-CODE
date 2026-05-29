//public class LowestCommonAncestor {
//
//
//    public static void main(String[] args) {
//
//        Node a = new Node(2);
//        Node b = new Node(3);
//        Node c = new Node(4);
//        Node d = new Node(5);
//        Node e = new Node(6);
//        Node f = new Node(7);
//        Node g = new Node(8);
//
//
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = g;
//
//
//        treequestions.display(a);
//
//        System.out.println("Common ancestor " + LowestAncestor(a, f.val, g.val).val);
//
//    }


//
//    private static Node LowestAncestor(Node root, int first, int second) {
//        // base condition
//        if (root.val == first || root.val == second) return root;
//        boolean le = isexist(root.left, first);/// checking in the left subtree
//
//        boolean re = isexist(root.left, second);/// same  for this
//
//        if (le && re) return LowestAncestor(root.left, first, second);
//        else if (!le && !re) return LowestAncestor(root.right, first, second);
//        else return root;
//
//    }
//
//       private static boolean isexist(Node root, int first) {
//
//        // base case
//        if (root == null) return false;
//        if (root.val == first) return true;
//        return isexist(root.left, first) || isexist(root.right, first);
//    }


//}

