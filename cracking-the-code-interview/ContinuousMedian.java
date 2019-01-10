import java.util.Random;

/*
 * (17.20) Continuous Median: Number are ranomly generated and passed to a
 * method. Write a program to find and maintain the median value as new values
 * are generated.
 */

 // go left off of mid one, then go as deep right as you can
 // save last node as new middle
 // save new middle's old left side to replace new middle's old location
 // set new middle's right side as root + right of root
 // set new middle's left side as old root's left side
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

        public void printTree(Node n) {

            if (n.left == null && n.right == null)
                System.out.println(n.value + " is a leaf node");
            else {
                System.out.print("Node " + n.value);
                if (n.left != null)
                    System.out.print(" has left node " +  n.left.value);
                if (n.right != null)
                    System.out.print(" has right node " + n.right.value);

                System.out.println("");
                if (n.left != null)
                    printTree(n.left);
                if (n.right != null)
                    printTree(n.right);
            }
        }

        public double getMedian() {
            // System.out.println("TREE:");
            // System.out.println("num left: " + this.numLeft + " num right: " + this.numRight);
            // printTree(this.mid);
            if (num % 2 == 0) {
                int secondValue;
                if (this.numLeft > this.numRight) {
                    Node prev = mid.left;
                    Node curr = mid.left.right;
                    while (curr != null) {
                        prev = curr;
                        curr = curr.right;
                    }
                    secondValue = prev.value;
                }
                else {
                    Node prev = mid.right;
                    Node curr = mid.right.left;
                    while (curr != null) {
                        prev = curr;
                        curr = curr.left;
                    }
                    secondValue = prev.value;
                }
                return (mid.value + secondValue) / 2.0;
            }
            else
                return new Double(mid.value);
        }

        public void insertNode(Node n) {
            this.num++;
            if (this.num == 1)
                this.mid = n;
            else {
                Node prev = new Node();
                Node curr = this.mid;
                boolean addedLeft = n.value < this.mid.value;

                while (curr != null) {
                    prev = curr;
                    curr = (n.value < curr.value) ? curr.left : curr.right;
                }

                if (n.value < prev.value) prev.left = n;
                else prev.right = n;

                if (addedLeft) this.numLeft++;
                else this.numRight++;

                if (this.numRight > this.numLeft + 1 || this.numLeft > this.numRight + 1)
                    this.rebalance(addedLeft);
            }
        }

        private void rebalance(boolean addedLeft) {
            Node newMiddleOldParent = new Node();
            boolean foundParent = false;

            if (addedLeft) {
                Node newMiddle = this.mid.left;
                this.numLeft--;
                this.numRight++;

                while (newMiddle.right != null) {
                    foundParent = true;
                    newMiddleOldParent = newMiddle;
                    newMiddle = newMiddle.right;
                }


                if (foundParent)
                    newMiddleOldParent.right = newMiddle.left;
                newMiddle.right = this.mid;
                newMiddle.left = (this.mid.left != newMiddle) ? this.mid.left : newMiddle.left;
                this.mid.left = null;
                this.mid = newMiddle;
            }
            else {
                Node newMiddle = this.mid.right;
                this.numRight--;
                this.numLeft++;
                while (newMiddle.left != null) {
                    foundParent = true;
                    newMiddleOldParent = newMiddle;
                    newMiddle = newMiddle.left;
                }

                if (foundParent)
                    newMiddleOldParent.left = newMiddle.right;
                newMiddle.left = this.mid;
                newMiddle.right = (this.mid.right != newMiddle) ? this.mid.right : newMiddle.right;
                this.mid.right = null;
                this.mid = newMiddle;
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
        int[] arr = {196, 590, 859, 897, 31, 557, 782, 570, 819, 648};
        // for (int i = 0; i < n; i++) {
        for (int num : arr) {
            // int num = r.nextInt(1000) + 1;
            System.out.println("Added: " + num);
            main.insertNode(new Node(num));
            System.out.println("New Median: " + main.getMedian());
        }
    }

}
