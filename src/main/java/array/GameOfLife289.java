package array;

/**
 * 289. 生命游戏
 * <p>
 * 1.遍历每个格子，根据格子周围八个格子的状态得出当前格子应该更新的状态
 * 2.更新的状态采用复合状态（好处：既可以知道更新前后的状态，又不占用空间，可以原地更新）
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-04-02
 */
public class GameOfLife289 {
    public void gameOfLife(int[][] board) {
        //定义方向数组，用以获取周围八个格子
        int[] neighbors = {0, 1, -1};
        //1.遍历所有格子，判断界限
        int rows = board.length;
        int cols = board[0].length;
        //2.获取周围八个格子中的状态，并计算存活的格子数
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = countLiveNeighbors(board, neighbors, rows, cols, row, col);

                //3.更新当前格子的状态成复合状态
                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }

        //4.把所有状态恢复成原始的两种状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int[] neighbors, int rows, int cols, int row, int col) {
        int liveNeighbors = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                    // 相邻位置的坐标
                    int r = (row + neighbors[i]);
                    int c = (col + neighbors[j]);

                    // 查看相邻的细胞是否是活细胞
                    if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                        liveNeighbors += 1;
                    }
                }
            }
        }
        return liveNeighbors;
    }
}
