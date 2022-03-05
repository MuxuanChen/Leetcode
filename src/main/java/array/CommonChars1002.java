package array;

import java.util.LinkedList;
import java.util.List;

/**
 * 1002. 查找共用字符
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Haixiang
 * @since 2022-03-05
 */
public class CommonChars1002 {
    public List<String> commonChars(String[] words) {
        int[] counts = new int[26];
        //先统计第一个数组
        for (char c : words[0].toCharArray()) {
            counts[c - 'a'] += 1;
        }

        //依次统计后面的数组，更新字符出现次数为相对少的
        for (int i = 1; i < words.length; i++) {
            int[] temp = new int[26];
            for (char c : words[i].toCharArray()) {
                temp[c - 'a'] += 1;
            }

            for (int j = 0; j < counts.length; j++) {
                counts[j] = Math.min(counts[j], temp[j]);
            }
        }

        List<String> result = new LinkedList<>();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }
}
