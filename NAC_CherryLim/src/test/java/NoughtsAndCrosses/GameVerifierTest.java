package NoughtsAndCrosses;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameVerifierTest {
    private char[][] grid;
    private GameVerifier verifier;

    private void resetGrid(int n) {
        grid = new char[n][n];
        // initialize grid to blank
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    @Test
    public void checkStateWhereXWins() {
        // top horizontal
        resetGrid(3);
        grid[0][0] = grid[0][1] = grid[0][2] = 'X';
        grid[1][0] = grid[1][1] = grid[2][2] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
        // middle horizontal
        resetGrid(3);
        grid[1][0] = grid[1][1] = grid[1][2] = 'X';
        grid[0][0] = grid[0][2] = grid[2][1] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
        // bottom horizontal
        resetGrid(3);
        grid[2][0] = grid[2][1] = grid[2][2] = 'X';
        grid[0][1] = grid[1][1] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
        // left vertical
        resetGrid(3);
        grid[0][0] = grid[1][0] = grid[2][0] = 'X';
        grid[1][1] = grid[1][2] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
        // middle vertical
        resetGrid(3);
        grid[0][1] = grid[1][1] = grid[2][1] = 'X';
        grid[1][0] = grid[2][0] = grid[2][2] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
        // right vertical
        resetGrid(3);
        grid[0][2] = grid[1][2] = grid[2][2] = 'X';
        grid[1][1] = grid[2][1] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
        // back-slash diagonal
        resetGrid(3);
        grid[0][0] = grid[1][1] = grid[2][2] = 'X';
        grid[2][0] = grid[0][2] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
        // forward-slash diagonal
        resetGrid(3);
        grid[0][2] = grid[1][1] = grid[2][0] = 'X';
        grid[0][0] = grid[2][2] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
    }

    @Test
    public void checkStateWhereOWins() {
        // top horizontal
        resetGrid(3);
        grid[0][0] = grid[0][1] = grid[0][2] = 'O';
        grid[1][0] = grid[1][1] = grid[2][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('O', verifier.checkState());
        // middle horizontal
        resetGrid(3);
        grid[1][0] = grid[1][1] = grid[1][2] = 'O';
        grid[0][0] = grid[0][2] = grid[2][1] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('O', verifier.checkState());
        // bottom horizontal
        resetGrid(3);
        grid[2][0] = grid[2][1] = grid[2][2] = 'O';
        grid[0][1] = grid[1][1] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('O', verifier.checkState());
        // left vertical
        resetGrid(3);
        grid[0][0] = grid[1][0] = grid[2][0] = 'O';
        grid[1][1] = grid[1][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('O', verifier.checkState());
        // middle vertical
        resetGrid(3);
        grid[0][1] = grid[1][1] = grid[2][1] = 'O';
        grid[1][0] = grid[2][0] = grid[2][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('O', verifier.checkState());
        // right vertical
        resetGrid(3);
        grid[0][2] = grid[1][2] = grid[2][2] = 'O';
        grid[1][1] = grid[2][1] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('O', verifier.checkState());
        // back-slash diagonal
        resetGrid(3);
        grid[0][0] = grid[1][1] = grid[2][2] = 'O';
        grid[2][0] = grid[0][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('O', verifier.checkState());
        // forward-slash diagonal
        resetGrid(3);
        grid[0][2] = grid[1][1] = grid[2][0] = 'O';
        grid[0][0] = grid[2][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('O', verifier.checkState());
    }

    @Test
    public void checkStateWhereWinnerUndecided() {
        // all blank
        resetGrid(3);
        verifier = new GameVerifier(grid);
        assertEquals('U', verifier.checkState());
        // 1 X
        resetGrid(3);
        grid[2][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('U', verifier.checkState());
        // 1 O
        resetGrid(3);
        grid[2][1] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('U', verifier.checkState());
        // 2 Xs 2 Os
        resetGrid(3);
        grid[1][1] = grid[2][0] = 'O';
        grid[1][2] = grid[2][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('U', verifier.checkState());
        // 3 Xs 3 Os
        resetGrid(3);
        grid[1][1] = grid[2][0] = grid[1][0] = 'O';
        grid[0][0] = grid[2][2] = grid[1][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('U', verifier.checkState());
        // 4 Xs 5 Os
        resetGrid(3);
        grid[0][1] = grid[0][2] = grid[1][0] = grid[1][1] = grid[2][2] = 'O';
        grid[0][0] = grid[1][2] = grid[2][0] = grid[2][1] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('U', verifier.checkState());
    }

    /*
    * Test of whether checkState works for grid of length 4. As the assignment currently requires length to be 3, I haven't implemented comprehensive tests for grids of length > 3.
    * */
    @Test
    public void checkStateOf4x4Board() {
        // forward-slash diagonal
        resetGrid(4);
        grid[0][3] = grid[1][2] = grid[2][1] = grid[3][0] = 'X';
        grid[0][0] = grid[2][2] = 'O';
        verifier = new GameVerifier(grid);
        assertEquals('X', verifier.checkState());
        // 8 Xs 8 Os
        resetGrid(4);
        grid[0][1] = grid[0][2] = grid[1][0] = grid[1][1] = grid[2][2] = grid[0][3] = grid[2][3] = grid[3][3] = 'O';
        grid[0][0] = grid[1][2] = grid[2][0] = grid[2][1] = grid[1][3] = grid[3][0] = grid[3][1] = grid[3][2] = 'X';
        verifier = new GameVerifier(grid);
        assertEquals('U', verifier.checkState());
    }
}