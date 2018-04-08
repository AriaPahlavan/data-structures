import java.util.Random;
import java.util.function.Supplier;

public class PathCountIterative {
    private Long[][] memo;
    private long[][] grid;
    private int ROW_LEN, COL_LEN;

    /**
     * Find path count from a source to destination in the {@code grid}
     *
     * @param grid initial grid
     * @apiNote bottom-up dynamic programming method
     */
    public PathCountIterative(long[][] grid) {
        this.ROW_LEN = grid.length;
        this.COL_LEN = grid[0].length;
        this.grid = grid;
        this.memo = new Long[ROW_LEN][COL_LEN];
        this.memo[ROW_LEN - 1][COL_LEN - 1] = 1L;
    }

    private PathCountIterative(long[][] grid, int row, int col) {
        this(grid);
        PathsFrom(row, col);
    }

    public long PathsFrom(int row, int col) {
        for (int i = ROW_LEN - 1; i >= row; i--) {
            for (int j = COL_LEN - 1; j >= col; j--) {
                if (grid[i][j] < 0)
                    continue;

                memo[i][j] = memo[i][j] == null ? compute(i, j) : memo[i][j];
            }
        }

        return memo[row][col];
    }

    private Long compute(int row, int col) {
        final long toRight = IsValidGrid(row, col + 1) ? memo[row][col + 1] : 0;
        final long toBottom = IsValidGrid(row + 1, col) ? memo[row + 1][col] : 0;

        return toRight + toBottom;
    }

    private Long[][] getResult() { return memo; }

    private boolean IsValidGrid(int row, int col) {
        return grid != null
               && 0 <= row && row < ROW_LEN
               && 0 <= col && col < COL_LEN
               && grid[row][col] >= 0;
    }

    public static void main(String[] args) {
        long[][] grid = new long[8][8];

        Supplier<Integer> randGen = () -> Math.abs(new Random().nextInt()) % 8;

        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;
        grid[randGen.get()][randGen.get()] = -1;

        for (long[] row : grid) {
            for (long elem : row) {
                System.out.print((elem == -1 ? "◼" : "☐") + "\t");
            }
            System.out.println();
        }

        System.out.println("-------------------------------");

        for (Long[] row : new PathCountIterative(grid, 0, 0).getResult()) {
            for (Long elem : row) {

                System.out.print((elem == null ? "◼" : elem) + "\t");
            }
            System.out.println();
        }
    }
}
