import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: 实现一个最小栈
 * User: HHH.Y
 * Date: 2020-05-15
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    // 入栈   两个栈都要入
    public void push(int x) {
        // 如果是第一次入栈, 那么stack中放入值之后, minStack中也需要入值
        // 如果不是第一次入栈, stack中入值之后, 需要和minStack中已有值进行判断
        // 如果比已有值小, 就需要入值minStack, 否则就不入值
        if(this.stack.empty()) {
            this.stack.push(x);
            this.minStack.push(x);
        } else {
            this.stack.push(x);
            if(x <= minStack.peek()) {
                this.minStack.push(x);
            }
        }
    }

    // 出栈
    public void pop() {
        // 判断栈是否为空, 若为空, 就不能进行出栈
        // 将stack中要出栈的值记录下来, 然后stack出栈
        // 将这个值与minStack的栈顶值进行比较, 若相同, 就将minStack的栈顶值出栈; 若不相同, 就不用出栈minStack的栈顶值
        if(this.stack.empty()) {
            return;
        }
        int data = stack.pop();
        if(data == minStack.peek()) {
            minStack.pop();
        }
    }

    // 获取栈顶元素
    public int top() {
        // 如果栈为空, 就没有栈顶元素
        // 若栈不为空, 返回栈顶元素即可
        if(stack.empty()) {
            return -1;
        }
        return this.stack.peek();
    }

    // 获取最小值
    public int getMin() {
        // 1. 如果栈为空, 就没有元素
        if(this.stack.empty()) {
            return -1;
        }
        // 2. 否则, 获取最小元素
        return this.minStack.peek();
    }
}
