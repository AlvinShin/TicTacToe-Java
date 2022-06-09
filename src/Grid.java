public class Grid {
    private String[][] grid;
    private Turn player;
    private int numLeft;

    public Grid() {
        System.out.println("Welcome to Tic Tac Toe! (Developed by Alvin Shin)");
        grid = new String[3][3];
        player = Turn.PLAYER1;
        numLeft = 9;
    }

    public void resetGame() {
        System.out.println("A new game has started.\n");
        grid = new String[3][3];
        player = Turn.PLAYER1;
        numLeft = 9;
    }

    public Turn getPlayer() {
        return player;
    }
    
    public String playerToString() {
        switch (player) {
            case PLAYER1:
                return "Player 1";
            case PLAYER2: 
                return "Player 2";
            default: 
            return null;
        }
    }
    
    public void displayGrid() {
        for (int outer = 0; outer < grid.length; outer++) {
            System.out.println();
            System.out.print(grid.length - outer);
            for (int inner = 0; inner < grid[0].length; inner++) {
                System.out.print((inner == 0) ? "  " : "");
                System.out.print((grid[outer][inner] == null) ? " " : grid[outer][inner]);
                System.out.print((inner != 2) ? " | " : "\n");
            }
            System.out.print((outer != 2) ? "  -----------" : "");
        }
        System.out.println("   1   2   3\n");
    }

    private boolean isGridTaken(int x, int y) {
        if (grid[3 - x][y - 1] == null) {
            return false;
        } else if (grid[3 - x][y - 1].equals("x") || grid[3 - x][y - 1].equals("o")) {
            return true;
        }
        return false;
    }

    public void play(int x, int y) {
        if (!isGameOver()) {
            try {
                if (player == Turn.PLAYER1 && !isGridTaken(y, x)) {
                    grid[3 - y][x - 1] = "x";
                    displayGrid();
                    System.out.println("Player 1 placed an x at (" + x + "," + y + ").\n");
                    numLeft--;
                    if (!isGameOver()) {
                        player = Turn.PLAYER2;
                    }
                } else if (player == Turn.PLAYER2 && !isGridTaken(y, x)) {
                    grid[3 - y][x - 1] = "o";
                    displayGrid();
                    System.out.println("Player 2 placed an o at (" + x + "," + y + ").\n");
                    numLeft--;
                    if (!isGameOver()) {
                        player = Turn.PLAYER1;
                    }
                } else {
                    System.out.println("This grid has been taken by " + ((grid[y - 1][x - 1].equals("x")) ? "Player 1" : "Player 2") + ". Please select a different grid.\n");
                }
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: the coordinate (" + x + ", " + y + ") is an invalid coordinate.\nThe minimum value for both values is 1. The maximum value for both values is 3.\nPlease try again.");
            }   
        }
        System.out.println("---------------------------------------\n");
    }


    public boolean isVertical() {
        boolean isVertical = false;

        for (int y = 0; y < grid[0].length; y++) {
            for (int x = 0; x < grid.length - 1; x++) {
                for (int x1 = x + 1; x1 < grid.length; x1++) {
                    try {
                        isVertical = grid[x][y].equals(grid[x1][y]);
                        if (!isVertical) {
                            break;
                        }
                    } catch (NullPointerException e) {
                        isVertical = false;
                        break;
                    }
                } 
                if (!isVertical) {
                    break;
                }
            }
            if (isVertical) {
                return isVertical;
            }
        }   
        return isVertical;
    }

    public boolean isHorizontal() {
        boolean isHorizontal = false;
        
        for (String[] row : grid) {
            for (int i = 0; i < row.length - 1; i++) {
                for (int j = i + 1; j < row.length; j++) {
                    try {
                        isHorizontal = row[i].equals(row[j]);
                        if (!isHorizontal) {
                            break;
                        }
                    } catch (NullPointerException e) {
                        isHorizontal = false;
                        break;
                    }
                }
                if (!isHorizontal) {
                    break;
                }
            }
            if (isHorizontal) {
                return isHorizontal;
            }
        }
        return isHorizontal;
    }

    public boolean isDiagonal() {
        boolean isDiagonal = false; 
        if (grid[1][1] != null) {
            isDiagonal = (grid[1][1] == grid[0][0] && grid[1][1] == grid[2][2]);
            if (!isDiagonal) {
                isDiagonal = (grid[1][1] == grid[0][2] && grid[1][1] == grid[2][0]);
            }
        }
        return isDiagonal;
    }

    public boolean isGameOver() {
        return(numLeft == 0 || isVertical() || isHorizontal() || isDiagonal());
    }
}
