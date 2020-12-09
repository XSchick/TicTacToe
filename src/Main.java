import edu.kit.informatik.Terminal;

/**
 * @version 1.1
 * @xschick
 */
public class Main {
    String[] gameBoard = new String[9];
    int[] gameplay = new int[9];

    public static void main(String[] args) {
        new Main(args);
    }

    public Main(String[] args) {
        String winner = null;
        inputGameplay(args);
        for (int i = 0; i < this.gameplay.length; i++) {
            playMove(i);
        }

    }

    public int[] inputGameplay(String[] args) {
        for (int i = 0; i < args.length; i++) {
            this.gameplay[i] = Integer.parseInt(args[i]);
        }
        return gameplay;

    }

    public void playMove(int m) {
        if (((m + 1) % 2) != 0) {
            gameBoard[gameplay[m]] = "X";
        }
        if (((m + 1) % 2) == 0) {
            gameBoard[gameplay[m]] = "O";
        }

    }
}
