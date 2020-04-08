package dfs;

/**
 * 面试题13. 机器人的运动范围
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-04-08
 */
public class MovingCount_mst13 {
    /**
     * 往右下方深度搜索
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
        if (0 > x || x >= m || 0 > y || y >= n || (x / 10 + x % 10 + y / 10 + y % 10 > k) || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        return dfs(x + 1, y, m, n, k, visited) + dfs(x, y + 1, m, n, k, visited) + 1;
    }
}
