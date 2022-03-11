package array;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 *
 * @author Haixiang
 * @since 2022-03-10
 */
public class CanConstruct383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            chars[c - 'a']--;
            if (chars[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
