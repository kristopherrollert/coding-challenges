/*
 * (17.20) Continuous Median: Number are ranomly generated and passed to a
 * method. Write a program to find and maintain the median value as new values
 * are generated.
 */
public class ContinuousMedian {

    private ArrayList<Integers> list = new ArrayList<Integer>();

    public static void main(String args[]) {
        for (int i = 0; i < args.length; i++) {

        }

    }

    public void addValue(int val) {
        this.binarySearch(0, list.length - 1, val);
    }

    private void binarySearch(int low, int high, int value) {

    }

    public int getMedian() {
        if (this.list.length % 2 == 0)
            return (this.list[this.list.length / 2];
        else
            return (this.list[this.list.length / 2]) + (this.list[this.list.length / 2 + 1]) / 2;
    }
}
