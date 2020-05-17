import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HHH.Y
 * Date: 2020-05-16
 */
public class Solution {
    public boolean IsPopOrder(int [] push,int [] pop) {
        if (push == null && pop == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0; // 用于记录 pop 序列的下标
        for (int i = 0; i < push.length; i++) {
            stack.add(push[i]);
            // 每入栈一次都需要比较栈顶元素是否和pop[j]相等
            while (!stack.empty() && stack.peek() == pop[j]) {
                // 若相等, 就出栈
                stack.pop();
                j++;
            }
            // 如果不相等, 就继续让 push 进栈
        }
        // 如果栈为空, 并且pop序列遍历完了, 就说明pop序列是正确的
        if (stack.empty() && j == pop.length) {
            return true;
        } else {
            return false;
        }
    }
}
