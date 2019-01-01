// import java.lang.Math;

/*
 * (17.19) Missing Two: You are given an array with all the numbers from 1 to N
 * appearing exactly once, except for one number that is missing. How can find
 * the missing number in O(N) time and O(1) space? What if there were two
 * numbers missing?
 */
public class MissingTwo {
    public static void main(String[] args) {
        int[] arr = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            arr[i - 1] = Integer.parseInt(args[i]);
        }

        if (args[0].equals("1"))
            findOneMissing(arr, arr.length + 1);
        else if (args[0].equals("2"))
            findTwoMissing(arr, arr.length + 2);
        else
            System.out.println(args[0]);
    }

    // one number missing from array
    public static void findOneMissing(int[] arr, int N) {
        int total = (N * (N + 1)) / 2;
        for (int val : arr) {
            total -= val;
        }
        System.out.println("The missing number is " + total);
    }

    // two numbers missing from array.
    public static void findTwoMissing(int[] arr, int N) {
        // trying to find a and b. We know a * b and a + b;
        // add = a + b;
        // multi = a * b;
        int total = 0;
        int multiCounter = 1;
        for (int val : arr) {
            total += val;
            multiCounter *= val;
        }
        int add = ((N * (N + 1)) / 2) - total;
        int multi = factorial(N) / multiCounter;
        int root = (int) Math.sqrt(add * add - 4 * multi);
        int val1 =  (add + root) / 2;
        int val2 =  (add - root) / 2;
        int num1 = val1 > 0 ? val1 : val2;
        int num2 = add - num1;
        System.out.println("The missing numbers are " + num1 + " and " + num2);
    }

    // I found faster ways to do this but it seems out of the scope of this problem.
    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
