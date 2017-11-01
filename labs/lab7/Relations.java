import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Colgate University COSC 290 Labs
 * Version 0.1,  2017
 *
 * @author Michael Hay
 */
public class Relations {

    /**
     * Returns composition of R and S.  Return relation T such that if (i, j) in R and (j, k) in S then (i, k) in T.
     * @param S relation, represented as a matrix (double array)
     * @param R relation, represented as a matrix (double array)
     * @return S composed with R
     */
    public static boolean[][] compose(boolean[][] R, boolean[][] S) {
        // compare matrix sizes and make sure they agree: if R is n1 x n2 then S should be n2 x n3.
        int n1 = R.length;
        int n3 = S.length;
        if (n1 == 0 || n3 == 0) throw new UnsupportedOperationException("expecting non-empty arrays!");
        int n2 = R[0].length;
        int n4 = S[0].length;
        if (n2 == 0 || n4 == 0) throw new UnsupportedOperationException("expecting non-empty arrays!");
        if (n2 != n3) throw new UnsupportedOperationException("Number of columns of R must match number of rows of S");

        throw new UnsupportedOperationException("implement me!");
    }

    /**
     * Returns union of R and S.  Return relation T such that (i, j) in T if (i, j) in R or (i, j) in S.
     * @param R relation, represented as a matrix (double array)
     * @param S relation, represented as a matrix (double array)
     * @return
     */
    public static boolean[][] union(boolean[][] R, boolean[][] S) {
        // compare matrix sizes and make sure they agree: if R is n1 x n2 then S should be n1 x n2.
        int n1 = R.length;
        int n3 = S.length;
        if (n1 == 0 || n3 == 0) throw new UnsupportedOperationException("expecting non-empty arrays!");
        int n2 = R[0].length;
        int n4 = S[0].length;
        if (n1 != n3 || n2 != n4) throw new UnsupportedOperationException("array dimensions must match!");

        throw new UnsupportedOperationException("implement me!");
    }

    public static boolean[][] transitiveClosure(boolean[][] R) {
        int n = R.length;
        if (R[0].length != n) throw new UnsupportedOperationException("expecting an n by n boolean array!");
        boolean[][] Rplus = new boolean[n][n];
        // your code goes here
        return null;  // replace this line
    }

    /**
     * A class for computing Warshall W_k relations for k=0...n-1.
     */
    public static class Warshall {
        // you should probably initialize some private fields here (e.g., W_k and k)

        /**
         * Initialize W_0 with relation R by making a *copy* of R.
         * @param R relation with which to initialize Warshall relation.
         */
        public Warshall(boolean[][] R) {
            throw new UnsupportedOperationException("implement me!");
        }

        /**
         * Whether there is another Warshall relation W_{k+1} after current Warshall relation W_{k}
         * @return true if there is another relation
         */
        public boolean hasNext() {
            throw new UnsupportedOperationException("implement me!");
        };

        /**
         * Generate the next Warshall relation W_{k+1}.  Note this method should produce W_{k+1} by updating W_k as
         * opposed to generating a new matrix.
         * @return a reference to W_{k+1}
         */
        public boolean[][] next() {
            throw new UnsupportedOperationException("implement me!");
        }
    }

    public static boolean[][] transitiveClosureW(boolean[][] R) {
        int n = R.length;
        if (R[0].length != n) throw new UnsupportedOperationException("expecting an n by n boolean array!");
        boolean[][] Rplus = new boolean[n][n];
        // your code goes here
        return null;  // replace this line
    }

    /**
     * Compare the runtimes of the two methods for transitive closure.  {@see System#currentTimeMillis()}
     * @param args
     */
    public static void main(String[] args) {
        throw new UnsupportedOperationException("implement me!");
    }

    /**
     * Returns a relation R where adjacent pairs are related.  In other words, for all i between 0 and n-1, we have (i,
     * i+1) in R or equivalently R[i][i+1] = true.
     * @param n size of relation
     * @return relation R
     */
    public static boolean[][] makeChain(int n) {
        boolean[][] R = new boolean[n][n];
        for (int i = 0; i < R.length-1; i++) {
            R[i][i+1] = true;
        }
        return R;
    }

}
