


//Iterative  code of the normal below things

//import java.util.*;
//
//class Node {
//    Node left, right;
//    int val;
//
//    Node(int val) {
//        this.val = val;
//    }
//}
//
//public class treequestions {
//
//    // Level Order Traversal (BFS)
//    public static void levelOrder(Node root) {
//        if (root == null) return;
//
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//            System.out.print(curr.val + " ");
//
//            if (curr.left != null) q.add(curr.left);
//            if (curr.right != null) q.add(curr.right);
//        }
//        System.out.println();
//    }
//
//    // Preorder Traversal (DFS)
//    static void display(Node root) {
//        if (root == null) return;
//
//        System.out.print(root.val + " ");
//        display(root.left);
//        display(root.right);
//    }
//
//    // Size (Iterative)
//    static int size(Node root) {
//        if (root == null) return 0;
//
//        int count = 0;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//            count++;
//
//            if (curr.left != null) q.add(curr.left);
//            if (curr.right != null) q.add(curr.right);
//        }
//        return count;
//    }
//
//    // Sum (Iterative)
//    static int sum(Node root) {
//        if (root == null) return 0;
//
//        int total = 0;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//            total += curr.val;
//
//            if (curr.left != null) q.add(curr.left);
//            if (curr.right != null) q.add(curr.right);
//        }
//        return total;
//    }
//
//    // Height of Tree
//    static int height(Node root) {
//        if (root == null) return 0;
//        return 1 + Math.max(height(root.left), height(root.right));
//    }
//
//    // Max Value (Iterative)
//    static int max(Node root) {
//        if (root == null) return Integer.MIN_VALUE;
//
//        int maxVal = Integer.MIN_VALUE;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//            maxVal = Math.max(maxVal, curr.val);
//
//            if (curr.left != null) q.add(curr.left);
//            if (curr.right != null) q.add(curr.right);
//        }
//        return maxVal;
//    }
//
//    // Product (Recursive - unavoidable generally)
//    public static long productOfNodes(Node root) {
//        if (root == null) return 1;
//        return root.val * productOfNodes(root.left) * productOfNodes(root.right);
//    }
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
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = g;
//
//        display(a);
//        System.out.println();
//
//        System.out.println("Size: " + size(a));
//        System.out.println("Sum: " + sum(a));
//        System.out.println("Max: " + max(a));
//        System.out.println("Height: " + height(a));
//        levelOrder(a);
//        System.out.println("Product: " + productOfNodes(a));
//    }
//}


import java.util.ArrayList;

/// ///////////////////////////////////////////////////////////////////////////////////////////////////////


//class Node {
//    Node left;
//    Node right;
//    int val;
//
//    Node(int val) {
//        this.val = val;
//        right = left = null;
//    }
//
//}

