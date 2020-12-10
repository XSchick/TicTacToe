import edu.kit.informatik.Terminal;

/**
 * @author xschick
 * @version 1.1
 */
public class Main {
    String[] gameBoard = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
    int[] gameplay = new int[9];

    public static void main(String[] args) {
        new Main(args);
    }

    public Main(String[] args) {
        String latestPlayer;
        String winner = null;
        int playMoveNumber = 0;

        inputGameplay(args);
        for (int i = 0; i < this.gameplay.length; i++) {
            latestPlayer = playMove(i);
            System.out.println(i);
            if (checkWin()) {
                winner = latestPlayer;
                playMoveNumber = i + 1;

            }
        }
        System.out.println(winner + " wins " + playMoveNumber);
    }

    private boolean checkWin() {
        System.out.println("colums: " + checkColumnsForWin());
        System.out.println("rows: " + checkRowsForWin());
        System.out.println("diagonal: " + checkDiagonalForWin());
        return (checkColumnsForWin() || checkDiagonalForWin() || checkRowsForWin());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++)
            if (checkRowsAndColumns(gameBoard[i], gameBoard[i + 1], gameBoard[i + 2])) {
                return true;
            }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++)
            if (checkRowsAndColumns(gameBoard[i], gameBoard[i + 3], gameBoard[i + 6])) {
                return true;
            }
        return false;
    }

    private boolean checkDiagonalForWin() {
        boolean diaLeft = checkRowsAndColumns(gameBoard[0], gameBoard[4], gameBoard[8]);
        boolean diaRight = checkRowsAndColumns(gameBoard[2], gameBoard[4], gameBoard[6]);
        if (diaLeft || diaRight) {
            return true;
        }
        return false;
    }

    private boolean checkRowsAndColumns(String f1, String f2, String f3) {
        return (((f1 != "-") || (f2 != "-") || (f3 != "-")) && (f1 == f2) && (f2 == f3));
    }

    private int[] inputGameplay(String[] args) {
        for (int i = 0; i < args.length; i++) {
            this.gameplay[i] = Integer.parseInt(args[i]);
        }
        return gameplay;

    }

    public String playMove(int m) {
        String actualPlayer;
        if (((m + 1) % 2) != 0) {
            gameBoard[gameplay[m]] = "X";
            return actualPlayer = "P1";
        }
        if (((m + 1) % 2) == 0) {
            gameBoard[gameplay[m]] = "O";
            return actualPlayer = "P2";
        }
        return actualPlayer = "undefined";
    }
}
