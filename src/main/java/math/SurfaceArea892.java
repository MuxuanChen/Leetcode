package math;

/**
 * 三维形体的表面积
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-25
 */
public class SurfaceArea892 {
    public int surfaceArea(int[][] grid) {
        //总面积
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    //减去了上下重叠的面积
                    sum += 4 * grid[i][j] + 2;

                    if (i > 0) {
                        //减去左右重叠的面积
                        sum -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    }
                    if (j > 0) {
                        //减去前后重叠的面积
                        sum -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                    }
                }
            }
        }
        return sum;
    }
}
