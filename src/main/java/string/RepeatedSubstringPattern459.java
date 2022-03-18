package string;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 * @author Haixiang
 * @since 2022-03-18
 */
public class RepeatedSubstringPattern459 {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        int len = s.length();
        //next数组末尾的值就是重复字符串除第一轮以外的字符串长度
        if (next[s.length() - 1] > 0 && len % (len - next[s.length() - 1]) == 0) {
            return true;
        }
        return false;
    }
}
