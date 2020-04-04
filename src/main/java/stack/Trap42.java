package stack;

import java.util.Stack;

/**
 * 42. 接雨水
 * <p>
 * 解题思路：构建一个栈，如果当前元素小于栈顶元素，压入；否则弹出栈顶元素，累加面积。
 * 面积 = 高度 * 宽度
 * 高度 = min(当前元素, 当前栈顶元素) - 刚弹出的栈顶元素
 * 宽度 = 当前元素 - 当前栈顶元素 - 1
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-04-04
 */
public class Trap42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        //最终结果
        int ans = 0;
        //当前元素索引
        int cur = 0;
        while (cur < height.length) {
            //当前元素大于栈顶元素
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                //弹出栈顶元素
                int top = stack.pop();
                //没有左边边界无法形成有效面积
                if (stack.isEmpty()) {
                    break;
                }
                //高度
                int ht = Math.min(height[cur], height[stack.peek()]) - height[top];
                //宽度
                int bound = cur - stack.peek() - 1;
                ans += ht * bound;
            }
            stack.push(cur);
            cur++;
        }
        return ans;
    }
}
