import java.util.Random;

/*
 * (17.20) Continuous Median: Number are ranomly generated and passed to a
 * method. Write a program to find and maintain the median value as new values
 * are generated.
 *
 * Plan: create a binary tree of sorts where the root element is the middle. If
 * it is a tree with no middle, it is the lower of the two values. Save length
 * so that if it is even you can average the value
 */
public class ContinuousMedian {

    public class Tree {
        public int num;
        public int numLeft;
        public int numRight;
        public Node mid;

        public Tree() {
            this.num = 0;
            this.numLeft = 0;
            this.numRight = 0;
        }

        public double getMedian() {
            System.out.println("Head " + this.mid.value);
            if (num % 2 == 0) {
                int secondValue = (this.numLeft > this.numRight) ? mid.left.value : mid.right.value;
                return (mid.value + secondValue) / 2.0;
            }
            else
                return new Double(mid.value);
        }

        public void insertNode(Node n) {
            this.num++;
            if (this.num != 1) {
                Node prev = new Node();
                Node curr = this.mid;
                boolean addedLeft = n.value < this.mid.value;
                int i = 0;
                while (curr != null) {
                    System.out.println("asdf" + curr.value);
                    i++;
                    if (i == 5)
                        break;
                    prev = curr;
                    curr = (n.value < curr.value) ? curr.left : curr.right;
                }

                if (n.value < prev.value)
                    prev.left = n;
                else
                    prev.right = n;

                this.rebalance(addedLeft);
            }
            else {
                this.mid = n;
            }
        }

        private void rebalance(boolean addedLeft) {
            System.out.println("asdf");
            if (addedLeft) {
                this.numRight++;
                Node newMiddleOldParent = new Node();
                boolean foundParent = false;
                Node newMiddle = this.mid.left;
                if (newMiddle != null) {
                    // go left off of mid one, then go as deep right as you can
                    // save last node as new middle
                    while (newMiddle.right != null) {
                        System.out.println("a");
                        foundParent = true;
                        newMiddleOldParent = newMiddle;
                        newMiddle = newMiddle.right;
                    }

                    // save new middle's old left side to replace new middle's old location
                    // set new middle's right side as root + right of root
                    // set new middle's left side as old root's left side
                    if (foundParent)
                        newMiddleOldParent.right = newMiddle.left;
                    newMiddle.right = this.mid;
                    newMiddle.left = this.mid.left;
                    this.mid.left = null;
                    this.mid = newMiddle;
                }
                else {
                    System.out.println("here 1");
                }

            }
            else {
                this.numLeft++;
                Node newMiddleOldParent = new Node();
                boolean foundParent = false;
                Node newMiddle = this.mid.right;
                if (newMiddle != null) {
                    while (newMiddle.left != null) {
                        System.out.println("b");
                        foundParent = true;
                        newMiddleOldParent = newMiddle;
                        newMiddle = newMiddle.left;
                    }

                    if (foundParent)
                        newMiddleOldParent.left = newMiddle.right;
                    newMiddle.left = this.mid;
                    newMiddle.right = this.mid.right;
                    this.mid.right = null;
                    this.mid = newMiddle;
                }
                else {
                    System.out.println("here 2");
                }
            }
        }
    }


    public class Node {
        public Node left;
        public Node right;
        public int value ;

        public Node(int val) {
            this.value = val;
        }

        public Node() {

        }
    }

    public static void main(String args[]) {
        ContinuousMedian m = new ContinuousMedian();
        m.start(args);
    }

    public void start(String args[]) {
        Tree main = new Tree();
        int n = Integer.parseInt(args[0]);
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int num = r.nextInt(1000) + 1;
            System.out.println("Added: " + num);
            main.insertNode(new Node(num));
            System.out.println("New Median: " + main.getMedian());
        }
    }

}
