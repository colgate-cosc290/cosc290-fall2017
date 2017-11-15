/**
 * Colgate University COSC 290 Labs
 * Version 0.1,  2017
 *
 * @author Michael Hay
 */
public class Board {
    private Mark[][] board;
    private final int n;

    /**
     * Helper class to represent valid marks on board
     */
    public enum Mark {
        X("X"), O("O"), BLANK(" ");

        private final String mark;

        Mark(String s) {
            mark = s;
        }
        @Override
        public String toString() {
            return mark;
        }
        public static Mark getMark(char s) {
            if ((s == 'X') || (s =='x')) {
                return X;
            } else if ((s =='O') || (s =='o')) {
                return O;
            } else {
                return BLANK;
            }
        }
    }

    /**
     * Initialize an empty 3x3 board
     */
    public Board() {
        n = 3;
        board = new Mark[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * Build a 3x3 board from a string, see example in main method below
     * @param boardStr string representation of a board
     */
    public Board(String boardStr) {
        this();
        boardStr = boardStr.replaceAll("\\|", "");
        assert boardStr.length() == 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i*n + j;
                Mark mark = Mark.getMark(boardStr.charAt(idx));
                board[i][j] = mark;
            }
        }
    }

    /**
     * Returns a new board that is a copy of this board
     * @return copy of this board
     */
    public Board copy() {
        Board copy = new Board();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy.board[i][j] = board[i][j];
            }
        }
        return copy;
    }

    /**
     * Return size of board (number of rows)
     * @return size of board
     */
    public int size() {
        return n;
    }

    /**
     * Place given mark at given (row,column)
     * @param row row to place mark (0 <= row < n)
     * @param col column to place mark (0 <= col < n)
     * @param mark mark to place (X, O or Blank)
     * @throws RuntimeException for invalid row/col or if placing mark in a fill space
     */
    public void placeMark(int row, int col, Mark mark) {
        checkRowAndCol(row, col);
        if (!board[row][col].equals(Mark.BLANK)) {
            throw new RuntimeException("Cannot place mark on occupied space!");
        }
        board[row][col] = mark;
    }

    private void checkRowAndCol(int row, int col) {
        if ((row < 0 || row >= n) || (col < 0 || col >= n)) {
            throw new RuntimeException("Invalid row/column");
        }
    }

    /**
     * Returns true if the given row/col is open (has a blank)
     * @param row desired row
     * @param col desired column
     * @return true if the given row/col is open (has a blank)
     */
    public boolean isOpen(int row, int col) {
        checkRowAndCol(row, col);
        return board[row][col].equals(Mark.BLANK);
    }

    /**
     * Returns true if every square has been filled
     * @return true if every square has been filled, false otherwise.
     */
    public boolean isFull() {
        for (Mark[] marks : board) {
            for (Mark mark : marks) {
                if (mark.equals(Mark.BLANK)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns true if there is a winner, false otherwise.
     * @return true if there is a winner, false otherwise.
     */
    public boolean hasWinner() {
        for (int i = 0; i < n; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }
        return checkDiagonals();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(" ").append(board[i][j]).append(" ");
                if (j < n - 1) {
                    sb.append("|");
                }
            }
            sb.append("\n");
            if (i < n - 1) {
                for (int j = 0; j < n; j++) {
                    sb.append("---");
                    if (j < n - 1) {
                        sb.append("+");
                    }
                }
                sb.append("\n");
            }
        }
        return sb.substring(0,sb.length()-1);  // drop last newline
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Board)) {
            return false;
        }
        Board otherBoard = (Board) obj;
        if (this.n != otherBoard.n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!board[i][j].equals(otherBoard.board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();  // being a little lazy here
    }


    // ------------------------------------------------------
    //            PRIVATE HELPER METHODS
    // ------------------------------------------------------
    private boolean checkRow(int i) {
        Mark first = board[i][0];
        if (first.equals(Mark.BLANK)) {
            return false;
        }
        for (int j = 1; j < n; j++) {
            if (!board[i][j].equals(first)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int j) {
        Mark first = board[0][j];
        if (first.equals(Mark.BLANK)) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (!board[i][j].equals(first)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals() {
        return checkFirstDiagonal() || checkSecondDiagonal();
    }

    private boolean checkSecondDiagonal() {
        Mark first;
        first = board[n-1][0];
        if (first.equals(Mark.BLANK)) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (!board[n-1-i][i].equals(first)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFirstDiagonal() {
        Mark first = board[0][0];
        if (first.equals(Mark.BLANK)) {
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (!board[i][i].equals(first)) {
                return false;
            }
        }
        return true;
    }

    // ------------------------------------------------------
    //            MAIN
    // ------------------------------------------------------
    public static void main(String[] args) {
        Board b = new Board("X  | OX|OXO");
        System.out.println(b);
    }
}
