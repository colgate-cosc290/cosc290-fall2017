import java.util.HashSet;
import java.util.Set;

/**
 * Colgate University COSC 290 Labs
 * Version 0.1,  2017
 *
 * @author Michael Hay
 */
public class BoardCounting {


    /**
     * Counts the number of empty boards
     * @return the number of empty boards
     */
    public static int allEmptyBoards() {
        Set<Board> emptyBoards = new HashSet<>();
        emptyBoards.add(new Board());
        return emptyBoards.size();
    }

    public static void main(String[] args) {
        // example: please delete this code before turning it in
        System.out.println("Problem 9.9999: the number of empty boards is: " + allEmptyBoards());
        // write appropriate calls to your methods here
    }
}
