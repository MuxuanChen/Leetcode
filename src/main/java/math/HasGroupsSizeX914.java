package math;

import java.util.HashMap;

/**
 * 914.卡牌分组
 * 解题思路：统计每个数字出现的次数并排序，检查每个数字出现的次数是否是最小的次数的整数倍
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-27
 */
public class HasGroupsSizeX914 {
    /**
     * 方法一：用数组计数
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        int[] counts = new int[1000];
        for (int i = 0; i < deck.length; i++) {
            counts[deck[i]]++;
        }
        int g = -1;
        for (int count : counts) {
            if (count > 0) {
                if (g == -1) {
                    g = count;
                } else {
                    g = gcd(count, g);
                }
            }
        }
        return g > 1 ? true : false;
    }


    /**
     * 方法二：用map计数
     */
    public boolean hasGroupsSizeX2(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> num2counts = new HashMap<>();
        for (int d : deck) {
            Integer count = num2counts.get(d);
            if (count == null) {
                num2counts.put(d, 1);
            } else {
                num2counts.put(d, ++count);
            }
        }

        int g = -1;
        for (Integer count : num2counts.values()) {
            if (g == -1) {
                g = count;
            } else {
                g = gcd(count, g);
            }
        }
        return g > 1 ? true : false;
    }

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        boolean res = new HasGroupsSizeX914().hasGroupsSizeX(a);
        System.out.println(res);
    }
}
