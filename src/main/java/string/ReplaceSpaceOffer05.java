package string;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author Haixiang
 * @since 2022-03-13
 */
public class ReplaceSpaceOffer05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int spaceCount = 0;

        char[] origin = s.toCharArray();
        for (char c : origin) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        char[] arrays = new char[s.length() + spaceCount * 2];

        /**
         * 用双指针从后往前填充新数组，避免扩容问题
         */
        int i = origin.length - 1;
        int j = arrays.length - 1;
        while (i >= 0) {
            if (origin[i] == ' ') {
                arrays[j--] = '0';
                arrays[j--] = '2';
                arrays[j--] = '%';
                i--;
            } else {
                arrays[j--] = origin[i--];
            }
        }
        return new String(arrays);
    }

    public static void main(String[] args) {
        new ReplaceSpaceOffer05().replaceSpace("We are happy.");
    }
}
