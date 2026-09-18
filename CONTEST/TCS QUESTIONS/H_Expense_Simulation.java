
/**
 * Write a program to manage expenses from a given total income.
 * <p>
 * Input:
 * 1. Total Income: Integer value representing the total money.
 * 2. For each expense, take the following inputs repeatedly until the user enters
 * "done":
 * - Category: String representing the type of expense (e.g., "food", "shopping").
 * - Expense: Integer value for the amount spent.
 * <p>
 * Output:
 * 1. Print the Total Income.
 * 2. Print the Total Expenses (sum of all expenses).
 * 3. Print the Total Savings (Total Income - Total Expenses).
 * 4. Print the breakdown of expenses for each category.
 *
 */

import java.util.*;

public class H_Expense_Simulation {

    public static void main(String[] args) {

        // take the input of the all the things tyaht is told to you

        Scanner sc = new Scanner(System.in);


        int totalIncome = sc.nextInt();

        sc.nextLine(); // eske baad string iuput krna hain

        HashMap<String, Integer> expenseMap = new HashMap<>();

        int total_Expense = 0;

        while (true) {


            String category = sc.nextLine();
            if (category.equals("done")) break;

            int expense = sc.nextInt();
            sc.nextLine(); /// very important if yoou are taking input of the int and the string


            expenseMap.put(category, expenseMap.getOrDefault(category, 0) + expense);
            total_Expense += expense;


        }

        System.out.println(totalIncome);
        System.out.println(total_Expense);
        System.out.println((totalIncome - total_Expense));

        // print the last expenses with the category

        for (String t : expenseMap.keySet()) {
            System.out.println(t + ":" + expenseMap.get(t));
        }

        sc.close();
    }

}