//        2
//      /   \
//     3     4
//    / \   / \
//   5   6 7   8
//
//public class treequestions {
//
//
//    //    public static void levelOrder(Node root) {
////        Queue<Node> q = new LinkedList<>();
////        q.add(root);/// root ko add
////
////        while (!q.isEmpty()) {
////            Node front = q.remove(); // front ko remove krenege
////            System.out.print(front.val + " ");
////            if (front.left != null) q.add(front.left);
////            if (front.right != null) q.add(front.right);
////        }
////        System.out.println();
////
////
////    }
////
////
////    static void display(Node root) {
////        if (root == null) return;
////        System.out.print(root.val + " ");/// also called thee dfs preorder traversal -->
////        display(root.left);
////        display(root.right);
////
////    }
////
////
////    public static int ProductoftheNodes(Node root) {
////        if (root == null) return 1;
////        return root.val * ProductoftheNodes(root.left) * ProductoftheNodes(root.right);
////
////    }
////
////
////    static int size(Node root) {
////        if (root == null) return 0;
////        return 1 + size(root.left) + size(root.right);
////
////    }
////
////    static int sum(Node root) {
////
////        if (root == null) return 0;
////        return root.val + sum(root.left) + sum(root.right);
////
////    }
////
////    static int leveloftree(Node root) {
////        if (root == null) return 0;
////        return 1 + Math.max(leveloftree(root.left), leveloftree(root.right));
////    }
////
////    static int max(Node root) {
////
////        if (root == null) return Integer.MIN_VALUE;
////        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
////    }
////
////
////    static int min(Node root) {
////
////        if (root == null) return Integer.MAX_VALUE;
////        return Math.min(root.val, Math.min(min(root.left), min(root.right)));
////    }
////
//
//
//    static Node LowestAncestor(Node root, int first, int second) {
//
//        ///Optimized approach for the lca -->  O(n)
//        if (root == null) return null;
//        if (root.val == first || root.val == second) return root;
//        Node l = LowestAncestor(root.left, first, second);
//        Node r = LowestAncestor(root.right, first, second);
//
//        if (l != null && r != null) return root;
//        return (l == null) ? r : l;
//
//
//    }
//
//
//    /// / find the distance of the between the given nodes(HARD ON THE GFG)
//
//    static int finddistance(Node root, int a, int b) {
//        // find thee lca
//        Node lca = LowestAncestor(root, a, b);
//
//        int[] dis = {0, 0};
//        dfs(lca, a, b, 0, dis);
//        return dis[0] + dis[1];
//
//
//    }
//
//    static void dfs(Node root, int a, int b, int depth, int[] dis) {
//
//        if (root == null) return;
//        if (root.val == a) dis[0] = depth;
//        if (root.val == b) dis[1] = depth;
//        dfs(root.left, a, b, depth + 1, dis);
//        dfs(root.right, a, b, depth + 1, dis);
//    }
//
//
//    //finding the right view of the tree
//
//
//    /// / flatten the binary tree into the linked list
//    ///
////    public static void flatten(Node root) {
////        // it store the Node
////        ArrayList<Node> arr = new ArrayList<>();
////        dfs(root, arr);
////        for (int i = 0; i < arr.size() - 1; i++) {
////            Node a = arr.get(i);
////            Node b = arr.get(i + 1);
////            a.right = b;
////            a.left = null;
////        }
////        ///last wala
////        Node last = arr.get(arr.size() - 1);
////        last.left = null;
////        last.right = null;
////
////    }
////
////    public static void dfs(Node root, ArrayList<Node> arr) {
////        if (root == null) return;
////        arr.add(root);/// sabhi nodes ko preorder mein arraylist mein add krr diye hain
////        dfs(root.left, arr);
////        dfs(root.right, arr);
////
////
////    }
//
//
//    /// now recursion style
////    public static void flatten(Node root) {
////        // it store the Node
////        if (root == null) return;
////        Node lst = root.left;// left subtree
////        Node rst = root.right;// right subtree
////        root.left = null;// left ko null se joiin
////        root.right = null;
////        flatten(lst);
////        flatten(rst);
////
////        root.right = lst;
////        Node last = root;/// ye root hi last element hoga
////        while (last.right != null) last = last.right;
////        last.right = rst; // join right subn tree
////
////    }
//
//    /// //  print the paths upto the target
//    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
//
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        ArrayList<Integer> arr = new ArrayList<>();
//        dfs(root, sum, arr, ans);
//        return ans;
//
//    }
//
//    private static void dfs(Node root, int sum, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans) {
//
//        //root null hia koi path nhi milega
//        if (root == null) return;
//
//        /// add the element into arr then into ans
//
//        arr.add(root.val);
//
//        /// if the element equal to sum return
//        if (root.val == sum) {
//            ans.add(new ArrayList<>(arr));  //// ans array_list me in hum arr ki copy daal denge
//        }
//        dfs(root.left, sum - root.val, arr, ans);
//        dfs(root.right, sum - root.val, arr, ans);
//
//        arr.remove(arr.size() - 1);/// remove the element backtracking
//
//
//    }
//
//
//    public static void main(String[] args) {
//
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

//        display(a);
//
//        System.out.println("Size " + size(a));
//        System.out.println("Sum " + sum(a));
//        System.out.println("max " + max(a));
//        System.out.println("max " + min(a));
//
//
//        System.out.println("Level  " + leveloftree(a));
//        levelOrder(a);
//        System.out.println("Product :" + ProductoftheNodes(a));

//        System.out.println("the distance between the two nodes " + finddistance(a, d.val, g.val));

//        flatten(a);// flatten thee tree to linked list
//
//
//        System.out.println( printPaths(a, 11));
//    }
//
//
//}