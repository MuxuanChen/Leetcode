package string;

/**
 * 字符串的最大公因子
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-12
 */
public class GcdOfStrings1071 {
    public String gcdOfStrings(String str1, String str2) {
        //如果str1 + str2 equals str2 + str1,则存在公因子，否则无解，因为（m + n）* str = (n + m) * str
        //如果存在公因子则一定存在最大公因子，因为如果最大公因子是公因子的倍数，能循环因子则肯定能循环公因子
        String s1 = str1 + str2;
        String s2 = str2 + str1;
        if (!s1.equals(s2)) {
            return "";
        }
        return s1.substring(0, gcd(str1.length(), str2.length()));
    }

    int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
