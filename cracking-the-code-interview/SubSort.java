/*
 * Sub Sort: Given an array of integers, write a method to find indices m and n
 * such that if you sorted elements m through n, the entire array would be
 * sorted. Minimized n - m (that is find the smalles sequence)
 * INCOMPLETE: fails some tests
 */

 public class SubSort {
     public static void main(String[] args) {
         boolean foundError = false;
         int start = -1;
         int end  = -1;
         int max = 0;
         int prev = Integer.parseInt(args[0]);
         for (int i = 1; i < args.length; i++) {
             int curr = Integer.parseInt(args[i]);
             // step 1: find a value that is incorrect. Then traverse backwards
             //     to find the indice where the value belongs. Then save the
             //     max so you can find the endpoint later.
             if (!foundError) {
                 if (prev > curr) {
                     System.out.println("Found error: " + prev + " " + curr);
                     foundError = true;
                     max = curr;
                     for (int j = i - 1; j >= 0; j--) {
                         int check = Integer.parseInt(args[j]);
                         if (curr >= check) {
                             if (start == -1 || j <= start) {
                                 System.out.println("Setting start at " + j + " " + curr + " " + check);
                                 start = j + 1;
                                 break;
                             }
                         }
                         max = Math.max(check, max);
                     }

                     if (start == -1)
                        start = 0;
                 }
             }
             // step 2: look for a point to stop where the max is less then the
             //     current value. Then move to step 3
             else {
                if (curr >= max) {
                    System.out.println("Setting end at " + i);
                    end = i - 1;
                    foundError = false;
                }
             }

             prev = curr;
         }

         if (end == -1 && start != -1)
             System.out.println("( " + start + ", " + (args.length - 1) + " )");
         else if ( end == -1 && start == -1)
            System.out.println("Array already sorted!");
         else
            System.out.println("( " + start + ", " + end + " )");
     }
 }
