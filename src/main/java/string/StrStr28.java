package string;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Haixiang
 * @since 2022-03-17
 */
public class StrStr28 {
    //前缀表Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        //定义next数组
        int[] next = new int[needle.length()];
        //构建next数组
        getNext(next, needle);

        int j = 0;
        //遍历原字符串
        for (int i = 0; i < haystack.length(); i++) {
            //模式串字符 不等于 原字符串字符，模式串回退到前一个元素对应的next数组值
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            //继续匹配下一个模式串字符
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            //模式串字符全部匹配到，返回匹配字符串的第一个字符下标
            if (j == needle.length()) {
                return i - j + 1;
            }
        }

        return -1;

    }

    private void getNext(int[] next, String s) {
        //初始化第一个元素
        next[0] = 0;
        //前缀索引
        int j = 0;
        //后缀从1遍历数组
        for (int i = 1; i < s.length(); i++) {
            //回退到最长公共前后缀
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }
}
