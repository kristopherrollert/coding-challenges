import java.util.Random;

/*
 * (17.2) Shuffle: Write a method to shuffle a deck of cards. It must be a
 * perfect shuffle - in other words, each of the 52! permutations of the deck
 * has to be equally likely. Assume that you are given a random numner generator
 * which is perfect.
 */
public class Shuffle {
    public static void main(String args[]) {
        String[] deck = {"HEART-A", "HEART-2", "HEART-3", "HEART-4", "HEART-5",
                         "HEART-6", "HEART-7", "HEART-8", "HEART-9", "HEART-10",
                         "HEART-J", "HEART-Q", "HEART-K", "SPADE-A", "SPADE-2",
                         "SPADE-3", "SPADE-4", "SPADE-5", "SPADE-6", "SPADE-7",
                         "SPADE-8", "SPADE-9", "SPADE-10", "SPADE-J", "SPADE-Q",
                         "SPADE-K", "CLUB-A", "CLUB-2", "CLUB-3", "CLUB-4",
                         "CLUB-5", "CLUB-6", "CLUB-7", "CLUB-8", "CLUB-9",
                         "CLUB-10", "CLUB-J", "CLUB-Q", "CLUB-K", "DIAMOND-A",
                         "DIAMOND-2", "DIAMOND-3", "DIAMOND-4", "DIAMOND-5",
                         "DIAMOND-6", "DIAMOND-7", "DIAMOND-8", "DIAMOND-9",
                         "DIAMOND-10", "DIAMOND-J", "DIAMOND-Q", "DIAMOND-K"};

        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int n = rand.nextInt(52);
            int m = rand.nextInt(52);
            String temp = deck[n];
            deck[n] = deck[m];
            deck[m] = temp;
        }

        for (String card: deck)
            System.out.println(card);
    }
}
