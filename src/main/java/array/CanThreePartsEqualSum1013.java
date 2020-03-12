package array;

/**
 * 1013. 将数组分成和相等的三个部分
 * <p>
 * 把"和相等分成三部分"的问题转换成"每部分的和是sum/3,求切分点的数组索引"
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-11
 */
public class CanThreePartsEqualSum1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int ans = sum / 3;

        int idx1 = -1;
        int partNum = 0;
        for (int i = 0; i < A.length; i++) {
            partNum += A[i];
            //找第一个切分点，找到以后不再进入这个判断条件（idx1 == -1）
            if (idx1 == -1 && partNum == ans) {
                idx1 = i;
                //找到第二个切分点，并且索引后面还有元素（i != A.length - 1）
            } else if (idx1 != -1 && partNum == ans * 2 && i != A.length - 1) {
                return true;
            }
        }
        return false;
    }
}
