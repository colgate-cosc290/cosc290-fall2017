import java.util.Random;

/**
 * Colgate University COSC 290 Labs
 * Version 0.1,  2017
 *
 * @author Michael Hay
 */
public class HashFunction<E> {
    private final static int CAPACITY = 2000000;
    private final int[] h;

    /**
     * Creates a hash function parameterized by i.  Function will hash objects to integers in 0..m-1.
     * @param i index of this hash function
     * @param m upper bound on hash value: items will be hashed to 0..m-1
     */
    public HashFunction(int i, int m) {
        Random random = new Random(i);
        h = random.ints(CAPACITY, 0, m).toArray();
    }

    /**
     * Return a hash value for given item.
     * @param item item to be hashed
     * @return a hash value between 0 and m-1
     */
    public int hash(E item) {
        return hash(Math.abs(item.hashCode()) % CAPACITY);
    }

    private int hash(int value) {
        if (value < 0 || value > h.length) {
            throw new UnsupportedOperationException("Unexpected value: can only hash integers between 0 and " +
                    "CAPACITY-1");
        }
        return h[value];
    }
}
