//public class treequestions {
//
//
//    class DoublyLinkedList {
//
//        private ListNode head;
//        private ListNode tail;
//        private int size;
//
//
//        // Node class
//        private static class ListNode {
//            int val;
//            ListNode next;
//            ListNode prev;
//
//            ListNode(int val) {
//                this.val = val;
//            }
//        }
//
//        // Insert at head
//        public void insertAtHead(int val) {
//            ListNode node = new ListNode(val);
//
//            if (head == null) {
//                head = tail = node;
//            } else {
//                node.next = head;
//                head.prev = node;
//                head = node;
//            }
//            size++;
//        }
//
//        // insert at Tail
//        public void insertAtTail(int val) {
//            ListNode node = new ListNode(val);
//
//            if (tail == null) {
//                head = tail = node;
//            } else {
//                tail.next = node;
//                node.prev = tail;
//                tail = node;
//            }
//            size++;
//        }
//
//        //insert at index
//        public void insertAtIndex(int idx, int val) {
//
//            if (size < idx || idx < 0) {
//                System.out.println("Invalid index ");
//                return;
//            }
//
//            if (idx == 0) {
//                insertAtHead(val);
//
//                return;
//            }
//
//            if (idx == size) {
//                insertAtTail(val);
//
//                return;
//            }
//
//            ListNode node = new ListNode(val);
//            ListNode temp = head;
//
//            for (int i = 1; i < idx; i++) {
//                temp = temp.next;
//            }
//
//            node.prev = temp;
//            temp.next.prev = node;
//            node.next = temp.next;
//            temp.next = node;
//            size++;
//
//
//        }
//
//        //Delete at Head
//        void deleteAtHead() {
//
//            if (size == 1) head = tail = null;
//            else {
//                head = head.next;
//                head.prev = null;
//            }
//            size--;
//        }
//
//        /// Delete at Tail
//
//        void deleteAtTail() {
//
//            if (size == 0) {
//                System.out.println("Can't do -> no more elements ");
//            } else if (size == 1) head = tail = null;
//            else {
//                tail = tail.prev;
//                tail.next = null;
//            }
//            size--;
//
//        }
//
//        void deleteATIndex(int idx) {
//
//            if (size < idx || idx < 0) {
//                System.out.println("Invalid index ");
//                return;
//
//            }
//
//            if (idx == 0) {
//                deleteAtHead();
//                return;
//            }
//
//            if (idx == size) {
//                deleteAtTail();
//                return;
//            }
//
//            ListNode temp = head;
//
//            for (int i = 1; i < idx; i++) {
//
//                temp = temp.next;
//
//            }
//
//            temp.next = temp.next.next;
//            temp.next.prev = temp;
//            size--;
//
//            return;
//
//
//        }
//
//        // Display forward
//        public void displayForward() {
//            ListNode current = head;
//
//
//            while (current != null) {
//                System.out.print(current.val + " ");
//                current = current.next;
//            }
//            System.out.println();
//
//        }
//
//        // Display backward
//        public void displayBackward() {
//
//            ListNode current = tail;
//
//            while (current != null) {
//                System.out.print(current.val + " ");
//                current = current.prev;
//            }
//            System.out.println();
//
//        }
//
//        public int size() {
//            return size;
//        }
//
//
//        public static void main(String[] args) {
//            DoublyLinkedList list = new DoublyLinkedList();
//
//            list.insertAtHead(10);
//            list.insertAtTail(20);
//            list.insertAtHead(5);
//            list.insertAtTail(55);
//            list.insertAtHead(0);
//            list.displayForward();   // 5 10 20
//            list.displayBackward();  // 20 10 5
//            list.deleteAtTail();
//            list.displayForward();
//
//            list.insertAtIndex(0, 444);
//            list.displayForward();
//            // list.insertAtIndex(1,444);
//            list.deleteATIndex(2);
//
//
//            list.displayForward();
////            list.reverseDLL();
//            list.displayForward();
//
//
//        }
//
//
//    }






///DLL KO REVERSE KARNA
/// Using the 3 pointer

// public static void  reverseDLL(ListNode head){
//         ListNode prev  =  null;
//         ListNode forw  =  null;
//         ListNode curr  =  head;

//         while(curr !=  null){
//             forw  =  curr.next ;
//             curr.next  =  prev  ;
//             curr.prev  = forw;//// for reversing the DLL
//             prev  =  curr;
//             curr  =  forw;
//         }
//         return prev;
// }



/// using the 2 pointer

// public static void  reverseDLL(ListNode head){

//    ListNode temp =  null ;
//    ListNode curr  =  head ;

//     while(curr !=  null){
//         temp   =  curr.prev  ;
//         curr.prev  = curr.next ;
//         curr.next  =  temp;
//         curr =  curr.prev;
//     }

//   while(temp != null){
//     System.out.print(temp.val+" ");

//   }
//   System.out.println();

//     // return temp.prev;




// }
// }




////copy list with the random pointer

//   public Node deepCopy(Node head1){
//     Node temp1 = head1;
//     Node head2 = new Node(-1);
//     Node temp2 = head2;

//     while(temp1 != null){
//         Node t = new Node(temp1.val);
//         temp2.next = t;
//         temp2 = temp2.next;
//         temp1 = temp1.next;
//     }
//     return head2.next;
// }

// public void merge(Node head1, Node head2){
//     Node t1 = head1;
//     Node t2 = head2;

//     while(t1 != null && t2 != null){

//         Node n1 = t1.next;
//         Node n2 = t2.next;

//         t1.next = t2;
//         t2.next = n1;

//         t1 = n1;
//         t2 = n2;
//     }
// }

// public void randomconnection(Node head1, Node head2){
//     Node t1 = head1;
//     Node t2 = head2;

//     while(t1 != null && t2 != null){
//         if(t1.random == null) t2.random = null;
//         else t2.random = t1.random.next; // main cheez

//         t1 = t1.next.next;   // MUST move always
//         t2 = t2.next.next;
//     }
// }

// public Node split(Node head1){
//     Node dummy2 = new Node(-1);
//     Node temp2 = dummy2;

//     Node temp = head1;   // merged list traverse

//     while(temp != null && temp.next != null){
//         temp2.next = temp;
//         temp = temp.next;
//         temp2 = temp2.next;

//         temp2.next = temp;
//         temp = temp.next;
//     }

//     // restore original list
//     Node t = head1;
//     Node c = dummy2.next;

//     while(t != null && c != null){
//         t.next = c.next;
//         t = t.next;
//         if(t != null) c.next = t.next;
//         c = c.next;
//     }

//     return dummy2.next;
// }

// public Node copyList(Node head1){

//     if(head1 == null) return null;

//     Node head2 = deepCopy(head1);   // step 1
//     merge(head1, head2);            // step 2
//     randomconnection(head1, head2); // step 3
//     return split(head1);            // step 4
// }

