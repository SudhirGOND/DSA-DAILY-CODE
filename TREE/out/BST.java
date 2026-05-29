import java.util.ArrayList;

// Node class
//class Node {
//    int val;
//    Node left, right;
//
//    public Node(int item) {
//        val = item;
//        left = right = null;
//    }
//
//
//}
//
////                          50   ← Root
////                        /    \
////                      30      70
////                     /  \    /  \
////                   20   40  60   80
//
//public class BST {
//
//
//    public static void main(String[] args) {
//
//        // Manually creating nodes
//        Node root = new Node(50);
//
//        // Level 1
//        root.left = new Node(30);
//        root.right = new Node(70);
//
//        // Level 2
//        root.left.left = new Node(20);
//        root.left.right = new Node(40);
//
//        root.right.left = new Node(60);
//        root.right.right = new Node(80);

//        System.out.println(search(root, 50));
//        getCount(root,20,80);
//        display(root);
//        insertNode(root, 65);
//        System.out.println();
//        display(root);
//        isValidBST(root);
//        System.out.println(inorder_pred__Succ(root, 56));
//        System.out.println(iterativeInorder(root));///MORRIS TRAVERSAL


//    }


    /// creating the pair that holds the value of the max
    /// & min
    ///
//    static class Pair {
//        int max;
//        int min;
//
//        Pair(int max, int min) {
//            this.max = max;
//            this.min = min;
//
//        }
//    }
//
//    static boolean flag;
//
//    public static boolean isValidBST(Node root) {
//        flag = true;
//        maxMin(root);
//        return flag;
//
//    }
//
//    public static Pair maxMin(Node root) {
//        if (root == null) return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE);
//        Pair lst = maxMin(root.left);/// max  min pairs from the left subtree
//        Pair rst = maxMin(root.right);/// max min  pairs from the right subtree
//        int max = Math.max(root.val, Math.max(lst.max, rst.max));
//        int min = Math.min(root.val, Math.min(lst.min, rst.min));
//
//        ////  main cheez
//        if (lst.max >= root.val || rst.min <= root.val)
//            flag = false; /// marked the flag as false means not BST
//        return new Pair(max, min);
//    }
//

/////Treversing of the BST

//    private static void display(Node root) {
//
//        if (root == null) return;
//        System.out.print(root.val + " ");
//        display(root.left);
//        display(root.right);
//    }


//////insertion of the node in the BST

//    public static Node insertNode(Node root, int val) {
    /// sbse phle yadi null hain to new node return
    /// yadi bada hai to root.data < val// right node bnake usko insert krr doge
    //// yadi chota hai root se to root.data >  val // to left node bnake insert krr doge

//        if (root == null) return new Node(val);
//
//        if (root.val == val) return root;
//        else if (root.val > val) root.left = insertNode(root.left, val);
//        else root.right = insertNode(root.right, val);
//        return root;


//
//        if (root == null) return new Node(val);
//        insertBST(root, val);
//        return root;/// yadi uske baraber ho to return;
//
//
//    }
//
//
//    private static void insertBST(Node root, int val) {
//
//        if (root.val < val) {///left jayenge
//
//            if (root.right == null)// if nulll hain to insert it
//                root.right = new Node(val);
//            else insertBST(root.right, val);
//        } else {
//
//            if (root.left == null) root.left = new Node(val);
//            else insertBST(root.left, val);
//
//
//        }
//    }


    /// / Searching of the element of the BST
//    public static boolean search(Node root, int target) {
//        if (root == null) return false;
//        if (root.val == target) return true;
//        if (root.val > target)
//            search(root.left, target);
//        return search(root.right, target);
//
//
//    }


    /// //// inorder_successor and the predecessor
