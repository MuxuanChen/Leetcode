package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 验证括号合法性
 * <p>
 * <p>
 * 思路：
 * <p>
 * 遍历字符串
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-02-22
 */
public class ValidParentheses20 {
    public static boolean isValid(String s) {
        //定义好括号
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('}', '{');
        parentheses.put(']', '[');
        parentheses.put(')', '(');

        //保存左括号的栈
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            //如果是右括号，去栈中弹出一个元素做比较
            if (!parentheses.containsKey(c)) {
                stack.push(c);
            } else if (stack.empty() || !stack.pop().equals(parentheses.get(c))) {
                //如果是左括号，压入栈中
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
