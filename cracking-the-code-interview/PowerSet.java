import java.util.ArrayList;
import java.util.List;

/*
 * (8.4) Power Set: write a method to return all subsets of a set
 *
 */
public class PowerSet {
    public static void main(String[] args) {
        // represents the various lenghts
        List<List<String>> powerSet = new ArrayList<>();
        List<String> first = new ArrayList<>();
        first.add(args[0]);
        powerSet.add(first);
        for (int i = 1; i < args.length; i++) {
            powerSet = pset(powerSet, args[i]);
        }
        printSet(powerSet);
    }

    // given a power set and an element, creates a new power set that includes that item
    public static List<List<String>> pset(List<List<String>> set, String item) {
        List<List<String>> newSet = new ArrayList<>();

        // add just single element
        List<String> single =  new ArrayList<>();
        single.add(item);
        newSet.add(single);

        // go through power set and add each set to our power set and all so add each set + the item
        for (int i = 0; i < set.size(); i++) {
            newSet.add(set.get(i));
            ArrayList<String> newSubList = new ArrayList<>(set.get(i));
            newSubList.add(item);
            newSet.add(newSubList);
        }

        return newSet;
    }

    public static void printSet(List<List<String>> set) {
        System.out.println("{}");
        for (int i = 0; i < set.size(); i++) {
            List<String> curr = set.get(i);
            System.out.print("{ ");
            for (int j = 0; j < curr.size(); j++) {
                System.out.print(curr.get(j) + " ");
            }
            System.out.println("}");
        }
    }
}
