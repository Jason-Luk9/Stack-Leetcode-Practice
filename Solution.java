import java.util.*;

class Solution {
    public static int calPoints(String[] operations) {
        int x = 0;
        int size = operations.length;

        // indicate whether the array contains a digit or not
        boolean isDigit = true;

        // creating an array list for the 
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < size; i++){
            if (operations[i].equals("C")){
                int numSize = nums.size();
                nums.remove(numSize - 1);
                isDigit = false;
            } else if (operations[i].equals("D")){
                int numSize = nums.size();
                int doubledNum = nums.get(numSize - 1) * 2;
                nums.add(doubledNum);
                isDigit = false;
            } else if (operations[i].equals("+")){
                int numSize = nums.size();
                int total = nums.get(numSize - 1) + nums.get(numSize - 2);
                nums.add(total);
                isDigit = false;
            }
            if(isDigit){
                int numbers = Integer.parseInt(operations[i]);
                nums.add(numbers);
            }
            isDigit = true;
        }
        for (int i = 0; i < nums.size(); i++){
            x += nums.get(i);
        }
        return x;
    }

    public static void main(String[] args) {
        {
        String[] ops =  {"5","2","C","D","+"};
        int result = calPoints(ops);
        System.out.println(result);
        }

        {
        String[] ops =  {"5","-2","4","C","D","9","+","+"};
        int result = calPoints(ops);
        System.out.println(result);
        }
    }
}