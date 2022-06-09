import java.util.Scanner;

public class Input {
    Scanner coordScanner;
    Scanner askForReset;

    Grid game;

    private int x;
    private int y;

    private String coord;
    private boolean isError;

    public Input(Grid game) {
        coordScanner = new Scanner(System.in);
        askForReset = new Scanner(System.in);
        this.game = game;
    }

    public void inputCoord(Turn player) {
        System.out.println("It is " + ((player == Turn.PLAYER1) ? "Player 1" : "Player2") + "'s turn.\n" + "Input a coordinate (ex: x,y): ");
        coord = coordScanner.nextLine();
        int indexComma = coord.indexOf(",");
        if (indexComma != -1) {
            try {
                x = Integer.parseInt(coord.substring(0, indexComma));
                y = Integer.parseInt(coord.substring(indexComma + 1, indexComma + 2));
                isError = false;
            } catch(StringIndexOutOfBoundsException|NumberFormatException e) {
                System.out.println("Error: invalid coordinate was entered because you did not insert a number. Please try again.\n");
                isError = true;
            }   
        } else {
            System.out.println("Invalid input: Input the x coordinate followed by a comma and the y coordinate [ex: (2,3)].\n");
        }
    }

    public void askForReset() {
        System.out.println("The game has ended. Would you like to play again? (y or n)");
        String reset = askForReset.nextLine();
        if (reset.equals("y")) {
            System.out.println("\nThe game is resetting!");
            game.resetGame();
        } else {
            System.out.println("Goodbye, hope you two had fun!");
            System.exit(0);
        }
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean getIsError() {
        return isError;
    }
}
