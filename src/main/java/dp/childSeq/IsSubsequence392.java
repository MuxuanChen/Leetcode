package dp.childSeq;

/**
 * @author Haixiang
 * @since 2022-10-19
 */
public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        //dp[i][j]表示第i-1个字符和第j-1个字符之间的公共子串的长度
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
