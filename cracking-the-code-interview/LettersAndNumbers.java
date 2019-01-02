import java.util.HashMap;

/*
 * (17.5) Letters and Numbers: Given an array filled with letters and numbers,
 * find the longest subarray with an equal number of letters and numbers.
 */
public class LettersAndNumbers {
    public static void main(String[] args) {
        // maps height to index
        HashMap<Integer, Integer> h = new HashMap<>();
        int start = -1;
        int end = -1;
        int maxLength = 0;

        int[] tally = new int[args.length + 1];
        tally[0] = 0;
        h.put(0 , 0);

        for (int i = 0; i < args.length; i++) {
            int change = isLetter(args[i]) ? 1 : -1;
            tally[i + 1] = tally[i] + change;
            if (!h.containsKey(tally[i + 1]))
                h.put(tally[i + 1], i + 1);
            else if (maxLength < (i - h.get(tally[i + 1])) ) {
                maxLength = i - h.get(tally[i + 1]) + 1;
                start = h.get(tally[i + 1]);
                end = i;
            }
        }
        if (maxLength != 0)
            System.out.println("The longest subarray is from " + start + " to " + end  + " with distance " + maxLength);
        else
            System.out.println("No equal subarray found!");
    }

    public static boolean isLetter(String l) {
        return Character.isLetter(l.charAt(0));
    }
}
