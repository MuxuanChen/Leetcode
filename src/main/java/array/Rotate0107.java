package array;

/**
 * 面试题 01.07. 旋转矩阵
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-04-07
 */
public class Rotate0107 {
    /**
     * 方法一：先水平翻转，再对角线翻转，原地翻转，空间复杂度较低
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        //水平翻转
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        //按对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 方法二：借助辅助矩阵，按题意进行转换，比较简单，空间复杂度相对较高
     */
    public void rotate2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int[][] ans = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][matrix.length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}
