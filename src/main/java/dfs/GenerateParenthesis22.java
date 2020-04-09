package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @author Haixiang
 * @email haixiang7c6@gmail.com
 * @since 2020-04-09
 */
public class GenerateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(1, 0, result, "(", n); // 第一个必定是左括号
        return result;
    }

    public void dfs(int LC, int RC, List<String> result, String preString, int n) {
        if (LC == n && RC == n) { // 如果左括号和右括号数量相等，说明已经是最终拼接
            result.add(preString);
            return;
        }
        if (LC < n) { // 左括号数量还有，则就添加左括号
            dfs(LC + 1, RC, result, preString + "(", n);
        }

        if (RC < n && LC > RC) { // 右括号还有，并且字符串中左括号的数量要大于右括号的数量，否则就会出现问题
            dfs(LC, RC + 1, result, preString + ")", n);
        }
    }


}
