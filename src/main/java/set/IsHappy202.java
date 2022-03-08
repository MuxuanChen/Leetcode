package set;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Haixiang
 * @since 2022-03-08
 */
public class IsHappy202 {
    public boolean isHappy(int n) {
        Set<Integer> result = new HashSet<>();
        while (n != 1 && !result.contains(n)) {
            result.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    private int getNextNumber2(int n) {
        int sum = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            int num = Integer.valueOf(String.valueOf(c));
            sum += num * num;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean res = new IsHappy202().isHappy(19);
        System.out.println(res);
    }
}
