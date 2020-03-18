package math;

/**
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-18
 */
public class IsRectangleOverlap {
    /**
     * 方法一：投影法
     *
     * 如果有交集，投影到X、Y轴上的线段应该有交集
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
                && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
    }

    /**
     * 方法二：反向思维
     * 反向思维，如果没有重叠有4种情况，一个矩形在另一个矩形的上、下、左、右，则只要根据各自的边进行判断就行。
     */
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        return !(rec1[1] >= rec2[3]
                || rec1[3] <= rec2[1]
                || rec1[2] <= rec2[0]
                || rec1[0] >= rec2[2]);
    }


}
