import java.util.Stack;

/**
 * Colgate University COSC 290 Labs
 * Version 0.1,  2017
 *
 * @author Michael Hay
 */
public class AlgorithmAnalysis {

    /**
     * Populates double array B so that B[i][j] stores the sum of all elements in array A from index i to j.
     * Formally, B[i][j] = \sum_{k=i}^j A[j]
     * @param A the array on which to compute interval sums
     * @param B the double array into which interval sums will be stored
     * @return the number of times array A was accessed
     */
    public static long intervalSums(int[] A, int[][] B) {
        long count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += A[k];
                    count += 1;
                }
                B[i][j] = sum;
                if (j > i) B[j][i] = -1;  // fill the lower "triangle" of B with -1s
            }
        }
        return count;
    }

    /**
     * More efficient version of {@link #intervalSums(int[], int[][])}
     * @param A the array on which to compute interval sums
     * @param B the double array into which interval sums will be stored
     * @return the number of times array A was accessed
     */
    public static void intervalSumsEfficient(int[] A, int[][] B) {
        throw new UnsupportedOperationException("implement me!");
    }

    /**
     * Given a set X of positive integers and a target integer T, this method checks whether there is a subset of
     * elements in X that add up to exactly T.
     * @param X a set of positive integers (represented as a stack)
     * @param T a target integer value
     * @return
     */
    public static boolean subsetSums(Stack<Integer> X, int T) {
        if (T == 0) {
            return true;
        }
        if (X.isEmpty()) {
            return false;
        }
        Integer x = X.pop();
        boolean case1 = subsetSums(X, T);
        boolean case2 = subsetSums(X, T - x);
        X.push(x);   // why is this line important?  hint: it should factor into your proof
        return case1 || case2;
    }

    public static void main(String[] args) {
        int[] sizes = new int[]{32, 64, 128, 256, 512, 1024, 2048, 4096};
        long[] counts = new long[sizes.length];
        // implement an experiment here
    }
}
