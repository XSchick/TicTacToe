/**
 * @author xschick
 * @version 1.2
 */
public final class Main {
    private String[] gameBoard = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
    private int[] gameplay = new int[9];

    private Main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            this.gameplay[i] = Integer.parseInt(args[i]);
        }
    }

    public void game() {
        String latestPlayer;
        String winner = null;
        int moveNumber = 0;
        for (int i = 0; i < this.gameplay.length; i++) {
            latestPlayer = playMove(i);
            if (checkWin()) {
                winner = latestPlayer;
                if (moveNumber == 0) {
                    moveNumber = i + 1;
                }
            }
        }
        System.out.println(winner + " wins " + moveNumber);
    }

    public String playMove(int m) {
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

    private boolean checkWin() {
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
        return diaLeft || diaRight;
    }

    private boolean checkRowsAndColumns(String f1, String f2, String f3) {
        return (((f1 != "-") || (f2 != "-") || (f3 != "-")) && (f1 == f2) && (f2 == f3));
    }

    public static void main(String[] args) {
        Main newGame = new Main(args);
        newGame.game();
    }
}
