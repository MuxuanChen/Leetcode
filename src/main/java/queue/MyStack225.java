package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * <p>
 * 实现思路：用一个队列实现栈，每次压入新元素的时候都把老元素先弹出再重新压入队列。
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2020-04-05
 */
public class MyStack225 {
    //用队列实现的栈
    Queue<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public MyStack225() {
        stack = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        //压入新元素
        stack.offer(x);
        int size = stack.size();
        //把老元素重新加到新元素后面
        while (size > 1) {
            Integer old = stack.poll();
            stack.offer(old);
            size--;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return stack.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return stack.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}
