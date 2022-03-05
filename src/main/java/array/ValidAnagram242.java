package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-03-18
 */
public class ValidAnagram242 {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            chars[c - 'a'] -= 1;
        }
        for (int c : chars) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram4(String s, String t) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        System.out.println(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);
        System.out.println(tc);
        return Arrays.equals(sc, tc);
    }

    public static boolean isAnagram3(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }

        for (char c : t.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                return false;
            } else {
                if (count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            }
        }
        return map.isEmpty();
    }

    public static boolean isAnagram2(String s, String t) {
        Map<Character, Integer> sm = new HashMap();
        for (char c : s.toCharArray()) {
            if (sm.get(c) == null) {
                sm.put(c, 1);
            } else {
                Integer count = sm.get(c);
                count++;
                sm.put(c, count);
            }
        }

        Map<Character, Integer> tm = new HashMap();
        for (char c : t.toCharArray()) {
            if (tm.get(c) == null) {
                tm.put(c, 1);
            } else {
                Integer count = tm.get(c);
                count++;
                tm.put(c, count);
            }
        }

        return sm.equals(tm);
    }

    public static void main(String[] args) {
        boolean anagram = isAnagram2("anagram", "nagaram");

        System.out.println(anagram);
    }

}
