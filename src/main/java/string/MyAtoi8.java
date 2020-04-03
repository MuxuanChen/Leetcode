package string;

/**
 * 8. 字符串转换整数 (atoi)
 * <p>
 * 解题思路：0.数组边界判断；1.去空格；2.正负号判断；3.数字判断；4.int越界判断
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-04-03
 */
public class MyAtoi8 {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int result = 0;
        int flag = 1;
        int i = 0;
        char[] chars = str.toCharArray();
        //去空格
        while (chars[i] == ' ') {
            i++;
            if (i == str.length()) {
                return 0;
            }
        }
        //正负号判断
        if (chars[i] == '-') {
            flag = -1;
        }
        if (chars[i] == '+' || chars[i] == '-') {
            i++;
        }
        //数字判断
        while (i < chars.length && isDigit(chars[i])) {
            //转成数字
            int r = chars[i] - '0';
            //int越界判断
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && r > 7)) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + r;
            i++;
        }

        return flag > 0 ? result : -result;
    }

    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }


    public int myAtoi2(String str) {
        /**
         * 最好不要修改字符串，效率很差，通过第一种方法里的索引遍历的方式跳到下一个字符串即可。
         */
        if (str.startsWith(" ")) {
            str = str.replaceFirst("\\s+", "");
        }
        boolean negative = false;
        //第一个字符是符号
        if (str.startsWith("+")) {
            str = str.substring(1);
        } else if (str.startsWith("-")) {
            negative = true;
            str = str.substring(1);
        }
        //拼接数字，如果遇到非数字结束遍历
        boolean isOver = false;
        int result = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                //判断是否会溢出
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && c > '7')) {
                    isOver = true;
                    break;
                }
                result = result * 10 + c - '0';
            } else {
                if (i == 0) {
                    return 0;
                }
                break;
            }
        }

        if (isOver) {
            result = negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            result = negative ? -result : result;
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println(Integer.MIN_VALUE);
        // int res = new MyAtoi8().myAtoi("   -42");
        // System.out.println(res);
        // int res2 = new MyAtoi8().myAtoi("4193 with words");
        // System.out.println(res2);
        // int res3 = new MyAtoi8().myAtoi("words and 987");
        // System.out.println(res3);
        // int res4 = new MyAtoi8().myAtoi("-91283472332");
        // System.out.println(res4);
        // int res5 = new MyAtoi8().myAtoi("  0000000000012345678");
        // System.out.println(res5);
        // int res6 = new MyAtoi8().myAtoi("+-2");
        // System.out.println(res6);
        // int res7 = new MyAtoi8().myAtoi("9223372036854775808");
        // System.out.println(res7);
        // int res8 = new MyAtoi8().myAtoi("-6147483648");
        // System.out.println(res8);
        int res8 = new MyAtoi8().myAtoi(" ");
        System.out.println(res8);
    }
}
