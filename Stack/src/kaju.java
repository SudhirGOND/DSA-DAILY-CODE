







/// STACK DATA TYPE IS  THE  LINEAR DATA TYPE
/// INSERTION AND DELETION HAPPEN INI THE STYLE OF THE LIFO AND THE FIFO

// remove the consecutive characters





 import java.util.Stack;

// public class kaju {
//
//     public static void main(String[] args) {
//
//         String s = "aaaabbbcccddcajse";
//         Stack<Character> stk = new Stack<>();
//
//         int n = s.length();
//
//         for (int i = 0; i < n - 1; i++) {
//             // if (s.charAt(i) != s.charAt(i + 1)) {
//             if (stk.isEmpty() || stk.peek() != s.charAt(i) ){
//                 stk.push(s.charAt(i));
//             }
//         }
//
//         // push last character
//         stk.push(s.charAt(n - 1));
//
//         System.out.println(stk);
//
//         StringBuilder ans = new StringBuilder();
//
//         while (!stk.isEmpty()) {
//             ans.append(stk.pop());
//         }
//
//         // reverse because stack pops in reverse order
//         System.out.println(ans.reverse().toString());
//     }
// }


//remove the nodes in the liinnked list


// import java.util.Stack;

// public class treequestions{

//     class ListNode {
//         int val;
//         ListNode next  ;
//     }

//     public static void main(String[]  args){

//         Stack<ListNode> st  =  new Stack<>();
//         ListNode temp   =  head ;

//         /// it takes the O(n)  time complexity
//         while(temp!= null){
//             whiile(st.size() > 0 && st.peek() < temp.val)

//             st.pop();

//             st.push(temp);
//             temp =  temp.next;
//         }

//         /// it also takes the O(n) TC
//         while(st.size() >0){

//             ListNode top  =  st.pop();
//             top.next  =  temp;
//             temp =  top;

//         }

//         return temp;





//     }
// }



///  next greater element gfgfg


// class Solution {
//     public int[] nextGreaterElements(int[] arr) {

//         int n  =  arr.length ;

//         Stack<Integer> st  =  new Stack<>();
//         int nge[]=  new int[n];
//         nge[n-1] =  -1;

//         st.push(arr[n-1]);

//         for(int i  =  n-2 ; i >=  0 ; i--){
//                 while(st.size() > 0 && arr[i] >=  st.peek()) st.pop();
//                 if(st.size() == 0 ) nge[i] = -1;
//                 else nge[i] = st.peek();
//                 st.push(arr[i]);

//         }

//         return nge;
//     }
// }




/////stock span problem


// import java.util.*;
// class treequestions{



//      static class Pair{
//     int val;
//     int idx  ;

//     Pair(int val,int idx){
//         this.val  =  val ;
//         this.idx  =  idx  ;

//     }
//         }



//     public static ArrayList<Integer> calculateSpan(int []  arr){


//             int n  =  arr.length;
//             int[]  span  =  new int[n];

//             span[0] = 1;/// phle index prr jo hai.....Uska previously greater element = 0+(1) including..

//             Stack<Pair> st  =  new Stack<>();

//             st.push(new Pair(arr[0],0));///phla pair-- element ka insert
//             for(int i  = 1 ; i< n  ; i++){
//                     while(st.size() > 0 && st.peek().val <= arr[i] )  st.pop();
//                     if(st.size() == 0) span[i]  = i -(-1);///previously greater element nhin hain
//                     else  span[i] =   i  -  st.peek().idx;
//                      st.push(new Pair(arr[i] , i));


//             }
//             ArrayList<Integer>  ans  =  new     ArrayList<>();
//             for(int i  = 0 ; i< n ;i++){
//                 ans.add(span[i]);
//             }

//             System.out.println(ans);
//             return ans ;

//     }


//      public static void main(String[] args){
//        int arr []=  {100,80,10,60,75,95};
//         calculateSpan(arr);

//      }

// }

/////CELEBRITY PROBLEM

// public class treequestions{


//     public int celebrity(int [][]arr){
//         int  n =  arr.length;

//         Stack<Integer> st  =  new Stack<>();

//         for(int i  = 0;  i <  n ; i++) st.push(i);//sare person are inserted in the stack

//         while(st.size() > 1){

//             int a  =  st.pop();
//             int b  =  st.pop();

//            /// checking that celeb kaun hai

//         boolean aFlag  =  true;
//         boolean bFlag   = true ;

//         if(arr[a][b]==  1) /// a not celeb
//         aFlag  = false ;
//         else bFlag  =  false; // b a ko janta... b not celeb

//         if(arr[b][a] == 1) bFlag  =  false;
//         else aFlag  =  false ; //  a not celeb

//             if(aFlag)  st.push(a);
//             if(bFlag)  st.push(b);

//         }

//         if(st.size()  ==  0) return -1;

//         int celeb  =  st.pop();///last 1 elemet hai

//         for(int j  = 0; j < n; j++){ ///  checking row & col

//             if(j  ==  celeb) continue;
//             if(arr[celeb][j] ==  1 || arr[j][celeb] ==  1) return -1; // 1 means janta hai



//         }



//       return celeb;

//     }



// }






//// the canyousee the minions wala example

// class Solution {

