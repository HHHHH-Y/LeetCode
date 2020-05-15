import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 用栈实现队列
 * User: HHH.Y
 * Date: 2020-05-15
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 指定将元素都存放到第一个栈中
        this.stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 1. 判断第二个栈是否为空
        // 2. 若第二个栈为空, 就判断第一个栈中的元素是否为空, 若不为空, 就将第一个栈中的元素全部倒到第二个栈中, 然后出第二个栈的栈顶元素
        // 3. 若第二个栈为空, 第一个栈也为空, 说明这个队都为空, 就不能进行出栈操作.
        // 4. 若第二个栈中的元素不为空, 直接出第二个栈的栈顶元素即可
        if(empty()) {
            // 两个栈均为空时
            return -1;
        }
        int s1Size = stack1.size();
        if(stack2.empty()) {
            // 第二个栈为空, 第一个栈不为空
            for (int i = 0; i < s1Size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(empty()) {
            // 两个栈均为空时
            return -1;
        }
        int s1Size = stack1.size();
        if(stack2.empty()) {
            // 第二个栈为空, 第一个栈不为空
            for (int i = 0; i < s1Size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.empty() && stack2.empty()) {
            return true;
        }
        return false;
    }
}
