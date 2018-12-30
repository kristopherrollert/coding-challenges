/*
 * (16.3) Intersection: Given two straight line segments (represented as a start
 * point and an end point), compute the point of intersection, if any.
 * Notes: fails for vertical lines. Complex solution would be using sin/cos to
 * rotate in the case where there is a vertical line. 
 */
public class Intersection {
    public static void main (String[] args) {
        double l1_x1 = Double.parseDouble(args[0]);
        double l1_y1 = Double.parseDouble(args[1]);
        double l1_x2 = Double.parseDouble(args[2]);
        double l1_y2 = Double.parseDouble(args[3]);

        double l2_x1 = Double.parseDouble(args[4]);
        double l2_y1 = Double.parseDouble(args[5]);
        double l2_x2 = Double.parseDouble(args[6]);
        double l2_y2 = Double.parseDouble(args[7]);

        // calculate slope
        double l1_slope = (l1_y2 - l1_y1) / (l1_x2 - l1_x1);
        double l2_slope = (l2_y2 - l2_y1) / (l2_x2 - l2_x1);

        // calculate y intercept
        double l1_yInter = l1_y1 - (l1_slope * l1_x1);
        double l2_yInter = l2_y1 - (l2_slope * l2_x1);

        // find the possible solution's y value
        double x_sol = (l2_yInter - l1_yInter) / (l1_slope - l2_slope);
        double possible_y1 = x_sol * l1_slope + l1_yInter;
        double possible_y2 = x_sol * l2_slope + l2_yInter;

        // if they produce the same y value for the x sol, then there is a
        // solution for an infinite line
        if (possible_y1 == possible_y2) {
            // check if in range
            boolean ifInLine1 = Math.max(l1_x1, l1_x2) >= x_sol
                                && Math.min(l1_x1, l1_x2) <= x_sol
                                && Math.max(l1_y1, l1_y2) >= possible_y1
                                && Math.min(l1_y1, l1_y2) <= possible_y1;
            boolean ifInLine2 = Math.max(l2_x1, l2_x2) >= x_sol
                                && Math.min(l2_x1, l2_x2) <= x_sol
                                && Math.max(l2_y1, l2_y2) >= possible_y1
                                && Math.min(l2_y1, l2_y2) <= possible_y1;
            if (ifInLine1 && ifInLine2)
                System.out.println("( " + x_sol + ", " + possible_y1 + " )" );
            else
                System.out.println("No point of intersection in range");

        }
        else {
            System.out.println("No point of intersection.");
        }
    }
}
