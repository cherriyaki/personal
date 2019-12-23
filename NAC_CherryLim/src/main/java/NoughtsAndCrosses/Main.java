package NoughtsAndCrosses;

/*
* @author Cherry Lim
* The Main class that creates the grid, constructs the verifier and executes the verifying function.
* */

public class Main {

    public static void main(String[] args) {
        int n = 3; // set grid length
        char[][] grid = new char[n][n];
        // initialize grid to blank
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = ' ';
            }
        }
        // verify
        GameVerifier verifier = new GameVerifier(fillGrid(grid)); // edit the grid in fillGrid method
        System.out.println("Current board outcome: " + verifier.checkState());
    }

    /*
    * Populate the grid
    * - I've included an example case (X wins) in comments
    * - grid[r][c] accesses the char at row r and column c.
    * */
    private static char[][] fillGrid(char[][] grid) {
        // EDIT GRID HERE
        /*grid[0][0] = grid[0][2] = grid[1][1] = grid[2][0] = 'X';
        grid[0][1] = grid[1][0] = grid[2][2] = 'O';*/

        return grid;
    }
}
