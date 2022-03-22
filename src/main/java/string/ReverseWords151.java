package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 翻转字符串里的单词
 *
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-04-10
 */
public class ReverseWords151 {

    /**
     * 方法一，效率更高
     */
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                if (i != words.length - 1) {
                    sb.append(" ");
                }
                sb.append(words[i]);
            }
        }
        return sb.toString();
    }


    /**
     * 方法二 原地翻转，先翻转整个字符串，再翻转每个单词
     *
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        //去除前后空格
        StringBuilder sb = removeEscape(s);
        //翻转整个字符串
        reverseAllStr(sb, 0, sb.length() - 1);
        //翻转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 1;
        int n = sb.length();
        while (left < n) {
            //right跳到空格为止
            while (right < n && sb.charAt(right) != ' ') {
                right++;
            }
            reverseAllStr(sb, left, right - 1);
            left = right + 1;
            right = left + 1;
        }
    }

    private void reverseAllStr(StringBuilder sb, int i, int j) {
        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
    }

    private StringBuilder removeEscape(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder result = new StringBuilder();
        while (start <= end) {
            if (s.charAt(start) != ' ' || result.charAt(result.length() - 1) != ' ') {
                result.append(s.charAt(start));
            }
            start++;
        }
        return result;
    }


    /**
     * 方法三：代码更简洁
     */
    public String reverseWords(String s) {
        //去掉头尾空格
        s = s.trim();
        //拆分单词
        List<String> list = Arrays.asList(s.split("\\s+"));
        //翻转
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
