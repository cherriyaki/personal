package NoughtsAndCrosses;

/*
 * Technical Submission
 * @author Cherry Lim
 * Note:
 * - my solution allows any grid, with length of at least 3, to be verified.
 * - my constructor takes in a 2D char array, i.e. char[][].
 * - customisation of the grid can be done in Main class
 * */

public class GameVerifier {
    private char[][] grid; // the grid we are verifying
    private int n; // length of grid

    /* Constructor
    * @param 2D array representing n x n grid with placed marks
    * */
    public GameVerifier(char[][] gridIn) {
        grid = gridIn;
        n = gridIn.length;
        if (n < 3) {
            System.out.println("Please provide a grid with length of at least 3.");
            System.exit(0);
        }
    }

    /*
    * @param n representing length of grid
    * @return array of groups containing grid positions that form a win
    * */
    private int[][][] winningGroups() {
        int[][][] groups = new int[2*n+2][n][2]; // no. of groups = n (horizontal) + n (vertical) + 2 (diagonal)

        for (int i = 0; i<n; i++) {
            // groups 2n to 2n+1 are diagonal
            // backslash diagonal group
            groups[2*n][i][0] = groups[2*n][i][1] = i;
            // forward slash diagonal group
            groups[2*n+1][i][0] = i;
            groups[2*n+1][i][1] = n-1-i;

            for (int j = 0; j<n; j++) {
                // groups 0 to n-1 are horizontal groups
                groups[i][j][0] = i;
                groups[i][j][1] = j;
                // groups n to 2n-1 are vertical groups
                groups[i+n][j][0] = j;
                groups[i+n][j][1] = i;
            }
        }
        return groups;
    }

    /*
     * Checks state of grid
     * @return
     * - 'X' if player placing X has won
     * - 'O' if player placing O has won
     * - 'U' if outcome of game is undecided
     * */
    public char checkState() {
        for (int[][] group : winningGroups()) {
            boolean matched = true;
            char first = grid[group[0][0]][group[0][1]]; // store char at first position in the group
            for (int[] winPos : group) {
                char box = grid[winPos[0]][winPos[1]];
                // ensure char at every position in this group matches the first
                if (box == ' ' || box != first) {
                    matched = false;
                    break;
                }
            }
            if (matched) return first; // if the chars at all positions in this group match, it means this char has won
        }
        return 'U';
    }


}
