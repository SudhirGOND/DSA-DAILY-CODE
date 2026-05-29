//
//class Node {
//    int val;
//    Node next;
//
//    Node(int val) {
//        this.val = val;
//        this.next = null;
//    }
//
//
//}
//
///// making the all thee linked data-structure
//
//class LinkedList {
//
//
//    Node head;
//    Node tail;
//    int size;
//
//    void addAtTail(int val) {
//
////        if (tail == null) head = tail = temp; /// means empty hai tabb
//        if (tail == null) {
//            addAtHead(val);
//            return;
//        }
//        Node temp = new Node(val);
//        tail.next = temp;
//        tail = temp;
//        size++;
//    }
//
//    void addAtHead(int val) {
//        Node temp = new Node(val);
//
//        if (head == null) head = tail = temp; /// means empty hai tabb
//        else {
//
//            temp.next = head;
//            head = temp;
//
//        }
//        size++;
//    }
//
//    void display() {
//
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.val + " ");
//            temp = temp.next;
//        }
//        System.out.println();
//    }
//
//    void deleteAtHead() {
//
//
//        if (head == null) {
//            System.out.println("Empty List :");  // means empty hai tabb { {
//            return;
//        }
//        head = head.next;
//        size--;
//
//    }
//
//
//    void delete(int idx) {
//
//        if (idx < 0 || idx >= size) {
//            System.out.println("Invalid index");
//            return;
//        }
//
//        if (idx == 0) {
//            deleteAtHead();
//            return;
//        }
//
//
//        Node temp = head;
//        for (int i = 1; i <= idx - 1; i++) {
//            temp = temp.next;
//
//        }
//
//        temp.next = temp.next.next;//deleted
//        if (idx == size - 1) tail = temp; /// we are deleting the tail;
//
//
//        size--;
//
//    }
//
//
//    int search(int val) {
//        int index = 0;
//        if (head == null) {
//            return -1;
//        }
//
//        Node temp = head;
//
//        while (temp != null) {
//            if (temp.val == val) return index;
//            temp = temp.next;
//            index++;
//        }
//        System.out.println("Not FOUND");
//        return -1;
//    }
//
//
//    void insert(int val, int idx) {
//
//        if (idx < 0 || idx > size) System.out.println("Invalaid Index ");
//        else if (idx == 0) addAtHead(val);
//        else if (idx == size) addAtTail(val);
//        else {
//
//
//            Node temp = head;
//            for (int i = 1; i <= idx - 1; i++) {
//                temp = temp.next;
//            }
//
//            Node insertNode = new Node(val);
//            insertNode.next = temp.next;
//            temp.next = insertNode;
//
//            size++;
//        }
//
//
//    }
//
//    public int get(int idx) {
//
//
//        Node temp = head;
//        for (int i = 1; i <= idx; i++) {
//            temp = temp.next;
//        }
//        return temp.val;
//
//
//    }
//
//
//}
//
//public class LinkedListASDS {
//
//
//    public static void main(String[] args) {
//        LinkedList l1 = new LinkedList();
//        l1.addAtTail(10);
//        l1.addAtTail(49);
//
//        l1.addAtTail(45);
//
//        l1.addAtTail(40);
//        l1.display();
//
//        l1.insert(33, 2);
//
//
//        System.out.println("Value at index :3 " + l1.get(3));
////        l1.addAtHead(755555);
//
////        l1.addAtTail(44);
//
//        l1.display();
//        l1.delete(2);
//
////        l1.deleteAtHead();
//
//        l1.display();
//        System.out.println("Size  : " + l1.size);
//
//
//        System.out.println("Found AT INDEX : " + l1.search(44));
//    }
//
//
//}

/// /// middle delete krna haik
/// / middle per insert krna hai
///  by using the slow and the fast pointer
/// / kth from the end o ll
///  remove the nth node from the  end of the list
/// / swap the kth node from the start and the end
/// / Intersection of the two linked list

