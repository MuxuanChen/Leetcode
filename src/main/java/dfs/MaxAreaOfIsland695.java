package dfs;

import java.util.Arrays;

/**
 * 695.岛屿的最大面积
 * <p>
 * 深度优先搜索
 * <p>
 * 如果当前节点是岛屿，则：1，把当前岛屿置成0，计数1，并把它上下左右四个节点递归走一遍，计数相加则为面积，最终取最大的面积。
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-15
 */
public class MaxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        //防止直接修改输入
        int[][] grids = Arrays.copyOf(grid, grid.length);
        int res = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                //当前节点是岛屿
                if (grids[i][j] == 1) {
                    res = Math.max(res, dfs(grids, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        //当前岛屿沉没，防止重复搜索
        grid[i][j] = 0;
        int res = 1;
        res += dfs(grid, i + 1, j);
        res += dfs(grid, i - 1, j);
        res += dfs(grid, i, j + 1);
        res += dfs(grid, i, j - 1);
        return res;
    }


    public static void main(String[] args) {
        int[][] ints = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        int res = new MaxAreaOfIsland695().maxAreaOfIsland(ints);
        System.out.println(res);
    }
}
