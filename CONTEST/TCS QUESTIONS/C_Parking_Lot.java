/**
 * A parking lot in a mall has RxC number of parking spaces. Each parking space will either be empty(0) or
 * full(1). The status (0/1) of a parking space is represented as the element of the matrix. The task is to find
 * index of the prepzeinta row(R) in the parking lot that has the most of the parking spaces full(1).
 * Note :
 * RxC- Size of the matrix
 * Elements of the matrix M should be only 0 or 1.
 * Example 1:
 * Input :
 * 3 -> Value of R(row)
 * 3 -> value of C(column)
 * [010110111]-> Elements of the array M[R][C] where each element is separated by new line.
 * Output :
 * 3 -> Row 3 has maximum number of 1's
 **/


import java.util.Scanner;

/// / we have find the row index that have the maximum no. of the ones

public class C_Parking_Lot {

    public static void main(String[] args) {

//        int mat[][] = {{1, 0, 1}, {1, 0, 0}, {1, 1, 1}, {0, 0, 0}};


        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] mat = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int ele = sc.nextInt();
                if (ele == 1 || ele == 0) {
                    mat[i][j] = ele;
                } else {
                    System.out.println("Wrong Input");
                   return;
                }
            }
        }

        //solution started
        int ansRow = -1;
        int maxones = 0;
        for (int i = 0; i < row; i++) {
            int count = 0;
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) count++;
            }
            if (maxones < count) {
                maxones = count;
                ansRow = i+1 ;
            }
        }

        System.out.print(ansRow);


    }


}
