package Easy;
// Baseball Game easy question LeetCode

import java.util.*;

class Solution {
    public static int calPoints(String[] operations) {
        int x = 0;
        int size = operations.length;

        // indicate whether the array contains a digit or not
        boolean isDigit = true;

        // creating an array list for the final result array
        ArrayList<Integer> result = new ArrayList<>();
        
        // looping through the operations array
        for (int i = 0; i < size; i++) {
            if (operations[i].equals("C")) {
                // taking the size of the result and remove the recent integer
                int numSize = result.size();
                result.remove(numSize - 1);
                isDigit = false;
            } else if (operations[i].equals("D")) {
                int numSize = result.size();
                // taking the most recent number and double it
                int doubledNum = result.get(numSize - 1) * 2;
                result.add(doubledNum);
                isDigit = false;
            } else if (operations[i].equals("+")) {
                int numSize = result.size();
                // summing up the numbers in the last 2 of the result
                int total = result.get(numSize - 1) + result.get(numSize - 2);
                result.add(total);
                isDigit = false;
            }

            // checking if the operation is a digit, then insert it into the result 
            if (isDigit) {
                int numbers = Integer.parseInt(operations[i]);
                result.add(numbers);
            }
            // resetting the isDigit counter
            isDigit = true;
        }
        // summing up the total in the result
        for (int i = 0; i < result.size(); i++) {
            x += result.get(i);
        }
        return x;
    }

    public static void main(String[] args) {
        {
            String[] ops = { "5", "2", "C", "D", "+" };
            int result = calPoints(ops);
            System.out.println("Expected result:30");
            System.out.println("Actual result  :" + result);
            System.out.println();
        }

        {
            String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
            int result = calPoints(ops);
            System.out.println("Expected result:27");
            System.out.println("Actual result  :" + result);
            System.out.println();
        }

        {
            String[] ops = { "1", "C" };
            int result = calPoints(ops);
            System.out.println("Expected result:0");
            System.out.println("Actual result  :" + result);

        }
    }
}