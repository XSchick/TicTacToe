import edu.kit.informatik.Terminal;

/**
 * @version 1.1
 * @xschick
 */
public class Main {
    int[] gameBoard = new int[9];
    int[] gameplay = new int[9];

    public static void main(String[] args) {
        new Main(args);
    }

    public Main(String[] args) {
        inputGameplay(args);

    }

    public int[] inputGameplay(String[] args) {
        for (int i = 0; i < args.length; i++) {
            this.gameplay[i] = Integer.parseInt(args[i]);
        }
        return gameplay;

    }

    public void playMove() {

    }
}
