package string;

/**
 * 409.最长回文串
 * <p>
 * 关键思路：1.统计每个字母出现的次数；2.回文串长度 = 字母出现次数 / 2 * 2；3.只允许统计一个奇数字符作为回文中心count % 2 = 1 && ans % 2 = 0
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-19
 */
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int ans = 0;
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c] += 1;
        }
        for (int i : count) {
            // 回文串长度 = 字母出现次数 / 2 * 2
            ans += i / 2 * 2;
            // 只允许统计一个奇数字符作为回文中心
            if (i % 2 == 1 && ans % 2 == 0) {
                ans += 1;
            }
        }
        return ans;
    }
}
