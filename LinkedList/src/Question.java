//import java.util.*;
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//
//
//public class Question {
//
//    public static ListNode reverselist(ListNode head) {
//
//        if (head == null || head.next == null) return head;
//
//
//        ListNode a = head.next;
//        head.next = null;
//
//
//        ListNode b = reverselist(a);
//        a.next = head;
//
//
//        return b;
//
//    }
//
//    /// // it have the space complexity O(n);
//
//    public static boolean PalindromeList(ListNode head) {
//
////        if (head == null || head.next == null) return true;
//        ListNode temp = head;
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        while (temp != null) {
//
//            arr.add(temp.val);
//            temp = temp.next;
//        }
//
//        int i = 0;
//        int j = arr.size() - 1;
//
//        while (i <= j) {
//            int a = arr.get(i);
//            int b = arr.get(j);
//            if (a != b) return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
//
//    public static boolean PalindromeNewList(ListNode head) {
//
////        if (head == null || head.next == null) return true;
//
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//
//
//        }
//
//
//        ListNode newHead = slow.next;
//        slow.next = null;
//        newHead = reverselist(newHead);
//        ListNode i = head;
//        ListNode j = newHead;
//        while (j != null) {
//
//            if (i.val != j.val) return false;
//            i = i.next;
//            j = j.next;
//        }
//        return true;
//    }
//
//    private static void printlist(ListNode a) {
//        ListNode temp = a;
//        while (temp != null) {
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//
//    }
//
//    public static void main(String[] args) {
//        ListNode head = new ListNode(10);
//        ListNode b = new ListNode(20);
//        ListNode c = new ListNode(30);
//        ListNode x = new ListNode(50);
//        ListNode d = new ListNode(20);
//        ListNode e = new ListNode(10);
//        head.next = b;
//        b.next = c;
//        c.next = x;
//        x.next = d;
////
//        d.next = e;
//        e.next = null;
//        printlist(head);
//
//
////        printlist(reverselist(head));
//        //       System.out.println(PalindromeNewList(head));
//    }
//
//    /// //mergeing of the k sorted list nodes
//
//
//    public static ListNode mergeKlist(ArrayList<Integer> arr) {
//        while (arr.size() > 1) {
//            ListNode head1 = arr.get(arr.size() - 1);
//
//            arr.remove(arr.size() - 1);
//            ListNode head2 = arr.get(arr.size() - 1);
//            arr.remove(arr.size() - 1);
//            ListNode newhead = merge(head1, head2);
//
//            arr.add(newhead);
//        }
//
//        return arr.get(0);
//    }
//
//
//
//
//}
//





/// merge K sorted linked list
/// add the number s 2 leetcode
/// add numbers on the gfg
/// break the liinked list into parts(circular ll)
///deletion and the reverse of the  circluar ll

//
//import java.util.*;
//class ListNode {
//     int val;
//     ListNode next;
//
//     ListNode() {
//     }
//
//     ListNode(int val) {
//         this.val = val;
//     }
//
//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
//     }
//
// public class Question {
//
//
//     public static ListNode reverse(ListNode head) {
//
//         if (head == null || head.next == null) return head;
//
//         ListNode a = head.next;
//         head.next = null;
//         ListNode b = reverse(a);
//         a.next = head;
//
//         return b;
//     }
//
//     public static ListNode mergelist(ListNode head1, ListNode head2) {
//         ListNode i = head1;
//         ListNode j = head2;
//
//         ListNode dummy = new ListNode(-1);
//         ListNode k = dummy;
//         while (i != null && j != null) {
//
//             if (i.val <= j.val) {
//                 k.next = i;
//                 i = i.next;
//                 k = k.next;
//             } else {
//                 k.next = j;
//                 j = j.next;
//                 k = k.next;
//             }
//
//
//             if (i == null) k.next = j;
//             else k.next = i;
//
//
//         }
//         return dummy.next;
//     }
//
// }










//     // // public static ListNode reorder(ListNode head){

//     //     if(head ==  null || head.next  ==  null) return head;


//     //     ListNode slow =  head;
//     //     ListNode fast =  head;

//     //     while(fast !=  null && fast.next != null){

//     //         slow  =  head.next;
//     //         fast  =  head.next.next;
//     //     }
//     //     ListNode newhead1 =  slow.next;
//     //     slow.next  =  null;
//     //     Listnode newHead2= reverse(newhead1);


//     //  return mergelist(head , newhead2);

//     //     // printlist(dhoom);

//     // // }
// //// reversing the part of the linked list

//         // public static Node ReversePart(ListNode head,  int a , int  b){

//         public static void  reverselist(ListNode head){
//             ListNode prev  =  null;
//             ListNode forw  =  null;
//             ListNode curr  =  head;

//             while(curr !=  null){
//                 forw  =  curr.next ;
//                 curr.next  =  prev  ;
//                 prev  =  curr;
//                 curr     =  forw;




//             }
//             // return prev;
//         }



//         public static ListNode ReversePart(ListNode head,  int a , int  b){

//                 ListNode dummy = new ListNode(-1);//nakli node bnnaye

//                 dummy.next  =  head  ;
//                 ListNode temp  =  dummy  ;

//             for(int  i  = 0 ; i < a-1; i++){
//                 temp  =  temp.next;
//             }
//             ListNode tail1  =  temp;
//             ListNode head2  =  tail1.next ;
//             temp  =  dummy  ;
//             for(int i  = 0  ; i< b;i++){
//                 temp  = temp.next  ;
//             }

//             ListNode tail2  =  temp ;
//             ListNode head3 =  tail2.next  ;

//             //ab list ko 3 part mein broke karenge

//             tail1.next  =  null;
//             tail2.next  =  null;

//            reverselist(head2);

//             tail1.next = tail2;
//             head2.next  =  head3  ;

//             return dummy.next;
//         }








//     public static void main(String[] args) {
//         ListNode head = new ListNode(10);
//         ListNode b = new ListNode(20);
//         ListNode c = new ListNode(30);
//         ListNode x = new ListNode(40);
//         ListNode d = new ListNode(50);
//         ListNode e = new ListNode(60);
//         ListNode f = new ListNode(70);
//         head.next = b;
//         b.next = c;
//         c.next = x;
//         x.next = d;
//         d.next = e;
//         e.next = f;
//         f.next = null;


//     //   ListNode dhoom = reorder(head);


//     //   printlist(dhoom);


//     ListNode dhoom = ReversePart(head ,  0, 7);
//     printlist(dhoom);

//     }






//     public  static void printlist(ListNode a) {
//         ListNode temp = a;
//         while (temp != null) {
//             System.out.print(temp.val + " ");
//             temp = temp.next;
//         }

//     }


// }

