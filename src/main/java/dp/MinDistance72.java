package dp;

/**
 * 72. 编辑距离
 * <p>
 * 实现思路：从一个单词转到另一个单词可以有三种操作，每一步都是在之前的基础上 + 1，
 * 之前的基础对应三种操作，取实现步骤最少的那种
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-04-06
 */
public class MinDistance72 {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        //word2为空字符串
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        //word1为空字符串
        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                //单词一样，则不增加步骤
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //否则取一直到前一步总步数最少的那个
                    int minor = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    int least = Math.min(minor, dp[i - 1][j - 1]);
                    dp[i][j] = least + 1;
                }
            }
        }
        return dp[length1][length2];
    }
}