//    public static ArrayList<Integer> inorder_pred__Succ(Node root, int target) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        Node curr = root;
//        Node pred = null;
//        Node succ = null;
//
//        while (curr != null) {
//
//            if (target < curr.val) {
//                succ = curr;
//                curr = curr.left;
//
//            } else if (target > curr.val) {
//                pred = curr;
//                curr = curr.right;
//
//            } else { ///  target  ==  curr.val;
//                if (curr.left != null)
//                    pred = rightmostLST(root.left);
//
//                if (curr.right != null)
//                    succ = leftmostRST(root.right);
//
//                break;
//            }
//
//
//        }
//        arr.add(pred.val);
//        arr.add(succ.val);
//
//        return arr;
//
//
//    }

//    private static Node leftmostRST(Node root) {
//        Node temp = root;
//        while (temp.left != null) {
//            temp = temp.left;
//        }
//
//        return temp;
//    }
//
//    private static Node rightmostLST(Node root) {
//        Node temp = root;
//        while (temp.right != null) {
//            temp = temp.right;
//        }
//
//        return temp;
//
//    }


    /// ///MORRIS TRAVERSAL BY STORY WITH THE MIK
//    public static ArrayList<Integer> iterativeInorder(Node root) {
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        Node curr = root;
//        while (curr != null) {
//
//            if (curr.left == null) { //  L , V  R
//                arr.add(curr.val);
//                curr = curr.right;
//            } else {
//                Node leftchild = curr.left; ///  left  child
//                while (leftchild.right != null) {
//                    /// curr child ke rightmost  chl jao
//                    leftchild = leftchild.right;
//                }
//
//                leftchild.right = curr;
//                /// curr-> left ko null mark ker denge
//                Node temp = curr;
//                curr = curr.left;
//                temp.left = null;
//            }
//        }
//        return arr;
//
//    }

    /// MORRIS TRAVERSAL BY THE RAGHAV SIR DSA

//    public static ArrayList<Integer> iterativeInorder(Node root) {
//
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        Node curr = root;
//        while (curr != null) {
//
//
//            if (curr.left != null) {
//                //// find the pred and do work
//                Node pred = curr.left;//// curr ka left
//
//                while (pred.right != null && pred.right != curr)
//                    pred = pred.right;///  finding the pred
//
//                if (pred.right == null) { /// ;linking
//                    pred.right = curr;
//                    curr = curr.left;
//                } else {
//                    //// pred.right  ==  curr //  Unlink and print
//                    pred.right = null;
//                    arr.add(curr.val);
//                    curr = curr.right;
//                }
//
//
//            } else { ///  curr.left ==  null
//
//                arr.add(curr.val);  ////  if left null haiuto root ko add karo
//                curr = curr.right;
//
//
//            }
//
//
//        }
//
//        return arr;
//    }


    /// Construct the tree from the inorder and the preorder

//    public void Constructionoftree(int[] inorder, int[] preorder) {
//        int n = inorder.length;
//        return constructtree(0, n - 1, 0, n - 1, inorder, postorder);

//
//    }
//    // construct tree from the inorder and preorder
//    private static Node constructtree(int prelo, int prehi, int inlo, int inhi, int[] inorder, int[] preorder) {
//        if (prelo > prehi)
//            return null;
//        int val = preorder[prelo];/// first index per preorder mein root ki val mei stored
//
//        Node root = new Node(val);
//
//        int rootidx = Integer.MIN_VALUE;// indexing
//        for (int i = inlo; i < inhi; i++) {
//            if (inorder[i] == val) {
//                rootidx = i;
//                break;
//            }
//        }
//
//
//        // we got the index of the node as rootidx
//
//        int cnt = rootidx - inlo; //  this count the elements in  the postorder lst tree//  also neglect the null nodes

//        constructtree(prelo + 1, prelo + cnt, inlo, rootidx - 1, inorder, preorder);// making of the left subtree
//        constructtree(prelo + cnt + 1, prehi, rootidx + 1, inhi, inorder, preorder);// making of the right subtree
//
//        return root;
//    }

// Construct the tree from the inorder and  postorder
//
//        private static Node constructtree( int postlo, int posthi, int inlo, int inhi, int[] inorder, int[] postorder){
//
//
//        }
//
//
//    }
