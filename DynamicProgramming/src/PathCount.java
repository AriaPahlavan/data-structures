import java.util.Random;
import java.util.function.Supplier;

public class PathCount {
    private Long[][] memo;
    private long[][] grid;
    private int ROW_LEN, COL_LEN;

    public PathCount(long[][] grid) {
        this.ROW_LEN = grid.length;
        this.COL_LEN = grid[0].length;
        this.grid = grid;
        this.memo = new Long[ROW_LEN][COL_LEN];
    }

    public PathCount(long[][] grid, int row, int col) {
        this.ROW_LEN = grid.length;
        this.COL_LEN = grid[0].length;
        this.grid = grid;
        this.memo = new Long[ROW_LEN][COL_LEN];

        PathsFrom(row, col);
    }

    public long PathsFrom(int row, int col) {
        if (!IsValidGrid(row, col)) return 0;
        if (row == (ROW_LEN - 1) && col == (COL_LEN - 1)) return 1;

        return memo[row][col] == null
                ? memo[row][col] = PathsFrom(row + 1, col) + PathsFrom(row, col + 1)
                : memo[row][col];
    }

    private Long[][] getResult() { return memo; }

    private boolean IsValidGrid(int row, int col) {
        return grid != null
               && row < ROW_LEN
               && col < COL_LEN
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
                System.out.print((elem == -1 ? "#" : elem) + "\t");
            }
            System.out.println();
        }

        System.out.println("-------------------------------");

        for (Long[] row : new PathCount(grid,0,0).getResult()) {
            for (Long elem : row) {

                System.out.print((elem == null ? "#" : elem) + "\t");
            }
            System.out.println();
            System.out.println();
        }
    }
}
