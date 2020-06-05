import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 用两个栈来实现队列， 并完成队的出队和入队操作。
 * User: HHH.Y
 * Date: 2020-06-05
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    // 默认第二个栈为出队栈
    public int pop() {
        if(stack2.empty() && stack1.empty()) {
            return -1;
        }
        if(stack2.empty()) {
            int s1Size = stack1.size();
            for (int i = 0; i < s1Size; i++) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
