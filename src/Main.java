import edu.kit.informatik.*;

/**
 * @author xschick
 * @version 1.2
 */
public final class Main {
    private String[] gameBoard = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
    private int[] gameplay = new int[9];

    /**
     * Constructor
     *
     * @param args the gameplay
     */
    private Main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            this.gameplay[i] = Integer.parseInt(args[i]);
        }
    }

    /**
     * This method calls the playMove() method for every play move
     * and calls checkWin() to check the field for a win
     */
    public void game() {
        String actualPlayer;
        String winner = null;
        int moveNumber = 0;
        for (int i = 0; i < this.gameplay.length; i++) {
            actualPlayer = playMove(i);
            if (checkWin()) {
                winner = actualPlayer;
                if (moveNumber == 0) {
                    moveNumber = i + 1;
                }
                break;
            }
        }
        Terminal.printLine(winner + " wins " + moveNumber);
    }

    /**
     * This method tests which player is to move and sets his symbol
     * in the right place on the playing field.
     * It also returns the actual player.
     *
     * @param m the move number
     * @return the actual player
     */
    private String playMove(int m) {
        if (((m + 1) % 2) != 0) {
            gameBoard[this.gameplay[m]] = "X";
            return "P1";
        }
        if (((m + 1) % 2) == 0) {
            gameBoard[this.gameplay[m]] = "O";
            return "P2";
        }
        return "undefined";
    }

    /**
     * Testing if one player has won
     *
     * @return true if one player won a row, column or diagonal
     */
    private boolean checkWin() {
        return (checkColumnsForWin() || checkDiagonalForWin() || checkRowsForWin());
    }

    /**
     * Testing all 3 columns for a win
     *
     * @return true if one player wins a row
     */
    private boolean checkRowsForWin() {
        for (int i = 0; i < 7; i += 3)
            if (checkRowsAndColumns(gameBoard[i], gameBoard[i + 1], gameBoard[i + 2])) {
                return true;
            }
        return false;
    }

    /**
     * Testing all 3 columns for a win
     *
     * @return true if one player wins a column
     */
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++)
            if (checkRowsAndColumns(gameBoard[i], gameBoard[i + 3], gameBoard[i + 6])) {
                return true;
            }
        return false;
    }

    /**
     * Testing the diagonals for a win
     *
     * @return true if one player wins one of the diagonals
     */
    private boolean checkDiagonalForWin() {
        boolean diaLeft = checkRowsAndColumns(gameBoard[0], gameBoard[4], gameBoard[8]);
        boolean diaRight = checkRowsAndColumns(gameBoard[2], gameBoard[4], gameBoard[6]);
        return diaLeft || diaRight;
    }

    /**
     * Testing whether all 3 symbols (X or O) in a row and column are equal
     *
     * @param f1 first field in a row or column
     * @param f2 second field in a row or column
     * @param f3 third field in a row or column
     * @return true if all three symbols are equal, false if not
     */
    private boolean checkRowsAndColumns(String f1, String f2, String f3) {
        return (((!f1.equals("-")) || (!f2.equals("-")) || (!f3.equals("-"))) && (f1.equals(f2)) && (f2.equals(f3)));
    }

    /**
     * Main method creates new object
     *
     * @param args the movement numbers
     */
    public static void main(String[] args) {
        Main newGame = new Main(args);
        newGame.game();
    }
}
