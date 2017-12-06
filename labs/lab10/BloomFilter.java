import java.util.ArrayList;
import java.util.List;

/**
 * Colgate University COSC 290 Labs
 * Version 0.1,  2017
 *
 * @author Michael Hay
 */
public class BloomFilter<E> {

    private final int k;  // number of hash functions
    private final int m;  // size of each hash array

    public BloomFilter(int k, int m) {
        this.k = k;
        this.m = m;
        // you may want to initialize some private fields here
    }

    public boolean lookUp(E item) {
        throw new UnsupportedOperationException("implement me!");
    }

    public void insert(E item) {
        throw new UnsupportedOperationException("implement me!");
    }

    public static void main(String[] args) {
        // complete the necessary experiment for 10.104 here; please write up your findings in markdown
    }

}
