import java.util.LinkedList;
import java.util.Queue;

public class questions {

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);


        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println(q); /// nakli printing
        q.remove();//removing the elements of the queue
        System.out.println(q + " " + q.size());


    }
}





/// traversing the element of the queue

//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class treequestions {
//
//    public static void main(String[] args) {
//
//            Queue<Integer> q  =  new LinkedList<>();
//
//            q.add(10);
//            q.add(20);
//            q.add(30);
//            q.add(40);
//            q.add(50);
//            q.add(60);
//            int n  =  q.size();
//
//
//            for(int i  =  0 ; i < n ; i++){
//                System.out.print(q.peek()+" ");
//                q.add(q.remove());
//            }
//
//            System.out.println(q);
//    }
//}
//
//
///// adding  the element at any index
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class treequestions {
//
//    private static void addAtIndex(Queue<Integer> q, int index,int ele){
//
//             int n  =  q.size();
//
//
//            for(int i  =  0 ; i < index ; i++){
//
//                q.add(q.remove());
//            }
//                q.add(ele); //  adding the element
//
//
//            for(int i   = 0 ; i < n - index ; i++){
//                q.add(q.remove());
//            }
//
//
//            System.out.println("the elements of the queue : "+q);
//
//
//    }
//
//
//    private static void Remove(Queue<Integer> q ,  int index){
//        int  n =  q.size();
//
//
//    for(int i  = 0 ; i <  index  ; i++){
//        q.add(q.remove());
//    }
//
//    System.out.println("Removed  : "+ q.remove());
//
//    for(int i  = 0 ; i < q.size() - index  ; i++){
//        q.add(q.remove());
//    }
//
//
//    }
//
//
//    private static void  peek(Queue<Integer> q ,  int index){
//    int  n =  q.size();
//
//
//    for(int i  = 0 ; i <  index  ; i++){
//        q.add(q.remove());
//    }
//
//    System.out.println("peeked :"+ q.peek());
//
//    for(int i  = 0 ; i < n - index  ; i++){
//        q.add(q.remove());
//    }
//
//    }
//
//
//    public static void main(String[] args) {
//        Queue<Integer> q  =  new LinkedList<>();
//            q.add(10);
//            q.add(20);
//            q.add(30);
//            q.add(40);
//            q.add(50);
//            q.add(60);
//            // addAtIndex(q,0,456);
//
//            peek(q,3);
//            System.out.println(q);
//            Remove(q,  3);
//            System.out.println(q);
//
//
//    }
//}
//
//
//////Implementing of the queue using  LL
//
//class Node {
//    int val ;
//    Node  next ;
//    Node(int val) {
//        this.val =  val ;
//    }
//
//}
//
//class MyQueue {
//
//   Node head  ;
//   Node tail ;
//   int size  ;
//
//
//    public void add(int val){
//
//        Node temp  =  new Node(val);
//        if(tail ==  null)  head  =  tail =  temp;
//
//        else {
//
//        tail.next  =  temp ;
//        tail  =  temp ;
//
//        }
//        size++;
//
//
//    }
//
//    public int remove(){
//
//        if(size == 0) {
//            System.out.println("Queue is empty ");
//            return -1;
//        }
//        int front  =  head.val ;
//        head  =  head.next  ;
//        size--;
//
//        return front ;
//
//    }
//
//
//  public int peek(){
//
//
//    if(size == 0){
//        System.out.println("Queue is Empty");
//        return -1;
//    }
//    return head.val;
//}
//
//
//    public void display(){
//        Node temp  = head;
//        while(temp != null){
//            System.out.print( temp.val+" ");
//              temp  =  temp.next;
//        }
//
//    }
//
//}
//
//public class treequestions{
//
//
// public static void main(String[]  args ){
//
//
//    MyQueue  q  =  new MyQueue();
//
//    q.add(10);
//    q.add(23);
//    q.add(43);
//    q.add(53);
//    q.display();
//
//    q.remove();
//    System.out.println();
//    q.display();
//
//    q.peek();
//
//
// }
//
//
//}
//
//
///Implementation via Circular --> array
//
//
//public class treequestions{
//
//
// static class CircularQueue {
//    int []arr ;
//    int f ;  //// front
//    int r;  //// rear
//    int size ;
//
//    CircularQueue(int capacity){
//        arr =  new int[capacity];
//    }
//
//    void add(int val){
//
//        if(size ==  arr.length)
//        {
//            System.out.println("array is full");
//            return;
//        }
//        arr[r++]=  val ;
//        if(r== arr.length)  r  = 0;
//        size++;
//
//    }
//
//    int  remove(){
//        if(size ==  0) {
//            System.out.println("array is empty");
//            return  -1 ;
//        }
//        int front  = arr[f];
//        f++;
//        if(f== arr.length)  f  = 0; //  makking the circular array as queue
//        size--; ///  size kamm ho jayega
//        return front;
//
//    }
//
//    int peek(){
//        if(size ==  0) {
//            System.out.println("array is empty");
//            return -1;
//        }
//        return arr[f];
//    }
//
//    void display(){
//
//            if(f>=r){
//                for(int i  = f ;  i < arr.length ; i++ )
//                System.out.print(arr[i] +" ");
//
//                for(int i  = 0 ;  i < r ; i++ )
//                System.out.print(arr[i] +" ");
//
//            }
//            else {
//
//                for(int i  = f  ; i  <= r ; i++){
//                     System.out.print(arr[i] +" ");
//                }
//            }
//    }
//
//}
//
//
// public static void main(String[] args ){
//
//    CircularQueue q   =  new CircularQueue(4);
//
//
//    q.add(34);
//    q.add(44);
//    q.add(234);
//    q.add(4);
//    q.remove();
//       q.display();
//    q.add(100);
//    System.out.println();
//    q.display();
//
//
// }
//
//
//}
//