//     public int[] canSeePersonsCount(int[] arr) {
//         int n = arr.length;
//         int[] ans = new int[n];///asnswer array
//         Stack<Integer> st = new Stack<>();
//         st.push(arr[n-1]); /// sbse phle push the last index value
//         ans[n-1] = 0;    /// last mein 0 daal denge
//         for(int i=n-2;i>=0;i--){
//             int count = 0;   ///
//             while(st.size()>0 && st.peek()<=arr[i]){
//                 count++;
//                 st.pop();
//             }
//             if(st.size()>0) count++; // Very Very IMPORTANT
//             ans[i] = count;
//             st.push(arr[i]);
//         }
//         return ans;
//     }
// }




//// monotonic stack problems (rectangle in the histogram )
//// brute froce kaise hoga


// class Solution{
//     public int largestRectangleHistogram(int []arr){

//             int n  =  arr.length;
//             int []nse  =  new int[n];
//             nse[n-1]  =  n; ///  Assumption is made

//             Stack<Integer> st  =  new Stack<>();

//             st.push(n-1);  /// for the next smallest number we put the last index first into the stack

//             for(int  i  =  n-2 ;  i >= 0 ; i--){

//
//
//
//
//            while(st.size() > 0 && arr[st.peek()] >=  arr[idx])  st.pop();
//                 if(st.isEmpty) nse[i]   =  n;
//                 else{
//                     nse[i] = st.peek();
//                 }
//                 st.push(i); // idx insert karenge
//             }

//           while(st.size() >   0) st.pop();/// empty the stack

//             int[]  pse = new int[n];

//             pse[0] = -1;

//             st.push(0);/// first indx push
//             for(int i =  1 ; i < n ;i++){
//                    while(st.size() > 0 && arr[st.peek()] >=  arr[idx])  st.pop();
//                 if(st.isEmpty) pse[i]   =  -1;
//                 else{
//                     pse[i] = st.peek();
//                 }
//                 st.push(i);
//             }


//             //// finding the max area
//             int maxArea  =  0;
//             for(int i  = 0 ; i <  n ; i++){
//                 int area  =  arr[i] * (nse[i] - pse[i] - 1);
//                 if(maxArea <  area) maxArea =  area;
//             }

//             return maxArea;

//      }
// }







///// maximum rectangle area  in the binary 2D -  array




// class treequestions{
// public static int getMaxArea(int []arr){

//         int n  =  arr.length;
//         int []nse  =  new int[n];
//         nse[n-1]  =  n;  ///  Assumption is made

//         Stack<Integer> st  =  new Stack<>();

//         st.push(n-1);   /// for the next smallest number we put the last index first into the stack

//         for(int  i  =  n-2 ;  i >= 0 ; i--){

//             while(st.size() > 0 && arr[st.peek()] >=  arr[i])  st.pop();
//             if(st.size() == 0) nse[i]   =  n;
//             else{

//                 nse[i] = st.peek();
//             }

//             st.push(i); // idx insert karenge
//         }

//         while(st.size() >   0) st.pop();/// empty the stack

//         int[]  pse = new int[n];

//         pse[0] = -1;

//         st.push(0);/// first indx push
//         for(int i =  1 ; i < n ;i++){
//                while(st.size() > 0 && arr[st.peek()] >=  arr[i])  st.pop();
//             if(st.size() ==0) pse[i]   =  -1;
//             else{
//                 pse[i] = st.peek();
//             }
//             st.push(i);
//         }


//         //// finding the max area
//         int maxArea  =  0;
//         for(int i  = 0 ; i <  n ; i++){
//             int area  =  arr[i] * (nse[i] - pse[i] - 1);
//             if(maxArea <  area) maxArea =  area;
//         }

//         return maxArea;
//     }




//  static int maxArea(int mat[][]) {


//     int m  = mat.length ;
//     int n  =  mat[0].length;
//     for(int  i  = 1  ; i<  m ;i++){
//         for(int j  = 0   ; j  <  n  ;j++){
//             if(mat[i][j]==  1)
//             mat[i][j] += mat[i-1][j];
//         }
//     }
//         /// harr ek row ke max area nikalenge
//         int maxArea  = 0 ;
//         for(int []row :  mat){
//             int curArea =  getMaxArea(row);
//             if(maxArea < curArea) maxArea  = curArea ;
//         }

//         return maxArea;

//     }

// }





//// solving the min stack problem


// class MinStack {

//we made the 2 stacks
//     Stack<Integer> st;

//     Stack<Integer> minSt;

//     public MinStack() {
//         st = new Stack<>();
//         minSt = new Stack<>();
//     }

//     public void push(int val) {
//         st.push(val);
//         if (minSt.size() == 0 || minSt.peek() > val)
//             minSt.push(val);
//         else
//             minSt.push(minSt.peek());
//     }

//     public void pop() {
//         st.pop();
//         minSt.pop();
//     }

//     public int top() {
//         return st.peek();
//     }

//     public int getMin() {

//         return minSt.peek();
//     }

// }




// class MinStack {
//     Stack<Long> st;
//     long min;
//     public MinStack() {
//         st = new Stack<>();
//         min = Long.MAX_VALUE;
//     }

//     public void push(int val) {
//         long value = (long)val;
//         if(st.size()==0) min = value;

//         if(value >= min) st.push(value);
//         else{ // val<min, stack me fake value daalo
//             st.push(value + (value-min));
//             min = value;
//         }
//     }

//     public void pop() {
//         if(st.peek() < min){ // locha hai, minimum roll back karo
//             min = min + (min - st.peek());
//         }
//         st.pop();
//     }

//     public int top() { // peek
//         long peek = st.peek();
//         if(peek < min){ // locha hai, minimum roll back karo
//             return (int)min;
//         }
//         else return (int)peek;
//     }

//     public int getMin() {
//         return (int)min;
//     }
// }