public class Game {
    public static void main(String[] args) throws Exception {
        Grid ticTacToe = new Grid();
        Input playerInput = new Input(ticTacToe);
        boolean start = true;

        while (true) {
            if (start) {
                ticTacToe.displayGrid();
                start = !start;
            }
            
            if (!ticTacToe.isGameOver()) {
                playerInput.inputCoord(ticTacToe.getPlayer());
                if (!playerInput.getIsError()) {
                    ticTacToe.play(playerInput.getX(), playerInput.getY());
                }
            } else {
                if (ticTacToe.isDiagonal() || ticTacToe.isVertical() || ticTacToe.isHorizontal()) {
                    System.out.println(ticTacToe.playerToString() + " won with a " + (ticTacToe.isVertical() ? "vertical " : "")  + (ticTacToe.isHorizontal() ? "horizontal " : "")  + (ticTacToe.isDiagonal() ? "diagonal " : "")  + "win! Congrats " + ticTacToe.playerToString() + "!");
                } else {
                    System.out.println("No one won the game :(");
                }
                playerInput.askForReset();
                if (!ticTacToe.isGameOver()) {
                    start = !start;
                }
            }
        }
    }
}
