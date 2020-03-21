package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 365.水壶问题
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-21
 */
public class CanMeasureWater {
    /**
     * 方法一：BFS
     * 遍历状态，搜索要求的状态值
     * 根据题意，我们只需要考虑四种操作的情况，加减X和加减Y水量；因为任何状态下的操作的效果都可以转化成这四种操作之一达到的效果。
     * 有了以上思路之后，再用BFS搜索想要的状态值就比较容易了
     */
    public boolean canMeasureWater(int x, int y, int z) {
        //考虑边界
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        //使用队列保存需要遍历的状态值
        Queue<Integer> current = new LinkedList<>();
        current.offer(0);
        //访问过的状态值
        Set<Integer> visited = new HashSet<>();
        //遍历所有可能的状态
        while (!current.isEmpty()) {
            Integer status = current.poll();
            if (status + x <= x + y && visited.add(status + x)) {
                current.offer(status + x);
            }
            if (status + y <= x + y && visited.add(status + y)) {
                current.offer(status + y);
            }
            if (status - x >= 0 && visited.add(status - x)) {
                current.offer(status - x);
            }
            if (status - y >= 0 && visited.add(status - y)) {
                current.offer(status - y);
            }
            if (visited.contains(z)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：数学解法，运用元祖定理也称为裴蜀定理
     * 所求的z一定是x和y的最大公约数的倍数
     */
    public boolean canMeasureWater2(int x, int y, int z) {
        //边界判断
        if (z == 0) {
            return true;
        }

        if (x + y < z) {
            return false;
        }

        if (x == 0 || y == 0){
            return y == z || x == z;
        }

        return z % gcd(x, y) == 0;
    }

    /**
     * 求最大公约数
     */
    private int gcd(int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (x % y == 0){
            return y;
        }

        return gcd(y, x % y);
    }
    }
