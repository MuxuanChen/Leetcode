package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-03-16
 */
public class IsValid20 {
    public static boolean isValid(String s) {
        Map<Character, Character> c2cs = new HashMap<>();
        c2cs.put('(', ')');
        c2cs.put('[', ']');
        c2cs.put('{', '}');
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c2cs.containsKey(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                Character required = c2cs.get(pop);
                if (!required.equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean res = isValid("()");
        System.out.println(res);
        boolean res2 = isValid("]");
        System.out.println(res2);
    }

}
