package string;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * @author Haixiang
 * @since 2022-03-13
 */
public class ReverseStr541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            //处理字符小于2k大于k的场景
            if (i + k < chars.length) {
                swap(chars, i, i + k - 1);
                continue;
            }
            //处理数组尾部不足k个字符的场景
            swap(chars, i, chars.length - 1);
        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }


}
