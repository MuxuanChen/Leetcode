package stack;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author Muxuan
 * @email muxuan@maihaoche.com
 * @since 2019-03-01
 */
class MyQueue {
    //输入栈
    Stack<Integer> input = new Stack();
    //输出栈
    Stack<Integer> output = new Stack();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}


