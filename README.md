# Welcome to Alvin's TicTacToe game! #

Please keep in mind that all neccessary files are stored in the src folder. 

## Files in src ##

* ***Game.java*** is the main method class
* ***Grid.java*** is responsible for the Tic Tac Toe board, checking for wins or when the game comes to an end, displaying the board, as well as alternating a player's turn
* ***Input.java*** is resposible for keeping track of the player's inputs, such as coordinates to the Tic Tac Toe board and the players's option to start a new game or to terminate the running code. This class utilizes the Java Scanner class
* ***Turn.java*** is a file that contains a global Enum for the program in order to keep track of which player's turn it is

## Invalid Inputs ##
With the awareness of possible bugs due to invalid inputs, there are ways in this program that counteracts such bugs.

### Examples ###
* An entered coordinate that is invalid (0 < domain <= 3, 0 < range <= 3) can trigger a ArrayOutOfBounds Exception error. In order to counteract such an error, a ***try catch*** conditional was implemented during development.
* *What if a player inputs a non-integer value?* Since a String is converted into an integer from the user's input, another ***try catch*** conditional is implemented, catching a NumberFormatException
## ##
Happy TicTacToeing!
