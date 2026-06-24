
import java.util.HashMap;

public class L_CloneTheRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node deepCopy(Node head1) {

        if (head1 == null) {
            return null;
        }

        Node temp1 = head1;
        Node dummy = new Node(-1);
        Node temp2 = dummy;

        while (temp1 != null) {
            Node t = new Node(temp1.val);
            temp2.next = t;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }

        return dummy.next;
    }

    public static Node cloneLinkedList(Node a) {

        if (a == null) {
            return null;
        }

        // Create a deep copy of the next pointers
        Node b = deepCopy(a);

        // Map original nodes to copied nodes
        HashMap<Node, Node> map = new HashMap<>();

        Node tempA = a;
        Node tempB = b;

        map.put(null, null);

        while (tempA != null) {
            map.put(tempA, tempB);
            tempA = tempA.next;
            tempB = tempB.next;
        }

        // Assign random pointers
        tempA = a;

        while (tempA != null) {
            tempB = map.get(tempA);
            tempB.random = map.get(tempA.random);
            tempA = tempA.next;
        }

        return b;
    }
}