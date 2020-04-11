package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 887. 鸡蛋掉落
 * 解题思路：使用动态规划解决这个问题，当前楼层扔鸡蛋的状态来自于两种状态：1，鸡蛋没碎；2，鸡蛋碎了；
 * 如果鸡蛋没碎，则搜索更高的楼层，如果鸡蛋碎了，则搜索更低的楼层
 * <p>
 * 根据上面的思路得出状态转移方程：dp(K,N)= min（0<=i<=N）{max{dp(K−1,i−1),dp(K,N−i)}+1}
 * K表示剩余的鸡蛋数；N表示需要测试的楼层数；max{}表示最坏情况；min{}表示最少的次数
 *
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-04-11
 */
public class SuperEggDrop887 {
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 二分搜索改进版
     */
    private int dp(int k, int n) {
        int res = Integer.MAX_VALUE;
        if (memo.containsKey(n * 100 + k)) {
            return memo.get(n * 100 + k);
        }
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        int lo = 1, hi = n;
        while (lo <= hi) {
            //定位到当前扔鸡蛋的楼层
            int mid = (lo + hi) / 2;
            //鸡蛋碎了
            int eggBreak = dp(k - 1, mid - 1);
            //鸡蛋没碎
            int eggUnBreak = dp(k, n - mid);
            //如果鸡蛋碎了，往下面的楼层找
            if (eggBreak > eggUnBreak) {
                hi = mid - 1;
                res = Math.min(res, eggBreak + 1);
            } else {
                //鸡蛋没碎，往上面的楼层找
                lo = mid + 1;
                res = Math.min(res, eggUnBreak + 1);
            }
        }
        memo.put(n * 100 + k, res);
        return res;
    }

    /**
     * 原始版dp，超出时间限制
     */
    private int dp2(int k, int n) {
        int res = Integer.MAX_VALUE;
        if (memo.containsKey(n * 100 + k)) {
            return memo.get(n * 100 + k);
        }
        if (n == 0) {
            return 0;
        }
        if (k == 1) {
            return n;
        }
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.max(dp2(k - 1, i - 1), dp2(k, n - i)) + 1);
        }
        memo.put(n * 100 + k, res);
        return res;
    }

    public static void main(String[] args) {
        int res = new SuperEggDrop887().superEggDrop(2, 6);
        System.out.println(res);
    }
}
