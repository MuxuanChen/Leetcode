package array;

/**
 * 螺旋矩阵II
 * 1.循环条件是圈数
 * 2.n为奇数时，中间的格子需要单独赋值
 * 3.从左到右循环的条件是startY + (n - offset)
 * 4.偏移量下一圈+2
 * 5.起始点下一圈+1
 *
 * @author Haixiang
 * @since 2022-02-15
 */
public class GenerateMatrix59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startX = 0;
        int startY = 0;
        int offset = 1;
        int count = 1;
        //循环几次，就是圈数
        int loop = n / 2;
        //n为奇数时，中间的格子需要单独赋值
        int mid = n / 2;
        while (loop > 0) {
            //定义起始点
            int i = startX;
            int j = startY;

            //从左到右
            for (; j < startY + n - offset; j++) {
                result[i][j] = count++;
            }

            //从上到下
            for (; i < startX + n - offset; i++) {
                result[i][j] = count++;
            }

            //从右到左
            for (; j > startY; j--) {
                result[i][j] = count++;
            }

            //从下到上
            for (; i > startX; i--) {
                result[i][j] = count++;
            }

            //下一圈起始点+1
            startX += 1;
            startY += 1;

            //下一圈偏移量+2
            offset += 2;

            loop--;
        }
        if (n % 2 != 0) {
            result[mid][mid] = count;
        }
        return result;
    }
}
