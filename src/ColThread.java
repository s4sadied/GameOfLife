import java.util.concurrent.Callable;

public class ColThread implements Runnable {

    private TheGrid grid;
    private TheGrid next;
    private int col;


    public ColThread(TheGrid grid, TheGrid next, int col) {
        this.grid = grid;
        this.next = next;
        this.col = col;
    }

    @Override
    public void run() {
        for (int curCol = this.col; curCol < this.col+100; curCol++) {
            for (int row = 0; row < 10000; row++) {
                next.setCell(curCol, row, grid.nextCellState(curCol, row));
            }
        }
    }

//    @Override
//    public void run() {
//        for (int row = 0; row < 10000; row++) {
//            next.setCell(this.col, row, grid.nextCellState(this.col, row));
//        }
//    }
}
