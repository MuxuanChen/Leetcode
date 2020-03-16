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
            if (c2cs.keySet().contains(String.valueOf(c))){
                stack.push(c);
            }else{
                Character pop = stack.pop();
                Character required = c2cs.get(c);
                if (!required.equals(pop)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = isValid("()");
        System.out.println(res);
    }

}
